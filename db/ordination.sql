-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: lokalePatientenDB
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.17.10.1

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
-- Table structure for table `benutzer`
--

DROP TABLE IF EXISTS `benutzer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `benutzer` (
  `username` varchar(45) NOT NULL,
  `passwort` varchar(100) NOT NULL,
  `rolle` varchar(45) NOT NULL,
  `beschreibung` varchar(255) DEFAULT NULL,
  `salt` char(12) NOT NULL,
  PRIMARY KEY (`username`),
  KEY `fk_rolle` (`rolle`),
  CONSTRAINT `fk_rolle` FOREIGN KEY (`rolle`) REFERENCES `rollen` (`rollen`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benutzer`
--

LOCK TABLES `benutzer` WRITE;
/*!40000 ALTER TABLE `benutzer` DISABLE KEYS */;
INSERT INTO `benutzer` VALUES ('drmuncan','079c01d6c2507a743b32023fcb63c790a0b3d791dad7134233250a72','arzt','Super typ','pV2MEk3mG6nO'),('haustanteraphael','3759740c22fd53ac9c07627bd618bda97c6cd4c66c4e2ac7032a1065','nutzer','Super Frau','HUq6NLyr0OUu');
/*!40000 ALTER TABLE `benutzer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patienten`
--

DROP TABLE IF EXISTS `patienten`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patienten` (
  `pt_svnr` char(10) NOT NULL,
  `pt_vorname` varchar(255) NOT NULL,
  `pt_nachname` varchar(255) NOT NULL,
  `pt_lebensjahr` tinyint(3) unsigned NOT NULL,
  `pt_adresse` varchar(255) NOT NULL,
  `pt_hausnummer` smallint(5) unsigned NOT NULL,
  `pt_stiege` tinyint(3) unsigned NOT NULL,
  `pt_plz` smallint(5) unsigned NOT NULL,
  `pt_ort` varchar(255) NOT NULL,
  PRIMARY KEY (`pt_svnr`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patienten`
--

LOCK TABLES `patienten` WRITE;
/*!40000 ALTER TABLE `patienten` DISABLE KEYS */;
INSERT INTO `patienten` VALUES ('5043030695','Dawid','Muncan',3,'Zentrum der Welt',503,3,1020,'Wien'),('5043030698','Dawid','Muncan',3,'Zentrum der Welt',503,3,1020,'Wien'),('5043030699','Petar','Muncan',72,'Kleistgasse',503,3,1020,'Wien');
/*!40000 ALTER TABLE `patienten` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rollen`
--

DROP TABLE IF EXISTS `rollen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rollen` (
  `rollen` varchar(45) NOT NULL,
  `beschreibung` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rollen`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rollen`
--

LOCK TABLES `rollen` WRITE;
/*!40000 ALTER TABLE `rollen` DISABLE KEYS */;
INSERT INTO `rollen` VALUES ('arzt','Aerzte koennen Einsicht auf die Arztansicht nehmen und Patientenveranlassungen durchfuehren.'),('nutzer','Nutzer haben Zugriff auf die Warteliste.');
/*!40000 ALTER TABLE `rollen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessions`
--

DROP TABLE IF EXISTS `sessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sessions` (
  `session_id` char(26) NOT NULL,
  `timestamp` int(11) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`session_id`),
  KEY `fk_session` (`username`),
  CONSTRAINT `fk_session` FOREIGN KEY (`username`) REFERENCES `benutzer` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessions`
--

LOCK TABLES `sessions` WRITE;
/*!40000 ALTER TABLE `sessions` DISABLE KEYS */;
/*!40000 ALTER TABLE `sessions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'lokalePatientenDB'
--
/*!50003 DROP FUNCTION IF EXISTS `hashPW` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-27  0:08:35
