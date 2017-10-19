const express = require('express');
const bodyParser = require('body-parser');
const cookieParser = require('cookie-parser');

const DBMS = require('./lib/dbaccess.js');
const webclientModule = require('./lib/webclientprocedures.js');

var app = express();
var DB = DBMS('localhost', 'root', 'v2tJ)Jjt=NS!F<%', 'lokalePatientenDB');	//	Create connection to DB
DB.connect();

app.use('/resources', express.static('public/resources'));
app.use('/login', express.static('public/login.html'));
app.use(cookieParser());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json())

app.get('/ansicht/arztansicht', (req, res) => {
	console.log('Received GET request at /ansicht/arztansicht');
	//	TODO: 
	//	If valid Cookie, grant access
	//	If not, redirect to /login
	//	res.redirect('/login'); 
	webclientModule.validateCookie(DB, req.cookies)
		.then((valid, unvalid) => {
			if (valid) 
				webclientModule.sendHtmlFile(res, './public/ansicht/arztansicht.html');
			else
				res.redirect('/login');
		})
		.catch((error) => {
			//	Respond with error message 
			console.error(error);
		});
});

app.get('/ansicht/warteliste', (req, res) => {
	console.log('Received GET request at /ansicht/warteliste');
	//	TODO: 
	//	If valid Cookie, then grant access
	//	If not, redirect to /login
	webclientModule.validateCookie(DB, req.cookies)
		.then((valid, unvalid) => {
			if (valid) 
				webclientModule.sendHtmlFile(res, './public/ansicht/arztansicht.html');
			else
				res.redirect('/login');
		})
		.catch((error) => {
			//	Respond with error message 
			console.error(error);
		});
});

app.get('/', (req, res) => {
	console.log('Received a GET request at /login');
	res.redirect('/login');
});

app.post('/login', (req, res) => {
	console.log('Received POST request at /login');
	const login = req.body;
	DB.SQLCommandFeeder(
			[
				'Select * from benutzer where username = \'' + login.username + '\'' +
				' AND ' + 'aes_decrypt(passwort, \'x0M9ErVpTVi98cWffCs1NRjQ9QixVq9X\') =\'' + login.password + '\''
			]
		).then((result) => {
				if(result.length == 1) {
					//	Create unique session id
					webclientModule.createUserSession(DB, login.username)
						.then((sessionUID) => {
							//	Send cookie with session UID back
							res.cookie(login.username, sessionUID);
							//	Check the role of the user
							switch(result[0].rolle) {
								case 'arzt': 		res.redirect('/ansicht/arztansicht'); break;
								case 'nutzer': 	res.redirect('/ansicht/warteliste'); 	break;
							}
						})
						.catch((error) => {
							//	Respond with error message
							console.error(error);
						});
				}
			
				else {
					//	Send back wrong credentials
					//	message to the user
					res.end('Scheisse, da war scheisse.');
				}
		});
});


// simple route to register the clients
app.get('/sse', function(req, res) {
		console.log('Received GET request at /sse');
		console.log(req.cookies);
		//	Always check, if cookie is valid
    // 	set timeout as high as possible
    req.setTimeout(Number.MAX_VALUE);

    //	send headers for event-stream connection
    //	according to the html5 sse specs
    res.writeHead(200, {
        'Content-Type': 'text/event-stream',
        'Cache-Control': 'no-cache',
        'Connection': 'keep-alive'
    });
    res.write('\n');
    
		console.log("Message header sent ...");
		
    // push this res object to our global variable
    //openConnections.push(res);

    // When the request is closed, e.g. the browser window
    // is closed, we search through the open connections
    // array and remove this connection.
    req.on('close', function() {
        /*DB.SQLCommandFeeder(['delete from sessions where session_id =' + req.cookie.])
        	.then((resolve) => {
        		
        	})
        	.catch((error) => console.error(error));*/
    });
});

app.listen(8080, () => console.log('Listen on port 8080 ...'));
