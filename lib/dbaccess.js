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
			this.DB.connect((err) => {
				if (err) {
					reject(err);
				} else {
					this.SQLCommandFeeder([`USE ${this.dbname}`])
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
	
	SQLCommandFeeder(commands) {
		return new Promise((resolve, reject) => {
			this.DB.query(commands[0], (err, result) => {
				if (err) {
					reject(err);
				}
				else {
					commands.splice(0, 1);	//	Pop the first command from the stack
					if(commands.length > 0)
						this.SQLCommandFeeder(commands)	//	Go to the next command
							.then((result) => resolve(result))
							.catch((error) => reject(error));
					else resolve(result);
				}
			});
		});
	}
	
	lookUpUser(credentials) {
		return new Promise((resolve, reject) => {
			this.SQLCommandFeeder(
				[
					'SELECT username, rolle ' +
					'FROM benutzer ' +
					`WHERE username = '${credentials.username}' AND passwort = hashPW('${credentials.password}', salt, 1000)`
				]
			)
			.then((user) => {
				if (user.length == 1) {
					resolve(user[0]);
				} else {
					reject(`Couldn't match user ${credentials.user} with the given password`);
				}
			})
			.catch((error) => reject(error));
		});
	}
	
	addPatient(patient) {
		return new Promise((resolve, reject) => {
			this.SQLCommandFeeder(
					[
						'INSERT IGNORE INTO patienten ' +
						`values ('${patient.svnr}', '${patient.vorname}', '${patient.nachname}', null, null, null, null, null, null, '${patient.titel}')`,
						`SELECT * FROM patienten WHERE pt_svnr = '${patient.svnr}'`
					]
				)
				.then((result) => {
					resolve(result);
				})
				.catch((error) => {
					reject(error);
				});
		});
	}
	
	updatePatient(patient) {
		return new Promise((resolve, reject) => {
			this.SQLCommandFeeder(
					[
						'INSERT IGNORE INTO patienten ' +
						`VALUES ('${patient.svnr}', '${patient.vorname}', '${patient.nachname}', null, null, null, null, null, null, '${patient.titel}')`,
						`SELECT * FROM patienten WHERE pt_svnr = '${patient.svnr}'`
					]
				)
				.then((result) => {
					resolve(result);
				})
				.catch((error) => {
					reject(error);
				});
		});
	}
}

module.exports = MySQLWrapper;
