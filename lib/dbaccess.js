//-----------	Imports	-----------

const mysql = require('mysql');

class MySQLWrapper {
	constructor(host, user, pw, dbname, transaction) {
		this.host 	= host;
		this.user		= user;
		this.pw			= pw;
		this.dbname	= dbname;
		this.transaction = transaction;
	}

	connect() {
		return new Promise((resolve, reject) => {
			this.DB = mysql.createConnection({
				host: this.host,
				user: this.user,
				password: this.pw
			});

			var autocommit = `SET autocommit = 1`;

			if (this.transaction) {
				autocommit = `SET autocommit = 0`;
			}

			//	Baut die Verbindung zur Datenbank auf.
			this.DB.connect((err) => {
				if (err) {
					reject(err);
				} else {
					this.SQLCommandFeeder([`USE ${this.dbname}`, autocommit])
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
					if (this.transaction) {
						// Rollback queries after error
						var error = err;
						this.DB.query('ROLLBACK', (err, result) => {
							reject(error);
						});
					} else {
						reject(err);
					}
				}
				else {
					commands.splice(0, 1);	//	Pop the first command from the stack
					if(commands.length > 0)
						this.SQLCommandFeeder(commands)	//	Go to the next command
							.then((result) => resolve(result))
							.catch((error) => reject(error));
					else {
						if (this.transaction) {
							// Commit queries after success
							var queryResult = result;
							this.DB.query('COMMIT', (err, result) => {
								resolve(queryResult);
							});
						} else {
							resolve(result);
						}
					}
				}
			});
		});
	}
}

module.exports = MySQLWrapper;
