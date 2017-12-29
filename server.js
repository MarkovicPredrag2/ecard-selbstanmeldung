//-----------	Imports	-----------

//	Third party modules
const express 			= require('express');
const bodyParser 		= require('body-parser');
const fs 						= require('fs');
const https 				= require('https');
const winston 			= require('winston');
const cookieSession = require('client-sessions');
const path 					= require('path');
const favicon 			= require('serve-favicon');

//	Self written modules
const ginaListener	= require('./lib/ginaBaseService.js');
const MySQLWrapper 	= require('./lib/dbaccess.js');

//-----------	Configuration -----------

//	Reading the config file.
const cfg = JSON.parse(fs.readFileSync('./.servercfg.json', 'utf8'));

//	Instantiating the logging instance.
const logger = new (winston.Logger)({
  transports: [
  	new (winston.transports.File)({
      name: 'server-error',
      filename: path.join(cfg.logsettings.logpath, 'server-error.log'),
      level: 'server_error'
    }),
    new (winston.transports.File)({
      name: 'server-traffic',
      filename: path.join(cfg.logsettings.logpath, 'server-traffic.log'),
      level: 'server_traffic_info'
    }),
    new (winston.transports.File)({
      name: 'gina-errors',
      filename: path.join(cfg.logsettings.logpath, 'gina-errors.log'),
      level: 'gina_error'
    }),
    new (winston.transports.File)({
      name: 'gina-proc-errors',
      filename: path.join(cfg.logsettings.logpath, 'gina-proc-errors.log'),
      level: 'gina_proc_error'
    })
  ]
});

//	Metadata, which is included in every log entry
const logMetaData = {
	file: 			__filename,
	directory:  __dirname
};

//	Keys for a secure https connection.
//	===================================
//	key: Path to the private key.
//	crt: Path to the certificate.
//	ca: Path to the chaining file.
const keys = {
	key: fs.readFileSync(cfg.ssl.key), 
  cert: fs.readFileSync(cfg.ssl.cert)
};

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

//	Third party middle ware.
app.use(favicon(path.join(__dirname, '/webfiles/favicon/ec_logo.ico')));
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(cookieSession(cfg.cookiesettings));

//	Set children apps for the root-app.
app.use('/public', public);
app.use('/role', role);

//	Set children apps for the role-app.
role.use('/arzt', arzt);
role.use('/benutzer', benutzer);
role.use('/app', ipadapp);

//	SSE subscriütion list for each app
arzt.locals.subscriptions			= [];
benutzer.locals.subscriptions	= [];
ipadapp.locals.subscriptions	= [];

/*
	Authentication function:
	Every app within the restricted route will use this function.
*/
role.use((req, res, next) => {
	if (req[cfg.cookiesettings.cookieName].user &&
			`/${req[cfg.cookiesettings.cookieName].user.role}` === req.app.mountpath) {
		//	The user is permitted
		//	to enter the url.
		//	Call the next middleware.
		next();
	} else {
		//	User does not have a valid cookie
		//	or is not permitted to enter the url.
		//	Therefore send a 403.html (access denied).
		logger.log('server_traffic_info', 
		`Access denied for User ${req[cfg.cookiesettings.cookieName].user.username} (${req.ip}) who accessed ${req.originalUrl}`,
		logMetaData);
		res.status(403).sendFile(path.join(__dirname, '/webfiles/misc/403.html')).end();
	}
});

/*
	Redirection function.
	Used to redirect users
	who provide valid cookies.
*/
function redirectUser(role, res) {
	switch(role) {
		case 'arzt': res.redirect('/role/arzt/arztansicht'); break;	//	Route to the rendered arzt view
		case 'benutzer': res.redirect('/role/benutzer');		 break;	//	Route to the warteliste html
	}
}

//-----------	Starting server	-----------

const dbconf 	= cfg.dbsettings;
const ginacfg = cfg.gina;

const DB = new MySQLWrapper(dbconf.host, dbconf.user, 'selbstanmeldungstool', dbconf.dbname);
DB.connect()
	.then((result) => {
		console.log('Verbunden mit der DB ...');
	})
	.catch((error) => {
		logger.log('server_error', `At server startup: ${error}`, logMetaData);
		//	Exits the program
		process.exit(1);
	});

//	Starting the server
https.createServer(keys, app).listen(80, () => {
	console.log('Verbunden auf Port 80 ...');
});
https.createServer(keys, app).listen(443, () => {
	console.log('Verbunden auf Port 443 ...');
});

//	Starting gina listerner
const ginaInformation = ginaListener.listen(ginacfg.ipaddress, ginacfg.reader, ginacfg.interval, ginacfg.testCardsAllowed);
	
//-----------	public routes	-----------

public.post('/login', (req, res) => {
	logger.log('server_traffic_info', `${req.ip} accessed ${req.originalUrl}`, logMetaData);
	console.log('Received POST request at /login');
	//	Check the credentials
	//	the user provided within
	//	the http body.
	DB.lookUpUser(req.body)
		.then((user) => {
			//	The user seems to exist, therefore
			//	sending him a cookie back.
			req[cfg.cookiesettings.cookieName].user.username 	= user.username;
			req[cfg.cookiesettings.cookieName].user.role			= user.rolle;
			//	After the cookie has been send,
			//	redirect the user to the right
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
			logger.log('server_error', `${req.ip}@${req.originalUrl}: ${error}`, logMetaData);
			res.render('login', { warning: 'Invalide eingabe. User konnte nicht gefunden werden.' });
		});
});

//-----------	Restricted routes	-----------

//-----------	arzt routes	-----------

/*
	Serve the rendered arztansicht.
*/
arzt.get('/arztansicht', (req, res) => {
	logger.log('server_traffic_info', 
		`User ${req[cfg.cookiesettings.cookieName].user.username} (${req.ip}) accessed ${req.originalUrl}`, 
		logMetaData);
	res.render('arztansicht', { user: `Dr. ${req[cfg.cookiesettings.cookieName].user.username}` });
});

arzt.get('/sse', (req, res) => {
	logger.log('server_traffic_info', 
		`User ${req[cfg.cookiesettings.cookieName].user.username} (${req.ip}) accessed ${req.originalUrl}`,
		logMetaData);
	console.log('Received GET request at /sse');
	// 	Set timeout as high as possible (in secs)
	req.setTimeout(Number.MAX_VALUE);
	//	Send headers for event-stream connection
	//	according to the html5 sse specs
	res.writeHead(200, {
		'Content-Type': 'text/event-stream',
		'Cache-Control': 'no-cache',
		'Connection': 'keep-alive'
	});
	res.write('\n');
	
	req.on('close', () => {
		//	Pop closed connection
		//	from the stack.
		arzt.locals.subscriptions.splice(
			arzt.locals.subscriptions.findIndex(x => x == res), 1);
	});
});

//-----------	ipadapp routes	-----------

ipadapp.get('/sse', (req, res) => {
	logger.log('server_traffic_info', 
		`User ${req[cfg.cookiesettings.cookieName].user} (${req.ip}) accessed ${req.originalUrl}`,
		logMetaData);
	console.log('Received GET request at /ipadapp/sse');
	// 	Set timeout as high as possible (in secs)
	req.setTimeout(Number.MAX_VALUE);
	//	Send headers for event-stream connection
	//	according to the html5 sse specs
	res.writeHead(200, {
		'Content-Type': 'text/event-stream',
		'Cache-Control': 'no-cache',
		'Connection': 'keep-alive'
	});
	res.write('\n');
	
	req.on('close', () => {
		//	Pop closed connection
		//	from the stack.
		ipadapp.locals.subscriptions.splice(
			ipadapp.locals.subscriptions.findIndex(x => x == res), 1);
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
});

//-----------	benutzer routes	-----------

benutzer.get('/sse', (req, res) => {
	logger.log('server_traffic_info', 
		`User ${req[cfg.cookiesettings.cookieName].user} (${req.ip}) accessed ${req.originalUrl}`,
		logMetaData);
	console.log('Received GET request at /benutzer/sse');
	// 	Set timeout as high as possible (in secs)
	req.setTimeout(Number.MAX_VALUE);
	//	Send headers for event-stream connection
	//	according to the html5 sse specs
	res.writeHead(200, {
		'Content-Type': 'text/event-stream',
		'Cache-Control': 'no-cache',
		'Connection': 'keep-alive'
	});
	res.write('\n');
	
	req.on('close', () => {
		//	Pop closed connection
		//	from the stack.
		benutzer.locals.subscriptions.splice(
			benutzer.locals.subscriptions.findIndex(x => x == res), 1);
	});
});
//-----------	app routes	-----------

/*
	If the user already had a recent session
	but tabbed out and re-requested /
	then redirect him back to his page.
*/
app.get('/', (req, res, next) => {
	logger.log('server_traffic_info', `${req.ip} accessed ${req.originalUrl}`, logMetaData);
	console.log('Root lookup ...');
	if (req[cfg.cookiesettings.cookieName].user) {
		//	The user already seems to have
		//	a valid cookie. Why demanding
		//	login credentials again then?
		//	Instead, redirect him to the right
		//	url, depending on his role.
		redirectUser(req[cfg.cookiesettings.cookieName].user.role, res);
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
	res.status(404).sendFile(path.join(__dirname, '/webfiles/misc/404.html')).end();
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
			ipadapp.locals.subscriptions.forEach((subscription) => {
				subscription.json(patient);
			});
		})
		.catch((error) => {
			logger.log('server_error', `db error: ${error}`, logMetaData);
		});
});

ginaInformation.on('error', (error) => {
	logger.log('gina_error', error, logMetaData);
});

ginaInformation.on('procerror', (error) => {
	logger.log('gina_proc_error', error, logMetaData);
});
