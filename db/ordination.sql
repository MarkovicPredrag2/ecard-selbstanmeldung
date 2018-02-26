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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=682 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `l_log`
--

LOCK TABLES `l_log` WRITE;
/*!40000 ALTER TABLE `l_log` DISABLE KEYS */;
INSERT INTO `l_log` VALUES (10,'2018-02-20 19:50:18','{\"username\":\"drmuncan\"}',5),(11,'2018-02-20 21:37:01','{\"username\":\"bernhard\"}',5),(12,'2018-02-20 21:37:02','{\"username\":\"bernhard\"}',5),(13,'2018-02-20 21:38:08','{\"username\":\"bernhard\"}',5),(14,'2018-02-20 21:38:08','{\"username\":\"bernhard\"}',5),(15,'2018-02-20 21:39:25','{\"username\":\"bernhard\"}',5),(16,'2018-02-20 21:39:26','{\"username\":\"bernhard\"}',5),(17,'2018-02-20 21:43:26','{\"username\":\"bernhard\"}',5),(18,'2018-02-20 21:43:27','{\"username\":\"bernhard\"}',5),(19,'2018-02-20 21:44:46','{\"username\":\"bernhard\"}',5),(20,'2018-02-20 21:44:47','{\"username\":\"bernhard\"}',5),(21,'2018-02-20 21:46:17','{\"username\":\"bernhard\"}',5),(22,'2018-02-20 21:46:17','{\"username\":\"bernhard\"}',5),(23,'2018-02-20 21:48:36','{\"username\":\"bernhard\"}',5),(24,'2018-02-20 21:48:36','{\"username\":\"bernhard\"}',5),(25,'2018-02-20 21:51:50','{\"username\":\"bernhard\"}',5),(26,'2018-02-20 21:51:50','{\"username\":\"bernhard\"}',5),(27,'2018-02-20 21:56:31','{\"username\":\"bernhard\"}',5),(28,'2018-02-20 21:56:32','{\"username\":\"bernhard\"}',5),(29,'2018-02-20 21:58:23','{\"username\":\"bernhard\"}',5),(30,'2018-02-20 21:58:24','{\"username\":\"bernhard\"}',5),(31,'2018-02-20 22:01:32','{\"username\":\"bernhard\"}',5),(32,'2018-02-20 22:01:32','{\"username\":\"bernhard\"}',5),(33,'2018-02-20 22:04:33','{\"username\":\"bernhard\"}',5),(34,'2018-02-20 22:04:34','{\"username\":\"bernhard\"}',5),(35,'2018-02-20 22:08:19','{\"username\":\"bernhard\"}',5),(36,'2018-02-20 22:08:19','{\"username\":\"bernhard\"}',5),(37,'2018-02-20 22:10:04','{\"username\":\"bernhard\"}',5),(38,'2018-02-20 22:10:05','{\"username\":\"bernhard\"}',5),(40,'2018-02-20 22:48:00',NULL,2),(41,'2018-02-20 22:51:20',NULL,2),(42,'2018-02-21 09:32:57','{\"username\":\"bernhard\"}',5),(43,'2018-02-21 09:32:57','{\"username\":\"bernhard\"}',5),(44,'2018-02-21 09:33:26','{\"username\":\"bernhard\"}',5),(45,'2018-02-21 09:33:26','{\"username\":\"bernhard\"}',5),(46,'2018-02-21 09:33:39','{\"username\":\"drmuncan\"}',5),(47,'2018-02-21 09:38:38','{\"username\":\"bernhard\"}',5),(48,'2018-02-21 09:38:38','{\"username\":\"bernhard\"}',5),(49,'2018-02-21 09:39:41','{\"username\":\"bernhard\"}',5),(50,'2018-02-21 09:39:41','{\"username\":\"bernhard\"}',5),(51,'2018-02-21 09:41:57','{\"username\":\"bernhard\"}',5),(52,'2018-02-21 09:41:57','{\"username\":\"bernhard\"}',5),(53,'2018-02-21 09:44:08','{\"username\":\"bernhard\"}',5),(54,'2018-02-21 09:44:09','{\"username\":\"bernhard\"}',5),(55,'2018-02-21 09:45:52','{\"username\":\"bernhard\"}',5),(56,'2018-02-21 09:45:52','{\"username\":\"bernhard\"}',5),(57,'2018-02-21 09:49:03','{\"username\":\"bernhard\"}',5),(58,'2018-02-21 09:49:04','{\"username\":\"bernhard\"}',5),(59,'2018-02-21 09:50:00','{\"username\":\"bernhard\"}',5),(60,'2018-02-21 09:50:00','{\"username\":\"bernhard\"}',5),(61,'2018-02-21 09:57:22','{\"username\":\"bernhard\"}',5),(62,'2018-02-21 09:57:23','{\"username\":\"bernhard\"}',5),(63,'2018-02-21 09:58:08','{\"username\":\"bernhard\"}',5),(64,'2018-02-21 09:58:08','{\"username\":\"bernhard\"}',5),(65,'2018-02-21 09:59:58','{\"username\":\"bernhard\"}',5),(66,'2018-02-21 09:59:58','{\"username\":\"bernhard\"}',5),(67,'2018-02-21 10:02:59','{\"username\":\"bernhard\"}',5),(68,'2018-02-21 10:02:59','{\"username\":\"bernhard\"}',5),(69,'2018-02-21 10:04:54','{\"username\":\"bernhard\"}',5),(70,'2018-02-21 10:04:54','{\"username\":\"bernhard\"}',5),(71,'2018-02-21 10:09:18','{\"username\":\"bernhard\"}',5),(72,'2018-02-21 10:09:18','{\"username\":\"bernhard\"}',5),(73,'2018-02-21 10:12:53','{\"username\":\"bernhard\"}',5),(74,'2018-02-21 10:12:54','{\"username\":\"bernhard\"}',5),(75,'2018-02-21 10:14:26','{\"username\":\"bernhard\"}',5),(76,'2018-02-21 10:14:27','{\"username\":\"bernhard\"}',5),(77,'2018-02-21 19:53:58','{\"username\":\"drmuncan\"}',5),(78,'2018-02-21 20:24:21','{\"username\":\"bernhard\"}',5),(79,'2018-02-21 20:24:21','{\"username\":\"bernhard\"}',5),(80,'2018-02-21 20:26:31','{\"username\":\"bernhard\"}',5),(81,'2018-02-21 20:26:31','{\"username\":\"bernhard\"}',5),(82,'2018-02-21 20:27:05','{\"username\":\"bernhard\"}',5),(83,'2018-02-21 20:27:05','{\"username\":\"bernhard\"}',5),(84,'2018-02-21 20:53:54','{\"username\":\"bernhard\"}',5),(85,'2018-02-21 20:53:55','{\"username\":\"bernhard\"}',5),(86,'2018-02-21 20:55:21','{\"username\":\"bernhard\"}',5),(87,'2018-02-21 20:55:22','{\"username\":\"bernhard\"}',5),(92,'2018-02-21 22:22:07',NULL,1),(93,'2018-02-22 09:34:50','{\"username\":\"bernhard\"}',5),(94,'2018-02-22 09:34:51','{\"username\":\"bernhard\"}',5),(95,'2018-02-22 09:35:15','{\"username\":\"drmuncan\"}',5),(96,'2018-02-22 09:37:04','{\"username\":\"bernhard\"}',5),(97,'2018-02-22 09:37:05','{\"username\":\"bernhard\"}',5),(98,'2018-02-22 09:42:00','{\"username\":\"bernhard\"}',5),(99,'2018-02-22 09:42:01','{\"username\":\"bernhard\"}',5),(100,'2018-02-22 10:24:42','{\"username\":\"bernhard\"}',5),(101,'2018-02-22 10:24:42','{\"username\":\"bernhard\"}',5),(102,'2018-02-22 10:24:42','{\"username\":\"bernhard\"}',5),(103,'2018-02-22 10:24:43','{\"username\":\"bernhard\"}',5),(104,'2018-02-22 10:25:27','{\"username\":\"bernhard\"}',5),(105,'2018-02-22 10:25:27','{\"username\":\"bernhard\"}',5),(106,'2018-02-22 10:31:37','{\"username\":\"raphael\"}',5),(107,'2018-02-22 10:32:21','{\"username\":\"bernhard\"}',5),(108,'2018-02-22 10:32:21','{\"username\":\"bernhard\"}',5),(109,'2018-02-22 10:32:28','{\"username\":\"bernhard\"}',5),(110,'2018-02-22 10:32:28','{\"username\":\"bernhard\"}',5),(111,'2018-02-22 10:32:35','{\"username\":\"bernhard\"}',5),(112,'2018-02-22 10:32:35','{\"username\":\"bernhard\"}',5),(113,'2018-02-22 16:49:08','{\"username\":\"bernhard\"}',5),(114,'2018-02-22 16:49:09','{\"username\":\"bernhard\"}',5),(115,'2018-02-22 16:49:29','{\"username\":\"drmuncan\"}',5),(116,'2018-02-22 16:50:57','{\"username\":\"bernhard\"}',5),(117,'2018-02-22 16:50:57','{\"username\":\"bernhard\"}',5),(118,'2018-02-22 16:55:52','{\"username\":\"bernhard\"}',5),(119,'2018-02-22 16:55:53','{\"username\":\"bernhard\"}',5),(120,'2018-02-22 17:06:42','{\"username\":\"bernhard\"}',5),(121,'2018-02-22 17:06:43','{\"username\":\"bernhard\"}',5),(122,'2018-02-22 17:10:46','{\"username\":\"bernhard\"}',5),(123,'2018-02-22 17:10:47','{\"username\":\"bernhard\"}',5),(124,'2018-02-22 17:12:35','{\"username\":\"bernhard\"}',5),(125,'2018-02-22 17:12:36','{\"username\":\"bernhard\"}',5),(126,'2018-02-22 17:14:21','{\"username\":\"bernhard\"}',5),(127,'2018-02-22 17:14:22','{\"username\":\"bernhard\"}',5),(128,'2018-02-22 17:16:19','{\"username\":\"bernhard\"}',5),(129,'2018-02-22 17:16:19','{\"username\":\"bernhard\"}',5),(130,'2018-02-22 17:22:41','{\"username\":\"bernhard\"}',5),(131,'2018-02-22 17:22:42','{\"username\":\"bernhard\"}',5),(132,'2018-02-22 17:29:51','{\"username\":\"bernhard\"}',5),(133,'2018-02-22 17:29:52','{\"username\":\"bernhard\"}',5),(134,'2018-02-22 17:31:23','{\"username\":\"bernhard\"}',5),(135,'2018-02-22 17:31:23','{\"username\":\"bernhard\"}',5),(136,'2018-02-22 17:33:54','{\"username\":\"bernhard\"}',5),(137,'2018-02-22 17:33:54','{\"username\":\"bernhard\"}',5),(138,'2018-02-22 17:35:53','{\"username\":\"bernhard\"}',5),(139,'2018-02-22 17:35:54','{\"username\":\"bernhard\"}',5),(140,'2018-02-22 17:38:59','{\"username\":\"bernhard\"}',5),(141,'2018-02-22 17:38:59','{\"username\":\"bernhard\"}',5),(142,'2018-02-22 17:39:50','{\"username\":\"bernhard\"}',5),(143,'2018-02-22 17:39:51','{\"username\":\"bernhard\"}',5),(144,'2018-02-22 17:41:17','{\"username\":\"bernhard\"}',5),(145,'2018-02-22 17:41:18','{\"username\":\"bernhard\"}',5),(146,'2018-02-22 17:43:29','{\"username\":\"bernhard\"}',5),(147,'2018-02-22 17:43:30','{\"username\":\"bernhard\"}',5),(148,'2018-02-22 17:47:45','{\"username\":\"bernhard\"}',5),(149,'2018-02-22 17:47:46','{\"username\":\"bernhard\"}',5),(150,'2018-02-22 17:50:11','{\"username\":\"bernhard\"}',5),(151,'2018-02-22 17:50:12','{\"username\":\"bernhard\"}',5),(152,'2018-02-22 17:57:05','{\"username\":\"bernhard\"}',5),(153,'2018-02-22 21:21:47','{\"username\":\"bernhard\"}',5),(154,'2018-02-22 21:21:47','{\"username\":\"bernhard\"}',5),(155,'2018-02-22 21:29:24',NULL,3),(156,'2018-02-22 21:40:12',NULL,3),(157,'2018-02-22 21:44:17',NULL,3),(158,'2018-02-22 21:49:11',NULL,3),(159,'2018-02-22 22:02:01',NULL,4),(160,'2018-02-22 22:17:16','{\"username\":\"bernhard\"}',5),(161,'2018-02-22 22:17:17','{\"username\":\"bernhard\"}',5),(162,'2018-02-22 22:17:27','{\"username\":\"bernhard\"}',5),(163,'2018-02-22 22:19:03','{\"username\":\"bernhard\"}',5),(164,'2018-02-22 22:19:04','{\"username\":\"bernhard\"}',5),(165,'2018-02-22 22:19:15','{\"username\":\"bernhard\"}',5),(166,'2018-02-22 22:19:49','{\"username\":\"bernhard\"}',5),(167,'2018-02-22 22:19:49','{\"username\":\"bernhard\"}',5),(168,'2018-02-22 22:19:56','{\"username\":\"bernhard\"}',5),(169,'2018-02-22 22:21:15','{\"username\":\"bernhard\"}',5),(170,'2018-02-22 22:21:16','{\"username\":\"bernhard\"}',5),(171,'2018-02-22 22:21:23','{\"username\":\"bernhard\"}',5),(172,'2018-02-22 22:21:26','{\"username\":\"bernhard\"}',5),(173,'2018-02-22 22:21:27','{\"username\":\"bernhard\"}',5),(174,'2018-02-22 22:21:36','{\"username\":\"bernhard\"}',5),(175,'2018-02-22 22:22:41','{\"username\":\"bernhard\"}',5),(176,'2018-02-22 22:22:41','{\"username\":\"bernhard\"}',5),(177,'2018-02-22 22:22:49','{\"username\":\"bernhard\"}',5),(178,'2018-02-22 22:24:03','{\"username\":\"bernhard\"}',5),(179,'2018-02-22 22:24:03','{\"username\":\"bernhard\"}',5),(180,'2018-02-22 22:25:45','{\"username\":\"bernhard\"}',5),(181,'2018-02-22 22:25:46','{\"username\":\"bernhard\"}',5),(182,'2018-02-22 22:30:19','{\"username\":\"bernhard\"}',5),(183,'2018-02-22 22:31:00','{\"username\":\"bernhard\"}',5),(184,'2018-02-22 22:32:41','{\"username\":\"bernhard\"}',5),(185,'2018-02-22 22:32:42','{\"username\":\"bernhard\"}',5),(186,'2018-02-22 22:33:01','{\"username\":\"bernhard\"}',5),(187,'2018-02-22 22:33:02','{\"username\":\"bernhard\"}',5),(188,'2018-02-22 22:33:41','{\"username\":\"bernhard\"}',5),(189,'2018-02-22 22:33:41','{\"username\":\"bernhard\"}',5),(190,'2018-02-22 22:37:16','{\"username\":\"bernhard\"}',5),(191,'2018-02-22 22:37:16','{\"username\":\"bernhard\"}',5),(192,'2018-02-22 22:38:52','{\"username\":\"bernhard\"}',5),(193,'2018-02-22 22:38:52','{\"username\":\"bernhard\"}',5),(194,'2018-02-22 22:44:10','{\"username\":\"bernhard\"}',5),(195,'2018-02-22 22:44:10','{\"username\":\"bernhard\"}',5),(196,'2018-02-22 22:46:53','{\"username\":\"bernhard\"}',5),(197,'2018-02-22 22:47:20','{\"username\":\"bernhard\"}',5),(198,'2018-02-22 22:48:32','{\"username\":\"drmuncan\"}',5),(199,'2018-02-22 22:52:56','{\"username\":\"bernhard\"}',5),(200,'2018-02-22 22:52:56','{\"username\":\"bernhard\"}',5),(201,'2018-02-22 22:53:14','{\"username\":\"bernhard\"}',5),(202,'2018-02-22 22:53:14','{\"username\":\"bernhard\"}',5),(203,'2018-02-23 09:53:13','{\"username\":\"drmuncan\"}',5),(204,'2018-02-23 09:58:24','{\"username\":\"drmuncan\"}',5),(205,'2018-02-23 10:01:48',NULL,3),(206,'2018-02-23 10:02:06',NULL,3),(207,'2018-02-23 10:02:29',NULL,3),(208,'2018-02-23 10:02:44',NULL,3),(209,'2018-02-23 10:03:20','{\"username\":\"drmuncan\"}',5),(214,'2018-02-23 11:36:35',NULL,4),(215,'2018-02-23 11:36:35',NULL,4),(216,'2018-02-23 11:36:42',NULL,4),(217,'2018-02-23 11:36:42',NULL,4),(218,'2018-02-23 11:36:42',NULL,4),(219,'2018-02-23 11:36:42',NULL,4),(220,'2018-02-23 11:36:56',NULL,4),(221,'2018-02-23 11:36:56',NULL,4),(222,'2018-02-23 11:36:56',NULL,4),(223,'2018-02-23 11:37:14',NULL,4),(224,'2018-02-23 11:37:14',NULL,4),(225,'2018-02-23 11:37:14',NULL,4),(226,'2018-02-23 11:37:23',NULL,4),(227,'2018-02-23 11:37:26',NULL,4),(228,'2018-02-23 11:37:31',NULL,4),(229,'2018-02-23 11:37:31',NULL,4),(230,'2018-02-23 11:37:31',NULL,4),(231,'2018-02-23 11:37:43',NULL,4),(232,'2018-02-23 11:38:50',NULL,4),(233,'2018-02-23 11:38:50',NULL,4),(234,'2018-02-23 12:37:14','{\"username\":\"drmuncan\"}',5),(235,'2018-02-23 12:37:22',NULL,4),(236,'2018-02-23 12:37:22',NULL,4),(237,'2018-02-23 12:37:22',NULL,4),(238,'2018-02-23 12:38:52',NULL,2),(239,'2018-02-23 12:52:47',NULL,4),(240,'2018-02-23 12:52:47',NULL,4),(241,'2018-02-23 12:52:47',NULL,4),(242,'2018-02-23 12:54:14',NULL,4),(243,'2018-02-23 12:54:14',NULL,4),(244,'2018-02-23 12:58:36',NULL,4),(245,'2018-02-23 12:58:36',NULL,4),(246,'2018-02-23 12:58:36',NULL,4),(247,'2018-02-23 19:35:38','{\"username\":\"drmuncan\"}',5),(248,'2018-02-23 19:35:47',NULL,4),(249,'2018-02-23 19:35:47',NULL,4),(250,'2018-02-23 19:36:00',NULL,4),(251,'2018-02-23 19:36:00',NULL,4),(252,'2018-02-23 20:06:34','{\"username\":\"drmuncan\"}',5),(253,'2018-02-23 20:36:10',NULL,4),(254,'2018-02-23 20:36:10',NULL,4),(255,'2018-02-23 20:36:30',NULL,4),(256,'2018-02-23 20:36:30',NULL,4),(257,'2018-02-23 20:36:30',NULL,4),(258,'2018-02-23 20:43:54',NULL,4),(259,'2018-02-23 20:43:54',NULL,4),(260,'2018-02-23 21:21:46',NULL,4),(261,'2018-02-23 21:21:46',NULL,4),(262,'2018-02-23 21:21:52',NULL,4),(263,'2018-02-23 21:21:52',NULL,4),(264,'2018-02-23 21:21:52',NULL,4),(265,'2018-02-23 21:21:56',NULL,4),(266,'2018-02-23 21:21:56',NULL,4),(267,'2018-02-23 21:21:56',NULL,4),(268,'2018-02-23 21:21:56',NULL,4),(269,'2018-02-23 23:19:30',NULL,4),(270,'2018-02-23 23:19:30',NULL,4),(271,'2018-02-23 23:19:30',NULL,4),(272,'2018-02-23 23:19:30',NULL,4),(273,'2018-02-23 23:19:36',NULL,4),(274,'2018-02-23 23:19:36',NULL,4),(275,'2018-02-23 23:31:57',NULL,4),(276,'2018-02-23 23:31:57',NULL,4),(277,'2018-02-23 23:31:57',NULL,4),(278,'2018-02-23 23:31:57',NULL,4),(279,'2018-02-23 23:32:04',NULL,4),(280,'2018-02-23 23:32:04',NULL,4),(281,'2018-02-23 23:32:06',NULL,4),(282,'2018-02-23 23:32:08',NULL,4),(283,'2018-02-23 23:32:08',NULL,4),(284,'2018-02-23 23:32:08',NULL,4),(285,'2018-02-23 23:32:08',NULL,4),(286,'2018-02-23 23:32:10',NULL,4),(287,'2018-02-23 23:32:10',NULL,4),(288,'2018-02-23 23:32:10',NULL,4),(289,'2018-02-23 23:32:11',NULL,4),(290,'2018-02-23 23:33:57',NULL,4),(291,'2018-02-23 23:33:57',NULL,4),(292,'2018-02-23 23:33:57',NULL,4),(293,'2018-02-23 23:34:04',NULL,4),(294,'2018-02-23 23:34:04',NULL,4),(295,'2018-02-23 23:34:10',NULL,4),(296,'2018-02-23 23:34:10',NULL,4),(297,'2018-02-23 23:35:56',NULL,4),(298,'2018-02-23 23:35:56',NULL,4),(299,'2018-02-23 23:35:56',NULL,4),(300,'2018-02-23 23:35:56',NULL,4),(301,'2018-02-23 23:36:43',NULL,4),(302,'2018-02-23 23:36:43',NULL,4),(303,'2018-02-23 23:36:43',NULL,4),(304,'2018-02-23 23:36:43',NULL,4),(305,'2018-02-23 23:36:45',NULL,4),(306,'2018-02-23 23:36:45',NULL,4),(307,'2018-02-23 23:36:45',NULL,4),(308,'2018-02-23 23:36:58',NULL,4),(309,'2018-02-23 23:36:58',NULL,4),(310,'2018-02-23 23:36:58',NULL,4),(311,'2018-02-23 23:36:58',NULL,4),(312,'2018-02-23 23:37:02',NULL,4),(313,'2018-02-23 23:37:02',NULL,4),(314,'2018-02-23 23:37:02',NULL,4),(315,'2018-02-23 23:38:16',NULL,4),(316,'2018-02-23 23:38:16',NULL,4),(317,'2018-02-23 23:38:16',NULL,4),(318,'2018-02-24 07:58:21','{\"username\":\"drmuncan\"}',5),(319,'2018-02-24 07:58:25',NULL,4),(320,'2018-02-24 07:59:13',NULL,4),(321,'2018-02-24 09:20:50','{\"username\":\"drmuncan\"}',5),(322,'2018-02-24 09:24:24',NULL,4),(323,'2018-02-24 09:24:24',NULL,4),(324,'2018-02-24 09:24:24',NULL,4),(325,'2018-02-24 09:24:28',NULL,4),(326,'2018-02-24 09:24:28',NULL,4),(327,'2018-02-24 09:26:11',NULL,4),(328,'2018-02-24 09:26:11',NULL,4),(329,'2018-02-24 09:27:20',NULL,4),(330,'2018-02-24 09:48:46',NULL,4),(331,'2018-02-24 09:50:46',NULL,4),(332,'2018-02-24 16:40:48','{\"username\":\"drmuncan\"}',5),(333,'2018-02-24 16:41:02',NULL,4),(334,'2018-02-24 20:06:38','{\"username\":\"drmuncan\"}',5),(335,'2018-02-24 20:12:03','{\"username\":\"drmuncan\"}',5),(336,'2018-02-24 20:59:50','{\"username\":\"drmuncan\"}',5),(337,'2018-02-24 22:44:04','{\"username\":\"drmuncan\"}',5),(338,'2018-02-24 22:48:27','{\"username\":\"drmuncan\"}',5),(339,'2018-02-24 22:52:41',NULL,4),(340,'2018-02-24 22:53:33',NULL,4),(341,'2018-02-24 22:53:33',NULL,4),(342,'2018-02-24 22:58:25',NULL,4),(343,'2018-02-24 22:58:25',NULL,4),(344,'2018-02-24 22:58:31',NULL,4),(345,'2018-02-24 22:58:31',NULL,4),(346,'2018-02-25 10:39:13','{\"username\":\"drmuncan\"}',5),(347,'2018-02-25 10:39:45',NULL,4),(348,'2018-02-25 10:39:45',NULL,4),(349,'2018-02-25 11:01:53',NULL,4),(350,'2018-02-25 11:01:53',NULL,4),(351,'2018-02-25 11:01:54',NULL,4),(352,'2018-02-25 11:02:04',NULL,4),(353,'2018-02-25 11:02:04',NULL,4),(354,'2018-02-25 11:07:45',NULL,4),(355,'2018-02-25 12:43:46',NULL,4),(356,'2018-02-25 12:46:49',NULL,4),(357,'2018-02-25 13:03:35','{\"username\":\"drmuncan\"}',5),(358,'2018-02-25 13:07:38','{\"username\":\"drmuncan\"}',5),(359,'2018-02-25 13:10:13',NULL,1),(360,'2018-02-25 13:19:17',NULL,1),(361,'2018-02-25 13:20:08',NULL,1),(362,'2018-02-25 13:20:32',NULL,1),(363,'2018-02-25 13:21:06',NULL,1),(364,'2018-02-25 13:21:09',NULL,1),(365,'2018-02-25 13:21:12',NULL,1),(366,'2018-02-25 13:21:16',NULL,1),(367,'2018-02-25 13:35:20',NULL,2),(368,'2018-02-25 13:37:37',NULL,2),(369,'2018-02-25 13:39:01',NULL,2),(370,'2018-02-25 13:43:48',NULL,2),(371,'2018-02-25 13:46:03',NULL,2),(372,'2018-02-25 13:49:22',NULL,2),(373,'2018-02-25 13:50:14',NULL,2),(374,'2018-02-25 13:56:04',NULL,2),(375,'2018-02-25 13:56:58',NULL,2),(376,'2018-02-25 13:59:12',NULL,2),(377,'2018-02-25 14:03:31',NULL,2),(378,'2018-02-25 14:03:57',NULL,2),(379,'2018-02-25 14:04:57',NULL,2),(380,'2018-02-25 14:04:57',NULL,3),(381,'2018-02-25 14:10:03',NULL,2),(382,'2018-02-25 14:10:03',NULL,3),(383,'2018-02-25 14:13:01',NULL,2),(384,'2018-02-25 14:13:01',NULL,3),(385,'2018-02-25 14:15:08',NULL,2),(386,'2018-02-25 14:15:08',NULL,3),(387,'2018-02-25 14:23:41',NULL,2),(388,'2018-02-25 14:23:41',NULL,3),(389,'2018-02-25 14:23:45',NULL,2),(390,'2018-02-25 14:23:45',NULL,3),(391,'2018-02-25 14:23:47',NULL,2),(392,'2018-02-25 14:23:47',NULL,3),(393,'2018-02-25 14:23:49',NULL,2),(394,'2018-02-25 14:23:49',NULL,3),(395,'2018-02-25 14:30:09',NULL,4),(396,'2018-02-25 14:30:09',NULL,4),(397,'2018-02-25 14:30:12',NULL,4),(398,'2018-02-25 14:32:20',NULL,4),(399,'2018-02-25 14:32:20',NULL,4),(400,'2018-02-25 14:32:32',NULL,4),(401,'2018-02-25 14:32:32',NULL,4),(402,'2018-02-25 14:32:32',NULL,4),(403,'2018-02-25 14:32:32',NULL,4),(404,'2018-02-25 14:32:32',NULL,4),(405,'2018-02-25 14:32:32',NULL,4),(406,'2018-02-25 14:32:36',NULL,4),(407,'2018-02-25 14:32:36',NULL,4),(408,'2018-02-25 14:32:36',NULL,4),(409,'2018-02-25 14:32:36',NULL,4),(410,'2018-02-25 14:32:44',NULL,4),(411,'2018-02-25 14:32:44',NULL,4),(412,'2018-02-25 14:32:44',NULL,4),(413,'2018-02-25 14:32:44',NULL,4),(414,'2018-02-25 14:32:44',NULL,4),(415,'2018-02-25 14:32:44',NULL,4),(416,'2018-02-25 14:33:02',NULL,4),(417,'2018-02-25 14:33:02',NULL,4),(418,'2018-02-25 14:33:02',NULL,4),(419,'2018-02-25 14:33:02',NULL,4),(420,'2018-02-25 14:33:02',NULL,4),(421,'2018-02-25 14:33:06',NULL,4),(422,'2018-02-25 14:33:06',NULL,4),(423,'2018-02-25 14:33:06',NULL,4),(424,'2018-02-25 14:33:06',NULL,4),(425,'2018-02-25 14:33:06',NULL,4),(426,'2018-02-25 14:33:23',NULL,4),(427,'2018-02-25 14:38:18',NULL,2),(428,'2018-02-25 14:38:18',NULL,3),(429,'2018-02-25 14:38:45',NULL,4),(430,'2018-02-25 14:38:45',NULL,4),(431,'2018-02-25 14:38:45',NULL,4),(432,'2018-02-25 14:38:45',NULL,4),(433,'2018-02-25 14:38:45',NULL,4),(434,'2018-02-25 14:38:45',NULL,4),(435,'2018-02-25 14:38:45',NULL,4),(436,'2018-02-25 14:53:42',NULL,4),(437,'2018-02-25 14:53:42',NULL,4),(438,'2018-02-25 14:53:42',NULL,4),(439,'2018-02-25 14:53:42',NULL,4),(440,'2018-02-25 14:53:42',NULL,4),(441,'2018-02-25 14:53:42',NULL,4),(442,'2018-02-25 14:53:42',NULL,4),(443,'2018-02-25 15:07:34',NULL,2),(444,'2018-02-25 15:07:34',NULL,3),(445,'2018-02-25 15:08:23',NULL,4),(446,'2018-02-25 15:08:47',NULL,2),(447,'2018-02-25 15:15:10',NULL,2),(448,'2018-02-25 15:15:10',NULL,3),(449,'2018-02-25 15:29:56',NULL,2),(450,'2018-02-25 15:29:57',NULL,3),(451,'2018-02-25 15:37:28',NULL,2),(452,'2018-02-25 15:37:28',NULL,3),(453,'2018-02-25 15:37:43',NULL,4),(454,'2018-02-25 15:37:43',NULL,4),(455,'2018-02-25 15:37:43',NULL,4),(456,'2018-02-25 15:37:43',NULL,4),(457,'2018-02-25 15:37:43',NULL,4),(458,'2018-02-25 15:37:43',NULL,4),(459,'2018-02-25 15:37:43',NULL,4),(460,'2018-02-25 15:37:48',NULL,4),(461,'2018-02-25 15:37:48',NULL,4),(462,'2018-02-25 15:37:48',NULL,4),(463,'2018-02-25 15:37:48',NULL,4),(464,'2018-02-25 15:37:56',NULL,4),(465,'2018-02-25 15:37:56',NULL,4),(466,'2018-02-25 15:43:11',NULL,4),(467,'2018-02-25 15:44:41',NULL,4),(468,'2018-02-25 15:44:41',NULL,4),(469,'2018-02-25 15:44:41',NULL,4),(470,'2018-02-25 15:44:41',NULL,4),(471,'2018-02-25 15:44:41',NULL,4),(472,'2018-02-25 15:44:41',NULL,4),(473,'2018-02-25 15:45:01',NULL,4),(474,'2018-02-25 15:45:01',NULL,4),(475,'2018-02-25 15:45:01',NULL,4),(476,'2018-02-25 15:45:01',NULL,4),(477,'2018-02-25 15:45:01',NULL,4),(478,'2018-02-25 15:45:35',NULL,4),(479,'2018-02-25 15:45:35',NULL,4),(480,'2018-02-25 15:45:35',NULL,4),(481,'2018-02-25 15:45:35',NULL,4),(482,'2018-02-25 15:45:35',NULL,4),(483,'2018-02-25 15:46:05',NULL,4),(484,'2018-02-25 15:46:05',NULL,4),(485,'2018-02-25 15:46:05',NULL,4),(486,'2018-02-25 15:46:05',NULL,4),(487,'2018-02-25 15:46:07',NULL,4),(488,'2018-02-25 15:46:28',NULL,4),(489,'2018-02-25 15:46:28',NULL,4),(490,'2018-02-25 15:46:28',NULL,4),(491,'2018-02-25 15:46:28',NULL,4),(492,'2018-02-25 15:46:28',NULL,4),(493,'2018-02-25 15:46:55',NULL,4),(494,'2018-02-25 15:46:55',NULL,4),(495,'2018-02-25 15:46:55',NULL,4),(496,'2018-02-25 15:47:16',NULL,4),(497,'2018-02-25 15:48:01',NULL,2),(498,'2018-02-25 15:48:01',NULL,3),(499,'2018-02-25 15:50:42',NULL,4),(500,'2018-02-25 15:50:42',NULL,4),(501,'2018-02-25 15:50:42',NULL,4),(502,'2018-02-25 15:50:42',NULL,4),(503,'2018-02-25 15:50:42',NULL,4),(504,'2018-02-25 15:51:05',NULL,4),(505,'2018-02-25 15:51:09',NULL,4),(506,'2018-02-25 15:51:09',NULL,4),(507,'2018-02-25 15:51:09',NULL,4),(508,'2018-02-25 15:51:09',NULL,4),(509,'2018-02-25 15:51:22',NULL,4),(510,'2018-02-25 15:51:22',NULL,4),(511,'2018-02-25 15:51:22',NULL,4),(512,'2018-02-25 15:51:22',NULL,4),(513,'2018-02-25 15:51:28',NULL,4),(514,'2018-02-25 15:51:28',NULL,4),(515,'2018-02-25 15:51:34',NULL,4),(516,'2018-02-25 15:51:34',NULL,4),(517,'2018-02-25 15:51:57',NULL,4),(518,'2018-02-25 15:52:02',NULL,4),(519,'2018-02-25 15:52:02',NULL,4),(520,'2018-02-25 15:52:02',NULL,4),(521,'2018-02-25 15:52:12',NULL,4),(522,'2018-02-25 15:52:15',NULL,4),(523,'2018-02-25 15:52:15',NULL,4),(524,'2018-02-25 15:52:33',NULL,4),(525,'2018-02-25 15:52:37',NULL,4),(526,'2018-02-25 15:52:48',NULL,4),(527,'2018-02-25 15:53:38',NULL,2),(528,'2018-02-25 15:53:39',NULL,3),(529,'2018-02-25 15:53:57',NULL,4),(530,'2018-02-25 16:29:14','{\"username\":\"drmuncan\"}',5),(531,'2018-02-25 16:29:33',NULL,2),(532,'2018-02-25 16:29:34',NULL,3),(533,'2018-02-25 16:31:09','{\"username\":\"drmuncan\"}',5),(534,'2018-02-25 16:32:25',NULL,4),(535,'2018-02-25 16:33:50',NULL,2),(536,'2018-02-25 16:33:50',NULL,3),(537,'2018-02-25 16:34:01',NULL,2),(538,'2018-02-25 16:34:01',NULL,3),(539,'2018-02-25 16:34:28',NULL,4),(540,'2018-02-25 16:34:30',NULL,4),(541,'2018-02-25 16:34:32',NULL,4),(542,'2018-02-25 16:34:34',NULL,4),(543,'2018-02-25 16:37:24',NULL,2),(544,'2018-02-25 16:37:24',NULL,3),(545,'2018-02-25 16:37:53',NULL,4),(546,'2018-02-25 16:37:54',NULL,4),(547,'2018-02-25 16:38:00',NULL,4),(548,'2018-02-25 16:38:15',NULL,2),(549,'2018-02-25 16:38:15',NULL,3),(550,'2018-02-25 16:38:33',NULL,2),(551,'2018-02-25 16:38:33',NULL,3),(552,'2018-02-25 16:38:53',NULL,4),(553,'2018-02-25 16:38:53',NULL,4),(554,'2018-02-25 16:39:49',NULL,4),(555,'2018-02-25 16:39:49',NULL,4),(556,'2018-02-25 16:39:54',NULL,4),(557,'2018-02-25 16:39:56',NULL,4),(558,'2018-02-25 16:40:19',NULL,4),(559,'2018-02-25 16:40:45',NULL,2),(560,'2018-02-25 16:40:45',NULL,3),(561,'2018-02-25 16:41:32',NULL,4),(562,'2018-02-25 16:46:39','{\"username\":\"drmuncan\"}',5),(563,'2018-02-25 16:46:50',NULL,2),(564,'2018-02-25 16:46:51',NULL,3),(565,'2018-02-25 16:47:12',NULL,2),(566,'2018-02-25 16:47:12',NULL,3),(567,'2018-02-25 16:47:31',NULL,2),(568,'2018-02-25 16:47:31',NULL,3),(569,'2018-02-25 16:47:42',NULL,4),(570,'2018-02-25 16:47:42',NULL,4),(571,'2018-02-25 16:47:42',NULL,4),(572,'2018-02-25 16:48:10',NULL,4),(573,'2018-02-25 16:48:17',NULL,4),(574,'2018-02-25 16:49:00',NULL,4),(575,'2018-02-25 16:49:00',NULL,4),(576,'2018-02-25 16:49:08',NULL,2),(577,'2018-02-25 16:49:08',NULL,3),(578,'2018-02-25 16:49:17',NULL,4),(579,'2018-02-25 16:49:17',NULL,4),(580,'2018-02-25 16:49:17',NULL,4),(581,'2018-02-25 16:49:47',NULL,4),(582,'2018-02-25 16:49:50',NULL,4),(583,'2018-02-25 16:49:50',NULL,4),(584,'2018-02-25 16:49:58',NULL,4),(585,'2018-02-25 16:49:58',NULL,4),(586,'2018-02-25 16:50:02',NULL,4),(587,'2018-02-25 16:50:04',NULL,4),(588,'2018-02-25 16:50:12',NULL,4),(589,'2018-02-25 16:55:40',NULL,2),(590,'2018-02-25 16:55:40',NULL,3),(591,'2018-02-25 16:55:57',NULL,4),(592,'2018-02-25 16:56:13',NULL,2),(593,'2018-02-25 16:56:13',NULL,3),(594,'2018-02-25 16:56:46',NULL,4),(595,'2018-02-25 16:57:13',NULL,2),(596,'2018-02-25 16:57:13',NULL,3),(597,'2018-02-25 16:57:32',NULL,4),(598,'2018-02-25 16:57:46',NULL,2),(599,'2018-02-25 16:57:46',NULL,3),(600,'2018-02-25 16:57:55',NULL,4),(601,'2018-02-25 16:58:05',NULL,4),(602,'2018-02-25 17:37:02','{\"username\":\"drmuncan\"}',5),(603,'2018-02-25 18:05:47','{\"username\":\"bernhard\"}',5),(604,'2018-02-25 18:05:48','{\"username\":\"bernhard\"}',5),(605,'2018-02-25 18:12:15','{\"username\":\"drmuncan\"}',5),(606,'2018-02-25 18:13:52','{\"username\":\"bernhard\"}',5),(607,'2018-02-25 18:13:52','{\"username\":\"bernhard\"}',5),(608,'2018-02-25 18:15:13','{\"username\":\"bernhard\"}',5),(609,'2018-02-25 18:15:13','{\"username\":\"bernhard\"}',5),(610,'2018-02-25 18:15:59','{\"username\":\"drmuncan\"}',5),(611,'2018-02-25 18:17:55','{\"username\":\"leonardo\"}',5),(612,'2018-02-25 18:22:52','{\"username\":\"bernhard\"}',5),(613,'2018-02-25 18:22:53','{\"username\":\"bernhard\"}',5),(614,'2018-02-25 18:23:47','{\"username\":\"bernhard\"}',5),(615,'2018-02-25 18:33:35','{\"username\":\"bernhard\"}',5),(616,'2018-02-25 18:33:36','{\"username\":\"bernhard\"}',5),(617,'2018-02-25 18:43:19','{\"username\":\"bernhard\"}',5),(618,'2018-02-25 18:43:19','{\"username\":\"bernhard\"}',5),(619,'2018-02-26 19:15:56','{\"username\":\"bernhard\"}',5),(620,'2018-02-26 19:15:57','{\"username\":\"bernhard\"}',5),(621,'2018-02-26 19:20:14','{\"username\":\"bernhard\"}',5),(622,'2018-02-26 19:20:15','{\"username\":\"bernhard\"}',5),(623,'2018-02-26 19:24:06','{\"username\":\"bernhard\"}',5),(624,'2018-02-26 19:24:07','{\"username\":\"bernhard\"}',5),(625,'2018-02-26 19:24:26','{\"username\":\"bernhard\"}',5),(626,'2018-02-26 19:25:37','{\"username\":\"bernhard\"}',5),(627,'2018-02-26 19:25:38','{\"username\":\"bernhard\"}',5),(628,'2018-02-26 19:27:21','{\"username\":\"drmuncan\"}',5),(629,'2018-02-26 19:28:51','{\"username\":\"bernhard\"}',5),(630,'2018-02-26 19:28:52','{\"username\":\"bernhard\"}',5),(631,'2018-02-26 19:31:36','{\"username\":\"bernhard\"}',5),(632,'2018-02-26 19:31:37','{\"username\":\"bernhard\"}',5),(633,'2018-02-26 19:34:53','{\"username\":\"drmuncan\"}',5),(634,'2018-02-26 20:10:20','{\"username\":\"bernhard\"}',5),(635,'2018-02-26 20:10:21','{\"username\":\"bernhard\"}',5),(636,'2018-02-26 20:14:25','{\"username\":\"bernhard\"}',5),(637,'2018-02-26 20:14:26','{\"username\":\"bernhard\"}',5),(638,'2018-02-26 20:22:37','{\"username\":\"bernhard\"}',5),(639,'2018-02-26 20:22:37','{\"username\":\"bernhard\"}',5),(640,'2018-02-26 20:32:39','{\"username\":\"bernhard\"}',5),(641,'2018-02-26 20:32:39','{\"username\":\"bernhard\"}',5),(642,'2018-02-26 20:40:22','{\"username\":\"bernhard\"}',5),(643,'2018-02-26 20:40:23','{\"username\":\"bernhard\"}',5),(644,'2018-02-26 20:51:33','{\"username\":\"bernhard\"}',5),(645,'2018-02-26 20:51:34','{\"username\":\"bernhard\"}',5),(646,'2018-02-26 20:52:33','{\"username\":\"bernhard\"}',5),(647,'2018-02-26 20:52:34','{\"username\":\"bernhard\"}',5),(648,'2018-02-26 20:55:34','{\"username\":\"bernhard\"}',5),(649,'2018-02-26 20:55:34','{\"username\":\"bernhard\"}',5),(650,'2018-02-26 20:59:36','{\"username\":\"bernhard\"}',5),(651,'2018-02-26 20:59:36','{\"username\":\"bernhard\"}',5),(652,'2018-02-26 21:00:56','{\"username\":\"bernhard\"}',5),(653,'2018-02-26 21:00:56','{\"username\":\"bernhard\"}',5),(654,'2018-02-26 21:03:10','{\"username\":\"bernhard\"}',5),(655,'2018-02-26 21:03:10','{\"username\":\"bernhard\"}',5),(656,'2018-02-26 21:05:41','{\"username\":\"bernhard\"}',5),(657,'2018-02-26 21:05:41','{\"username\":\"bernhard\"}',5),(658,'2018-02-26 21:09:32','{\"username\":\"bernhard\"}',5),(659,'2018-02-26 21:09:32','{\"username\":\"bernhard\"}',5),(660,'2018-02-26 21:10:37','{\"username\":\"bernhard\"}',5),(661,'2018-02-26 21:10:38','{\"username\":\"bernhard\"}',5),(662,'2018-02-26 21:13:07','{\"username\":\"bernhard\"}',5),(663,'2018-02-26 21:13:07','{\"username\":\"bernhard\"}',5),(664,'2018-02-26 21:20:37','{\"username\":\"bernhard\"}',5),(665,'2018-02-26 21:20:38','{\"username\":\"bernhard\"}',5),(666,'2018-02-26 21:34:53','{\"username\":\"bernhard\"}',5),(667,'2018-02-26 21:34:54','{\"username\":\"bernhard\"}',5),(668,'2018-02-26 21:36:45','{\"username\":\"bernhard\"}',5),(669,'2018-02-26 21:36:45','{\"username\":\"bernhard\"}',5),(670,'2018-02-26 21:43:11','{\"username\":\"bernhard\"}',5),(671,'2018-02-26 21:43:11','{\"username\":\"bernhard\"}',5),(672,'2018-02-26 21:45:39','{\"username\":\"bernhard\"}',5),(673,'2018-02-26 21:45:39','{\"username\":\"bernhard\"}',5),(674,'2018-02-26 21:49:11','{\"username\":\"bernhard\"}',5),(675,'2018-02-26 21:49:11','{\"username\":\"bernhard\"}',5),(676,'2018-02-26 22:04:13','{\"username\":\"bernhard\"}',5),(677,'2018-02-26 22:04:13','{\"username\":\"bernhard\"}',5),(678,'2018-02-26 22:06:34','{\"username\":\"bernhard\"}',5),(679,'2018-02-26 22:06:34','{\"username\":\"bernhard\"}',5),(680,'2018-02-26 22:08:06','{\"username\":\"bernhard\"}',5),(681,'2018-02-26 22:08:07','{\"username\":\"bernhard\"}',5);
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
INSERT INTO `ver_versicherungen` VALUES ('05',6529837019,0),('07',6523980167,1),('11',1003250229,0),('11',2469180576,1),('11',3048280984,1),('11',6032060899,0),('11',7078280984,1),('12',1234567890,1),('17',663782916,0),('19',7724091276,1),('25',663782916,0),('25',3048280984,0),('28',6032060899,1),('28',6523980167,0),('40',3048280984,0),('40',6529837019,1),('50',6523980167,0),('7A',663782916,1),('8B',7724091276,0),('8D',987654328,1),('8D',4294280984,1),('8D',6032060899,0);
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-26 22:10:14
