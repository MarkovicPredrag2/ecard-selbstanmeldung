-- MySQL dump 10.13  Distrib 5.7.19, for Linux (x86_64)
--
-- Host: localhost    Database: lokalePatientenDB
-- ------------------------------------------------------
-- Server version	5.7.19-0ubuntu0.16.04.1

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
  `passwort` varchar(45) NOT NULL,
  `rolle` varchar(45) NOT NULL,
  `beschreibung` varchar(255) DEFAULT NULL,
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
INSERT INTO `benutzer` VALUES ('drmuncan','S Õs®Ðõ€‰WÛÝ\n½','arzt','Dr. Muncan David ist Oberarzt und gelegentlicher Gastvortragender an der Med Uni Wien.'),('haustanteraphael','Lâ_Ùë)drÍï·};¡ü®¬e·ßMAÑ*','nutzer','Frau Raphael ist seit jahrzehnten im Gesundheitsbereich tätig. Ihre Spezialitäten sind das Kartenleserstecken und Aushändigen von Ecards.');
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
  `session_id` varchar(35) NOT NULL,
  `timestamp` int(11) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
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
INSERT INTO `sessions` VALUES ('=8NjtCPE)cvSdA%CN5NeuFdk§p2bKnq',0,'drmuncan');
/*!40000 ALTER TABLE `sessions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-19 22:02:07
