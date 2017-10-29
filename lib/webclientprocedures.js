//-----------	Imports	-----------

const path = require('path');
const fs = require('fs');
const unixTime = require('unix-time');

//-----------	Private Fields -----------

const ASCII = 'AaBbcCDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz123456789';
const ASCII_len = ASCII.length;
const iterations = 26;
var DB;

//-----------	Constructor -----------

module.exports = (dbref) => {
	//	Field assignment
	DB = dbref;
	
	//	Function export
	return {
		sendPage: sendPage,
		createUserSession: createUserSession,
		checkIfCookieisValid: checkIfCookieisValid,
		redirectUserToPage: redirectUserToPage,
		setTimeStamp: setTimeStamp,
		lookupUser: lookupUser
	};
};

//-----------	Public Functions -----------

//	Function to send back the requested HTML file
const sendPage = (response, pathname) => {
	const mimeType = {
		  '.html': 'text/html'
	};
	fs.readFile(pathname, (err, data) => {
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

const createUserSession = (user) => {
	return new Promise((resolve, reject) => {
		DB.SQLCommandFeeder(['SELECT session_id FROM sessions'])
			.then((result) => {
				var token = generateSessionID();
				for(var n = 0; n < result.length; n++) 
					if(result[n].session_id == token) {
						token = generateSessionID();
						n = -1;
					}
				//	Delete the last cookie in the DB,
				//	even if there is none
				DB.SQLCommandFeeder(
					[
						'DELETE FROM sessions ' +
						'WHERE username = \'' + user.username + '\'',
						'INSERT INTO sessions ' + 
						'VALUES (\'' + token + '\', ' + null + ', \'' + user.username + '\')'
					]
				).then((result) => resolve(token))
				 .catch((error) => reject(error));
			});
	});
}

const checkIfCookieisValid = (cookies, cookieName) => {
	return new Promise((resolve, reject) => {
		DB.SQLCommandFeeder(['SELECT * FROM sessions'])
			.then((session) => {
				var flag = true;
				for(var n = 0; n < session.length; n++)
					if(cookies[cookieName] == session[n].session_id) {
						 //	Return, if the timestamp is null
						 if(session[n].timestamp == null) {
						  flag = false;
						 	resolve(session);
						 }
						 //	Refresh timestamp of the session (set to 0)
						 if(session[n].timestamp >= unixTime(new Date())) {
						 	flag = false;
						 	setTimeStamp(cookies[cookieName], null)
						 		.then((valid) => resolve(session))
						 		.catch((error) => reject(error));
						 	}
						 //	Cookie already overdue
						 else resolve({});
					}
					
				if(flag) resolve({});
			})
			.catch((error) => reject(error));
	});
}

const redirectUserToPage = (user, res) => {
	switch(user.rolle) {
		case 'arzt': 		res.redirect('/role/arzt/arztansicht.html'); 			break;
		case 'nutzer': 	res.redirect('/role/benutzer/warteliste.html'); 	break;
	}
}

const lookupUser = (credentials) => {
	return new Promise((resolve, reject) => {
		DB.SQLCommandFeeder(
			[
				'SELECT username, rolle ' + 
				'FROM benutzer ' + 
				'WHERE username = \'' + credentials.username + '\'' + ' AND ' + 
				'aes_decrypt(passwort, \'x0M9ErVpTVi98cWffCs1NRjQ9QixVq9X\') =\'' + credentials.password + '\''
			]
		)
		.then((user) => {
			if(user.length == 1) resolve(user[0]);
			reject('Benutzer konnte nicht gefunden werden');
		})
		.catch((error) => reject(error));
	});
}

const setTimeStamp = (sessionID, timestamp) => {
	return new Promise((resolve, reject) => {
		DB.SQLCommandFeeder(
			[
				'UPDATE sessions ' +
				'SET timestamp = ' + timestamp +
				' WHERE session_id = \'' + sessionID + '\''
			]
		)
		.then(() => resolve(true))
		.catch((error) => reject(error));
	});
}

//-----------	Private Functions -----------

//	Creates a random string token with a length of 26
const generateSessionID = () => {
	//	Note: Math.round() returns a number between 0 (inklusive) and 1 (exklusive)
	var token = "";
	for(var n = 0; n < iterations; n++)
		token += ASCII.charAt(Math.floor(Math.random() * ASCII_len));
	return token;
}
