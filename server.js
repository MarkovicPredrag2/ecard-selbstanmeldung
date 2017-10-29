//-----------	Imports	-----------

const express 			= require('express');
const bodyParser 		= require('body-parser');
const cookieParser 	= require('cookie-parser');
const unixTime 			= require('unix-time');

//-----------	App settings	-----------

//	Initialise app instances
//	The intendation symbolises the
//	order in the inhertiance tree
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
//	Set children apps
server.use('/public', public);
server.use('/role', role);

//	Set the middleware (will be inherited)
role.use(cookieParser());
//	Authentication function
//	Every app within the restricted route will use this function
role.use(function checkAuthentication(req, res, next) {
	if (typeof req.cookies[server.locals.cookieName] !== 'undefined')	//	For performance reasons
		webclientModule.checkIfCookieisValid(req.cookies, server.locals.cookieName)
			.then((session) => {
				//	If cookie is valid,
				//	invoke next middleware-function
				if (Object.keys(session).length > 0) next();
				//	If not,
				//	send the login page
				else {
					//	Delete cookie, since its already overdue
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

//-----------	DB connection	-----------

//	TODO:
//	Assignment through hidden config file
//	Including: host, user, dbms-password, DB, port, 256bit AES Key
var webclientModule;
const DB = require('./lib/dbaccess.js')('localhost', 'root', 'v2tJ)Jjt=NS!F<%', 'lokalePatientenDB');
DB.connect()
	.then((result) => {
		//	After the DB connection has been established,
		webclientModule = require('./lib/webclientprocedures.js')(DB);
		//	listen on the given port
		server.listen(8080, () => console.log('Listen on port 8080 ...'));
	})
	.catch((error) => console.error(error));
	
//-----------	public routes	-----------

public.post('/login', (req, res) => {
	console.log('Received POST request at /');
	
	webclientModule.lookupUser(req.body)
		.then((user) => {
			//	Create unique session id
			webclientModule.createUserSession(user)
				.then((sessionUID) => {
					//	Send cookie with session UID back
					res.cookie(server.locals.cookieName, sessionUID);
					//	Redirect the user to
					//	the correct page
					webclientModule.redirectUserToPage(user, res);
				})
				.catch((error) => {
					//	Send back wrong credentials
					//	message to the client
					console.error(error);
					res.end('Scheisse, da war Scheisse.');
				});
		})
		.catch((error) => console.error(error));
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

//-----------	static file service	-----------

//	Serves all files from the webroot directory
server.use('/', express.static('./webroot', {index: '/public/login.html', fallthrough: false}));

//	If not found, return '404 not found' file
server.use(function notFoundError(err, req, res, next) {
	//	ToDo:
	//	Send 404 File
	res.status(404).send('Nix gefunden').end();
});

/*setInterval(function() {
    // we walk through each connection
    openConnections.forEach(function(resp) {
        var d = new Date();
        resp.write('id: ' + d.getMilliseconds() + '\n');
        resp.write('data:' + createMsg() +   '\n\n'); // Note the extra newlines
    });

}, 1000);*/
