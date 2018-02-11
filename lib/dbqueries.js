const MySQLWrapper = require('./lib/dbaccess.js');

class SelbstanmeldungsDB extends MySQLWrapper {
  constructor(host, user, pw, dbname, transaction = false) {
    super(host, user, pw, dbname, transaction);
  }

  lookUpUser(credentials) {
		return new Promise((resolve, reject) => {
			this.SQLCommandFeeder(
				[
					`SET @ergebnis = (SELECT b_username as 'username', b_r_role as 'role' ` +
					`FROM b_benutzer ` +
					`WHERE b_username = '${ this.DB.escape(credentials.username) }' AND b_passwort = hashPW('${ this.DB.escape(credentials.password) }'), b_salt, 1000)`,
          `CALL log_anmeldung(@ergebnis)`,
          `SELECT @ergebnis`
				]
			)
			.then((user) => {
				if (user.length == 1) {
					resolve(user[0]);
				} else {
					reject(`Couldn't match user ${ this.DB.escape(credentials.user) } with the given password`);
				}
			})
			.catch((error) => reject(error));
		});
	}

	addPatient(patient) {
		return new Promise((resolve, reject) => {
			this.SQLCommandFeeder(
					[
						`INSERT IGNORE INTO p_patient ` +
						`VALUES ('${ this.DB.escape(patient.svnr) }', '${ this.DB.escape(patient.titel) }', '${ this.DB.escape(patient.geschlecht) }', '${ this.DB.escape(patient.nachname) }', '${ this.DB.escape(patient.vorname) }', '${ this.DB.escape(patient.geburtsdatum) }', '${ this.DB.escape(patient.hausnummer) }', '${ this.DB.escape(patient.ort) }', '${ this.DB.escape(patient.plz) }', '${ this.DB.escape(patient.postfachnummer) }', '${ this.DB.escape(patient.postfachtext) }', '${ this.DB.escape(patient.staatscode) }', '${ this.DB.escape(patient.stocktuernummer) }', '${ this.DB.escape(patient.strasse) }')`,
						`SELECT * FROM p_patient WHERE p_svnr = '${ this.DB.escape(patient.svnr) }'` // TODO: Bearbeitung des SELECT Query nach Fertigstellung der DB (absprache mit Pirker)

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

  dumpLog(logart) {
    return new Promise((resolve, reject) => {
      this.SQLCommandFeeder(
        [
          `SELECT l_daten as 'Daten', l_timestamp as 'Timestamp', l_id as 'id' FROM l_log WHERE l_la_art = '${ this.DB.escape(logart) }'`
        ]
      )
      .then((result) => {
         resolve(result);
       })
       .catch((error) => {
         reject(error);
       })
    });
  }

	updatePatient(patient) {
		return new Promise((resolve, reject) => {
			// TODO: Implement update function
		});
	}

	getWartelistePatients() {
		return new Promise((resolve, reject) => {
			this.SQLCommandFeeder(
				[
					"SELECT w_warteliste.w_g_grund as 'grund', " +
						"p_patient.p_svnr as 'svnr', " +
						"p_patient.p_titel as 'anrede', " +
						"p_patient.p_vorname as 'vorname', " +
						"p_patient.p_nachname as 'nachname', " +
						"p_patient.p_gebdat as 'alter' " +
					"FROM w_warteliste INNER JOIN p_patienten " +
					"ON w_warteliste.w_patient_p_svnr = p_patienten.p_svnr ORDER BY w_warteliste.w_rank"
				]
			)
			.then((result) => {
				resolve(result);
			 })
			 .catch((error) => {
				reject(error);
			 })
		});
	}

	getPatientData(svnr) {
		return new Promise((resolve, reject) => {
			// TODO: Inner Join for p_grund
			this.SQLCommandFeeder(
				[
					`SELECT p_patient.p_vorname as 'vorname ' `+
            `p_patient.p_nachname as 'nachname', ` +
            `w_warteliste.w_g_grund as 'grund' ` +
					`FROM p_patient INNER JOIN w_warteliste ` +
					`ON w_warteliste.w_patient_p_svnr = p_patient.p_svnr ` +
					`WHERE p_svnr = ${ this.DB.escape(svnr) }`
				]
			)
			.then((result) => {
			 	resolve(result);
			 })
			 .catch((error) => {
			 	reject(error);
			 })
		});
	}

	rankWarteliste(from, to) {
		return new Promise((resolve, reject) => {
			// TODO: Implement Transaction
			this.SQLCommandFeeder(
				[
					`SET @from = (SELECT w_rank FROM w_warteliste WHERE w_patient_p_svnr = ${ this.DB.escape(from) })`,
					`SET @to = IF(${ this.DB.escape(to) } LIKE '0', (SELECT MAX(w_rank) FROM w_warteliste), ((SELECT w_rank FROM w_warteliste WHERE w_patient_p_svnr = ${ this.DB.escape(to) }) - 1))`,
					`SET @vector = IFNULL((@from - @to)/ABS(@from - @to), 0)`,
					`SET @to = @to + IF(@vector > 0, 1, 0)`,
					`SET @inferior = LEAST(@from, @to)`,
					`SET @superior = GREATEST(@from, @to)`,
					`UPDATE w_warteliste SET w_rank = w_rank + @vector ` +
					`WHERE w_rank BETWEEN @inferior AND @superior AND w_patient_p_svnr NOT IN (${ this.DB.escape(from) })`,
					`UPDATE w_warteliste SET w_rank = @to WHERE w_patient_p_svnr = ${ this.DB.escape(from) }`,
					"SELECT w_warteliste.w_g_grund as 'grund', " +
						"p_patienten.p_svnr as 'svnr', " +
						"p_patienten.p_titel as 'anrede', " +
						"p_patienten.p_vorname as 'vorname', " +
						"p_patienten.p_nachname as 'nachname', " +
						"p_patienten.p_alter as 'alter' " +
				  "FROM w_warteliste INNER JOIN p_patient " +
					"ON w_warteliste.w_patient_p_svnr = p_patient.p_svnr ORDER BY w_warteliste.w_rank"
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

module.exports = SelbstanmeldungsDB;
