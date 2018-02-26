const MySQLWrapper = require('./dbaccess.js');

class SelbstanmeldungsDB extends MySQLWrapper {
  constructor(host, user, pw, dbname, transaction = true) {
    super(host, user, pw, dbname, transaction);
  }

  isPatientAlreadyInWarteliste(svnr) {
    return new Promise((resolve, reject) => {
      this.SQLCommandFeeder(
        [
          `SELECT w_patient_p_svnr FROM w_warteliste WHERE w_patient_p_svnr = ${ this.DB.escape(svnr) }`
        ]
      )
      .then((result) => {
        resolve(result.length);
      })
      .catch((error) => reject(error));
    });
  }

  addPatientToWarteliste(patient) {
    return new Promise((resolve, reject) => {
      this.SQLCommandFeeder(
        [
          `SET @lastRank = IFNULL((SELECT MAX(w_rank) FROM w_warteliste), 0) + 1`,
          `INSERT IGNORE INTO w_warteliste VALUES (` +
            `${ this.DB.escape(patient.svnr) }, ` +
            `@lastRank, ` +
            `UNIX_TIMESTAMP(), ` +
            `${ this.DB.escape(patient.grund) }, ` +
            `null)`,
          // Statement to get back patient data for arzt-SSE notification
          `SELECT p_patient.p_svnr AS 'svnr', ` +
            `p_patient.p_vorname AS 'vorname', ` +
            `p_patient.p_nachname AS 'nachname', ` +
            `p_patient.p_gender AS 'geschlecht', ` +
            `p_patient.p_titel AS 'titel', ` +
            `DATE_FORMAT(FROM_DAYS(DATEDIFF(CURDATE(), STR_TO_DATE(p_patient.p_gebdat, '%d.%m.%Y'))), "%Y") + 0 AS 'alter', ` +
            `w_warteliste.w_g_grund AS 'grundid', ` +
            `g_grund.g_bezeichnung AS 'grund' ` +
          `FROM (p_patient INNER JOIN w_warteliste ON p_svnr = w_patient_p_svnr AND w_patient_p_svnr = ${ this.DB.escape(patient.svnr) }) ` +
          `INNER JOIN g_grund ON g_id = w_g_grund`
        ]
      )
      .then((result) => {
        resolve(result[0]);
      })
      .catch((error) => reject(error));
    });
  }

  callInPatientIntoBehandlungsZimmer(svnr, arzt) {
    return new Promise((resolve, reject) => {
      // Before calling in the patient, check if he really is the first one
      // AND is not in a behandlung to not get tricked.
      this.SQLCommandFeeder(
        [
          //Patient muss erster sein und beh_session muss null sein
          `SELECT w_rank as 'rank' FROM w_warteliste WHERE w_patient_p_svnr = ${ this.DB.escape(svnr) } AND w_beh_session IS NULL AND w_rank = 1`
        ]
      )
      .then((check) => {
         // Seems that he is, so call him in by giving him a
         // session and select the data to display on the warteraumansicht
         if (typeof check[0] !== 'undefined') {
           this.SQLCommandFeeder(
              [
                // IGNORE FOREIGN Check
                `SET foreign_key_checks = 0`,
                // In beh_behandlung: Add entry
                `INSERT INTO beh_behandlung VALUES (0, ${ this.DB.escape(svnr) }, ${ this.DB.escape(arzt) }, 1)`,
                // In w_warteliste: Get highest rank
                // `SET @highestRank = (SELECT MIN(w_rank) FROM w_warteliste WHERE w_beh_session IS NULL)`,
                // In w_warteliste: Update first patient with the new beh_id
                `UPDATE w_warteliste SET w_beh_session = (SELECT MAX(beh_id) FROM beh_behandlung) WHERE w_rank = 1`,
                // Enable FOREIGN KEY Check
                `SET foreign_key_checks = 1`,
                // In p_patient: Retrieve patient name to display on warteraumansicht
                `SELECT p_patient.p_titel as 'titel', p_patient.p_vorname as 'vorname', p_patient.p_nachname as 'nachname' FROM p_patient WHERE p_patient.p_svnr = ${ this.DB.escape(svnr) }`
              ]
            )
            .then((result) => {
              if (result.length == 1) {
      					resolve(result[0]);
        			 } else {
        					reject(`Couldn't find the patient with svnr: ${ svnr }`);
        				}
            })
            .catch((error) => {
              reject(error);
            })
         } else {
           reject("Can't call in patient. He is not in the position to be called in.")
         }
       })
       .catch((error) => {
         reject(error);
       })
    });
  }

  dismissPatient(svnr) {
    return new Promise ((resolve, reject) => {
      // Before dismissing the patient, check if he really is in a behandlung
      // to not get tricked.
      this.SQLCommandFeeder(
        [
          `SELECT w_beh_session as 'behandlung' FROM w_warteliste WHERE w_patient_p_svnr = ${ this.DB.escape(svnr) } AND w_beh_session IS NOT NULL`
        ]
      )
      .then((check) => {
        if (typeof check[0] !== 'undefined') {
          this.SQLCommandFeeder(
            [
              // IGNORE FOREIGN Check
              `SET foreign_key_checks = 0`,
              // In w_warteliste: Delete the first patient
              `DELETE FROM w_warteliste WHERE w_rank = 1`,
              // In beh_behandlung: Delete the associated entry
              `DELETE FROM beh_behandlung WHERE beh_w_patient = ${ this.DB.escape(svnr) }`,
              // In w_warteliste: Uprank the other patients
              `UPDATE w_warteliste ` +
                `SET w_rank = w_rank - 1 ` +
              `WHERE w_rank > 1`,
              // Enable FOREIGN KEY Check
              `SET foreign_key_checks = 1`
            ]
          )
          .then((result) => {
            resolve(result);
          })
          .catch((error) => {
            reject(error);
          })
        } else {
          reject("Patient couldn't be dismissed, he is not in a behandlung.")
        }
       })
       .catch((error) => {
         reject(error);
       })
    })
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
					reject(`Couldn't match user ${ credentials.username } with the given password`);
				}
			})
			.catch((error) => reject(error));
		});
	}

	addPatientIfNotExists(patient) {
		return new Promise((resolve, reject) => {
      var addPatientQuery = [
        `INSERT IGNORE INTO p_patient ` +
          `VALUES (${ this.DB.escape(patient.person.svnr) }, ${ this.DB.escape(patient.person.titel) }, ` +
        `${ this.DB.escape(patient.person.geschlecht) }, ${ this.DB.escape(patient.person.nachname) }, ` +
        `${ this.DB.escape(patient.person.vorname) }, ${ this.DB.escape(patient.person.geburtsdatum) }, ` +
        `null, null, ` +
        `null, null, ` +
        `null, null, ` +
        `null, null, ` +
        `null, null)`
      ];

      // Before inserting insurance data,
      // delete all insurance data of the patient
      addPatientQuery.push(`DELETE FROM ver_versicherungen WHERE ver_p_id = ${ this.DB.escape(patient.person.svnr) }`);

      // Add the new versicherungen to the patient
      for (var i = 0; i < patient.versicherung.anspruchsdaten.length; i++) {
        addPatientQuery.push(`INSERT INTO ver_versicherungen VALUES (${ this.DB.escape(patient.versicherung.anspruchsdaten[i].svtCode) }, ${ this.DB.escape(patient.person.svnr) }, false)`);
      }
			this.SQLCommandFeeder(addPatientQuery)
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
          `UPDATE p_patient ` +
            `SET p_patient.p_hausnummer = ${ this.DB.escape(patient.hausnummer) }, ` +
            `p_patient.p_ort = ${ this.DB.escape(patient.ort) }, ` +
            `p_patient.p_plz = ${ this.DB.escape(patient.postleitzahl) }, ` +
            // `p_patient.p_postfachnummer = ${ this.DB.escape(patient.postfachnummer) }, ` +
            // `p_patient.p_postfachtext = ${ this.DB.escape(patient.postfachtext) }, `+
            // `p_patient.p_stocktuernummer = ${ this.DB.escape(patient.stock) }, ` +
            `p_patient.p_strasse = ${ this.DB.escape(patient.strasse) }, ` +
            `p_patient.p_email = ${ this.DB.escape(patient.email) }, ` +
            `p_patient.p_telefonnummer = ${ this.DB.escape(patient.telefonnummer) } ` +
          `WHERE p_patient.p_svnr = ${ this.DB.escape(patient.svnr) }`,
          // In ver_versicherungen: Set all leistungsträger flags to false
          `UPDATE ver_versicherungen ` +
            `SET ver_leistungAktuell = false ` +
            `WHERE ver_p_id = ${ this.DB.escape(patient.svnr) }`,
          // In ver_versicherungen: Set leistungsträger flag
          `UPDATE ver_versicherungen ` +
            `SET ver_leistungAktuell = true ` +
          `WHERE ver_v_id = ${ this.DB.escape(patient.versid) } AND ver_p_id = ${ this.DB.escape(patient.svnr) }`,
          // SELECT to check, if the chosen leistungsträger is assigned to the patient
          `SELECT ver_leistungAktuell FROM ver_versicherungen WHERE ver_v_id = ${ this.DB.escape(patient.versid) } AND ver_p_id = ${ this.DB.escape(patient.svnr) }`
        ]
      )
      .then((result) => {
        if (result.length == 1) {
          resolve(result);
        } else {
          reject("Wrong leistungstraeger chosen");
        }
       })
       .catch((error) => {
         reject(error);
       })
    });
  }

  isFirstPatientInBehandlung() {
    return new Promise((resolve, reject) => {
      this.SQLCommandFeeder(
        [
          `SELECT w_beh_session as 'behandlung' FROM w_warteliste WHERE w_rank = 1`
        ]
      )
      .then((result) => {
        if (result.length != 0 && result[0].behandlung == null) {
          resolve(true);
        } else {
          resolve(false);
        }
      })
      .catch((error) => {
        reject(error);
      });
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
          reject("Patient not in the list");
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
					`SELECT w_warteliste.w_g_grund as 'grundid', ` +
            `g_grund.g_bezeichnung as 'grund', `+
						`p_patient.p_svnr as 'svnr', `+
						`p_patient.p_titel as 'anrede', `+
						`p_patient.p_vorname as 'vorname', `+
						`p_patient.p_nachname as 'nachname', `+
            `p_patient.p_gender as 'geschlecht', `+
						`DATE_FORMAT(FROM_DAYS(DATEDIFF(CURDATE(), STR_TO_DATE(p_patient.p_gebdat, '%d.%m.%Y'))), '%Y') + 0 as 'alter', `+
            `w_warteliste.w_enterTimestamp as 'timestamp', `+
            `w_warteliste.w_beh_session as 'behandlung' ` + // TODO: Wenn in Behandlung, dann true, sonst false
					`FROM ((w_warteliste INNER JOIN p_patient ` +
					`ON w_warteliste.w_patient_p_svnr = p_patient.p_svnr) `+
          `INNER JOIN g_grund on w_warteliste.w_g_grund = g_grund.g_id) `+
          `ORDER BY w_warteliste.w_rank`
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
      // Daten die dabei anfallen:
      // Tabellen: w_warteliste (Grund),
      // Titel, Vorname, Nachname, Geschlecht, SVNR, ausgewählter Versicherungsträger, Grund, Geburtsdatum, Alter, Plz, Ort, Strasse, hausnummer, Email, telefonnummer
			this.SQLCommandFeeder(
				[
          `SELECT p_patient.p_titel AS 'titel', `+
            `p_patient.p_vorname AS 'vorname', ` +
            `p_patient.p_nachname AS 'nachname', ` +
            `p_patient.p_gender AS 'geschlecht', ` +
            `p_patient.p_svnr AS 'svnr', ` +
            `p_patient.p_gebdat AS 'geburtsdatum', ` +
            `DATE_FORMAT(FROM_DAYS(DATEDIFF(CURDATE(), STR_TO_DATE(p_gebdat, '%d.%m.%Y'))), "%Y") + 0 AS age, ` +
            `p_patient.p_plz AS 'plz', ` +
            `p_patient.p_ort AS 'ort', ` +
            `p_patient.p_strasse AS 'strasse', ` +
            `p_patient.p_hausnummer AS 'hausnummer', ` +
            `p_patient.p_email AS 'email', ` +
            `p_patient.p_telefonnummer AS 'telefonnummer', ` +
            `v_versicherung.v_kuerzel AS 'verskuerzel', ` +
            `v_versicherung.v_bezeichnunglang AS 'verslang', ` +
            `g_grund.g_bezeichnung AS 'grund' ` +
            `FROM (((p_patient INNER JOIN ver_versicherungen ` +
              `ON p_svnr = ver_p_id AND ver_leistungAktuell = true) ` +
            `INNER JOIN v_versicherung ON v_versicherungsid = ver_v_id) ` +
            `INNER JOIN w_warteliste ON p_svnr = w_patient_p_svnr) ` +
            `INNER JOIN g_grund ON g_id = w_g_grund ` +
          `WHERE p_patient.p_svnr = ${ this.DB.escape(svnr) }`
				]
			)
			.then((result) => {
        if (result.length == 1) {
					resolve(result[0]);
				} else {
					reject(`Couldn't find patient with svnr: ${ svnr }`);
				}
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
					`UPDATE w_warteliste SET w_rank = @to WHERE w_patient_p_svnr = ${ this.DB.escape(from) }`
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
