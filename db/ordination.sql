-- MySQL dump 10.13  Distrib 5.7.21, for Win64 (x86_64)
--
-- Host: localhost    Database: ordination
-- ------------------------------------------------------
-- Server version	5.7.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `b_benutzer`
--

DROP TABLE IF EXISTS `b_benutzer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `b_benutzer` (
  `b_username` varchar(45) NOT NULL,
  `b_passwort` varchar(100) NOT NULL,
  `b_beschreibung` varchar(255) DEFAULT NULL,
  `b_salt` char(12) NOT NULL,
  `b_r_role` varchar(45) NOT NULL,
  PRIMARY KEY (`b_username`),
  KEY `fk_b_benutzer_r_role1_idx` (`b_r_role`),
  CONSTRAINT `fk_b_benutzer_r_role1` FOREIGN KEY (`b_r_role`) REFERENCES `r_role` (`r_bezeichnung`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `b_benutzer`
--

LOCK TABLES `b_benutzer` WRITE;
/*!40000 ALTER TABLE `b_benutzer` DISABLE KEYS */;
INSERT INTO `b_benutzer` VALUES ('bernhard','907143a7c348c47a9d873bbe293e47e6ae3bba9429f6d233bc21819c','Super app','8GKBjPfyzWDY','ipadapp'),('drmuncan','b8b62cc5eed8f3137c56777f33a66405417369e17567634ae190ea3a','Super arzt','guEIlzTuovQ5','arzt');
/*!40000 ALTER TABLE `b_benutzer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `beh_behandlung`
--

DROP TABLE IF EXISTS `beh_behandlung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `beh_behandlung` (
  `beh_id` int(11) NOT NULL AUTO_INCREMENT,
  `beh_b_arzt` varchar(45) NOT NULL,
  `beh_r_raum` varchar(45) NOT NULL,
  `beh_w_patient` bigint(10) NOT NULL,
  PRIMARY KEY (`beh_id`),
  KEY `fk_beh_behandlung_b_benutzer1_idx` (`beh_b_arzt`),
  KEY `fk_beh_behandlung_r_raum1_idx` (`beh_r_raum`),
  KEY `fk_beh_behandlung_w_warteliste1_idx` (`beh_w_patient`),
  CONSTRAINT `fk_beh_behandlung_b_benutzer1` FOREIGN KEY (`beh_b_arzt`) REFERENCES `b_benutzer` (`b_username`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_beh_behandlung_r_raum1` FOREIGN KEY (`beh_r_raum`) REFERENCES `r_raum` (`r_raumname`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_beh_behandlung_w_warteliste1` FOREIGN KEY (`beh_w_patient`) REFERENCES `w_warteliste` (`w_patient_p_svnr`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beh_behandlung`
--

LOCK TABLES `beh_behandlung` WRITE;
/*!40000 ALTER TABLE `beh_behandlung` DISABLE KEYS */;
/*!40000 ALTER TABLE `beh_behandlung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `g_grund`
--

DROP TABLE IF EXISTS `g_grund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `g_grund` (
  `g_id` int(11) NOT NULL AUTO_INCREMENT,
  `g_bezeichnung` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `g_grund`
--

LOCK TABLES `g_grund` WRITE;
/*!40000 ALTER TABLE `g_grund` DISABLE KEYS */;
INSERT INTO `g_grund` VALUES (1,'Rezept'),(2,'Behandlung'),(3,'Arbeitsunf├ñhigkeitsmeldung');
/*!40000 ALTER TABLE `g_grund` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `l_log`
--

DROP TABLE IF EXISTS `l_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `l_log` (
  `l_id` int(11) NOT NULL AUTO_INCREMENT,
  `l_timestamp` datetime DEFAULT NULL,
  `l_la_art` int(11) DEFAULT NULL,
  `l_daten` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`l_id`),
  KEY `fk_l_log_la_logart1_idx` (`l_la_art`),
  CONSTRAINT `fk_l_log_la_logart1` FOREIGN KEY (`l_la_art`) REFERENCES `la_logart` (`la_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `l_log`
--

LOCK TABLES `l_log` WRITE;
/*!40000 ALTER TABLE `l_log` DISABLE KEYS */;
INSERT INTO `l_log` VALUES (25,'2018-02-14 12:02:17',5,'{\"username\":\"drmuncan\"}'),(26,'2018-02-14 12:24:34',5,'{\"username\":\"drmuncan\"}'),(27,'2018-02-14 12:28:05',5,'{\"username\":\"drmuncan\"}'),(28,'2018-02-14 14:07:19',5,'{\"username\":\"drmuncan\"}'),(29,'2018-02-14 15:56:01',5,'{\"username\":\"drmuncan\"}'),(30,'2018-02-14 16:57:27',5,'{\"username\":\"drmuncan\"}'),(31,'2018-02-14 18:02:49',5,'{\"username\":\"drmuncan\"}'),(32,'2018-02-14 19:14:50',5,'{\"username\":\"drmuncan\"}'),(33,'2018-02-14 21:02:50',5,'{\"username\":\"bernhard\"}'),(34,'2018-02-14 21:17:11',5,'{\"username\":\"drmuncan\"}'),(35,'2018-02-14 21:20:21',5,'{\"username\":\"drmuncan\"}'),(36,'2018-02-14 21:23:19',5,'{\"username\":\"drmuncan\"}'),(37,'2018-02-14 21:33:26',5,'{\"username\":\"bernhard\"}'),(38,'2018-02-14 21:36:07',5,'{\"username\":\"drmuncan\"}');
/*!40000 ALTER TABLE `l_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `la_logart`
--

DROP TABLE IF EXISTS `la_logart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `la_logart` (
  `la_id` int(11) NOT NULL,
  `la_bezeichnung` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`la_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `la_logart`
--

LOCK TABLES `la_logart` WRITE;
/*!40000 ALTER TABLE `la_logart` DISABLE KEYS */;
INSERT INTO `la_logart` VALUES (1,'Neuer Patient'),(2,'Patientendaten├ñnderung'),(3,'Patienten-Einschreibung'),(4,'Wartelistenaufruf'),(5,'Webapplikationanmeldung');
/*!40000 ALTER TABLE `la_logart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `p_patient`
--

DROP TABLE IF EXISTS `p_patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `p_patient` (
  `p_svnr` bigint(10) NOT NULL,
  `p_titel` varchar(45) DEFAULT NULL,
  `p_gender` varchar(45) NOT NULL,
  `p_nachname` varchar(45) NOT NULL,
  `p_vorname` varchar(45) NOT NULL,
  `p_gebdat` varchar(45) NOT NULL,
  `p_hausnummer` varchar(3) DEFAULT NULL,
  `p_ort` varchar(45) DEFAULT NULL,
  `p_plz` varchar(45) DEFAULT NULL,
  `p_postfachnummer` varchar(45) DEFAULT NULL,
  `p_postfachtext` varchar(45) DEFAULT NULL,
  `p_staatcode` varchar(45) DEFAULT NULL,
  `p_stocktuernummer` varchar(45) DEFAULT NULL,
  `p_strasse` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`p_svnr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `p_patient`
--

LOCK TABLES `p_patient` WRITE;
/*!40000 ALTER TABLE `p_patient` DISABLE KEYS */;
INSERT INTO `p_patient` VALUES (3048280984,'Dipl','M','Reifert','Saphael','28.04.1984','3','Wien','1100','daw','Postfachtext','AT','5','Favoriten'),(4294280984,'Dr','F','Ernst','Anton','28.04.1984','3','Wien','1100','daw','Postfachtext','AT','5','Favoriten'),(5047060999,'Mag','F','Maxina','Musterfrau','12.04.2017','3','Wien','1100','daw','Postfachtext','AT','5','Favoriten'),(6666280984,'Dr','F','Duncan','Mawid','28.04.1984','3','Wien','1100','daw','Postfachtext','AT','5','Favoriten'),(7078280984,'Dr','F','Cos','Martin','28.04.1984','3','Wien','1100','daw','Postfachtext','AT','5','Favoriten');
/*!40000 ALTER TABLE `p_patient` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `ordination`.`p_patient_AFTER_INSERT`
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
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `ordination`.`p_patient_AFTER_UPDATE`
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
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `p_patient_has_v_versicherung`
--

DROP TABLE IF EXISTS `p_patient_has_v_versicherung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `p_patient_has_v_versicherung` (
  `p_patient_p_svnr` bigint(10) NOT NULL,
  `v_versicherung_v_versicherungsid` varchar(45) NOT NULL,
  PRIMARY KEY (`p_patient_p_svnr`,`v_versicherung_v_versicherungsid`),
  KEY `fk_p_patient_has_v_versicherung_v_versicherung1_idx` (`v_versicherung_v_versicherungsid`),
  KEY `fk_p_patient_has_v_versicherung_p_patient_idx` (`p_patient_p_svnr`),
  CONSTRAINT `fk_p_patient_has_v_versicherung_p_patient` FOREIGN KEY (`p_patient_p_svnr`) REFERENCES `p_patient` (`p_svnr`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_p_patient_has_v_versicherung_v_versicherung1` FOREIGN KEY (`v_versicherung_v_versicherungsid`) REFERENCES `v_versicherung` (`v_versicherungsid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `p_patient_has_v_versicherung`
--

LOCK TABLES `p_patient_has_v_versicherung` WRITE;
/*!40000 ALTER TABLE `p_patient_has_v_versicherung` DISABLE KEYS */;
INSERT INTO `p_patient_has_v_versicherung` VALUES (3048280984,'11'),(3048280984,'12'),(3048280984,'1A');
/*!40000 ALTER TABLE `p_patient_has_v_versicherung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_raum`
--

DROP TABLE IF EXISTS `r_raum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_raum` (
  `r_raumname` varchar(45) NOT NULL,
  `r_platz` int(11) DEFAULT NULL,
  PRIMARY KEY (`r_raumname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_raum`
--

LOCK TABLES `r_raum` WRITE;
/*!40000 ALTER TABLE `r_raum` DISABLE KEYS */;
/*!40000 ALTER TABLE `r_raum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `r_role`
--

DROP TABLE IF EXISTS `r_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_role` (
  `r_bezeichnung` varchar(45) NOT NULL,
  `r_beschreibung` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`r_bezeichnung`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_role`
--

LOCK TABLES `r_role` WRITE;
/*!40000 ALTER TABLE `r_role` DISABLE KEYS */;
INSERT INTO `r_role` VALUES ('arzt',NULL),('ipadapp',NULL);
/*!40000 ALTER TABLE `r_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `v_versicherung`
--

DROP TABLE IF EXISTS `v_versicherung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `v_versicherung` (
  `v_versicherungsid` varchar(45) NOT NULL,
  `v_kuerzel` varchar(45) DEFAULT NULL,
  `v_bezeichnunglang` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`v_versicherungsid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `v_versicherung`
--

LOCK TABLES `v_versicherung` WRITE;
/*!40000 ALTER TABLE `v_versicherung` DISABLE KEYS */;
INSERT INTO `v_versicherung` VALUES ('05','VAEB','Versicherungsanstalt f├╝r Eisenbahnen und Bergbau'),('07','BVA','Versicherungsanstalt ├Âffentlich Bediensteter'),('11','WGKK','Gebietskrankenkasse Wien'),('12','NOEGKK','Gebietskrankenkasse Nieder├Âsterreich'),('13','BGKK','Gebietskrankenkasse Burgenland'),('14','OOEGKK','Gebietskrankenkasse Ober├Âsterreich'),('15','STGKK','Gebietskrankenkasse Steiermark'),('16','KGKK','Gebietskrankenkasse K├ñrnten'),('17','SGKK','Gebietskrankenkasse Salzburg'),('18','TGKK','Gebietskrankenkasse Tirol'),('19','VGKK','Gebietskrankenkasse Vorarlberg'),('1A','KFAWIEN','Krankenf├╝rsorgeanstalt der Bediensteten der Stadt Wien'),('21','BKKTABAK','Betriebskrankenkasse Austria Tabak'),('22','BKKWVB','Betriebskrankenkasse der Wiener Verkehrsbetriebe'),('24','BKKMONDI','Betriebskrankenkasse Mondi'),('25','BKKVABS','Betriebskrankenkasse voestalpine Bahnsysteme'),('26','BKKZELTWEG','Betriebskrankenkasse Zeltweg'),('28','BKKKAPFENBERG','Betriebskrankenkasse Kapfenberg'),('40','SVAGW','Sozialversicherungsanstalt der gewerblichen Wirtschaft'),('50','SVB','Sozialversicherungsanstalt der Bauern'),('5A','KFGRAZ','Krankenf├╝rsorgeanstalt f├╝r die Beamten der Landeshauptstadt Graz'),('6A','KFAVILLACH','Krankenf├╝rsorgeanstalt f├╝r die Beamten der Stadt Villach'),('7A','KFASALZBURG','Krankenf├╝rsorgeanstalt der Magistratsbeamten der Landeshauptstadt Salzburg'),('8B','KUFTGEM','Kranken- und Unfallf├╝rsorge der Tiroler Gemeindebeamten'),('8C','KUFTIROL','KUFTIROL : Kranken- und Unfallf├╝rsorge der Tiroler Landesbeamten'),('8D','KUFTLEHRER','Kranken- und Unfallf├╝rsorge der Tiroler Landeslehrer');
/*!40000 ALTER TABLE `v_versicherung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `w_warteliste`
--

DROP TABLE IF EXISTS `w_warteliste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `w_warteliste` (
  `w_patient_p_svnr` bigint(10) NOT NULL,
  `w_rank` int(11) DEFAULT NULL,
  `w_enterTimestamp` int(11) DEFAULT NULL,
  `w_beh_session` int(11) DEFAULT NULL,
  `w_g_grund` int(11) NOT NULL,
  PRIMARY KEY (`w_patient_p_svnr`),
  KEY `fk_w_warteliste_p_patient1_idx` (`w_patient_p_svnr`),
  KEY `fk_w_warteliste_beh_behandlung1_idx` (`w_beh_session`),
  KEY `fk_w_warteliste_g_grund1` (`w_g_grund`),
  CONSTRAINT `fk_w_warteliste_beh_behandlung1` FOREIGN KEY (`w_beh_session`) REFERENCES `beh_behandlung` (`beh_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_w_warteliste_g_grund1` FOREIGN KEY (`w_g_grund`) REFERENCES `g_grund` (`g_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_w_warteliste_p_patient1` FOREIGN KEY (`w_patient_p_svnr`) REFERENCES `p_patient` (`p_svnr`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_warteliste`
--

LOCK TABLES `w_warteliste` WRITE;
/*!40000 ALTER TABLE `w_warteliste` DISABLE KEYS */;
INSERT INTO `w_warteliste` VALUES (3048280984,3,1518599188,NULL,2),(4294280984,2,1518599178,NULL,2),(5047060999,1,1518599169,NULL,1),(6666280984,4,1518599195,NULL,3);
/*!40000 ALTER TABLE `w_warteliste` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `ordination`.`w_warteliste_AFTER_INSERT`
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
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `ordination`.`w_warteliste_AFTER_UPDATE`
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
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Dumping routines for database 'ordination'
--
/*!50003 DROP FUNCTION IF EXISTS `hashPW` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
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
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `log_anmeldungen` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `log_anmeldungen`(IN benutzername VARCHAR(45))
BEGIN 
	IF benutzername IS NOT NULL THEN
		INSERT INTO l_log(l_timestamp, l_la_art, l_daten) VALUES (now(), 5, CONCAT("{\"username\":\"",benutzername,"\"}"));
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-14 22:52:25
