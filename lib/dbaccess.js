//-----------	Imports	-----------

const mysql = require('mysql');

class MySQLWrapper {
	constructor(host, user, pw, dbname) {
		this.host 	= host;
		this.user		= user;
		this.pw			= pw;
		this.dbname	= dbname;
	}
	
	connect() {
		return new Promise((resolve, reject) => {
			this.DB = mysql.createConnection({
				host: this.host,
				user: this.user,
				password: this.pw
			});
			//	Baut die Verbindung zur Datenbank auf.
			DB.connect((err) => {
				if (err) {
					reject(err);
				} else {
					SQLCommandFeeder([`USE ${this.dbname}`])
						.then((result) => {
							resolve(result);
						})
						.catch((error) => {
							reject(error);
						});
				}
			});
		});	
	}
	
	SQLCommandFeeder() {
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
	}
}

module.exports = MySQLWrapper;
