const path = require('path');
const fs = require('fs');

const ASCII = 'AaBbcCDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz123456789?=()&%$§!?_<>';
const ASCII_len = ASCII.length;

//	Creates a random string token
//	with a length between 25 and 35
exports.generateSessionID = () => {
	//	Note: Math.round() returns a number between 0 (inklusive) and 1 (exklusive)
	const iterations = 25 + Math.floor(Math.random() * 11);
	var token = "";
	
	for(var n = 0; n < iterations; n++)
		token += ASCII.charAt(Math.floor(Math.random() * ASCII_len));
		
	return token;
}

//	Function to send back the requested HTML file
exports.sendHtmlFile = (response, pathname) => {
	const mimeType = {
		  '.html': 'text/html'
	};
	fs.readFile(pathname, function(err, data) {
		if(err) {
			response.statusCode = 500;
			console.error(err);
		} else {
				// based on the URL path, extract the file extention. e.g. .js, .doc, ...
				const ext = path.parse(pathname).ext;
				// if the file is found, set Content-type and send data
				response.setHeader('Content-type', mimeType[ext] || 'text/plain' );
				response.end(data);
		}
	});
}

exports.createUserSession = (DB, username) => {
	return new Promise((resolve, reject) => {
		DB.SQLCommandFeeder(['select session_id from sessions'])
			.then((result) => {
				var token = exports.generateSessionID();
				for(var n = 0; n < result.length; n++) {
					if(result[n].session_id == token) {
						token = exports.generateSessionID();
						n = -1;
					}
				}
				DB.SQLCommandFeeder(['insert into sessions values (\'' + token + '\', ' + 0 + ', \'' + username + '\')'])
					.then((result) => resolve(token))
					.catch((error) => console.error(error));
			});
	});
}

exports.validateCookie = (DB, cookieObj) => {
	return new Promise((resolve, reject) => {
		DB.SQLCommandFeeder(['select * from sessions'])
			.then((result) => {
				var cookies = cookieObj;
				console.log(result);
				/*for(var n = 0; n < result.length; n++)
					for(var m = 0; m < cookies.length; m++)
						if (	cookies[result[n].username] != 'undefined' && 
									cookies[result[n].username] == result.session_id	)
										resolve(true);
				reject(false);*/
			})
			.catch((error) => console.error(error));
	});
}
/*setInterval(function() {
    // we walk through each connection
    openConnections.forEach(function(resp) {
        var d = new Date();
        resp.write('id: ' + d.getMilliseconds() + '\n');
        resp.write('data:' + createMsg() +   '\n\n'); // Note the extra newlines
    });

}, 1000);*/
