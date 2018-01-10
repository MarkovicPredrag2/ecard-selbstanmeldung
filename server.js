//-----------	Imports	-----------

//	Third party modules
const express = require('express');
const bodyParser = require('body-parser');
const fs = require('fs');
const https = require('http');
const winston = require('winston');
const cookieSession = require('client-sessions');
const path = require('path');
const favicon = require('serve-favicon');

//	Self written modules
const ginaListener = require('./lib/ginaBaseService.js');
const MySQLWrapper = require('./lib/dbaccess.js');

//-----------	Configuration -----------

//	Reading the config file.
const cfg = JSON.parse(fs.readFileSync('./.servercfg.json', 'utf8'));

//	Logging instances.
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
/*const keys = {
	key: fs.readFileSync(cfg.ssl.key),
  cert: fs.readFileSync(cfg.ssl.cert)
};*/

//-----------	Express configuration -----------

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

//	Third party middle ware.
app.use(favicon(path.join(__dirname, '/webfiles/favicon/ec_logo.ico')));
app.use(bodyParser.urlencoded({ extended: false }));
//	app.use(bodyParser.json({ limit: '5mb' })) --> HTTP Size limited to 5mb, replace when in production
app.use(bodyParser.json());
app.use(cookieSession(cfg.cookiesettings));

//	Set children apps for the root-app.
app.use('/public', public);
app.use('/role', role);

//	SSE subscription list for each app
arzt.locals.subscriptions			= [];
benutzer.locals.subscriptions	= [];
ipadapp.locals.subscriptions	= [];

/*
	Authentication function:
	Every app within the restricted route will use this function.
*/

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
		case 'arzt': res.redirect('/role/arzt/arztansicht'); break;	//	Route to the rendered arzt view
		case 'benutzer': res.redirect('/role/benutzer/warteliste.html'); break;	//	Route to the warteliste html
    case 'ipadapp': res.status(200).end('Eingeloggt'); break;
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
  user.locals.subscriptions.push({ user: req[cookieName].user, connection: res});

	req.on('close', () => {
		//	Pop closed connection
		//	from the stack.
    user.locals.subscriptions.splice(
  		user.locals.subscriptions.findIndex(x => x.connection == res), 1);
	});
}

//-----------	Starting server	-----------

const dbconf 	= cfg.dbsettings;
const ginacfg = cfg.gina;
const portcfg = cfg.ports;
const cookieName = cfg.cookiesettings.cookieName;

const DB = new MySQLWrapper(dbconf.host, dbconf.user, dbconf.password, dbconf.dbname);
DB.connect()
	.then((result) => {
		console.log('Verbunden mit der DB ...');
	})
	.catch((error) => {
		serverTrafficLogger.log('error', `At server startup: ${error}`, logMetaData);
		//	Exits the program
		process.exit(1);
	});

//	Starting the server
https.createServer(app).listen(portcfg.port_1, () => {
	console.log(`Verbunden auf Port ${portcfg.port_1}`);
});

https.createServer(app).listen(portcfg.port_2, (port) => {
	console.log(`Verbunden auf Port ${portcfg.port_2}`);
});

//	Starting gina listerner
const ginaInformation =
        ginaListener.listen(ginacfg.ipaddress, ginacfg.reader, ginacfg.ocardreader, ginacfg.pin, ginacfg.interval, ginacfg.testCardsAllowed);

ginaInformation.on('connection', () => {
  console.log('Verbunden mit der GINA');
})

//-----------	public routes	-----------

public.post('/login', (req, res) => {
	serverTrafficLogger.log('info', `${req.ip} accessed ${req.originalUrl}`, logMetaData);
	//	Check the credentials
	//	the user provided within
	//	the http body.
  DB.lookUpUser(req.body)
		.then((user) => {
      if (req[cookieName].user) {
        // If the user already
        // has a valid cookie,
        // reset the cookie.
        req[cookieName].reset();
        console.log("Users cookie got resetted");
      }
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

//-----------	Restricted routes	-----------

//-----------  role routes -----------

role.get('/logout', (req, res) => {
  req[cookieName].reset();
  res.redirect('/');
});

//-----------	arzt routes	-----------

/*
	Serve the rendered arztansicht.
*/
arzt.get('/arztansicht', (req, res) => {
	serverTrafficLogger.log('info',
		`User ${req[cookieName].user.username} (${req.ip}) accessed ${req.originalUrl}`,
		logMetaData);
  // TODO:
  // Implement for loop in jade
  // by parsing the DB results.

  //Codestup for prototype showcase
	res.render('arztansicht', { user: `Dr. ${req[cookieName].user.username}`,
                              arztansicht: [{name: "Ernst", grund: "Untersuchung", svnr: "1234200199"},
                              {name: "Muncan", grund: "Rezept", svnr: "1123230999"},
                              {name: "Reichts", grund: "Rezept", svnr: "1984190499"}]});
});

arzt.get('/sse', (req, res) => {
	serverTrafficLogger.log('info',
		`User ${req[cookieName].user.username} (${req.ip}) accessed ${req.originalUrl}`,
		logMetaData);
  startSSE(req, res, arzt, 2147483647);
});

//Codestub for prototype showcase
arzt.get('/patientendata', (req, res) => {
  if(req.body.patient.svnr == "1234200199") {
    res.json({name: "Ernst", grund: "Untersuchung", svnr: "1234200199"});
  }
  else if(req.body.patient.svnr == "1123230999") {
    res.json({name: "Muncan", grund: "Rezept", svnr: "1123230999"});
  }
  else if(req.body.patient.svnr == "1984190499") {
    res.json({name: "Reichts", grund: "Rezept", svnr: "1984190499"});
  }
});

// TODO: Implement warteliste ranking logic
arzt.put('/warteliste', (req, res) => {
  /*if (req.body.payload) {
    var payload = req.body.payload;
    // It's a ranking request
    // Dataformat:
    // { from: '5050060985', before: '4075081055'}
    DB.rankWarteliste(payload.from, payload.before)
      .then((result) => {
        arzt.locals.subscriptions.forEach((subscriber) => {
          // Inform all arzt subscribers
          // Except the requesting arzt.
          if (subscriber.user != req[cookieName].user) {
            subscriber.connection.write('id: patient');
            subscriber.connection.write('/n');
            subscriber.connection.write('data: ${result}');
            subscriber.connection.write('/n/n');
          }
        });
      })
      .catch((error) => {
        serverTrafficLogger.log('error', `@${req.originalUrl}: ${error}`, logMetaData);
        // Only inform the subscriber
        // who send the request
        var connection = arzt.locals.subscriptions
          .find(x => x.user == req[cookieName].user).connection;
        DB.loadWarteliste()
          .then((result) => {
            connection.write('id: reset');
            connection.write('/n');
            connection.write('data: ${result}');
            connection.write('/n/n');
           })
           .catch((error) => {
             error
           });
      });
    } else {
    //  Bad request from the user
    res.status(400).end();
  }*/
});

// -----------	ipadapp routes	-----------

ipadapp.get('/sse', (req, res) => {
	serverTrafficLogger.log('info',
		`User ${req[cookieName].user.username} (${req.ip}) accessed ${req.originalUrl}`,
		logMetaData);

	startSSE(req, res, ipadapp, 2147483647);
  console.log("Wurde angemeldet");
  // TODO: Implement test stub for ipadapp data.
  ipadapp.locals.subscriptions.forEach((subscriber) => {
    subscriber.connection.write(`id: patient`);
    subscriber.connection.write('\n');
    subscriber.connection.write(`data: ${JSON.stringify({
      person: {
        geschlecht: 'F',
        titel: 'Dr.',
        nachname: 'Kenjamin',
        vorname: 'Bolouch',
        gebdatum: '19.6.1999'
      },
      adresse: {
        hausnummer: 7,
        ort: 'Wien',
        plz: '1110',
        strasse: 'Favoritenstrasse'
      },
      versicherung: {
        svnr: '5555030688',
        anspruchdaten: [
          {
            anspruchsart: 'Kassenaerzte',
            svtcode: 'BVA',
            kostenteilbefreit: true,
            rezeptbefreit: false
          },
          {
            anspruchsart: 'Kassenaerzte',
            svtcode: 'WGKK',
            kostenteilbefreit: true,
            rezeptbefreit: false
          }
        ]
      }
    })}`);
    subscriber.connection.write('\n\n');
  });
});

ipadapp.put('/patientdata', (req, res) => {
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
});

//-----------	benutzer routes	-----------

benutzer.get('/sse', (req, res) => {
	serverTrafficLogger.log('info',
		`User ${req[cookieName].user} (${req.ip}) accessed ${req.originalUrl}`,
		logMetaData);
	startSSE(req, res, benutzer, 2147483647);
});

//-----------	app routes	-----------

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

//	Return 404 not found html file
app.use((err, req, res, next) => {
	serverTrafficLogger.log('info', `404 not found: ${req.ip} accessed ${req.originalUrl}`, logMetaData);
	res.status(404).sendFile(path.join(__dirname, '/webfiles/misc/404.html'));
});

//-----------	Gina Section -----------

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
ginaInformation.on('data', (patient) => {
	//	Patient plugged his card.
	//	Add patient to the database
	//	if he/she does not exist.
	DB.addPatient(patient)
		.then((result) => {
			//	After adding the patient,
			//	send the patient data along
			//	with all of his data in the DB
			//	to the subscribed iPad-apps.
			/*ipadapp.locals.subscriptions.forEach((subscriber) => {
        subscriber.write(`id: patient`);
        subscriber.write('\n');
        subscriber.write(`data: ${JSON.stringify(patient)}`);
        subscriber.write('\n\n');
			});*/
		})
		.catch((error) => {
			serverTrafficLogger.log('error', `db error: ${error}`, logMetaData);
		});
});

ginaInformation.on('error', (error) => {
	ginaErrorLogger.log('error', error, logMetaData);
});

ginaInformation.on('procerror', (error) => {
	ginaErrorLogger.log('fatal', error, logMetaData);
});
