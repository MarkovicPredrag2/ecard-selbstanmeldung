//-----------	Imports	-----------
const mysql = require('mysql');

//-----------	Private Fields -----------
var DB;
var HOST;
var USER;
var PASSWORD;
var DBNAME;

//-----------	Constructor -----------
module.exports = 
	(host, user, password, dbname) => {
	//Field assignment
	HOST 			= host;
	USER 			= user;
	PASSWORD 	= password;
	DBNAME 		= dbname;
	
	//Function export
	return {
		connect: connect,
		SQLCommandFeeder: SQLCommandFeeder
	};
};

//-----------	Public Functions -----------
const SQLCommandFeeder = 
	(commands) => {
		return new Promise((resolve, reject) => {
			DB.query(commands[0], (err, result) => {
				if (err) {
					console.error(err);
					reject();
				} 
				else {
					commands.splice(0, 1);	//	Pop the first command from the stack
					if(commands.length > 0)
						SQLCommandFeeder(commands)	//	Go to the next command
							.then((result) => resolve(result))
							.catch((error) => reject(error));
					else resolve(result);
				}
			});
		});
	};

const connect = 
	() => {
		DB = mysql.createConnection({
				host: HOST,
				user: USER,
				password: PASSWORD
		});
		//	Funktion zum binary-seitigen Erstellen 
		//	und Verwenden der Patienten-DB
		DB.connect((err) => {
			if (err) console.error(err);
			else { 
				console.log("Verbindung zum DBMS wurde hergestellt");
		
				const commands = [
					'CREATE DATABASE IF NOT EXISTS ' + DBNAME,
					'USE ' + DBNAME,
					'CREATE TABLE IF NOT EXISTS patienten (' 			+
						'pt_svnr CHAR(10), '												+
						'pt_vorname VARCHAR(255) NOT NULL, ' 				+ 
						'pt_nachname VARCHAR(255) NOT NULL, ' 			+
						'pt_lebensjahr TINYINT UNSIGNED NOT NULL, '	+
						'pt_adresse VARCHAR(255) NOT NULL, ' 				+
						'pt_hausnummer SMALLINT UNSIGNED NOT NULL, '+
						'pt_stiege TINYINT UNSIGNED NOT NULL, ' 		+
						'pt_plz SMALLINT UNSIGNED NOT NULL, ' 			+
						'pt_ort VARCHAR(255) NOT NULL, '						+
						'CONSTRAINT pt_id PRIMARY KEY (pt_svnr)' 		+
					')'
				];
				SQLCommandFeeder(commands)
					.then((result) => console.log('Verbindung zur DB ' + DBNAME + ' wurde hergestellt')) 
					.catch((error) => console.error(error));
			}
		});
	};

//-----------	Private Functions -----------
const checkIfPayloadIsComplete = 
	(payload) => {
		return 	payload.svnr			&&
						payload.vorname 	&& 
						payload.nachname 	&&
						payload.alter			&&
						payload.addresse	&&
						payload.hn				&&	//	hn = Hausnummer
						payload.stiege		&&
						payload.plz				&&
						payload.ort;
	};
