// ===========	Imports	===========

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

// ===========	Configuration ===========

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

// ===========	Express configuration ===========

//	Initialize app instances.
//	The intendation corresponds to the
//	order in the inhertiance tree.
const app 		= express(),
				public 			= express(),
				role			 	= express(),
					arzt 				= express(),
					benutzer		= express(),
					ipadapp			=	express();

//	Template engine settings.
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
arzt.locals.subscriptionsWarteliste	= [];
ipadapp.locals.subscriptions = [];

// Authentication function:
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
  user.push({ user: req[cookieName].user, connection: res});

	req.on('close', () => {
		//	Pop closed connection
		//	from the stack.
    user.splice(
  		user.findIndex(x => x.connection == res), 1);
	});
}

// ===========	Starting server	===========

const dbconf 	= cfg.dbsettings;
const ginacfg = cfg.gina;
const portcfg = cfg.ports;
const cookieName = cfg.cookiesettings.cookieName;
const appSignatureSecret = cfg.appsignature.secret;

const DB = new SelbstanmeldungsDB(dbconf.host, dbconf.user, dbconf.password, dbconf.dbname);
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
https.createServer(app).listen(portcfg.port_1, () => {
	console.log(`Verbunden auf Port ${portcfg.port_1}`);
});

https.createServer(app).listen(portcfg.port_2, () => {
	console.log(`Verbunden auf Port ${portcfg.port_2}`);
});

//	Starting gina listerner
// const ginaInformation =
//         ginaListener.listen(ginacfg.ipaddress, ginacfg.reader, ginacfg.ocardreader, ginacfg.pin, ginacfg.interval, ginacfg.testCardsAllowed);
//
// ginaInformation.on('connection', () => {
//   console.log('Verbunden mit der GINA');
// })

// ===========  public routes ===========

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
			res.render('login', { warning: 'Invalide eingabe. User konnte nicht gefunden werden.' });
		});
});

public.post('/ipadappdata', (req, res) => {
  var payload = req.body;
  console.log(req.body);
  payload.testflag = true;
  arzt.locals.subscriptionsArzt.forEach((subscriber) => {
    subscriber.connection.write(`id: patient`);
    subscriber.connection.write('\n');
    subscriber.connection.write(`data: ${ JSON.stringify(req.body) }`);
    subscriber.connection.write('\n\n');
  });
  res.sendStatus(200);
});

// ===========  role routes ===========

role.get('/logout', (req, res) => {
  req[cookieName].reset();
  res.redirect('/');
});

// ===========	arzt routes	===========

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
    		 	template.patients = result;
          res.render(ansicht, template);
    		 })
    		 .catch((error) => {
          serverTrafficLogger.log('error', `@${req.originalUrl}: ${error}`, logMetaData);
    		 	res.sendStatus(500).end();
    		 })
    } else {
        res.render(ansicht, template);
    }
});

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
  startSSE(req, res, arzt.locals.subscriptionsWarteliste, 2147483647);
})

// TODO: Implement warteliste ranking logic
arzt.put('/warteliste', (req, res) => {
  if (ranking.from && ranking.before) {
    var payload = req.body;
    // It's a ranking request
    // Dataformat: { from: '5050060985', before: '4075081055'}
    DB.rankWarteliste(payload.from, payload.before)
      .then((result) => {
        arzt.locals.subscriptionsArzt.filter(x => x.user != req[cookieName].user).forEach((subscriber) => {
          // Inform all arzt subscribers except the requesting arzt.
          subscriber.connection.write('id: patient');
          subscriber.connection.write('\n');
          subscriber.connection.write('data: ${ JSON.stringify(result) }');
          subscriber.connection.write('\n\n');
        });
      })
      .catch((error) => {
        serverTrafficLogger.log('error', `@${req.originalUrl}: ${error}`, logMetaData);
        // Only inform the subscriber who send the request
        var connection = arzt.locals.subscriptionsArzt
          .find(x => x.user == req[cookieName].user).connection;
        DB.getWartelistePatients()
          .then((result) => {
            connection.write('id: reset');
            connection.write('\n');
            connection.write('data: ${ JSON.stringify(result) }');
            connection.write('\n\n');
           })
           .catch((error) => {
             console.error(error);
             serverTrafficLogger.log('error', `@${req.originalUrl}: ${error}`, logMetaData);
           });
      });
    } else {
    //  Bad request from the user
    res.sendStatus(400).end();
  }
});

// Test Stub, to simulate "plug"-process
arzt.get('/plug', (req, res) => {

  var svnr = "3048280984";

  DB.getPatientForTestPurpose(svnr)
    .then((result) => {
      var patientData = {
        signature: crypto.createHmac('sha256', appSignatureSecret)
                    .update(svnr)
                    .digest('hex'),
        patient: result
      };

      console.log("Patientdata final >>> " + JSON.stringify(patientData));
      res.send("Data was send to the ipadapp clients");
      ipadapp.locals.subscriptions.forEach((subscriber) => {
        subscriber.connection.write(`id: patient`);
        subscriber.connection.write('\n');
        subscriber.connection.write(`data: ${ JSON.stringify(patientData) }`);
        subscriber.connection.write('\n\n');
      });
    })
    .catch((error) => {
      console.error(error);
    })
});

// =========== ipadapp routes ===========

ipadapp.get('/sse', (req, res) => {
	serverTrafficLogger.log('info',
		`User ${req[cookieName].user.username} (${req.ip}) accessed ${req.originalUrl}`,
		logMetaData);

	startSSE(req, res, ipadapp.locals.subscriptions, 2147483647);
});

//
// setInterval(() => {
//   ipadapp.locals.subscriptions.forEach((subscriber) => {
//     subscriber.connection.write(`id: patient`);
//     subscriber.connection.write('\n');
//     subscriber.connection.write(`data: hello test`);
//     subscriber.connection.write('\n\n');
//   });
// }, 2000);

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
  console.log(req.body);
  // if (req.body) {
  //   // TODO: Receive correct data and update patient in the database
  //   // Also check signature before inserting into database
  //
  //   // Signature & Payload
  //   var signature = req.body.signature,
  //       payload = req.body.payload,
  //       svnrSignature = crypto.createHmac('sha256', appSignatureSecret).update(payload.patient.svnr).digest('hex');
  //
  //   if (svnrSignature === signature) {
  //     // TODO: Update patient in database
  //     DB.addOrUpdatePatient()
  //   } else {
  //     // TODO: Send back 403 error
  //     res.sendStatus(403).end();
  //   }
  //
  // } else {
  //   // Send bad request message back
  //   res.sendStatus(403).end();
  // }
});

// ===========	app routes ===========

/*
	If the user already had a recent session
	but tabbed out and re-requested /
	then redirect him back to his page.
*/
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

//	Serves all files from the
//	webroot directory statically
app.use('/', express.static('./webfiles/webroot', { index: '/public/login.html', fallthrough: false }));

// // Return 404 not found html file
// app.use((err, req, res, next) => {
// 	serverTrafficLogger.log('info', `404 not found: ${req.ip} accessed ${req.originalUrl}`, logMetaData);
// 	res.status(404).sendFile(path.join(__dirname, '/webfiles/misc/404.html'));
// });

// ===========	Gina Section ===========

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
//   // TODO: Test for patient data and gina module
//   //console.log(JSON.stringify(patient));
//
// 	DB.addPatient(patient)
// 		.then((result) => {
// 			//	After adding the patient,
// 			//	send the patient data along
// 			//	with all of his data in the DB
// 			//	to the subscribed iPad-apps.
//
//       var patientData = {
//         signature: crypto.createHmac('sha256', appSignatureSecret)
//                    .update(patient.svnr)
//                    .digest('hex'),
//         payload: result[0]
//       };
//
// 			ipadapp.locals.subscriptions.forEach((subscriber) => {
//         subscriber.write(`id: patient`);
//         subscriber.write('\n');
//         subscriber.write(`data: ${ JSON.stringify(patientData) }`);
//         subscriber.write('\n\n');
// 			});
// 		})
// 		.catch((error) => {
// 			serverTrafficLogger.log('error', `db error: ${error}`, logMetaData);
// 		});
// });
//
// ginaInformation.on('error', (error) => {
//   console.error(error);
// 	ginaErrorLogger.log('error', error, logMetaData);
// });
//
// ginaInformation.on('procerror', (error) => {
//   console.error(error);
// 	ginaErrorLogger.log('fatal', error, logMetaData);
// });
