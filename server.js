//-----------	Imports	-----------

const express 			= require('express');
const bodyParser 		= require('body-parser');
const cookieParser 	= require('cookie-parser');
const unixTime 			= require('unix-time');
const DB 						= require('./lib/dbaccess.js')('localhost', 'root', 'v2tJ)Jjt=NS!F<%', 'lokalePatientenDB');
const ginaListener	= require('./lib/ginaBaseService.js');
const fs 						= require('fs');
const https2 				= require('http2');

//-----------	App settings	-----------
/*
	Keys for a secure https connection.
	===================================
	
	key: Path to the private key.
	crt: Path to the certificate.
	ca: Path to the chaining file.
*/
const keys = {
	key: fs.readFileSync('/home/ecard/ssl-cert/five4u_spengergasse_at.key'), 
  cert: fs.readFileSync('/home/ecard/ssl-cert/five4u_spengergasse_at_2246905/five4u_spengergasse_at.crt')
};

/*
	Initialise app instances.
	The intendation corresponds to the
	order in the inhertiance tree.
*/
const server 		= express(),
				public 			= express(),
				role			 	= express(),
					arzt 				= express(),
					benutzer		= express();

//	Global variables
server.locals.cookieName = 'AnsichtSessionCookie';

//	Set the middleware (will be inherited)
server.use(bodyParser.urlencoded({ extended: false }));
server.use(bodyParser.json());
server.use(cookieParser());

//	Set children apps
server.use('/public', public);
server.use('/role', role);

/*
	Authentication function:
	Every app within the restricted route will use this function.
*/
role.use((req, res, next) => {
	console.log('Permission lookup ...');
	if (typeof req.cookies[server.locals.cookieName] !== 'undefined')	//	For performance reasons
		webclientModule.checkIfCookieisValid(req.cookies, server.locals.cookieName)
			.then((session) => {
				//	If cookie is valid,
				//	invoke next middleware-function
				if (Object.keys(session).length > 0) {
					res.locals.role = session.rolle;
					next();
				} else {
					//	If not, send the login page.
					//	Delete cookie, since its already overdue.
					res.clearCookie(server.locals.cookieName);
					//	and redirect user to the login
					res.redirect('/');
				}
			})
			.catch((error) => {
				//	Send error message back
				res.end(error);
				console.error(error);
			});
	else res.redirect('/');
});

//	Set children apps
role.use('/arzt', arzt);
role.use('/benutzer', benutzer);

//	Check, if the user is
//	permitted to request
//	the arzt resources.
arzt.use((req, res, next) => {
	console.log('Entered arzt realm');
	if (res.locals.role === 'arzt') {
		next();
	} else {
		res.end('Access denied.');
	}
});

//	Check, if the user is
//	permitted to request
//	the benutzer resources.
benutzer.use((req, res, next) => {
	console.log('Entered benutzer realm');
	if (res.locals.role === 'nutzer') {
		next();
	} else {
		res.end('Access denied.');
	}
});

//-----------	DB connection	-----------

//	TODO:
//	Assignment through hidden config file
//	Including: host, user, dbms-password, DB, port, 256bit AES Key
var webclientModule;
DB.connect()
	.then((result) => {
		//	After the DB connection has been established,
		webclientModule = require('./lib/webclientprocedures.js')(DB);
		/*
			Https2 listens on both http ports, so there is no
			way of using http.
		*/
		https2.createSecureServer(keys, server).listen(8080);
		https2.createSecureServer(keys, server).listen(8081);
	})
	.catch((error) => console.error(error));
	
//-----------	public routes	-----------

public.post('/login', (req, res) => {
	console.log('Received POST request at /login');
	//	Does the user actually exist?
	webclientModule.lookupUser(req.body)
		.then((user) => {
			//	Create unique session id.
			webclientModule.createUserSession(user)
				.then((sessionUID) => {
					//	Create and send cookie with session UID back.
					res.cookie(server.locals.cookieName, sessionUID);
					//	Redirect the user to
					//	the correct page
					webclientModule.redirectUserToPage(user.rolle, res);
				})
				.catch((error) => {
					//	Send back wrong credentials
					//	message to the client.
					console.error(error);
					res.end('Scheisse, da war Scheisse.');
				});
		})
		.catch((error) => {
			//	Send back wrong credentials
			//	message to the client.
			console.error(error); 
		});
});

//-----------	restricted routes	-----------

//-----------	arzt routes	-----------

arzt.get('/sse', (req, res) => {
	console.log('Received GET request at /sse');
	
	// 	Set timeout as high as possible
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
		//	Set 5 minute timestamp for request
		//	whose connection broke up
		webclientModule.setTimeStamp(req.cookies[server.locals.cookieName], (unixTime(new Date()) + 300));
	});
});

//-----------	benutzer routes	-----------

//	TODO:
//	Implement /sse-feed for benutzer

//-----------	server routes	-----------

//	If the user already had a recent session
//	but tabbed out and re-requested /
//	then redirect him back to his page
server.get('/', (req, res, next) => {
	console.log('Root lookup ...');
	if (typeof req.cookies[server.locals.cookieName] !== 'undefined')	//	For performance reasons
		webclientModule.checkIfCookieisValid(req.cookies, server.locals.cookieName)
			.then((session) => {
				//	If cookie is valid,
				//	invoke next middleware-function
				if (Object.keys(session).length > 0)
					webclientModule.redirectUserToPage(session.rolle, res);
				//	If not,
				//  invoke next middleware
				else {
					//	Delete cookie, since its already overdue
					res.clearCookie(server.locals.cookieName);
					next();
				}
			})
			.catch((error) => {
				//	Send error message back
				res.end(error);
				console.error(error);
			});
	else next();
});

//	Serves all files from the webroot directory statically
server.use('/', express.static('./webroot', {index: '/public/login.html', fallthrough: false}));

//	If not found, return '404 not found' file
server.use((err, req, res, next) => {
	//	TODO:
	//	Send 404 File
	res.status(404).send('Nix gefunden').end();
});

/*
	Establish the gina connection.
	Note: There are 3 different events 
	for this function.
	==================================
	
	data: Gets emitted when a patient plugged
		an e-card.
	==========================================
	
	error: Gets emitted when errors from 
		the ecard occur.
	==========================================
	
	procerror: Gets emitted when errors from 
		the process itself occur.
	==========================================
*/
const ginaInformation = ginaListener.listen('10.196.2.18', 'Test-03 (02:94:93)', 400, true);

ginaInformation.on('data', (patient) => {
	console.log(patient);
});

ginaInformation.on('error', (error) => {
	console.error(error);
});

ginaInformation.on('procerror', (error) => {
	console.error(error);
});
