const MySQLWrapper = require('./dbaccess.js');

class SelbstanmeldungsDB extends MySQLWrapper {
  constructor(host, user, pw, dbname, transaction = true) {
    super(host, user, pw, dbname, transaction);
  }

  lookUpUser(credentials) {
		return new Promise((resolve, reject) => {
			this.SQLCommandFeeder(
				[
          `SET @username = (SELECT b_username as 'benutzername' FROM b_benutzer WHERE b_username = ${ this.DB.escape(credentials.username) } AND b_passwort = hashPW(${ this.DB.escape(credentials.password) }, b_salt, 1000))`,
          // Query to log the login
          `CALL log_anmeldungen(IF((SELECT count(@username)) = 1, @username, null))`,
          // Query to fetch the role and the name
          `SELECT b_username as 'username', b_r_role as 'rolle' FROM b_benutzer WHERE b_username = ${ this.DB.escape(credentials.username) } AND b_passwort = hashPW(${ this.DB.escape(credentials.password) }, b_salt, 1000)`
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

	addPatientIfNotExists(patient) {
		return new Promise((resolve, reject) => {
      var addPatientQuery = [
        `INSERT INTO IGNORE p_patient ` +
        `VALUES ('${ this.DB.escape(patient.svnr) }', '${ this.DB.escape(patient.titel) }', ` +
        `'${ this.DB.escape(patient.geschlecht) }', '${ this.DB.escape(patient.nachname) }', ` +
        `'${ this.DB.escape(patient.vorname) }', '${ this.DB.escape(patient.geburtsdatum) }', ` +
        `'${ this.DB.escape(patient.hausnummer) }', '${ this.DB.escape(patient.ort) }', ` +
        `'${ this.DB.escape(patient.plz) }', '${ this.DB.escape(patient.postfachnummer) }', ` +
        `'${ this.DB.escape(patient.postfachtext) }', '${ this.DB.escape(patient.staatscode) }', ` +
        `'${ this.DB.escape(patient.stocktuernummer) }', '${ this.DB.escape(patient.strasse) }',`
      ];

      // Before inserting insurance data,
      // delete all insurance data of the patient
      addPatientQuery.push(`DELETE FROM ver_versicherungen WHERE ver_p_id = '${ this.DB.escape(patient.svnr) }'`);

      // Add the new versicherungen to the patient
      for (var i = 0; i < patient.anspruchsdaten.length; i++) {
        addPatientQuery.push(`INSERT INTO ver_versicherungen VALUES ('${ this.DB.escape(patient.anspruchsdaten[i].svtCode) }', '${ this.DB.escape(patient.svnr) }')`);
                              // `ON DUPLICATE KEY UPDATE ver_versicherungen.ver_v_id = '${ this.DB.escape(patient.anspruchsdaten[i].svtCode) }'`);
      }
			this.SQLCommandFeeder(addPatientQuery)
				.then((patientresultat) => {
          resolve(patientresultat);
				})
				.catch((error) => {
					reject(error);
				});
		});
	}

  updatePatient(patient) {
    return new Promise((resolve, reject) => {
      // TODO: Update patient, if the app sends back data
      // NOTE: With Update statement
      this.SQLCommandFeeder(
        [
          `UPDATE p_patient ` +
            `SET p_patient.p_hausnummer = ${ this.DB.escape(patient.hausnummer) }, ` +
            `p_patient.p_ort = ${ this.DB.escape(patient.ort) }, ` +
            `p_patient.p_plz = ${ this.DB.escape(patient.postleitzahl) }, ` +
            `p_patient.p_postfachnummer = ${ this.DB.escape(patient.postfachnummer) }, ` +
            `p_patient.p_postfachtext = ${ this.DB.escape(patient.postfachtext) }, `+
            `p_patient.p_stocktuernummer = ${ this.DB.escape(patient.stock) }, ` +
            `p_patient.p_strasse = ${ this.DB.escape(patient.strasse) }, ` +
            `p_patient.p_email = ${ this.DB.escape(patient.email) }, ` +
            `p_patient.p_telefonnummer = ${ this.DB.escape(patient.telefonnummer) } ` +
          `WHERE p_patient.p_svnr = ${ this.DB.escape(patient.svnr) }`,
          `UPDATE ver_versicherungen ` +
            `SET ver_leistungAktuell = true ` +
          `WHERE ver_v_id = (SELECT v_versicherungsid FROM v_versicherung WHERE v_kuerzel = ${ this.DB.escape(patient.versicherung) })`
        ]
      )
    });
  }

  getAllPatientData(svnr) {
    return new Promise((resolve, reject) => {
      // Query for patient data
      this.SQLCommandFeeder(
        [
          `SELECT p_patient.p_svnr as 'svnr', ` +
          `p_patient.p_titel as 'anrede', ` +
          `p_patient.p_gender as 'geschlecht', ` +
          `p_patient.p_vorname as 'vorname', ` +
          `p_patient.p_nachname as 'nachname', ` +
          `p_patient.p_gebdat as 'alter', `  +
          `p_patient.p_hausnummer as 'hausnummer', ` +
          `p_patient.p_ort as 'ort', ` +
          `p_patient.p_plz as 'postleitzahl', ` +
          `p_patient.p_postfachnummer as 'postfachnummer', ` +
          `p_patient.p_postfachtext as 'postfachtext', `  +
          `p_patient.p_staatcode as 'staatscode', ` +
          `p_patient.p_stocktuernummer as 'stock', ` +
          `p_patient.p_strasse as 'strasse', `  +
          `p_patient.p_email as 'email', `  +
          `p_patient.p_telefonnummer as 'telefonnummer' ` +
          `FROM p_patient WHERE p_svnr = ${ this.DB.escape(svnr) }`
        ]
      )
      .then((patientresultat) => {
        if (patientresultat[0]) {
          // Form the payload to transmit
          var patient = patientresultat[0];

          // Query for Versicherungs data
          this.SQLCommandFeeder(
            [
              `SELECT v_versicherung.v_versicherungsid as 'versicherungsid', `  +
              `v_versicherung.v_kuerzel as 'kuerzel', `  +
              `v_versicherung.v_bezeichnunglang as 'versicherung' `  +
              `FROM ((v_versicherung INNER JOIN ver_versicherungen ` +
              `ON v_versicherungsid = ver_v_id) INNER JOIN p_patient ` +
              `ON p_svnr = ver_p_id) ` +
              `WHERE p_svnr = ${ this.DB.escape(svnr) }`
            ]
          )
          .then((versicherungsresultat) => {
            patient.versicherungen = versicherungsresultat;
            resolve(patient);
          })
          .catch((error) => {
            reject(error);
          })
        } else {
          reject("Gesuchter Patient nicht vorhanden");
        }
       })
       .catch((error) => {
         reject(error);
       })
    });
  }

  dumpLog(logart) {
    return new Promise((resolve, reject) => {
      this.SQLCommandFeeder(
        [
          `SELECT l_daten as 'daten', l_timestamp as 'timestamp', l_id as 'id' FROM l_log WHERE l_la_art = ${ this.DB.escape(logart) }`
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

	getWartelistePatients() {
		return new Promise((resolve, reject) => {
			this.SQLCommandFeeder(
				[
					"SELECT w_warteliste.w_g_grund as 'grundid', " +
            "g_grund.g_bezeichnung as 'grund', " +
						"p_patient.p_svnr as 'svnr', " +
						"p_patient.p_titel as 'anrede', " +
						"p_patient.p_vorname as 'vorname', " +
						"p_patient.p_nachname as 'nachname', " +
						"p_patient.p_gebdat as 'alter', " +
            "w_warteliste.w_enterTimestamp as 'timestamp' " +
					"FROM ((w_warteliste INNER JOIN p_patient " +
					"ON w_warteliste.w_patient_p_svnr = p_patient.p_svnr)" +
          "INNER JOIN g_grund on w_warteliste.w_g_grund = g_grund.g_id) " +
          "ORDER BY w_warteliste.w_rank"
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
						"p_patient.p_svnr as 'svnr', " +
						"p_patient.p_titel as 'anrede', " +
						"p_patient.p_vorname as 'vorname', " +
						"p_patient.p_nachname as 'nachname', " +
						"p_patient.p_alter as 'alter' " +
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
