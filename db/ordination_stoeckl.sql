-- MySQL Script generated by MySQL Workbench
-- Sat Feb 17 22:42:17 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP Database ordination;
create database ordination;
use ordination;
-- -----------------------------------------------------
-- Table `ordination`.`r_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`r_role` (
  `r_bezeichnung` VARCHAR(45) NOT NULL,
  `r_beschreibung` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`r_bezeichnung`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ordination`.`b_benutzer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`b_benutzer` (
  `b_username` VARCHAR(45) NOT NULL,
  `b_passwort` VARCHAR(100) NOT NULL,
  `b_beschreibung` VARCHAR(255) NULL DEFAULT NULL,
  `b_salt` CHAR(12) NOT NULL,
  `b_r_role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`b_username`),
  INDEX `fk_b_benutzer_r_role1_idx` (`b_r_role` ASC),
  CONSTRAINT `fk_b_benutzer_r_role1`
    FOREIGN KEY (`b_r_role`)
    REFERENCES `ordination`.`r_role` (`r_bezeichnung`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ordination`.`r_raum`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`r_raum` (
  `r_raumname` VARCHAR(45) NOT NULL,
  `r_platz` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`r_raumname`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ordination`.`p_patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`p_patient` (
  `p_svnr` BIGINT(10) NOT NULL,
  `p_gender` VARCHAR(45) NULL DEFAULT NULL,
  `p_nachname` VARCHAR(45) NULL DEFAULT NULL,
  `p_vorname` VARCHAR(45) NULL DEFAULT NULL,
  `p_gebdat` VARCHAR(45) NULL DEFAULT NULL,
  `p_hausnummer` VARCHAR(3) NULL DEFAULT NULL,
  `p_ort` VARCHAR(45) NULL DEFAULT NULL,
  `p_plz` VARCHAR(45) NULL DEFAULT NULL,
  `p_postfachnummer` VARCHAR(45) NULL DEFAULT NULL,
  `p_postfachtext` VARCHAR(45) NULL DEFAULT NULL,
  `p_staatcode` VARCHAR(45) NULL DEFAULT NULL,
  `p_stocktuernummer` VARCHAR(45) NULL DEFAULT NULL,
  `p_strasse` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`p_svnr`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ordination`.`g_grund`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`g_grund` (
  `g_id` INT NOT NULL AUTO_INCREMENT,
  `g_bezeichnung` VARCHAR(45) NULL,
  PRIMARY KEY (`g_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ordination`.`w_warteliste`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`w_warteliste` (
  `p_patient_p_svnr` BIGINT(10) NOT NULL,
  `w_rank` INT(11) NULL DEFAULT NULL,
  `w_enter_timestamp` INT(11) NULL DEFAULT NULL,
  `w_beh_arzt` INT(11) NOT NULL,
  `w_g_grund` INT NOT NULL,
  PRIMARY KEY (`p_patient_p_svnr`),
  INDEX `fk_w_warteliste_p_patient1_idx` (`p_patient_p_svnr` ASC),
  INDEX `fk_w_warteliste_beh_behandlung1_idx` (`w_beh_arzt` ASC),
  INDEX `fk_w_warteliste_g_grund1_idx` (`w_g_grund` ASC),
  CONSTRAINT `fk_w_warteliste_beh_behandlung1`
    FOREIGN KEY (`w_beh_arzt`)
    REFERENCES `ordination`.`beh_behandlung` (`beh_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_w_warteliste_p_patient1`
    FOREIGN KEY (`p_patient_p_svnr`)
    REFERENCES `ordination`.`p_patient` (`p_svnr`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_w_warteliste_g_grund1`
    FOREIGN KEY (`w_g_grund`)
    REFERENCES `ordination`.`g_grund` (`g_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ordination`.`beh_behandlung`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`beh_behandlung` (
  `beh_id` INT(11) NOT NULL AUTO_INCREMENT,
  `beh_b_arzt` VARCHAR(45) NOT NULL,
  `beh_r_raum` INT NOT NULL,
  `beh_w_patient` BIGINT(10) NOT NULL,
  PRIMARY KEY (`beh_id`),
  INDEX `fk_beh_behandlung_b_benutzer1_idx` (`beh_b_arzt` ASC),
  INDEX `fk_beh_behandlung_r_raum1_idx` (`beh_r_raum` ASC),
  INDEX `fk_beh_behandlung_w_warteliste1_idx` (`beh_w_patient` ASC),
  CONSTRAINT `fk_beh_behandlung_b_benutzer1`
    FOREIGN KEY (`beh_b_arzt`)
    REFERENCES `ordination`.`b_benutzer` (`b_username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_beh_behandlung_r_raum1`
    FOREIGN KEY (`beh_r_raum`)
    REFERENCES `ordination`.`r_raum` (`r_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_beh_behandlung_w_warteliste1`
    FOREIGN KEY (`beh_w_patient`)
    REFERENCES `ordination`.`w_warteliste` (`p_patient_p_svnr`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ordination`.`la_logart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`la_logart` (
  `l_id` INT(11) NOT NULL,
  `l_bezeichnung` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`l_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ordination`.`l_log`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`l_log` (
  `l_id` INT(11) NOT NULL AUTO_INCREMENT,
  `l_timestamp` DATETIME NULL DEFAULT NULL,
  `l_la_art` INT(11) NULL DEFAULT NULL,
  `l_daten` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`l_id`),
  INDEX `fk_l_log_la_logart1_idx` (`l_la_art` ASC),
  CONSTRAINT `fk_l_log_la_logart1`
    FOREIGN KEY (`l_la_art`)
    REFERENCES `ordination`.`la_logart` (`l_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ordination`.`v_versicherung`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`v_versicherung` (
  `v_versicherungsartencode` VARCHAR(45) NOT NULL,
  `v_anspruchsart` VARCHAR(45) NULL DEFAULT NULL,
  `v_svtcode` VARCHAR(45) NULL DEFAULT NULL,
  `v_kostenteilbefreit` TINYINT(4) NULL DEFAULT NULL,
  `v_rezeptbefreit` TINYINT(4) NULL DEFAULT NULL,
  PRIMARY KEY (`v_versicherungsartencode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ordination`.`vs_versicherungen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`vs_versicherungen` (
  `vs_p_id` INT(11) NOT NULL,
  `vs_v_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`vs_p_id`, `vs_v_id`),
  INDEX `fk_p_patient_has_v_versicherung_v_versicherung1_idx` (`vs_v_id` ASC),
  INDEX `fk_p_patient_has_v_versicherung_p_patient_idx` (`vs_p_id` ASC),
  CONSTRAINT `fk_p_patient_has_v_versicherung_p_patient`
    FOREIGN KEY (`vs_p_id`)
    REFERENCES `ordination`.`p_patient` (`p_svnr`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_p_patient_has_v_versicherung_v_versicherung1`
    FOREIGN KEY (`vs_v_id`)
    REFERENCES `ordination`.`v_versicherung` (`v_versicherungsartencode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ordination`.`g_grundart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`g_grundart` (
  `g_id` INT NOT NULL AUTO_INCREMENT,
  `g_beschreibung` VARCHAR(45) NULL,
  PRIMARY KEY (`g_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ordination`.`p_patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`p_patient` (
  `p_svnr` BIGINT(10) NOT NULL,
  `p_titel` VARCHAR(45) NULL DEFAULT NULL,
  `p_gender` VARCHAR(45) NOT NULL,
  `p_nachname` VARCHAR(45) NOT NULL,
  `p_vorname` VARCHAR(45) NOT NULL,
  `p_gebdat` VARCHAR(45) NOT NULL,
  `p_hausnummer` VARCHAR(3) NULL DEFAULT NULL,
  `p_ort` VARCHAR(45) NULL DEFAULT NULL,
  `p_plz` VARCHAR(45) NULL DEFAULT NULL,
  `p_postfachnummer` VARCHAR(45) NULL DEFAULT NULL,
  `p_postfachtext` VARCHAR(45) NULL DEFAULT NULL,
  `p_staatcode` VARCHAR(45) NULL DEFAULT NULL,
  `p_stocktuernummer` VARCHAR(45) NULL DEFAULT NULL,
  `p_strasse` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`p_svnr`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ordination`.`tel_telefonnummer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`tel_telefonnummer` (
  `tel_p_id` BIGINT(10) NOT NULL,
  `tel_id` INT NOT NULL AUTO_INCREMENT,
  `tel_nummer` VARCHAR(20) NOT NULL,
  INDEX `fk_table1_p_patient1_idx` (`tel_p_id` ASC),
  PRIMARY KEY (`tel_id`),
  CONSTRAINT `fk_table1_p_patient1`
    FOREIGN KEY (`tel_p_id`)
    REFERENCES `ordination`.`p_patient` (`p_svnr`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ordination`.`e_email`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`e_email` (
  `e_p_id` BIGINT(10) NOT NULL,
  `e_id` INT NOT NULL AUTO_INCREMENT,
  `e_mail` VARCHAR(255) NOT NULL,
  INDEX `fk_table2_p_patient1_idx` (`e_p_id` ASC),
  PRIMARY KEY (`e_id`),
  CONSTRAINT `fk_table2_p_patient1`
    FOREIGN KEY (`e_p_id`)
    REFERENCES `ordination`.`p_patient` (`p_svnr`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `ordination` ;

-- -----------------------------------------------------
-- Table `ordination`.`r_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`r_role` (
  `r_bezeichnung` VARCHAR(45) NOT NULL,
  `r_beschreibung` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`r_bezeichnung`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ordination`.`b_benutzer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`b_benutzer` (
  `b_username` VARCHAR(45) NOT NULL,
  `b_passwort` VARCHAR(100) NOT NULL,
  `b_beschreibung` VARCHAR(255) NULL DEFAULT NULL,
  `b_salt` CHAR(12) NOT NULL,
  `b_r_role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`b_username`),
  INDEX `fk_b_benutzer_r_role1_idx` (`b_r_role` ASC),
  CONSTRAINT `fk_b_benutzer_r_role1`
    FOREIGN KEY (`b_r_role`)
    REFERENCES `ordination`.`r_role` (`r_bezeichnung`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ordination`.`r_raum`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`r_raum` (
  `r_id` INT NOT NULL AUTO_INCREMENT,
  `r_platz` INT(11) NULL DEFAULT NULL,
  `r_name` VARCHAR(45) NULL,
  PRIMARY KEY (`r_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ordination`.`g_grund`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`g_grund` (
  `g_id` INT(11) NOT NULL AUTO_INCREMENT,
  `g_bezeichnung` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`g_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ordination`.`w_warteliste`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`w_warteliste` (
  `w_patient_p_svnr` BIGINT(10) NOT NULL,
  `w_rank` INT(11) NULL DEFAULT NULL,
  `w_enterTimestamp` INT(11) NULL DEFAULT NULL,
  `w_beh_session` INT(11) NULL DEFAULT NULL,
  `w_g_grund` INT(11) NOT NULL,
  PRIMARY KEY (`w_patient_p_svnr`),
  INDEX `fk_w_warteliste_p_patient1_idx` (`w_patient_p_svnr` ASC),
  INDEX `fk_w_warteliste_beh_behandlung1_idx` (`w_beh_session` ASC),
  INDEX `fk_w_warteliste_g_grund1` (`w_g_grund` ASC),
  CONSTRAINT `fk_w_warteliste_beh_behandlung1`
    FOREIGN KEY (`w_beh_session`)
    REFERENCES `ordination`.`beh_behandlung` (`beh_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_w_warteliste_g_grund1`
    FOREIGN KEY (`w_g_grund`)
    REFERENCES `ordination`.`g_grund` (`g_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_w_warteliste_p_patient1`
    FOREIGN KEY (`w_patient_p_svnr`)
    REFERENCES `ordination`.`p_patient` (`p_svnr`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ordination`.`la_logart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`la_logart` (
  `la_id` INT(11) NOT NULL,
  `la_bezeichnung` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`la_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ordination`.`l_log`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`l_log` (
  `l_id` INT(11) NOT NULL AUTO_INCREMENT,
  `l_timestamp` DATETIME NULL DEFAULT NULL,
  `l_la_art` INT(11) NULL DEFAULT NULL,
  `l_daten` VARCHAR(1000) NULL DEFAULT NULL,
  PRIMARY KEY (`l_id`),
  INDEX `fk_l_log_la_logart1_idx` (`l_la_art` ASC),
  CONSTRAINT `fk_l_log_la_logart1`
    FOREIGN KEY (`l_la_art`)
    REFERENCES `ordination`.`la_logart` (`la_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 41
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ordination`.`v_versicherung`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`v_versicherung` (
  `v_versicherungsid` VARCHAR(45) NOT NULL,
  `v_kuerzel` VARCHAR(45) NULL DEFAULT NULL,
  `v_bezeichnunglang` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`v_versicherungsid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ordination`.`ver_versicherungen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ordination`.`ver_versicherungen` (
  `ver_p_id` BIGINT(10) NOT NULL,
  `ver_v_id` VARCHAR(45) NOT NULL,
  `ver_leistungAktuell` TINYINT NULL,
  PRIMARY KEY (`ver_p_id`, `ver_v_id`),
  INDEX `fk_p_patient_has_v_versicherung_v_versicherung1_idx` (`ver_v_id` ASC),
  INDEX `fk_p_patient_has_v_versicherung_p_patient_idx` (`ver_p_id` ASC),
  CONSTRAINT `fk_p_patient_has_v_versicherung_p_patient`
    FOREIGN KEY (`ver_p_id`)
    REFERENCES `ordination`.`p_patient` (`p_svnr`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_p_patient_has_v_versicherung_v_versicherung1`
    FOREIGN KEY (`ver_v_id`)
    REFERENCES `ordination`.`v_versicherung` (`v_versicherungsid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `ordination` ;

-- -----------------------------------------------------
-- function hashPW
-- -----------------------------------------------------

DELIMITER $$
USE `ordination`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `hashPW`(password TEXT, salt TEXT, count INT) RETURNS text CHARSET latin1
BEGIN
DECLARE hash TEXT;
SET hash = CONCAT(salt ,'.' , password);
iteration: LOOP
  IF count > 0 THEN
  SET hash = SHA2(hash, 224);
SET count = count - 1;
ELSE
LEAVE iteration;
END IF;
END LOOP;
RETURN hash;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure log_anmeldungen
-- -----------------------------------------------------

DELIMITER $$
USE `ordination`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `log_anmeldungen`(IN benutzername VARCHAR(45))
BEGIN
	IF benutzername IS NOT NULL THEN
		INSERT INTO l_log(l_timestamp, l_la_art, l_daten) VALUES (now(), 5, CONCAT("{\"username\":\"",benutzername,"\"}"));
	END IF;
END$$

DELIMITER ;
USE `ordination`;

DELIMITER $$
USE `ordination`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `ordination`.`p_patient_AFTER_INSERT`
AFTER INSERT ON `ordination`.`p_patient`
FOR EACH ROW
BEGIN
	/*INSERT l_log
    SET l_timestamp = now(),
			l_la_art = 1;*/
	SET @json = "{";
    SET @json = CONCAT(@json, """zeit""", ":", """", now(), """");
    SET @json = CONCAT(@json, "}");
    INSERT INTO l_log (`l_timestamp`, `l_la_art`, `l_daten`) VALUES (now(), 1, @json);
END$$

USE `ordination`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `ordination`.`p_patient_AFTER_INSERT`
AFTER INSERT ON `ordination`.`p_patient`
FOR EACH ROW
BEGIN
	SET @svnr= (SELECT LAST_INSERT_ID());
    SET @oldSVNR = (SELECT LAST_INSERT_ID());
    SET @vorname= (SELECT p_vorname FROM p_patient WHERE p_svnr = @svnr);
    SET @name= (SELECT p_nachname FROM p_patient WHERE p_svnr = @svnr);
	SET @json = "{";
    SET @json = CONCAT(@json, """svnr""", ":", """", @svnr, """," ,"""nachname""", ":", """", @name, """," ,"""vorname""", ":", """", @vorname, """" );
    SET @json = CONCAT(@json, "}");
    INSERT INTO l_log (`l_timestamp`, `l_la_art`, `l_daten`) VALUES (now(), 1, @json);
END$$

USE `ordination`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `ordination`.`p_patient_AFTER_UPDATE`
AFTER UPDATE ON `ordination`.`p_patient`
FOR EACH ROW
BEGIN
	SET @svnr= (SELECT LAST_INSERT_ID());
    SET @vorname= (SELECT p_vorname FROM p_patient WHERE p_svnr = @svnr);
    SET @oldVorname = (SELECT p_vorname FROM p_patient WHERE p_svnr = @oldSVNR);
	SET @json = "{";
    SET @json = CONCAT(@json, """svnr""", ":", """", @svnr, ""","  );
    SET @json = CONCAT(@json, """aenderungen"":[{");
    SET @json = CONCAT(@json, """old""", ":", """", @oldVorname, """" , ",",  """new""", ":", """", @vorname, """");
    SET @json = CONCAT(@json, "}]");
    SET @json = CONCAT(@json, "}");
    INSERT INTO l_log (`l_timestamp`, `l_la_art`, `l_daten`) VALUES (now(), 2, @json);
END$$


DELIMITER ;
USE `ordination`;

DELIMITER $$
USE `ordination`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `ordination`.`w_warteliste_AFTER_INSERT`
AFTER INSERT ON `ordination`.`w_warteliste`
FOR EACH ROW
BEGIN
	SET @svnr= (SELECT LAST_INSERT_ID());
    SET @vorname= (SELECT p_vorname FROM p_patient WHERE p_svnr = @svnr);
    SET @name= (SELECT p_nachname FROM p_patient WHERE p_svnr = @svnr);
    SET @grundID= (SELECT w_g_grund FROM w_warteliste WHERE w_patient_p_svnr = @svnr);
    SET @grund= (SELECT g_bezeichnung FROM g_grund WHERE g_id = @grundID);
	SET @json = "{";
    SET @json = CONCAT(@json, """svnr""", ":", """", @svnr, """," ,"""nachname""", ":", """", @name, """," ,"""vorname""", ":", """", @vorname, """," ,"""grund""", ":", """", @grund, """" );
    SET @json = CONCAT(@json, "}");
    INSERT INTO l_log (`l_timestamp`, `l_la_art`, `l_daten`) VALUES (now(), 3, @json);
END$$

USE `ordination`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `ordination`.`w_warteliste_AFTER_UPDATE`
AFTER UPDATE ON `ordination`.`w_warteliste`
FOR EACH ROW
BEGIN
	SET @svnr= (SELECT LAST_INSERT_ID());
    SET @name= (SELECT p_nachname FROM p_patient WHERE p_svnr = @svnr);
    SET @vorname= (SELECT p_vorname FROM p_patient WHERE p_svnr = @svnr);
    SET @arzt= (SELECT beh_b_arzt FROM beh_behandlung WHERE beh_w_patient = @svnr);
	SET @raum= (SELECT beh_r_raum FROM beh_behandlung WHERE beh_w_patient = @svnr);
	SET @json = "{";
    SET @json = CONCAT(@json, """svnr""", ":", """", @svnr, """," ,"""nachname""", ":", """", @name, """," ,"""vorname""", ":", """", @vorname, """," ,"""arzt""", ":", """", @arzt, """," ,"""raum""", ":", """", @raum, """");
    SET @json = CONCAT(@json, "}");
    INSERT INTO l_log (`l_timestamp`, `l_la_art`, `l_daten`) VALUES (now(), 4, @json);
END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `ordination`.`r_role`
-- -----------------------------------------------------
START TRANSACTION;
USE `ordination`;
INSERT INTO `ordination`.`r_role` (`r_bezeichnung`, `r_beschreibung`) VALUES ('arzt', 'User um die Webapplikation zu benutzen');
INSERT INTO `ordination`.`r_role` (`r_bezeichnung`, `r_beschreibung`) VALUES ('ipadapp', 'iPads für die Anmeldung');

COMMIT;


-- -----------------------------------------------------
-- Data for table `ordination`.`g_grund`
-- -----------------------------------------------------
START TRANSACTION;
USE `ordination`;
INSERT INTO `ordination`.`g_grund` (`g_id`, `g_bezeichnung`) VALUES (1, 'Rezept');
INSERT INTO `ordination`.`g_grund` (`g_id`, `g_bezeichnung`) VALUES (2, 'Behandlung');
INSERT INTO `ordination`.`g_grund` (`g_id`, `g_bezeichnung`) VALUES (3, 'Arbeitsunfähigkeitsmeldung');

COMMIT;


-- -----------------------------------------------------
-- Data for table `ordination`.`la_logart`
-- -----------------------------------------------------
START TRANSACTION;
USE `ordination`;
INSERT INTO `ordination`.`la_logart` (`l_id`, `l_bezeichnung`) VALUES (1, 'Neuer Patient');
INSERT INTO `ordination`.`la_logart` (`l_id`, `l_bezeichnung`) VALUES (2, 'Patientendatenänderung');
INSERT INTO `ordination`.`la_logart` (`l_id`, `l_bezeichnung`) VALUES (3, 'Patient-Einschreibung');
INSERT INTO `ordination`.`la_logart` (`l_id`, `l_bezeichnung`) VALUES (4, 'Wartelisteaufruf');
INSERT INTO `ordination`.`la_logart` (`l_id`, `l_bezeichnung`) VALUES (5, 'Webapplikation Anmeldung');

COMMIT;


-- -----------------------------------------------------
-- Data for table `ordination`.`v_versicherung`
-- -----------------------------------------------------
START TRANSACTION;
USE `ordination`;
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsartencode`, `v_anspruchsart`, `v_svtcode`, `v_kostenteilbefreit`, `v_rezeptbefreit`) VALUES ('A', NULL, NULL, NULL, NULL);
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsartencode`, `v_anspruchsart`, `v_svtcode`, `v_kostenteilbefreit`, `v_rezeptbefreit`) VALUES ('C', NULL, NULL, NULL, NULL);
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsartencode`, `v_anspruchsart`, `v_svtcode`, `v_kostenteilbefreit`, `v_rezeptbefreit`) VALUES ('B', NULL, NULL, NULL, NULL);
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsartencode`, `v_anspruchsart`, `v_svtcode`, `v_kostenteilbefreit`, `v_rezeptbefreit`) VALUES ('D', NULL, NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `ordination`.`g_grundart`
-- -----------------------------------------------------
START TRANSACTION;
USE `ordination`;
INSERT INTO `ordination`.`g_grundart` (`g_id`, `g_beschreibung`) VALUES (1, 'Rezept');
INSERT INTO `ordination`.`g_grundart` (`g_id`, `g_beschreibung`) VALUES (2, 'Behandlung');
INSERT INTO `ordination`.`g_grundart` (`g_id`, `g_beschreibung`) VALUES (3, 'Arbeitsunfähigkeitsmeldung');

COMMIT;


-- -----------------------------------------------------
-- Data for table `ordination`.`p_patient`
-- -----------------------------------------------------
START TRANSACTION;
USE `ordination`;
INSERT INTO `ordination`.`p_patient` (`p_svnr`, `p_titel`, `p_gender`, `p_nachname`, `p_vorname`, `p_gebdat`, `p_hausnummer`, `p_ort`, `p_plz`, `p_postfachnummer`, `p_postfachtext`, `p_staatcode`, `p_stocktuernummer`, `p_strasse`) VALUES (3048280984, 'Prof', 'M', 'Markovic', 'Predrag', '28.09.1984', '23', 'Wien', '1100', '1234567891', 'Keine Werbung', 'AT', '1', 'Favoriten');
INSERT INTO `ordination`.`p_patient` (`p_svnr`, `p_titel`, `p_gender`, `p_nachname`, `p_vorname`, `p_gebdat`, `p_hausnummer`, `p_ort`, `p_plz`, `p_postfachnummer`, `p_postfachtext`, `p_staatcode`, `p_stocktuernummer`, `p_strasse`) VALUES (4294280984, 'Dr', 'W', 'Maria', 'Hofbauer', '28.09.1984', '24', 'Wien', '1190', '2345678912', 'Keine Webrung', 'AT', '2', 'Währingerhauptsraße');
INSERT INTO `ordination`.`p_patient` (`p_svnr`, `p_titel`, `p_gender`, `p_nachname`, `p_vorname`, `p_gebdat`, `p_hausnummer`, `p_ort`, `p_plz`, `p_postfachnummer`, `p_postfachtext`, `p_staatcode`, `p_stocktuernummer`, `p_strasse`) VALUES (5047060999, 'Mag', 'W', 'Elisabeth', 'Galhuber', '06.09.1999', '12', 'Perchtoldsdorf', '2380', '9876543211', NULL, 'AT', '3', 'Hauptstraße');
INSERT INTO `ordination`.`p_patient` (`p_svnr`, `p_titel`, `p_gender`, `p_nachname`, `p_vorname`, `p_gebdat`, `p_hausnummer`, `p_ort`, `p_plz`, `p_postfachnummer`, `p_postfachtext`, `p_staatcode`, `p_stocktuernummer`, `p_strasse`) VALUES (6666280984, 'Bsc', 'M', 'Leoanrdo', 'Barrientos', '28.09.1984', '34', 'Mödling', '2345', '2345679124', NULL, 'AT', '4', 'Bachgasse');
INSERT INTO `ordination`.`p_patient` (`p_svnr`, `p_titel`, `p_gender`, `p_nachname`, `p_vorname`, `p_gebdat`, `p_hausnummer`, `p_ort`, `p_plz`, `p_postfachnummer`, `p_postfachtext`, `p_staatcode`, `p_stocktuernummer`, `p_strasse`) VALUES (7078280984, 'Bsc', 'M', 'Raphael', 'Seifert', '28.09.1984', '50', '2392', 'Sulz', '1243524635', NULL, 'AT', '5', 'Bahngasse');

COMMIT;


-- -----------------------------------------------------
-- Data for table `ordination`.`r_role`
-- -----------------------------------------------------
START TRANSACTION;
USE `ordination`;
INSERT INTO `ordination`.`r_role` (`r_bezeichnung`, `r_beschreibung`) VALUES ('arzt', NULL);
INSERT INTO `ordination`.`r_role` (`r_bezeichnung`, `r_beschreibung`) VALUES ('ipadapp', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `ordination`.`b_benutzer`
-- -----------------------------------------------------
START TRANSACTION;
USE `ordination`;
INSERT INTO `ordination`.`b_benutzer` (`b_username`, `b_passwort`, `b_beschreibung`, `b_salt`, `b_r_role`) VALUES ('drmuncan', 'hashPW(\'fliegeimohr\', \'m5zNFY7VZhW1\', 1000)', 'hier gibt es nicht zu sehen', 'm5zNFY7VZhW1', 'arzt');
INSERT INTO `ordination`.`b_benutzer` (`b_username`, `b_passwort`, `b_beschreibung`, `b_salt`, `b_r_role`) VALUES ('bernhard', 'hashPW(\'saric\', \'TD8kN2JRv2Je\', 1000)', NULL, 'TD8kN2JRv2Je', 'ipadapp');
INSERT INTO `ordination`.`b_benutzer` (`b_username`, `b_passwort`, `b_beschreibung`, `b_salt`, `b_r_role`) VALUES ('leonardo', 'hashPW(\'barrientos\', \'szwTCW1kDFMA\', 1000)', NULL, 'szwTCW1kDFMA', 'ipadapp');
INSERT INTO `ordination`.`b_benutzer` (`b_username`, `b_passwort`, `b_beschreibung`, `b_salt`, `b_r_role`) VALUES ('philipp', 'hashPW(\'STO16372\', \'VD9XWJLFatmX\', 1000)', NULL, 'VD9XWJLFatmX', 'arzt');
INSERT INTO `ordination`.`b_benutzer` (`b_username`, `b_passwort`, `b_beschreibung`, `b_salt`, `b_r_role`) VALUES ('raphael', 'hashPW(\'seifert\', \'AlG0laPNmpSS\', 1000)', NULL, 'AlG0laPNmpSS', 'arzt');

COMMIT;


-- -----------------------------------------------------
-- Data for table `ordination`.`r_raum`
-- -----------------------------------------------------
START TRANSACTION;
USE `ordination`;
INSERT INTO `ordination`.`r_raum` (`r_id`, `r_platz`, `r_name`) VALUES (DEFAULT, 2, 'behandlungsraum1');
INSERT INTO `ordination`.`r_raum` (`r_id`, `r_platz`, `r_name`) VALUES (DEFAULT, 5, 'behandlungsraum2');
INSERT INTO `ordination`.`r_raum` (`r_id`, `r_platz`, `r_name`) VALUES (DEFAULT, 3, 'behandlungsraum3');
INSERT INTO `ordination`.`r_raum` (`r_id`, `r_platz`, `r_name`) VALUES (DEFAULT, 1, 'behandlungsraum4');
INSERT INTO `ordination`.`r_raum` (`r_id`, `r_platz`, `r_name`) VALUES (DEFAULT, 2, 'behandlungsraum5');

COMMIT;


-- -----------------------------------------------------
-- Data for table `ordination`.`g_grund`
-- -----------------------------------------------------
START TRANSACTION;
USE `ordination`;
INSERT INTO `ordination`.`g_grund` (`g_id`, `g_bezeichnung`) VALUES (1, 'Rezept');
INSERT INTO `ordination`.`g_grund` (`g_id`, `g_bezeichnung`) VALUES (2, 'Behandlung');
INSERT INTO `ordination`.`g_grund` (`g_id`, `g_bezeichnung`) VALUES (3, 'Arbeitsunfähigkeitsmeldung');

COMMIT;


-- -----------------------------------------------------
-- Data for table `ordination`.`w_warteliste`
-- -----------------------------------------------------
START TRANSACTION;
USE `ordination`;
INSERT INTO `ordination`.`w_warteliste` (`w_patient_p_svnr`, `w_rank`, `w_enterTimestamp`, `w_beh_session`, `w_g_grund`) VALUES (3048280984, 3 , 1518599188, NULL, 2);
INSERT INTO `ordination`.`w_warteliste` (`w_patient_p_svnr`, `w_rank`, `w_enterTimestamp`, `w_beh_session`, `w_g_grund`) VALUES (4294280984, 2, 1518599178, NULL, 2);
INSERT INTO `ordination`.`w_warteliste` (`w_patient_p_svnr`, `w_rank`, `w_enterTimestamp`, `w_beh_session`, `w_g_grund`) VALUES (5047060999, 1, 1518599169, NULL, 1);
INSERT INTO `ordination`.`w_warteliste` (`w_patient_p_svnr`, `w_rank`, `w_enterTimestamp`, `w_beh_session`, `w_g_grund`) VALUES (6666280984, 4, 1518599195, NULL, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `ordination`.`la_logart`
-- -----------------------------------------------------
START TRANSACTION;
USE `ordination`;
INSERT INTO `ordination`.`la_logart` (`la_id`, `la_bezeichnung`) VALUES (1, 'Patientenneuanmeldung');
INSERT INTO `ordination`.`la_logart` (`la_id`, `la_bezeichnung`) VALUES (2, 'Patientendatenänderung');
INSERT INTO `ordination`.`la_logart` (`la_id`, `la_bezeichnung`) VALUES (3, 'Patienteneinschreibung');
INSERT INTO `ordination`.`la_logart` (`la_id`, `la_bezeichnung`) VALUES (4, 'Patientenaufruf');
INSERT INTO `ordination`.`la_logart` (`la_id`, `la_bezeichnung`) VALUES (5, 'Webapplikation Anmeldung');

COMMIT;


-- -----------------------------------------------------
-- Data for table `ordination`.`v_versicherung`
-- -----------------------------------------------------
START TRANSACTION;
USE `ordination`;
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('11', 'WGKK', 'Gebietskrankenkasse Wien');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('12', 'NOEGKK', 'Gebietskrankenkasse Niederösterreich');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('13', 'BGKK', 'Gebietskrankenkasse Burgenland');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('14', 'OOEGKK', 'Gebietskrankenkasse Oberösterreich');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('15', 'STGKK', 'Gebietskrankenkasse Steiermark');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('16', 'KGKK', 'Gebietskrankenkasse Kärnten');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('17', 'SGKK', 'Gebietskrankenkasse Salzburg');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('18', 'TGKK', 'Gebietskrankenkasse Tirol');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('19', 'VGKK', 'Gebietskrankenkasse Vorarlberg');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('21', 'BKKTABAK', 'Betriebskrankenkasse Austria Tabak');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('22', 'BKKWVB', 'Betriebskrankenkasse der Wiener Verkehrsbetriebe');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('24', 'BKKMONDI', 'Betriebskrankenkasse Mondi');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('25', 'BKKVABS', 'Betriebskrankenkasse voestalpine Bahnsysteme');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('26', 'BKKZELTWEG', 'Betriebskrankenkasse Zeltweg');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('28', 'BKKKAPFENBERG', 'Betriebskrankenkasse Kapfenberg');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('05', 'VAEB', 'Versicherungsanstalt für Eisenbahnen und Bergbau');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('07', 'BVA', 'Versicherungsanstalt öffentlich Bediensteter');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('40', 'SVAGW', 'Sozialversicherungsanstalt der gewerblichen Wirtschaft');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('50', 'SVB', 'Sozialversicherungsanstalt der Bauern');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('1A', 'KFAWIEN', 'Krankenfürsorgeanstalt der Bediensteten der Stadt Wien');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('5A', 'KFGRAZ', 'Krankenfürsorgeanstalt für die Beamten der Landeshauptstadt Graz');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('6A', 'KFAVILLACH', 'Krankenfürsorgeanstalt für die Beamten der Stadt Villach');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('7A', 'KFASALZBURG', 'Krankenfürsorgeanstalt der Magistratsbeamten der Landeshauptstadt Salzburg');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('8B', 'KUFTGEM', 'Kranken- und Unfallfürsorge der Tiroler Gemeindebeamten');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('8C', 'KUFTIROL', 'Kranken- und Unfallfürsorge der Tiroler Landesbeamten');
INSERT INTO `ordination`.`v_versicherung` (`v_versicherungsid`, `v_kuerzel`, `v_bezeichnunglang`) VALUES ('8D', 'KUFTLEHRER', 'Kranken- und Unfallfürsorge der Tiroler Landeslehrer');

COMMIT;
