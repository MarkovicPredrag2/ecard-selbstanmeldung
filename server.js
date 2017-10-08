const express = require('express');
const http = require('http');
const os = require('os');
const path = require('path');
const fs = require('fs');
const cookieParser = require('cookie-parser');
const DBMS = require('./lib/dbaccess.js');

var app = express();
var openConnections = [];
var DB = DBMS('localhost', 'root', 'v2tJ)Jjt=NS!F<%', 'lokalePatientenDB');	//	Create connection to DB
DB.connect();
// 	configure everything, just basic setup	
//	app.set() -> Used to set special behaviours to the website (i.e.: strict-url mode)
//	app.use()	->	Used to add middleware functions to express in order to extend the
app.use('/resources', express.static('public/resources'));
app.use('/login', express.static('public/login.html'));
app.use(cookieParser());

app.get('/ansicht/arztansicht', (req, res) => {
	console.log('Received GET request at /ansicht/arztansicht');
	console.log(req.cookies);
	//	TODO: 
	//	If valid PW OR Cookie, grant access
	//	If not, redirect to /login
	//	res.redirect('/login');
	sendHtmlFile(res, './public/ansicht/arztansicht.html');
});

app.get('/ansicht/warteliste', (req, res) => {
	console.log('Received GET request at /ansicht/warteliste');
	console.log(req.cookies);
	//	TODO: 
	//	If valid PW OR Cookie, then grant access
	//	If not, redirect to /login
	//	res.redirect('/login');
	sendHtmlFile(res, './public/ansicht/arztansicht.html');
});

app.get('/', (req, res) => {
	res.redirect('/login');
});

app.post('/login', (req, res) => {
	console.log('Received POST request at /login');
	console.log(req.cookies);
	console.log(req.body);
	//	TODO:
	//	If Username && PW correct, then send cookie
	//	and send the corresponding html site.
	//	If wrong, send error message.
	res.cookie('mar16271','riu987wadoadmpoawd');
	sendHtmlFile(res, './public/ansicht/arztansicht.html');
});


// simple route to register the clients
app.get('/sse', function(req, res) {
		console.log('Received GET request at /sse');
		console.log(req.cookies);
		//	Always check, if cookie is valid
    // set timeout as high as possible
    req.setTimeout(1000);

    // send headers for event-stream connection
    // according to the html5 sse specs
    res.writeHead(200, {
        'Content-Type': 'text/event-stream',
        'Cache-Control': 'no-cache',
        'Connection': 'keep-alive'
    });
    res.write('\n');
		console.log("Message header sent ...");
    // push this res object to our global variable
    openConnections.push(res);

    // When the request is closed, e.g. the browser window
    // is closed, we search through the open connections
    // array and remove this connection.
    req.on('close', function() {
        var toRemove;
        for (var j =0 ; j < openConnections.length ; j++) {
            if (openConnections[j] == res) {
                toRemove =j;
                break;
            }
        }
        openConnections.splice(j,1);
        console.log(openConnections.length);
    });
});

/*setInterval(function() {
    // we walk through each connection
    openConnections.forEach(function(resp) {
        var d = new Date();
        resp.write('id: ' + d.getMilliseconds() + '\n');
        resp.write('data:' + createMsg() +   '\n\n'); // Note the extra newlines
    });

}, 1000);*/

//	Function to send back the requested HTML file
function sendHtmlFile(response, pathname) {
	const mimeType = {
		  '.html': 'text/html'
	};
	fs.readFile(pathname, function(err, data){
		if(err) {
			response.statusCode = 500;
			response.end(`Error getting the file: ${err}.`);
		} else {
				// based on the URL path, extract the file extention. e.g. .js, .doc, ...
				const ext = path.parse(pathname).ext;
				// if the file is found, set Content-type and send data
				response.setHeader('Content-type', mimeType[ext] || 'text/plain' );
				response.end(data);
		}
	});
}

app.listen(8080, () => console.log('Listen on port 8080 ...'));
