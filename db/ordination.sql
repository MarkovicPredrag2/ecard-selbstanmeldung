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
INSERT INTO `b_benutzer` VALUES ('bernhard','50ede5b2c97f466be3c8cef5d496ae57064732f6f3eb6f5abc51812a',NULL,'TD8kN2JRv2Je','ipadapp'),('drmuncan','d6150aac3e07c645daae42559fdcebcf9c459749c22ec28655da179a',NULL,'m5zNFY7VZhW1','arzt'),('leonardo','d352a63a24ecead17df61ab7b5344d3f4b0dd149f00bf553f450b2be',NULL,'AlG0laPNmpSS','ipadapp'),('philipp','24360ee37bbaf100541f7cdf4db05a2e1290331841cc2e10027ebba1',NULL,'szwTCW1kDFMA','arzt'),('raphael','6463d1bebd06ce1bfa0bdf91eb4354f055ee45a4ec5ee070264782b7',NULL,'VD9XWJLFatmX','arzt');
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
  `beh_w_patient` bigint(10) NOT NULL,
  `beh_b_arzt` varchar(45) NOT NULL,
  `beh_r_raum` int(10) NOT NULL,
  PRIMARY KEY (`beh_id`),
  KEY `fk_beh_behandlung_w_warteliste1_idx` (`beh_w_patient`),
  KEY `fk_beh_behandlung_b_benutzer1_idx` (`beh_b_arzt`),
  KEY `fk_beh_behandlung_r_raum1_idx` (`beh_r_raum`),
  CONSTRAINT `fk_beh_behandlung_b_benutzer1` FOREIGN KEY (`beh_b_arzt`) REFERENCES `b_benutzer` (`b_username`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_beh_behandlung_r_raum1` FOREIGN KEY (`beh_r_raum`) REFERENCES `r_raum` (`r_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_beh_behandlung_w_warteliste1` FOREIGN KEY (`beh_w_patient`) REFERENCES `w_warteliste` (`w_patient_p_svnr`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
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
  `g_id` int(11) NOT NULL,
  `g_bezeichnung` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `g_grund`
--

LOCK TABLES `g_grund` WRITE;
/*!40000 ALTER TABLE `g_grund` DISABLE KEYS */;
INSERT INTO `g_grund` VALUES (1,'Rezept'),(2,'Behandlung'),(3,'Arbeitsunfähigkeitsmeldung');
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
  `l_daten` varchar(1000) DEFAULT NULL,
  `l_la_art` int(11) NOT NULL,
  PRIMARY KEY (`l_id`),
  KEY `fk_l_log_la_logArt_idx` (`l_la_art`),
  CONSTRAINT `fk_l_log_la_logArt` FOREIGN KEY (`l_la_art`) REFERENCES `la_logart` (`la_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=817 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `l_log`
--

LOCK TABLES `l_log` WRITE;
/*!40000 ALTER TABLE `l_log` DISABLE KEYS */;
INSERT INTO `l_log` VALUES (10,'2018-02-20 19:50:18','{\"username\":\"drmuncan\"}',5),(11,'2018-02-20 21:37:01','{\"username\":\"bernhard\"}',5),(12,'2018-02-20 21:37:02','{\"username\":\"bernhard\"}',5),(13,'2018-02-20 21:38:08','{\"username\":\"bernhard\"}',5),(14,'2018-02-20 21:38:08','{\"username\":\"bernhard\"}',5),(15,'2018-02-20 21:39:25','{\"username\":\"bernhard\"}',5),(16,'2018-02-20 21:39:26','{\"username\":\"bernhard\"}',5),(17,'2018-02-20 21:43:26','{\"username\":\"bernhard\"}',5),(18,'2018-02-20 21:43:27','{\"username\":\"bernhard\"}',5),(19,'2018-02-20 21:44:46','{\"username\":\"bernhard\"}',5),(20,'2018-02-20 21:44:47','{\"username\":\"bernhard\"}',5),(21,'2018-02-20 21:46:17','{\"username\":\"bernhard\"}',5),(22,'2018-02-20 21:46:17','{\"username\":\"bernhard\"}',5),(23,'2018-02-20 21:48:36','{\"username\":\"bernhard\"}',5),(24,'2018-02-20 21:48:36','{\"username\":\"bernhard\"}',5),(25,'2018-02-20 21:51:50','{\"username\":\"bernhard\"}',5),(26,'2018-02-20 21:51:50','{\"username\":\"bernhard\"}',5),(27,'2018-02-20 21:56:31','{\"username\":\"bernhard\"}',5),(28,'2018-02-20 21:56:32','{\"username\":\"bernhard\"}',5),(29,'2018-02-20 21:58:23','{\"username\":\"bernhard\"}',5),(30,'2018-02-20 21:58:24','{\"username\":\"bernhard\"}',5),(31,'2018-02-20 22:01:32','{\"username\":\"bernhard\"}',5),(32,'2018-02-20 22:01:32','{\"username\":\"bernhard\"}',5),(33,'2018-02-20 22:04:33','{\"username\":\"bernhard\"}',5),(34,'2018-02-20 22:04:34','{\"username\":\"bernhard\"}',5),(35,'2018-02-20 22:08:19','{\"username\":\"bernhard\"}',5),(36,'2018-02-20 22:08:19','{\"username\":\"bernhard\"}',5),(37,'2018-02-20 22:10:04','{\"username\":\"bernhard\"}',5),(38,'2018-02-20 22:10:05','{\"username\":\"bernhard\"}',5),(42,'2018-02-21 09:32:57','{\"username\":\"bernhard\"}',5),(43,'2018-02-21 09:32:57','{\"username\":\"bernhard\"}',5),(44,'2018-02-21 09:33:26','{\"username\":\"bernhard\"}',5),(45,'2018-02-21 09:33:26','{\"username\":\"bernhard\"}',5),(46,'2018-02-21 09:33:39','{\"username\":\"drmuncan\"}',5),(47,'2018-02-21 09:38:38','{\"username\":\"bernhard\"}',5),(48,'2018-02-21 09:38:38','{\"username\":\"bernhard\"}',5),(49,'2018-02-21 09:39:41','{\"username\":\"bernhard\"}',5),(50,'2018-02-21 09:39:41','{\"username\":\"bernhard\"}',5),(51,'2018-02-21 09:41:57','{\"username\":\"bernhard\"}',5),(52,'2018-02-21 09:41:57','{\"username\":\"bernhard\"}',5),(53,'2018-02-21 09:44:08','{\"username\":\"bernhard\"}',5),(54,'2018-02-21 09:44:09','{\"username\":\"bernhard\"}',5),(55,'2018-02-21 09:45:52','{\"username\":\"bernhard\"}',5),(56,'2018-02-21 09:45:52','{\"username\":\"bernhard\"}',5),(57,'2018-02-21 09:49:03','{\"username\":\"bernhard\"}',5),(58,'2018-02-21 09:49:04','{\"username\":\"bernhard\"}',5),(59,'2018-02-21 09:50:00','{\"username\":\"bernhard\"}',5),(60,'2018-02-21 09:50:00','{\"username\":\"bernhard\"}',5),(61,'2018-02-21 09:57:22','{\"username\":\"bernhard\"}',5),(62,'2018-02-21 09:57:23','{\"username\":\"bernhard\"}',5),(63,'2018-02-21 09:58:08','{\"username\":\"bernhard\"}',5),(64,'2018-02-21 09:58:08','{\"username\":\"bernhard\"}',5),(65,'2018-02-21 09:59:58','{\"username\":\"bernhard\"}',5),(66,'2018-02-21 09:59:58','{\"username\":\"bernhard\"}',5),(67,'2018-02-21 10:02:59','{\"username\":\"bernhard\"}',5),(68,'2018-02-21 10:02:59','{\"username\":\"bernhard\"}',5),(69,'2018-02-21 10:04:54','{\"username\":\"bernhard\"}',5),(70,'2018-02-21 10:04:54','{\"username\":\"bernhard\"}',5),(71,'2018-02-21 10:09:18','{\"username\":\"bernhard\"}',5),(72,'2018-02-21 10:09:18','{\"username\":\"bernhard\"}',5),(73,'2018-02-21 10:12:53','{\"username\":\"bernhard\"}',5),(74,'2018-02-21 10:12:54','{\"username\":\"bernhard\"}',5),(75,'2018-02-21 10:14:26','{\"username\":\"bernhard\"}',5),(76,'2018-02-21 10:14:27','{\"username\":\"bernhard\"}',5),(77,'2018-02-21 19:53:58','{\"username\":\"drmuncan\"}',5),(78,'2018-02-21 20:24:21','{\"username\":\"bernhard\"}',5),(79,'2018-02-21 20:24:21','{\"username\":\"bernhard\"}',5),(80,'2018-02-21 20:26:31','{\"username\":\"bernhard\"}',5),(81,'2018-02-21 20:26:31','{\"username\":\"bernhard\"}',5),(82,'2018-02-21 20:27:05','{\"username\":\"bernhard\"}',5),(83,'2018-02-21 20:27:05','{\"username\":\"bernhard\"}',5),(84,'2018-02-21 20:53:54','{\"username\":\"bernhard\"}',5),(85,'2018-02-21 20:53:55','{\"username\":\"bernhard\"}',5),(86,'2018-02-21 20:55:21','{\"username\":\"bernhard\"}',5),(87,'2018-02-21 20:55:22','{\"username\":\"bernhard\"}',5),(93,'2018-02-22 09:34:50','{\"username\":\"bernhard\"}',5),(94,'2018-02-22 09:34:51','{\"username\":\"bernhard\"}',5),(95,'2018-02-22 09:35:15','{\"username\":\"drmuncan\"}',5),(96,'2018-02-22 09:37:04','{\"username\":\"bernhard\"}',5),(97,'2018-02-22 09:37:05','{\"username\":\"bernhard\"}',5),(98,'2018-02-22 09:42:00','{\"username\":\"bernhard\"}',5),(99,'2018-02-22 09:42:01','{\"username\":\"bernhard\"}',5),(100,'2018-02-22 10:24:42','{\"username\":\"bernhard\"}',5),(101,'2018-02-22 10:24:42','{\"username\":\"bernhard\"}',5),(102,'2018-02-22 10:24:42','{\"username\":\"bernhard\"}',5),(103,'2018-02-22 10:24:43','{\"username\":\"bernhard\"}',5),(104,'2018-02-22 10:25:27','{\"username\":\"bernhard\"}',5),(105,'2018-02-22 10:25:27','{\"username\":\"bernhard\"}',5),(106,'2018-02-22 10:31:37','{\"username\":\"raphael\"}',5),(107,'2018-02-22 10:32:21','{\"username\":\"bernhard\"}',5),(108,'2018-02-22 10:32:21','{\"username\":\"bernhard\"}',5),(109,'2018-02-22 10:32:28','{\"username\":\"bernhard\"}',5),(110,'2018-02-22 10:32:28','{\"username\":\"bernhard\"}',5),(111,'2018-02-22 10:32:35','{\"username\":\"bernhard\"}',5),(112,'2018-02-22 10:32:35','{\"username\":\"bernhard\"}',5),(113,'2018-02-22 16:49:08','{\"username\":\"bernhard\"}',5),(114,'2018-02-22 16:49:09','{\"username\":\"bernhard\"}',5),(115,'2018-02-22 16:49:29','{\"username\":\"drmuncan\"}',5),(116,'2018-02-22 16:50:57','{\"username\":\"bernhard\"}',5),(117,'2018-02-22 16:50:57','{\"username\":\"bernhard\"}',5),(118,'2018-02-22 16:55:52','{\"username\":\"bernhard\"}',5),(119,'2018-02-22 16:55:53','{\"username\":\"bernhard\"}',5),(120,'2018-02-22 17:06:42','{\"username\":\"bernhard\"}',5),(121,'2018-02-22 17:06:43','{\"username\":\"bernhard\"}',5),(122,'2018-02-22 17:10:46','{\"username\":\"bernhard\"}',5),(123,'2018-02-22 17:10:47','{\"username\":\"bernhard\"}',5),(124,'2018-02-22 17:12:35','{\"username\":\"bernhard\"}',5),(125,'2018-02-22 17:12:36','{\"username\":\"bernhard\"}',5),(126,'2018-02-22 17:14:21','{\"username\":\"bernhard\"}',5),(127,'2018-02-22 17:14:22','{\"username\":\"bernhard\"}',5),(128,'2018-02-22 17:16:19','{\"username\":\"bernhard\"}',5),(129,'2018-02-22 17:16:19','{\"username\":\"bernhard\"}',5),(130,'2018-02-22 17:22:41','{\"username\":\"bernhard\"}',5),(131,'2018-02-22 17:22:42','{\"username\":\"bernhard\"}',5),(132,'2018-02-22 17:29:51','{\"username\":\"bernhard\"}',5),(133,'2018-02-22 17:29:52','{\"username\":\"bernhard\"}',5),(134,'2018-02-22 17:31:23','{\"username\":\"bernhard\"}',5),(135,'2018-02-22 17:31:23','{\"username\":\"bernhard\"}',5),(136,'2018-02-22 17:33:54','{\"username\":\"bernhard\"}',5),(137,'2018-02-22 17:33:54','{\"username\":\"bernhard\"}',5),(138,'2018-02-22 17:35:53','{\"username\":\"bernhard\"}',5),(139,'2018-02-22 17:35:54','{\"username\":\"bernhard\"}',5),(140,'2018-02-22 17:38:59','{\"username\":\"bernhard\"}',5),(141,'2018-02-22 17:38:59','{\"username\":\"bernhard\"}',5),(142,'2018-02-22 17:39:50','{\"username\":\"bernhard\"}',5),(143,'2018-02-22 17:39:51','{\"username\":\"bernhard\"}',5),(144,'2018-02-22 17:41:17','{\"username\":\"bernhard\"}',5),(145,'2018-02-22 17:41:18','{\"username\":\"bernhard\"}',5),(146,'2018-02-22 17:43:29','{\"username\":\"bernhard\"}',5),(147,'2018-02-22 17:43:30','{\"username\":\"bernhard\"}',5),(148,'2018-02-22 17:47:45','{\"username\":\"bernhard\"}',5),(149,'2018-02-22 17:47:46','{\"username\":\"bernhard\"}',5),(150,'2018-02-22 17:50:11','{\"username\":\"bernhard\"}',5),(151,'2018-02-22 17:50:12','{\"username\":\"bernhard\"}',5),(152,'2018-02-22 17:57:05','{\"username\":\"bernhard\"}',5),(153,'2018-02-22 21:21:47','{\"username\":\"bernhard\"}',5),(154,'2018-02-22 21:21:47','{\"username\":\"bernhard\"}',5),(160,'2018-02-22 22:17:16','{\"username\":\"bernhard\"}',5),(161,'2018-02-22 22:17:17','{\"username\":\"bernhard\"}',5),(162,'2018-02-22 22:17:27','{\"username\":\"bernhard\"}',5),(163,'2018-02-22 22:19:03','{\"username\":\"bernhard\"}',5),(164,'2018-02-22 22:19:04','{\"username\":\"bernhard\"}',5),(165,'2018-02-22 22:19:15','{\"username\":\"bernhard\"}',5),(166,'2018-02-22 22:19:49','{\"username\":\"bernhard\"}',5),(167,'2018-02-22 22:19:49','{\"username\":\"bernhard\"}',5),(168,'2018-02-22 22:19:56','{\"username\":\"bernhard\"}',5),(169,'2018-02-22 22:21:15','{\"username\":\"bernhard\"}',5),(170,'2018-02-22 22:21:16','{\"username\":\"bernhard\"}',5),(171,'2018-02-22 22:21:23','{\"username\":\"bernhard\"}',5),(172,'2018-02-22 22:21:26','{\"username\":\"bernhard\"}',5),(173,'2018-02-22 22:21:27','{\"username\":\"bernhard\"}',5),(174,'2018-02-22 22:21:36','{\"username\":\"bernhard\"}',5),(175,'2018-02-22 22:22:41','{\"username\":\"bernhard\"}',5),(176,'2018-02-22 22:22:41','{\"username\":\"bernhard\"}',5),(177,'2018-02-22 22:22:49','{\"username\":\"bernhard\"}',5),(178,'2018-02-22 22:24:03','{\"username\":\"bernhard\"}',5),(179,'2018-02-22 22:24:03','{\"username\":\"bernhard\"}',5),(180,'2018-02-22 22:25:45','{\"username\":\"bernhard\"}',5),(181,'2018-02-22 22:25:46','{\"username\":\"bernhard\"}',5),(182,'2018-02-22 22:30:19','{\"username\":\"bernhard\"}',5),(183,'2018-02-22 22:31:00','{\"username\":\"bernhard\"}',5),(184,'2018-02-22 22:32:41','{\"username\":\"bernhard\"}',5),(185,'2018-02-22 22:32:42','{\"username\":\"bernhard\"}',5),(186,'2018-02-22 22:33:01','{\"username\":\"bernhard\"}',5),(187,'2018-02-22 22:33:02','{\"username\":\"bernhard\"}',5),(188,'2018-02-22 22:33:41','{\"username\":\"bernhard\"}',5),(189,'2018-02-22 22:33:41','{\"username\":\"bernhard\"}',5),(190,'2018-02-22 22:37:16','{\"username\":\"bernhard\"}',5),(191,'2018-02-22 22:37:16','{\"username\":\"bernhard\"}',5),(192,'2018-02-22 22:38:52','{\"username\":\"bernhard\"}',5),(193,'2018-02-22 22:38:52','{\"username\":\"bernhard\"}',5),(194,'2018-02-22 22:44:10','{\"username\":\"bernhard\"}',5),(195,'2018-02-22 22:44:10','{\"username\":\"bernhard\"}',5),(196,'2018-02-22 22:46:53','{\"username\":\"bernhard\"}',5),(197,'2018-02-22 22:47:20','{\"username\":\"bernhard\"}',5),(198,'2018-02-22 22:48:32','{\"username\":\"drmuncan\"}',5),(199,'2018-02-22 22:52:56','{\"username\":\"bernhard\"}',5),(200,'2018-02-22 22:52:56','{\"username\":\"bernhard\"}',5),(201,'2018-02-22 22:53:14','{\"username\":\"bernhard\"}',5),(202,'2018-02-22 22:53:14','{\"username\":\"bernhard\"}',5),(203,'2018-02-23 09:53:13','{\"username\":\"drmuncan\"}',5),(204,'2018-02-23 09:58:24','{\"username\":\"drmuncan\"}',5),(209,'2018-02-23 10:03:20','{\"username\":\"drmuncan\"}',5),(234,'2018-02-23 12:37:14','{\"username\":\"drmuncan\"}',5),(247,'2018-02-23 19:35:38','{\"username\":\"drmuncan\"}',5),(252,'2018-02-23 20:06:34','{\"username\":\"drmuncan\"}',5),(318,'2018-02-24 07:58:21','{\"username\":\"drmuncan\"}',5),(321,'2018-02-24 09:20:50','{\"username\":\"drmuncan\"}',5),(332,'2018-02-24 16:40:48','{\"username\":\"drmuncan\"}',5),(334,'2018-02-24 20:06:38','{\"username\":\"drmuncan\"}',5),(335,'2018-02-24 20:12:03','{\"username\":\"drmuncan\"}',5),(336,'2018-02-24 20:59:50','{\"username\":\"drmuncan\"}',5),(337,'2018-02-24 22:44:04','{\"username\":\"drmuncan\"}',5),(338,'2018-02-24 22:48:27','{\"username\":\"drmuncan\"}',5),(346,'2018-02-25 10:39:13','{\"username\":\"drmuncan\"}',5),(357,'2018-02-25 13:03:35','{\"username\":\"drmuncan\"}',5),(358,'2018-02-25 13:07:38','{\"username\":\"drmuncan\"}',5),(530,'2018-02-25 16:29:14','{\"username\":\"drmuncan\"}',5),(533,'2018-02-25 16:31:09','{\"username\":\"drmuncan\"}',5),(562,'2018-02-25 16:46:39','{\"username\":\"drmuncan\"}',5),(602,'2018-02-25 17:37:02','{\"username\":\"drmuncan\"}',5),(603,'2018-02-25 18:05:47','{\"username\":\"bernhard\"}',5),(604,'2018-02-25 18:05:48','{\"username\":\"bernhard\"}',5),(605,'2018-02-25 18:12:15','{\"username\":\"drmuncan\"}',5),(606,'2018-02-25 18:13:52','{\"username\":\"bernhard\"}',5),(607,'2018-02-25 18:13:52','{\"username\":\"bernhard\"}',5),(608,'2018-02-25 18:15:13','{\"username\":\"bernhard\"}',5),(609,'2018-02-25 18:15:13','{\"username\":\"bernhard\"}',5),(610,'2018-02-25 18:15:59','{\"username\":\"drmuncan\"}',5),(611,'2018-02-25 18:17:55','{\"username\":\"leonardo\"}',5),(612,'2018-02-25 18:22:52','{\"username\":\"bernhard\"}',5),(613,'2018-02-25 18:22:53','{\"username\":\"bernhard\"}',5),(614,'2018-02-25 18:23:47','{\"username\":\"bernhard\"}',5),(615,'2018-02-25 18:33:35','{\"username\":\"bernhard\"}',5),(616,'2018-02-25 18:33:36','{\"username\":\"bernhard\"}',5),(617,'2018-02-25 18:43:19','{\"username\":\"bernhard\"}',5),(618,'2018-02-25 18:43:19','{\"username\":\"bernhard\"}',5),(619,'2018-02-26 19:15:56','{\"username\":\"bernhard\"}',5),(620,'2018-02-26 19:15:57','{\"username\":\"bernhard\"}',5),(621,'2018-02-26 19:20:14','{\"username\":\"bernhard\"}',5),(622,'2018-02-26 19:20:15','{\"username\":\"bernhard\"}',5),(623,'2018-02-26 19:24:06','{\"username\":\"bernhard\"}',5),(624,'2018-02-26 19:24:07','{\"username\":\"bernhard\"}',5),(625,'2018-02-26 19:24:26','{\"username\":\"bernhard\"}',5),(626,'2018-02-26 19:25:37','{\"username\":\"bernhard\"}',5),(627,'2018-02-26 19:25:38','{\"username\":\"bernhard\"}',5),(628,'2018-02-26 19:27:21','{\"username\":\"drmuncan\"}',5),(629,'2018-02-26 19:28:51','{\"username\":\"bernhard\"}',5),(630,'2018-02-26 19:28:52','{\"username\":\"bernhard\"}',5),(631,'2018-02-26 19:31:36','{\"username\":\"bernhard\"}',5),(632,'2018-02-26 19:31:37','{\"username\":\"bernhard\"}',5),(633,'2018-02-26 19:34:53','{\"username\":\"drmuncan\"}',5),(634,'2018-02-26 20:10:20','{\"username\":\"bernhard\"}',5),(635,'2018-02-26 20:10:21','{\"username\":\"bernhard\"}',5),(636,'2018-02-26 20:14:25','{\"username\":\"bernhard\"}',5),(637,'2018-02-26 20:14:26','{\"username\":\"bernhard\"}',5),(638,'2018-02-26 20:22:37','{\"username\":\"bernhard\"}',5),(639,'2018-02-26 20:22:37','{\"username\":\"bernhard\"}',5),(640,'2018-02-26 20:32:39','{\"username\":\"bernhard\"}',5),(641,'2018-02-26 20:32:39','{\"username\":\"bernhard\"}',5),(642,'2018-02-26 20:40:22','{\"username\":\"bernhard\"}',5),(643,'2018-02-26 20:40:23','{\"username\":\"bernhard\"}',5),(644,'2018-02-26 20:51:33','{\"username\":\"bernhard\"}',5),(645,'2018-02-26 20:51:34','{\"username\":\"bernhard\"}',5),(646,'2018-02-26 20:52:33','{\"username\":\"bernhard\"}',5),(647,'2018-02-26 20:52:34','{\"username\":\"bernhard\"}',5),(648,'2018-02-26 20:55:34','{\"username\":\"bernhard\"}',5),(649,'2018-02-26 20:55:34','{\"username\":\"bernhard\"}',5),(650,'2018-02-26 20:59:36','{\"username\":\"bernhard\"}',5),(651,'2018-02-26 20:59:36','{\"username\":\"bernhard\"}',5),(652,'2018-02-26 21:00:56','{\"username\":\"bernhard\"}',5),(653,'2018-02-26 21:00:56','{\"username\":\"bernhard\"}',5),(654,'2018-02-26 21:03:10','{\"username\":\"bernhard\"}',5),(655,'2018-02-26 21:03:10','{\"username\":\"bernhard\"}',5),(656,'2018-02-26 21:05:41','{\"username\":\"bernhard\"}',5),(657,'2018-02-26 21:05:41','{\"username\":\"bernhard\"}',5),(658,'2018-02-26 21:09:32','{\"username\":\"bernhard\"}',5),(659,'2018-02-26 21:09:32','{\"username\":\"bernhard\"}',5),(660,'2018-02-26 21:10:37','{\"username\":\"bernhard\"}',5),(661,'2018-02-26 21:10:38','{\"username\":\"bernhard\"}',5),(662,'2018-02-26 21:13:07','{\"username\":\"bernhard\"}',5),(663,'2018-02-26 21:13:07','{\"username\":\"bernhard\"}',5),(664,'2018-02-26 21:20:37','{\"username\":\"bernhard\"}',5),(665,'2018-02-26 21:20:38','{\"username\":\"bernhard\"}',5),(666,'2018-02-26 21:34:53','{\"username\":\"bernhard\"}',5),(667,'2018-02-26 21:34:54','{\"username\":\"bernhard\"}',5),(668,'2018-02-26 21:36:45','{\"username\":\"bernhard\"}',5),(669,'2018-02-26 21:36:45','{\"username\":\"bernhard\"}',5),(670,'2018-02-26 21:43:11','{\"username\":\"bernhard\"}',5),(671,'2018-02-26 21:43:11','{\"username\":\"bernhard\"}',5),(672,'2018-02-26 21:45:39','{\"username\":\"bernhard\"}',5),(673,'2018-02-26 21:45:39','{\"username\":\"bernhard\"}',5),(674,'2018-02-26 21:49:11','{\"username\":\"bernhard\"}',5),(675,'2018-02-26 21:49:11','{\"username\":\"bernhard\"}',5),(676,'2018-02-26 22:04:13','{\"username\":\"bernhard\"}',5),(677,'2018-02-26 22:04:13','{\"username\":\"bernhard\"}',5),(678,'2018-02-26 22:06:34','{\"username\":\"bernhard\"}',5),(679,'2018-02-26 22:06:34','{\"username\":\"bernhard\"}',5),(680,'2018-02-26 22:08:06','{\"username\":\"bernhard\"}',5),(681,'2018-02-26 22:08:07','{\"username\":\"bernhard\"}',5),(682,'2018-02-26 22:27:43','{\"username\":\"bernhard\"}',5),(683,'2018-02-26 22:27:43','{\"username\":\"bernhard\"}',5),(684,'2018-02-26 22:29:35','{\"username\":\"bernhard\"}',5),(685,'2018-02-26 22:29:35','{\"username\":\"bernhard\"}',5),(686,'2018-02-26 22:33:39','{\"username\":\"bernhard\"}',5),(687,'2018-02-26 22:33:40','{\"username\":\"bernhard\"}',5),(688,'2018-02-26 22:47:02','{\"username\":\"bernhard\"}',5),(689,'2018-02-26 22:47:02','{\"username\":\"bernhard\"}',5),(690,'2018-02-26 22:56:15','{\"username\":\"bernhard\"}',5),(691,'2018-02-26 22:56:16','{\"username\":\"bernhard\"}',5),(692,'2018-02-26 22:58:19','{\"username\":\"bernhard\"}',5),(693,'2018-02-26 22:58:20','{\"username\":\"bernhard\"}',5),(694,'2018-02-26 23:00:59','{\"username\":\"philipp\"}',5),(695,'2018-02-26 23:01:50','{\"username\":\"bernhard\"}',5),(696,'2018-02-26 23:01:51','{\"username\":\"bernhard\"}',5),(697,'2018-02-26 23:05:41','{\"username\":\"bernhard\"}',5),(698,'2018-02-26 23:05:41','{\"username\":\"bernhard\"}',5),(699,'2018-02-26 23:19:22','{\"username\":\"bernhard\"}',5),(700,'2018-02-26 23:19:23','{\"username\":\"bernhard\"}',5),(701,'2018-02-26 23:21:47','{\"username\":\"bernhard\"}',5),(702,'2018-02-26 23:21:48','{\"username\":\"bernhard\"}',5),(703,'2018-02-26 23:23:30','{\"username\":\"bernhard\"}',5),(704,'2018-02-26 23:23:31','{\"username\":\"bernhard\"}',5),(705,'2018-02-26 23:26:14','{\"username\":\"bernhard\"}',5),(706,'2018-02-26 23:26:14','{\"username\":\"bernhard\"}',5),(707,'2018-02-26 23:37:26','{\"username\":\"bernhard\"}',5),(708,'2018-02-26 23:37:27','{\"username\":\"bernhard\"}',5),(709,'2018-02-27 22:10:58','{\"username\":\"drmuncan\"}',5),(711,'2018-02-27 22:11:42','{\"svnr\":\"1003250229\",\"nachname\":\"Soren-Test\",\"vorname\":\"Ake\",\"grund\":\"Behandlung\"}',3),(712,'2018-02-27 22:39:11','{\"username\":\"drmuncan\"}',5),(713,'2018-02-27 22:39:34','{\"username\":\"drmuncan\"}',5),(717,'2018-02-27 22:41:09','{\"username\":\"drmuncan\"}',5),(718,'2018-02-27 22:48:58',NULL,2),(719,'2018-02-27 22:48:58','{\"svnr\":\"2469180576\",\"nachname\":\"Reuchelt\",\"vorname\":\"manfred\",\"grund\":\"Arbeitsunfähigkeitsmeldung\"}',3),(720,'2018-02-27 22:49:02',NULL,4),(721,'2018-02-27 22:49:13',NULL,4),(722,'2018-02-27 22:55:54',NULL,2),(723,'2018-02-27 22:55:54','{\"svnr\":\"1003250229\",\"nachname\":\"Soren-Test\",\"vorname\":\"Ake\",\"grund\":\"Behandlung\"}',3),(724,'2018-02-27 22:55:56',NULL,2),(725,'2018-02-27 22:55:56','{\"svnr\":\"1234567890\",\"nachname\":\"Askan\",\"vorname\":\"kevin\",\"grund\":\"Rezept\"}',3),(726,'2018-02-27 22:56:00',NULL,2),(727,'2018-02-27 22:56:00','{\"svnr\":\"2469180576\",\"nachname\":\"Reuchelt\",\"vorname\":\"manfred\",\"grund\":\"Arbeitsunfähigkeitsmeldung\"}',3),(728,'2018-02-27 22:56:02',NULL,2),(729,'2018-02-27 22:56:02','{\"svnr\":\"6523980167\",\"nachname\":\"knuckls\",\"vorname\":\"Uganda\",\"grund\":\"Rezept\"}',3),(730,'2018-02-27 22:56:04',NULL,2),(731,'2018-02-27 22:56:04','{\"svnr\":\"7724091276\",\"nachname\":\"Babushka\",\"vorname\":\"Olga\",\"grund\":\"Arbeitsunfähigkeitsmeldung\"}',3),(732,'2018-02-27 22:56:06',NULL,2),(733,'2018-02-27 22:56:06','{\"svnr\":\"663782916\",\"nachname\":\"Kraut\",\"vorname\":\"Lara\",\"grund\":\"Rezept\"}',3),(734,'2018-02-27 22:56:08',NULL,2),(735,'2018-02-27 22:56:08','{\"svnr\":\"987654328\",\"nachname\":\"Schiff\",\"vorname\":\"Hans\",\"grund\":\"Behandlung\"}',3),(736,'2018-02-27 22:56:29',NULL,4),(737,'2018-02-27 22:56:29',NULL,4),(738,'2018-02-27 22:56:29',NULL,4),(739,'2018-02-27 22:56:29',NULL,4),(740,'2018-02-27 22:56:29',NULL,4),(741,'2018-02-27 22:56:29',NULL,4),(742,'2018-02-27 22:56:29',NULL,4),(743,'2018-02-27 22:56:33',NULL,4),(744,'2018-02-27 22:56:33',NULL,4),(745,'2018-02-27 22:56:33',NULL,4),(746,'2018-02-27 22:56:33',NULL,4),(747,'2018-02-27 22:56:38',NULL,4),(748,'2018-02-27 22:56:38',NULL,4),(749,'2018-02-27 22:56:38',NULL,4),(750,'2018-02-27 22:56:38',NULL,4),(751,'2018-02-27 22:56:38',NULL,4),(752,'2018-02-27 22:56:38',NULL,4),(753,'2018-02-27 22:56:39',NULL,4),(754,'2018-02-27 22:56:39',NULL,4),(755,'2018-02-27 22:56:39',NULL,4),(756,'2018-02-27 22:56:39',NULL,4),(757,'2018-02-27 22:56:39',NULL,4),(758,'2018-02-27 22:56:39',NULL,4),(759,'2018-02-27 22:57:01',NULL,4),(760,'2018-02-27 22:57:01',NULL,4),(761,'2018-02-27 22:57:01',NULL,4),(762,'2018-02-27 22:58:47',NULL,4),(763,'2018-02-27 22:59:02',NULL,4),(764,'2018-02-27 22:59:02',NULL,4),(765,'2018-02-27 22:59:02',NULL,4),(766,'2018-02-27 22:59:02',NULL,4),(767,'2018-02-27 22:59:02',NULL,4),(768,'2018-02-27 22:59:02',NULL,4),(769,'2018-02-27 22:59:04',NULL,4),(770,'2018-02-27 22:59:04',NULL,4),(771,'2018-02-27 22:59:04',NULL,4),(772,'2018-02-27 22:59:04',NULL,4),(773,'2018-02-27 22:59:04',NULL,4),(774,'2018-02-27 22:59:06',NULL,4),(775,'2018-02-27 22:59:13',NULL,4),(776,'2018-02-27 22:59:13',NULL,4),(777,'2018-02-27 22:59:13',NULL,4),(778,'2018-02-27 22:59:13',NULL,4),(779,'2018-02-27 22:59:13',NULL,4),(780,'2018-02-27 22:59:15',NULL,4),(781,'2018-02-27 23:02:35',NULL,4),(782,'2018-02-27 23:02:35',NULL,4),(783,'2018-02-27 23:02:35',NULL,4),(784,'2018-02-27 23:02:35',NULL,4),(785,'2018-02-27 23:02:38',NULL,4),(786,'2018-02-27 23:02:38',NULL,4),(787,'2018-02-27 23:02:38',NULL,4),(788,'2018-02-27 23:02:38',NULL,4),(789,'2018-02-27 23:03:01',NULL,4),(790,'2018-02-27 23:03:01',NULL,4),(791,'2018-02-27 23:03:01',NULL,4),(792,'2018-02-27 23:03:01',NULL,4),(793,'2018-02-27 23:03:49',NULL,4),(794,'2018-02-27 23:03:49',NULL,4),(795,'2018-02-27 23:03:58',NULL,4),(796,'2018-02-27 23:04:03',NULL,4),(797,'2018-02-27 23:04:03',NULL,4),(798,'2018-02-27 23:04:03',NULL,4),(799,'2018-02-27 23:04:03',NULL,4),(800,'2018-02-27 23:04:34',NULL,4),(801,'2018-02-27 23:04:34',NULL,4),(802,'2018-02-27 23:04:34',NULL,4),(803,'2018-02-27 23:04:34',NULL,4),(804,'2018-02-27 23:04:42',NULL,4),(805,'2018-02-27 23:04:42',NULL,4),(806,'2018-02-27 23:04:42',NULL,4),(807,'2018-02-27 23:04:42',NULL,4),(808,'2018-02-27 23:04:49',NULL,4),(809,'2018-02-27 23:05:03',NULL,4),(810,'2018-02-27 23:05:03',NULL,4),(811,'2018-02-27 23:05:03',NULL,4),(812,'2018-02-27 23:32:10',NULL,4),(813,'2018-02-27 23:32:10',NULL,4),(814,'2018-02-27 23:32:10',NULL,4),(815,'2018-02-27 23:34:31','{\"username\":\"drmuncan\"}',5),(816,'2018-02-27 23:41:14','{\"username\":\"drmuncan\"}',5);
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
INSERT INTO `la_logart` VALUES (1,'Patientenneuanmeldung'),(2,'Patientendaten├ñnderung'),(3,'Patienteneinschreibung'),(4,'Patientenaufruf'),(5,'Webapplikation - Anmeldung');
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
  `p_hausnummer` varchar(45) DEFAULT NULL,
  `p_ort` varchar(45) DEFAULT NULL,
  `p_plz` varchar(45) DEFAULT NULL,
  `p_postfachnummer` varchar(45) DEFAULT NULL,
  `p_postfachtext` varchar(45) DEFAULT NULL,
  `p_staatcode` varchar(45) DEFAULT NULL,
  `p_stocktuernummer` varchar(45) DEFAULT NULL,
  `p_strasse` varchar(45) DEFAULT NULL,
  `p_email` varchar(255) DEFAULT NULL,
  `p_telefonnummer` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`p_svnr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `p_patient`
--

LOCK TABLES `p_patient` WRITE;
/*!40000 ALTER TABLE `p_patient` DISABLE KEYS */;
INSERT INTO `p_patient` VALUES (663782916,'','W','Kraut','Lara','01.09.1960','15','Perchtoldsdorf','2380',NULL,NULL,NULL,NULL,'Marktplatz','neuberger@gmail.com','43036097816'),(987654328,'','M','Schiff','Hans','07.01.2003','15','Perchtoldsdorf','2380',NULL,NULL,NULL,NULL,'Marktplatz','hhfsuiujnlil@gmail.com','43036097816'),(1003250229,'Dr.-Ing.','M','Soren-Test','Ake','16.02.1988','12','ohrstadt','11245',NULL,NULL,NULL,NULL,'Marktplatz','marwin1998@gmail.com','43036097816'),(1234567890,'','M','Askan','kevin','11.11.2011','15','aal','2380',NULL,NULL,NULL,NULL,'Marktplatz','bushwookie@gmail.com','43036097816'),(2469180576,'Mag.','M','Reuchelt','manfred','01.05.1990','15','Perchtoldsdorf','2380',NULL,NULL,NULL,NULL,'Marktplatz','bushwookie@gmail.com','43036097816'),(3048280984,'Ing','W','Saric','Sarah','28.09.1984','15','Perchtoldsdorf','2380',NULL,NULL,'AT','20','Marktplatz','bushwookie@debil.com','43036097816'),(4294280984,'Mag','W','Müller','Anna','28.09.1984','12','Perchtoldsdorf','2380','9987654321','Keine Werbung','AT','21','Bahngasse',NULL,NULL),(5047060999,'Prof','M','Markovic','Predrag','06.09.1999','123','Wien','1100','1234567890','Keine Werbung','AT','12','Favoriten',NULL,NULL),(6032060899,'Mag.','M','Tobolka','Anton','06.08.1999',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6523980167,'','M','knuckls','Uganda','22.03.2007','12','Perchtoldsdorf','2380',NULL,NULL,NULL,NULL,'Marktplatz','bushwookie@gmail.com','43036097816'),(6529837019,'Ing.','M','Klein','Eugen','20.07.2000','15','Perchtoldsdorf','2380',NULL,NULL,NULL,NULL,'Marktplatz','bushwookie@gmail.com','43036097816'),(6666280984,'Dipl.Ing','M','Neuberger','Christopher','28.09.1984','11','Sulz','2392','435346435','Keine Werbung','AT','32','Hauptstra├ƒe',NULL,NULL),(7078280984,'Msc','M','Icme','Eren','28.09.1984','56','Wien','1010','235676453','Keine Werbung','AT','1','K├ñrtnerstra├ƒe',NULL,NULL),(7724091276,'Ing.','W','Babushka','Olga','01.04.1987','66','Sodorf','1245',NULL,NULL,NULL,NULL,'larnstrasse','chuxxl@gmail.com','43036097816');
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `ordination`.`p_patient_AFTER_INSERT` AFTER INSERT ON `p_patient` FOR EACH ROW
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `ordination`.`p_patient_AFTER_UPDATE` AFTER UPDATE ON `p_patient` FOR EACH ROW
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
-- Table structure for table `r_raum`
--

DROP TABLE IF EXISTS `r_raum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `r_raum` (
  `r_id` int(10) NOT NULL,
  `r_raumname` varchar(45) DEFAULT NULL,
  `r_platz` int(11) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `r_raum`
--

LOCK TABLES `r_raum` WRITE;
/*!40000 ALTER TABLE `r_raum` DISABLE KEYS */;
INSERT INTO `r_raum` VALUES (1,'behandlungsraum1',2),(2,'behandlungsraum2',4),(3,'behandlungsraum3',5),(4,'behandlungsraum4',1),(5,'behandlungsraum5',2);
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
INSERT INTO `v_versicherung` VALUES ('05','VAEB','Versicherungsanstalt f├╝r Eisenbahnen und Bergbau'),('07','BVA','Versicherungsanstalt ├Âffentlich Bediensteter'),('11','WGKK','Gebietskrankenkasse Wien'),('12','NOEGKK','Gebietskrankenkasse Nieder├Âsterreich'),('13','BGKK','Gebietskrankenkasse Burgenland'),('14','OOEGKK','Gebietskrankenkasse Ober├Âsterreich'),('15','STGKK','Gebietskrankenkasse Steiermark'),('16','KGKK','Gebietskrankenkasse K├ñrnten'),('17','SGKK','Gebietskrankenkasse Salzburg'),('18','TGKK','Gebietskrankenkasse Tirol'),('19','VGKK','Gebietskrankenkasse Vorarlberg'),('1A','KFAWIEN','Krankenf├╝rsorgeanstalt der Bediensteten der Stadt Wien'),('21','BKKTABAK','Betriebskrankenkasse Austria Tabak'),('22','BKKWVB','Betriebskrankenkasse der Wiener Verkehrsbetriebe'),('24','BKKMONDI','Betriebskrankenkasse Mondi'),('25','BKKVABS','Betriebskrankenkasse voestalpine Bahnsysteme'),('26','BKKZELTWEG','Betriebskrankenkasse Zeltweg'),('28','BKKKAPFENBERG','Betriebskrankenkasse Kapfenberg'),('40','SVAGW','Sozialversicherungsanstalt der gewerblichen Wirtschaft'),('50','SVB','Sozialversicherungsanstalt der Bauern'),('5A','KFGRAZ','Krankenf├╝rsorgeanstalt f├╝r die Beamten der Landeshauptstadt Graz'),('6A','KFAVILLACH','Krankenf├╝rsorgeanstalt f├╝r die Beamten der Stadt Villach'),('7A','KFASALZBURG','Krankenf├╝rsorgeanstalt der Magistratsbeamten der Landeshauptstadt Salzburg'),('8B','KUFTGEM','Kranken- und Unfallf├╝rsorge der Tiroler Gemeindebeamten'),('8C','KUFTIROL','Kranken- und Unfallf├╝rsorge der Tiroler Landesbeamten'),('8D','KUFTLEHRER','Kranken- und Unfallf├╝rsorge der Tiroler Landeslehrer');
/*!40000 ALTER TABLE `v_versicherung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ver_versicherungen`
--

DROP TABLE IF EXISTS `ver_versicherungen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ver_versicherungen` (
  `ver_v_id` varchar(45) NOT NULL,
  `ver_p_id` bigint(10) NOT NULL,
  `ver_leistungAktuell` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ver_v_id`,`ver_p_id`),
  KEY `fk_v_versicherung_has_p_patient_p_patient1_idx` (`ver_p_id`),
  KEY `fk_v_versicherung_has_p_patient_v_versicherung1_idx` (`ver_v_id`),
  CONSTRAINT `fk_v_versicherung_has_p_patient_p_patient1` FOREIGN KEY (`ver_p_id`) REFERENCES `p_patient` (`p_svnr`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_v_versicherung_has_p_patient_v_versicherung1` FOREIGN KEY (`ver_v_id`) REFERENCES `v_versicherung` (`v_versicherungsid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ver_versicherungen`
--

LOCK TABLES `ver_versicherungen` WRITE;
/*!40000 ALTER TABLE `ver_versicherungen` DISABLE KEYS */;
INSERT INTO `ver_versicherungen` VALUES ('05',6529837019,0),('07',6523980167,1),('11',1003250229,1),('11',2469180576,1),('11',3048280984,1),('11',6032060899,0),('11',7078280984,1),('12',1234567890,1),('17',663782916,0),('19',7724091276,1),('25',663782916,0),('25',3048280984,0),('28',6032060899,1),('28',6523980167,0),('40',3048280984,0),('40',6529837019,1),('50',6523980167,0),('7A',663782916,1),('8B',7724091276,0),('8D',987654328,1),('8D',4294280984,1),('8D',6032060899,0);
/*!40000 ALTER TABLE `ver_versicherungen` ENABLE KEYS */;
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
  `w_enterTimestamp` int(11) NOT NULL,
  `w_g_grund` int(11) NOT NULL,
  `w_beh_session` int(11) DEFAULT NULL,
  PRIMARY KEY (`w_patient_p_svnr`),
  KEY `fk_w_warteliste_g_grund1_idx` (`w_g_grund`),
  KEY `w_beh_session` (`w_beh_session`),
  CONSTRAINT `fk_w_warteliste_g_grund1` FOREIGN KEY (`w_g_grund`) REFERENCES `g_grund` (`g_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_w_warteliste_p_patient1` FOREIGN KEY (`w_patient_p_svnr`) REFERENCES `p_patient` (`p_svnr`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `w_warteliste_ibfk_1` FOREIGN KEY (`w_beh_session`) REFERENCES `beh_behandlung` (`beh_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `w_warteliste`
--

LOCK TABLES `w_warteliste` WRITE;
/*!40000 ALTER TABLE `w_warteliste` DISABLE KEYS */;
INSERT INTO `w_warteliste` VALUES (1003250229,2,1519768554,2,NULL),(1234567890,1,1519768556,1,NULL),(6523980167,3,1519768562,1,NULL);
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `ordination`.`w_warteliste_AFTER_INSERT` AFTER INSERT ON `w_warteliste` FOR EACH ROW
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `ordination`.`w_warteliste_AFTER_UPDATE` AFTER UPDATE ON `w_warteliste` FOR EACH ROW
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

-- Dump completed on 2018-02-27 23:49:25
