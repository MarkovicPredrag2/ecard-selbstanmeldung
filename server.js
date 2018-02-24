// =========== Imports ===========

// Third party modules
const express = require('express');
const bodyParser = require('body-parser');
const fs = require('fs');
const https = require('http');
const winston = require('winston');
const cookieSession = require('client-sessions');
const path = require('path');
const favicon = require('serve-favicon');
const crypto = require('crypto');

// Self written modules
const ginaListener = require('./lib/ginaBaseService.js');
const SelbstanmeldungsDB = require('./lib/dbqueries.js');

// =========== SSL, Logging and config-file Configuration ===========

// Reading the config file.
const cfg = JSON.parse(fs.readFileSync('./.servercfg.json', 'utf8'));

// Logging instances.
const serverTrafficLogger = new (winston.Logger)({
  transports: [
  	new (winston.transports.File)({
      name: 'server-error',
      filename: path.join('./logs/', 'server-error.log'),
      level: 'error'
    }),
    new (winston.transports.File)({
      name: 'server-traffic',
      filename: path.join('./logs/', 'server-traffic.log'),
      level: 'info'
    })
   ]
});

const ginaErrorLogger = new (winston.Logger)({
  transports: [
  	new (winston.transports.File)({
      name: 'gina-proc-errors',
      filename: path.join('./logs/', 'gina-proc-errors.log'),
      level: 'fatal'
    }),
    new (winston.transports.File)({
      name: 'gina-errors',
      filename: path.join('./logs/', 'gina-errors.log'),
      level: 'error'
    })
   ]
});

//	Metadata, which is included in every log entry
const logMetaData = {
	file: __filename
};

//	Keys for a secure https connection.
//	===================================
//	key: Path to the private key.
//	crt: Path to the certificate.
//	ca: Path to the chaining file.
// const keys = {
// 	key: fs.readFileSync(cfg.ssl.key),
//   cert: fs.readFileSync(cfg.ssl.cert)
// };

// =========== Express configuration ===========

// Initialize app instances inclusive
// the inheritance tree.
const app 		= express(),
			public 			= express(),
			role			 	= express(),
			arzt 				= express(),
			benutzer		= express(),
			ipadapp			=	express();

// Template engine settings
// In this case, every app
// is using pug (Jade).
app.set('view engine', 'pug');
app.set('views', path.join(__dirname, '/webfiles/views/'));
public.set('view engine', 'pug');
public.set('views', path.join(__dirname, '/webfiles/views/'));
arzt.set('view engine', 'pug');
arzt.set('views', path.join(__dirname, '/webfiles/views/'));

//	Third party middle-ware.
app.use(favicon(path.join(__dirname, '/webfiles/favicon/ec_logo.ico')));
app.use(bodyParser.urlencoded({ extended: false }));
//	app.use(bodyParser.json({ limit: '5mb' })) --> HTTP Size limited to 5mb, replace when in production
app.use(bodyParser.json());
app.use(cookieSession(cfg.cookiesettings));

//	Set children apps for the root-app.
app.use('/public', public);
app.use('/role', role);

//	SSE subscription list for each app
arzt.locals.subscriptionsArzt	= [];
arzt.locals.subscriptionsWarteRaum	= [];
ipadapp.locals.subscriptions = [];

// =========== Authentication function ===========

// Every app within the restricted route will use this function.
role.use((req, res, next) => {
  if (req.path === '/logout' && req[cookieName].user) {
    //  The /logout URL is free for all users to access.
    next();
  }
	else if (req[cookieName].user &&
			req[cookieName].user.role ===
			req.path.substring(1, req[cookieName].user.role.length + 1)) {
		//	The user is permitted
		//	to enter the url.
		//	Call the next middleware.
		next();
	} else {
		//	User does not have a valid cookie
		//	or is not permitted to enter the url.
		//	Therefore send a 403.html (access denied).
		serverTrafficLogger.log('info',
		`Access denied for ${req.ip} who accessed ${req.originalUrl}`,
		logMetaData);
		res.status(403).sendFile(path.join(__dirname, '/webfiles/misc/403.html'));
	}
});

//	Set children apps for the role-app.
role.use('/arzt', arzt);
role.use('/benutzer', benutzer);
role.use('/ipadapp', ipadapp);

// =========== Global functions	===========

// Redirection function.
// Used to redirect users
// who provide valid cookies.
function redirectUser(role, res) {
	switch(role) {
		case 'arzt': res.redirect('/role/arzt/ansicht/homepage'); break;
    case 'ipadapp': res.end(); break;
	}
}

// Function to start a SSE session
function startSSE(req, res, user, timeout) {
  // 	Set timeout as high as possible (in secs)
	req.setTimeout(timeout);
	//	Send headers for event-stream connection
	//	according to the html5 sse specs
	res.writeHead(200, {
		'Content-Type': 'text/event-stream',
		'Cache-Control': 'no-cache',
		'Connection': 'keep-alive'
	});
	res.write('\n');
  // Push the user to the subscriptions
  user.push({ user: req[cookieName].user.username, connection: res});
  console.log("User got SSE ...");
	req.on('close', () => {
		//	Pop closed connection
		//	from the stack.
    user.splice(
  		user.findIndex(x => x.connection == res), 1);
    console.log("User removed from SSE ... (req)");
	});
}

// Function to inform the other aerzte
function informOtherAertzteOnChange(sendingArzt) {
  DB.getWartelistePatients()
    .then((wartelistePatients) => {
      // Inform all arzt subscribers except the requesting arzt
      arzt.locals.subscriptionsArzt.filter(x => x.user != sendingArzt).forEach((subscriber) => {
        subscriber.connection.write('id: patient');
        subscriber.connection.write('\n');
        subscriber.connection.write('data: ${ JSON.stringify(wartelistePatients) }');
        subscriber.connection.write('\n\n');
      });
     })
     .catch((error) => {
       serverTrafficLogger.log('error', `@Informing other Aerzte: ${error}`, logMetaData);
       console.error("Inform other aerzte error: " + error);
     })
}

// Function to inform the sending arzt on error
function informSendingArztOnError(req, res) {
  // Only inform the subscriber who send the request
  DB.getWartelistePatients()
    .then((result) => {
      var data = {};
      data.payload = result;
      res.status(500).json(data);
     })
     .catch((error) => {
      serverTrafficLogger.log('error', `@${req.originalUrl}: ${error}`, logMetaData);
      console.error("Error at informSendingArztOnError: " + error);
     });
}

// =========== Starting server	===========

// Initilizing config variables
const dbconf = cfg.dbsettings;
const ginacfg = cfg.gina;
const portcfg = cfg.ports;
const cookieName = cfg.cookiesettings.cookieName;
const appSignatureSecret = cfg.appsignature.secret;

// Initialize DB
const DB = new SelbstanmeldungsDB(dbconf.host, dbconf.user, dbconf.password, dbconf.dbname);

// Establish connection to database
DB.connect()
	.then((result) => {
		console.log('Verbunden mit der DB ...');
	})
	.catch((error) => {
		serverTrafficLogger.log('error', `At server startup: ${error}`, logMetaData);
		//	Exits the program
    console.error(error);
		process.exit(1);
	});

//	Starting the server
https.createServer(//keys,
  app).listen(portcfg.port_1, () => {
	console.log(`Verbunden auf Port ${portcfg.port_1}`);
});
https.createServer(//keys,
  app).listen(portcfg.port_2, () => {
	console.log(`Verbunden auf Port ${portcfg.port_2}`);
});

//	Starting gina listerner
// const ginaInformation =
//         ginaListener.listen(ginacfg.ipaddress, ginacfg.reader, ginacfg.ocardreader, ginacfg.pin, ginacfg.interval, ginacfg.testCardsAllowed);
//
// ginaInformation.on('connection', () => {
//   console.log('Verbunden mit der GINA');
// })

// =========== public routes ===========

public.post('/login', (req, res) => {
	serverTrafficLogger.log('info', `${req.ip} accessed ${req.originalUrl}`, logMetaData);
	//	Check the credentials
	//	the user provided within
	//	the http body.
  console.log(JSON.stringify(req.body));
  DB.lookUpUser(req.body)
		.then((user) => {
      // if (req[cookieName].user) {
      //   // If the user already
      //   // has a valid cookie,
      //   // reset the cookie.
      //   req[cookieName].reset();
      // }
			//	The user seems to exist, therefore
			//	sending him a cookie back.
			req[cookieName].user	= {
				username: user.username,
				role: user.rolle
			};
			//	After the cookie has been send,
			//	redirect the user to the rightu
			//	url (depending on his role),
			//	where he receives a
			//	(eventually rendered) html file.
      console.log(user);
			redirectUser(user.rolle, res);
		})
		.catch((error) => {
			//	The client entered wrong or non
			//	existing credentials. Therefore,
			//	send back a rendered html view
			//	with a credentials error.
			serverTrafficLogger.log('error', `${req.ip}@${req.originalUrl}: ${error}`, logMetaData);
			res.status(403).render('login', { warning: 'Invalide eingabe. User konnte nicht gefunden werden.' });
		});
});

// =========== role routes ===========

role.get('/logout', (req, res) => {
  req[cookieName].reset();
  res.redirect('/');
});

// =========== arzt routes ===========

// Serve the templates
arzt.get('/ansicht/:ansicht', (req, res) => {
	serverTrafficLogger.log('info',
		`User ${req[cookieName].user.username} (${req.ip}) accessed ${req.originalUrl}`,
		logMetaData);

    var ansicht = req.params.ansicht.toLowerCase();
    var template = { user: req[cookieName].user.username };

    // If the requested site is the arztansicht,
    // also add the patient ranking template.
    if (ansicht == 'arztansicht') {
      DB.getWartelistePatients()
    		.then((result) => {
          console.log("Patientendaten: >>> " + JSON.stringify(result));
    		 	template.patients = result;
          res.render(ansicht, template);
    		 })
    		 .catch((error) => {
          serverTrafficLogger.log('error', `@${req.originalUrl}: ${error}`, logMetaData);
          console.error(error);
    		 	res.sendStatus(500).end();
    		 })
    } else {
        res.render(ansicht, template);
    }
});

// Return logdata to specific log-art
arzt.get('/logdata', (req, res) => {
  console.log(req.query.logart);
  if (req.query.logart) {
    DB.dumpLog(req.query.logart)
      .then((result) => {
        //console.log(JSON.stringify(result));
         res.json(result);
       })
       .catch((error) => {
         serverTrafficLogger.log('error', `@${req.originalUrl}: ${error}`, logMetaData);
         console.error(error);
         res.sendStatus(500).end();
       })
  } else {
    res.sendStatus(404).end();
  }
});

// Start the sse to provide
// New patient sse
arzt.get('/patientsse', (req, res) => {
	serverTrafficLogger.log('info',
		`User ${req[cookieName].user.username} (${req.ip}) accessed ${req.originalUrl}`,
		logMetaData);
  startSSE(req, res, arzt.locals.subscriptionsArzt, 2147483647);
});

// Start sse to provide warteraum data
arzt.get('/warteraumsse', (req, res) => {
  serverTrafficLogger.log('info',
		`User ${req[cookieName].user.username} (${req.ip}) accessed ${req.originalUrl}`,
		logMetaData);
  startSSE(req, res, arzt.locals.subscriptionsWarteRaum, 2147483647);
})

// Provide patient data
arzt.post('/patientdata', (req, res) => {
  if (req.body.svnr) {
    // TODO: Send back the patient data to the corresponding patient
    DB.getPatientData(req.body.svnr)
      .then((result) => {
        res.json(result);
      })
      .catch((error) => {
        serverTrafficLogger.log('error', `@${req.originalUrl}: ${error}`, logMetaData);
        console.error(error);
        res.send(500).end();
      })
  } else {
    console.log("Forbidden request at /patientdata ...");
    res.send(403).end();
  }
});

// Function to call in patients
arzt.post('/callin', (req, res) => {
  // TODO: Notify warteraum agents
  if (req.body.svnr) {
    DB.callInPatientIntoBehandlungsZimmer(req.body.svnr, req[cookieName].user)
      .then((wartelistePatients) => {
        //informOtherAertzteOnChange(req[cookieName].user);
        // Notify the warteraum agents via SSE
        arzt.locals.subscriptionsWarteRaum.forEach((subscriber) => {
          subscriber.connection.write('id: patient');
          subscriber.connection.write('\n');
          subscriber.connection.write('data: ${ JSON.stringify(wartelistePatients) }');
          subscriber.connection.write('\n\n');
        });
        res.send(200).end();
       })
      .catch((error) => {
        serverTrafficLogger.log('error', `@${req.originalUrl}: ${error}`, logMetaData);
        console.error("At /callin: " + error);
        informSendingArztOnError(req, res);
      })
  } else {
    console.log("Forbidden request at /callin ...");
    res.send(403).end();
  }
});

// Function to dismiss the patients
arzt.post('/dismiss', (req, res) => {
  if (req.body.svnr) {
    DB.dismissPatient(req.body.svnr)
      .then((result) => {
        //informOtherAertzteOnChange(req[cookieName].user);
        res.send(200).end();
       })
       .catch((error) => {
         serverTrafficLogger.log('error', `@${req.originalUrl}: ${error}`, logMetaData);
         console.error("At /dismiss: " + error);
         informSendingArztOnError(req, res);
       })
  } else {
    console.log("Forbidden request at /dismiss ...");
    res.send(403).end();
  }
})

// Warteliste ranking logic
arzt.post('/rank', (req, res) => {
  // Dataformat: { from: '5050060985', before: '4075081055'}
  if (req.body.from && req.body.before) {
    var payload = req.body;
    // It's a ranking request
    // Dataformat: { from: '5050060985', before: '4075081055'}
    DB.rankWarteliste(payload.from, payload.before)
      .then((result) => {
        // informOtherAertzteOnChange(req[cookieName].user);
        res.send(200).end();
      })
      .catch((error) => {
        serverTrafficLogger.log('error', `@${req.originalUrl}: ${error}`, logMetaData);
        informSendingArztOnError(req, res);
      });
    } else {
    //  Bad request from the user
    res.send(403).end();
  }
});

// Test Stub, to simulate "plug"-process (Bernhard)
// arzt.get('/plug', (req, res) => {
//   var svnr = "3048280984";
//
//   DB.getAllPatientData(svnr)
//     .then((result) => {
//       var patientData = {
//         signature: crypto.createHmac('sha256', appSignatureSecret)
//                     .update(svnr)
//                     .digest('hex'),
//         patient: result
//       };
//       patientData.patient.svnr = String(patientData.patient.svnr);
//       console.log(JSON.stringify(patientData));
//       res.send("Data was send to the ipadapp clients");
//       ipadapp.locals.subscriptions.forEach((subscriber) => {
//         subscriber.connection.write(`id: patient`);
//         subscriber.connection.write('\n');
//         subscriber.connection.write(`data: ${ JSON.stringify(patientData) }`);
//         subscriber.connection.write('\n\n');
//       });
//       console.log("Patientdata sent ...");
//     })
//     .catch((error) => {
//       console.error(error);
//     })
// });

function loadTestPatients() {
  var testPatients = [
    {
      "versicherung": {
        "anspruchsdaten": [
          {
            "kostenteilbefreit":false,
            "anspruchsart":"S",
            "rezeptbefreit":false,
            "svtCode":"11",
            "versichertenArtCode":null
          }
        ]
      },
      "person": {
        "svnr":"1003250229",
        "titel":"Dr.-Ing.",
        "geburtsdatum":"16.02.1988",
        "vorname":"Ake",
        "geschlecht":"M",
        "nachname":"Soren-Test"
      }
    },
    {
      "versicherung": {
        "anspruchsdaten": [
          {
            "kostenteilbefreit":false,
            "anspruchsart":"S",
            "rezeptbefreit":false,
            "svtCode":"12",
            "versichertenArtCode":null
          }
        ]
      },
      "person": {
        "svnr":"1234567890",
        "titel":"",
        "geburtsdatum":"11.11.2011",
        "vorname":"kevin",
        "geschlecht":"M",
        "nachname":"Askan"
      }
    },
    {
      "versicherung": {
        "anspruchsdaten": [
          {
            "kostenteilbefreit":false,
            "anspruchsart":"S",
            "rezeptbefreit":false,
            "svtCode":"11",
            "versichertenArtCode":null
          }
        ]
      },
      "person": {
        "svnr":"2469180576",
        "titel":"Mag.",
        "geburtsdatum":"01.05.1990",
        "vorname":"manfred",
        "geschlecht":"M",
        "nachname":"Reuchelt"
      }
    },
    {
      "versicherung": {
        "anspruchsdaten": [
          {
            "kostenteilbefreit":false,
            "anspruchsart":"S",
            "rezeptbefreit":false,
            "svtCode":"05",
            "versichertenArtCode":null
          },
          {
            "kostenteilbefreit":false,
            "anspruchsart":"S",
            "rezeptbefreit":false,
            "svtCode":"40",
            "versichertenArtCode":null
          }
        ]
      },
      "person": {
        "svnr":"6529837019",
        "titel":"Ing.",
        "geburtsdatum":"20.07.2000",
        "vorname":"Eugen",
        "geschlecht":"M",
        "nachname":"Klein"
      }
    },
    {
      "versicherung": {
        "anspruchsdaten": [
          {
            "kostenteilbefreit":false,
            "anspruchsart":"S",
            "rezeptbefreit":false,
            "svtCode":"7A",
            "versichertenArtCode":null
          },
          {
            "kostenteilbefreit":false,
            "anspruchsart":"S",
            "rezeptbefreit":false,
            "svtCode":"25",
            "versichertenArtCode":null
          },
          {
            "kostenteilbefreit":false,
            "anspruchsart":"S",
            "rezeptbefreit":false,
            "svtCode":"17",
            "versichertenArtCode":null
          }
        ]
      },
      "person": {
        "svnr":"663782916",
        "titel":"",
        "geburtsdatum":"01.09.1960",
        "vorname":"Lara",
        "geschlecht":"W",
        "nachname":"Kraut"
      }
    },
    {
      "versicherung": {
        "anspruchsdaten": [
          {
            "kostenteilbefreit":false,
            "anspruchsart":"S",
            "rezeptbefreit":false,
            "svtCode":"19",
            "versichertenArtCode":null
          },
          {
            "kostenteilbefreit":false,
            "anspruchsart":"S",
            "rezeptbefreit":false,
            "svtCode":"8B",
            "versichertenArtCode":null
          }
        ]
      },
      "person": {
        "svnr":"7724091276",
        "titel":"Ing.",
        "geburtsdatum":"01.04.1987",
        "vorname":"Olga",
        "geschlecht":"W",
        "nachname":"Babushka"
      }
    },
    {
      "versicherung": {
        "anspruchsdaten": [
          {
            "kostenteilbefreit":false,
            "anspruchsart":"S",
            "rezeptbefreit":false,
            "svtCode":"8D",
            "versichertenArtCode":null
          }
        ]
      },
      "person": {
        "svnr":"0987654328",
        "titel":"",
        "geburtsdatum":"07.01.2003",
        "vorname":"Hans",
        "geschlecht":"M",
        "nachname":"Schiff"
      }
    },
    {
      "versicherung": {
        "anspruchsdaten": [
          {
            "kostenteilbefreit":false,
            "anspruchsart":"S",
            "rezeptbefreit":false,
            "svtCode":"50",
            "versichertenArtCode":null
          },
          {
            "kostenteilbefreit":false,
            "anspruchsart":"S",
            "rezeptbefreit":false,
            "svtCode":"28",
            "versichertenArtCode":null
          },
          {
            "kostenteilbefreit":false,
            "anspruchsart":"S",
            "rezeptbefreit":false,
            "svtCode":"07",
            "versichertenArtCode":null
          }
        ]
      },
      "person": {
        "svnr":"6523980167",
        "titel":"",
        "geburtsdatum":"22.03.2007",
        "vorname":"Uganda",
        "geschlecht":"M",
        "nachname":"knuckls"
      }
    }
  ];

  // TODO: Add test patients

  return testPatients;
}

// Test Stub, to simulate the "real" plug-process
arzt.get('/plugsimulation', (req, res) => {

  var testPatients = loadTestPatients();
  var patient = testPatients[req.query.pat];

  console.log("Ipadapps atm: " + ipadapp.locals.subscriptions.length);

  DB.isPatientAlreadyInWarteliste(patient.person.svnr)
    .then((answer) => {
      // There must be at least 1 ipadapp available AND
      // the patient has not to be in the warteliste
      // in order to send data to the ipadapp
      // Otherwise, ignore the prank.
      // In Production Statement: answer && ipadapp.locals.subscriptions.length > 0
      // In test statement:
      if (!answer) {

        DB.addPatientIfNotExists(patient)
            .then((result) => {

               DB.getAllPatientData(patient.person.svnr)
                .then((patientDataResult) => {

                  // Add signature
                  var patientData = {
                    signature: crypto.createHmac('sha256', appSignatureSecret)
                                .update(patient.person.svnr)
                                .digest('hex'),
                    patient: patientDataResult
                  };

                  //  After adding the patient,
                 	//	send the patient data along
                 	//	with all of his data in the DB
                 	//	to the subscribed iPad-apps.
                 	ipadapp.locals.subscriptions.forEach((subscriber) => {
                      subscriber.connection.write(`id: patient`);
                      subscriber.connection.write('\n');
                      subscriber.connection.write(`data: ${ JSON.stringify(patientData) }`);
                      subscriber.connection.write('\n\n');
                 	});
                  res.send("Patientdata was send: " + JSON.stringify(patientData));
                 })
                 .catch((error) => {
                   serverTrafficLogger.log('error', `db error: ${error}`, logMetaData);
                   console.error(error);
                 })
             })
             .catch((error) => {
               serverTrafficLogger.log('error', `db error: ${error}`, logMetaData);
               console.error(error);
             })
      } else {
        // Ignore the case
        console.log("Patient is already in warteliste or there ain't an ipadapp");
        res.send("Patient is already in warteliste or there ain't an ipadapp");
      }
     })
     .catch((error) => {
       serverTrafficLogger.log('error', `db error: ${error}`, logMetaData);
       console.error(error);
     })
})

function loadAppResponses() {
  var appResponses = [
    {
    	"signature":"cfa86b457cb3acb037be1bed18e7b58263d33bd699722a2b57c2f143a03aa395",
    	"patient": {
    		"svnr": "1003250229",
    		"hausnummer":"7",
    		"ort":"ohrstadt",
    		"postleitzahl":"11245",
    		"stock":"3",
    		"strasse":"Marktplatz",
    		"versid": "11",
    		"telefonnummer": "43036097816",
    		"email": "marwin1998@gmail.com",
    		"grund": "2"
    	}
    },
    {
    	"signature":"fc4631bc30c2cfb303939df74cda7a5c69dbc463b1a6c946dacbfd737668483d",
    	"patient": {
    		"svnr": "1234567890",
    		"hausnummer":"15",
    		"ort":"aal",
    		"postleitzahl":"2380",
    		"stock":"20",
    		"strasse":"Marktplatz",
    		"versid": "12",
    		"telefonnummer": "43036097816",
    		"email": "bushwookie@gmail.com",
    		"grund": "1"
    	}
    },
    {
    	"signature":"5a7ea11be12e345e65ad474070d7b027f1975db5806e89a413b00f699b2e61e3",
    	"patient": {
    		"svnr": "2469180576",
    		"hausnummer":"15",
    		"ort":"Perchtoldsdorf",
    		"postleitzahl":"2380",
    		"stock":"20",
    		"strasse":"Marktplatz",
    		"versid": "11",
    		"telefonnummer": "43036097816",
    		"email": "bushwookie@gmail.com",
    		"grund": "3"
    	}
    },
    {
    	"signature":"bdae6ae25223daade20b48cc4c65d73d59641dfad0541fbc333185a12b81685c",
    	"patient": {
    		"svnr": "6529837019",
    		"hausnummer":"15",
    		"ort":"Perchtoldsdorf",
    		"postleitzahl":"2380",
    		"stock":"20",
    		"strasse":"Marktplatz",
    		"versid": "40",
    		"telefonnummer": "43036097816",
    		"email": "bushwookie@gmail.com",
    		"grund": "2"
    	}
    },
    {
    	"signature":"8e216e870471600dbda5d6a9ecaa1fbd61194de9f3a04ef48ace4cc45269bc27",
    	"patient": {
    		"svnr": "663782916",
    		"hausnummer":"15",
    		"ort":"Perchtoldsdorf",
    		"postleitzahl":"2380",
    		"stock":"20",
    		"strasse":"Marktplatz",
    		"versid": "7A",
    		"telefonnummer": "43036097816",
    		"email": "neuberger@gmail.com",
    		"grund": "1"
    	}
    },
    {
    	"signature":"ccac33265c6404e38d371112f6875e4cefe3f1b185737a3d10940be5849ee9f3",
    	"patient": {
    		"svnr": "7724091276",
    		"hausnummer":"66",
    		"ort":"Sodorf",
    		"postleitzahl":"1245",
    		"stock":"300",
    		"strasse":"larnstrasse",
    		"versid": "19",
    		"telefonnummer": "43036097816",
    		"email": "chuxxl@gmail.com",
    		"grund": "3"
    	}
    },
    {
    	"signature":"fcd63945282dc2796d60def7ab6fa3a1a67f3e120d014ea455be264077e6cf6b",
    	"patient": {
    		"svnr": "0987654328",
    		"hausnummer":"15",
    		"ort":"Perchtoldsdorf",
    		"postleitzahl":"2380",
    		"stock":"20",
    		"strasse":"Marktplatz",
    		"versid": "05",
    		"telefonnummer": "43036097816",
    		"email": "hhfsuiujnlil@gmail.com",
    		"grund": "2"
    	}
    },
    {
    	"signature":"5101b5a3a37f1b8e4889a9d4f6d00caa6e9a18f180330b1a204528e1b0fbcdac",
    	"patient": {
    		"svnr": "6523980167",
    		"hausnummer":"12",
    		"ort":"Perchtoldsdorf",
    		"postleitzahl":"2380",
    		"stock":"20",
    		"strasse":"Marktplatz",
    		"versid": "07",
    		"telefonnummer": "43036097816",
    		"email": "bushwookie@gmail.com",
    		"grund": "1"
    	}
    }
  ];
  return appResponses;
}

// Test stub, to simulate app-send process
arzt.get('/appsendsimulation', (req, res) => {
  var testDaten = loadAppResponses()[req.query.pat];

  var svnrSignature = crypto.createHmac('sha256', appSignatureSecret).update(testDaten.patient.svnr).digest('hex');

  // Check for signature
  if (testDaten.signature == svnrSignature) {
    DB.updatePatient(testDaten.patient)
      .then((result) => {
        DB.addPatientToWarteliste()
          .then((patientData) => {
             // Notify ärzte
             arztansicht.locals.subscriptionsArzt.forEach((subscriber) => {
                subscriber.connection.write(`id: patient`);
                subscriber.connection.write('\n');
                subscriber.connection.write(`data: ${ JSON.stringify(patientData) }`);
                subscriber.connection.write('\n\n');
             });
             res.send("Ärzte wurden notifiziert");
           })
           .catch((error) => {
             console.error("At /appsendsimulation: " + error);
             res.send(500);
           })
      })
      .catch((error) => {
        console.error(error);
        res.send(500);
      });
  } else {
    res.status(403).send("Gefaelschtes Datenpaket");
  }
});

// =========== ipadapp routes ===========

ipadapp.get('/sse', (req, res) => {
	serverTrafficLogger.log('info',
		`User ${req[cookieName].user.username} (${req.ip}) accessed ${req.originalUrl}`,
		logMetaData);

	startSSE(req, res, ipadapp.locals.subscriptions, 2147483647);
});

ipadapp.post('/patientdata', (req, res) => {
	/*
		TODO:
		=====

		Store the data in the
		database by retrieving
		the JSON object and add
		the patient to the warteliste.
		Also update the arztansichtwarteliste.
	*/
  console.log("Patientdata received:");
  console.log(req.body);
  // TODO: Implement the ipadapp receiver logic
  // if (req.body) {
  //
  // } else {
  //   // Send bad request message back
  //   res.sendStatus(403).end();
  // }
});

// =========== app routes ===========

// If the user already had a recent session
// but tabbed out and re-requested
// then redirect him back to his page.
app.get('/', (req, res, next) => {
	serverTrafficLogger.log('info', `${req.ip} accessed ${req.originalUrl}`, logMetaData);
	if (req[cookieName].user) {
		//	The user already seems to have
		//	a valid cookie. Why demanding
		//	login credentials again then?
		//	Instead, redirect him to the right
		//	url, depending on his role.
		redirectUser(req[cookieName].user.role, res);
	} else {
		//	The user does not have
		//	a valid cookie. Let
		//	express.static send
		//	him the login html page.
		next();
	}
});

// =========== Static file serving & 404 Handling ===========

// Serves all files from the webroot directory statically
app.use('/', express.static('./webfiles/webroot', { index: '/public/login.html', fallthrough: false }));

// // Return 404 not found html file
// app.use((err, req, res, next) => {
// 	serverTrafficLogger.log('info', `404 not found: ${req.ip} accessed ${req.originalUrl}`, logMetaData);
// 	res.status(404).sendFile(path.join(__dirname, '/webfiles/misc/404.html'));
// });

// =========== Gina Section ===========

/*
	Establish the gina connection.
	Note: There are 3 different events
	for this function.
	==================================

	data: Gets emitted when a patient plugged
		an e-card.
	Dataformat:
		{
			svnr: '1003280380',
  		titel: 'Mag.',
  		geburtsdatum: '01.01.1980',
  		vorname: 'Max',
  		nachname: 'Musterpatient'
  	}

	==========================================

	error: Gets emitted when errors from
		the ecard occur.
	==========================================

	procerror: Gets emitted when errors from
		the process itself occur.
	==========================================
*/
// ginaInformation.on('data', (patient) => {
// 	//	Patient plugged his card.
// 	//	Add patient to the database
// 	//	if he/she does not exist.
//   console.log(JSON.stringify(patient));
//
//   // DB.isPatientAlreadyInWarteliste(patient.person.svnr)
//   //   .then((answer) => {
//   //     // There must be at least 1 ipadapp available AND
//   //     // the patient has not to be in the warteliste
//   //     // in order to send data to the ipadapp
//   //     // Otherwise, ignore the prank.
//   //     if (answer && ipadapp.locals.subscriptions.length != 0) {
//   //
//   //       DB.addPatientIfNotExists(patient)
//   //           .then((result) => {
//   //
//   //              DB.getAllPatientData(patient.person.svnr)
//   //               .then((patientDataResult) => {
//   //
//   //                 // Add signature
//   //                 var patientData = {
//   //                   signature: crypto.createHmac('sha256', appSignatureSecret)
//   //                               .update(patient.person.svnr)
//   //                               .digest('hex'),
//   //                   patient: patientDataResult
//   //                 };
//   //
//   //                 //  After adding the patient,
//   //                 //	send the patient data along
//   //                 //	with all of his data in the DB
//   //                 //	to the subscribed iPad-apps.
//   //                 // ipadapp.locals.subscriptions.forEach((subscriber) => {
//   //                 //     subscriber.write(`id: patient`);
//   //                 //     subscriber.write('\n');
//   //                 //     subscriber.write(`data: ${ JSON.stringify(patientData) }`);
//   //                 //     subscriber.write('\n\n');
//   //                 // });
//   //                })
//   //                .catch((error) => {
//   //                  serverTrafficLogger.log('error', `db error: ${error}`, logMetaData);
//   //                  console.error(error);
//   //                })
//   //            })
//   //            .catch((error) => {
//   //              serverTrafficLogger.log('error', `db error: ${error}`, logMetaData);
//   //              console.error(error);
//   //            })
//   //     } else {
//   //       // Ignore the case
//   //       console.log("Patient is already in warteliste or there ain't an ipadapp");
//   //     }
//   //    })
//   //   .catch((error) => {
//   //     serverTrafficLogger.log('error', `db error: ${error}`, logMetaData);
//   //     console.error(error);
//   //   })
// });
//
// ginaInformation.on('error', (error) => {
//   console.error("Error: " + error);
// 	ginaErrorLogger.log('error', error, logMetaData);
// });
//
// ginaInformation.on('procerror', (error) => {
//   console.error("ProcError: " + error);
// 	ginaErrorLogger.log('fatal', error, logMetaData);
// });
