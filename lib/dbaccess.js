//-----------	Imports	-----------

const mysql = require('mysql');

START Transaction
INSERT INTO ...
IF result_insert1 = true
	INSERT INTO ...
	COMMIT;
ELSE rollback;

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

			if (transaction) {
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
          // Rollback queries after error
					var error = err;
					this.DB.query('ROLLBACK', (err, result) => {
						reject(error);
					});
				}
				else {
					commands.splice(0, 1);	//	Pop the first command from the stack
					if(commands.length > 0)
						this.SQLCommandFeeder(commands)	//	Go to the next command
							.then((result) => resolve(result))
							.catch((error) => reject(error));
					else {
						// Commit queries after error
						this.DB.query('COMMIT', (err, result) => {
							resolve(result);
						});
					}
				}
			});
		});
	}
}

module.exports = MySQLWrapper;
