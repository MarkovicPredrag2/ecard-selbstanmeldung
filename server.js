const express = require('express');
const bodyParser = require('body-parser');
const cookieParser = require('cookie-parser');
const unixTime = require('unix-time');

const DB = require('./lib/dbaccess.js')('localhost', 'root', 'v2tJ)Jjt=NS!F<%', 'lokalePatientenDB');
DB.connect();
const webclientModule = require('./lib/webclientprocedures.js')(DB);

var app = express();
app.use('/resources', express.static('public/resources'));
app.use(cookieParser());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

app.get('/', (req, res) => res.redirect('/login'));

app.get('/ansicht/arztansicht', (req, res) => {
	console.log('Received GET request at /ansicht/arztansicht');
	//	Check, if the user already has a (valid) cookie (for forwarding).
	//	If not, send the login page
	if(typeof req.cookies['AnsichtSessionCookie'] !== 'undefined')	//	For performance reasons
		webclientModule.checkIfCookieisValid(req.cookies)
			.then((user) => {
				//	If cookie is valid, send
				//	the corresponding page
				if(Object.keys(user).length > 0) webclientModule.sendPage(res, './public/ansicht/arztansicht.html');
				//	If not,
				//	redirect to /login
				else res.redirect('/login');
			})
			.catch((error) => {
				//	Respond with error message
				console.error(error);
			});
	else res.redirect('/login');
});

app.get('/ansicht/warteliste', (req, res) => {
	console.log('Received GET request at /ansicht/warteliste');
	//	Check, if the user already has a (valid) cookie (for forwarding).
	//	If not, send the login page
	if(typeof req.cookies['AnsichtSessionCookie'] !== 'undefined')	//	For performance reasons
		webclientModule.checkIfCookieisValid(req.cookies)
			.then((user) => {
				//	If cookie is valid, send
				//	the corresponding page
				if(Object.keys(user).length > 0) webclientModule.sendPage(res, './public/ansicht/arztansicht.html');
				//	If not,
				//	redirect to /login
				else res.redirect('/login');
			})
			.catch((error) => {
				//	Respond with error message
				res.redirect('/login');
				console.error(error);
			});
	else res.redirect('/login');
});

app.get('/login', (req, res) => {
	console.log('Received GET request at /login');
	//	Check, if the user already has a (valid) cookie (for forwarding).
	//	If not, send the login page
	if(typeof req.cookies['AnsichtSessionCookie'] !== 'undefined')	//	For performance reasons
		webclientModule.checkIfCookieisValid(req.cookies)
			.then((user) => {
				//	If cookie is valid, redirect
				//	user to corresponding page
				if(Object.keys(user).length > 0) webclientModule.redirectUserToPage(user, res);
				//	If not,
				//	send the login page
				else {
					//	Delete cookie, since its already overdue
					res.clearCookie('AnsichtSessionCookie');
					webclientModule.sendPage(res, './public/login.html');
				}
			})
			.catch((error) => {
				//	Send error message back
				res.end(error);
				console.error(error);
			});
	else webclientModule.sendPage(res, './public/login.html');
});

app.post('/login', (req, res) => {
	console.log('Received POST request at /login');
	
	webclientModule.lookupUser(req.body)
		.then((user) => {
			//	Create unique session id
			webclientModule.createUserSession(user)
				.then((sessionUID) => {
					//	Send cookie with session UID back
					res.cookie('AnsichtSessionCookie', sessionUID);
					//	Redirect the user to
					//	the correct page
					webclientModule.redirectUserToPage(user, res);
				})
				.catch((error) => {
					//	Send back wrong credentials
					//	message to the client
					console.error(error);
					res.end('Scheisse, da war scheisse.');
				});
		});
});

app.get('/sse', (req, res) => {
	console.log('Received GET request at /sse');
	
	if(typeof req.cookies['AnsichtSessionCookie'] !== 'undefined')	//	For performance reasons
		webclientModule.checkIfCookieisValid(req.cookies)
			.then((user) => {
				//	If cookie is valid, send
				//	allow streaming
				if(Object.keys(user).length > 0) {
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
				
					console.log("Message header sent ...");
		
					req.on('close', () => {
					 //	Set 5 minute timestamp for request
					 //	whose connection broke up
					 webclientModule.setTimeStamp(req.cookies['AnsichtSessionCookie'], (unixTime(new Date()) + 300));
					});
				}
				//	If not,
				//	redirect to /login
				else res.redirect('/login');
			})
			.catch((error) => {
				//	Respond with error message
				res.redirect('/login');
				console.error(error);
			});
	else res.redirect('/login');
});

/*setInterval(function() {
    // we walk through each connection
    openConnections.forEach(function(resp) {
        var d = new Date();
        resp.write('id: ' + d.getMilliseconds() + '\n');
        resp.write('data:' + createMsg() +   '\n\n'); // Note the extra newlines
    });

}, 1000);*/

app.listen(8080, () => console.log('Listen on port 8080 ...'));
