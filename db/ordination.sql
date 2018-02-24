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
  `l_daten` varchar(1000) DEFAULT NULL,
  `l_la_art` int(11) NOT NULL,
  PRIMARY KEY (`l_id`),
  KEY `fk_l_log_la_logArt_idx` (`l_la_art`),
  CONSTRAINT `fk_l_log_la_logArt` FOREIGN KEY (`l_la_art`) REFERENCES `la_logart` (`la_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=346 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `l_log`
--

LOCK TABLES `l_log` WRITE;
/*!40000 ALTER TABLE `l_log` DISABLE KEYS */;
INSERT INTO `l_log` VALUES (10,'2018-02-20 19:50:18','{\"username\":\"drmuncan\"}',5),(11,'2018-02-20 21:37:01','{\"username\":\"bernhard\"}',5),(12,'2018-02-20 21:37:02','{\"username\":\"bernhard\"}',5),(13,'2018-02-20 21:38:08','{\"username\":\"bernhard\"}',5),(14,'2018-02-20 21:38:08','{\"username\":\"bernhard\"}',5),(15,'2018-02-20 21:39:25','{\"username\":\"bernhard\"}',5),(16,'2018-02-20 21:39:26','{\"username\":\"bernhard\"}',5),(17,'2018-02-20 21:43:26','{\"username\":\"bernhard\"}',5),(18,'2018-02-20 21:43:27','{\"username\":\"bernhard\"}',5),(19,'2018-02-20 21:44:46','{\"username\":\"bernhard\"}',5),(20,'2018-02-20 21:44:47','{\"username\":\"bernhard\"}',5),(21,'2018-02-20 21:46:17','{\"username\":\"bernhard\"}',5),(22,'2018-02-20 21:46:17','{\"username\":\"bernhard\"}',5),(23,'2018-02-20 21:48:36','{\"username\":\"bernhard\"}',5),(24,'2018-02-20 21:48:36','{\"username\":\"bernhard\"}',5),(25,'2018-02-20 21:51:50','{\"username\":\"bernhard\"}',5),(26,'2018-02-20 21:51:50','{\"username\":\"bernhard\"}',5),(27,'2018-02-20 21:56:31','{\"username\":\"bernhard\"}',5),(28,'2018-02-20 21:56:32','{\"username\":\"bernhard\"}',5),(29,'2018-02-20 21:58:23','{\"username\":\"bernhard\"}',5),(30,'2018-02-20 21:58:24','{\"username\":\"bernhard\"}',5),(31,'2018-02-20 22:01:32','{\"username\":\"bernhard\"}',5),(32,'2018-02-20 22:01:32','{\"username\":\"bernhard\"}',5),(33,'2018-02-20 22:04:33','{\"username\":\"bernhard\"}',5),(34,'2018-02-20 22:04:34','{\"username\":\"bernhard\"}',5),(35,'2018-02-20 22:08:19','{\"username\":\"bernhard\"}',5),(36,'2018-02-20 22:08:19','{\"username\":\"bernhard\"}',5),(37,'2018-02-20 22:10:04','{\"username\":\"bernhard\"}',5),(38,'2018-02-20 22:10:05','{\"username\":\"bernhard\"}',5),(40,'2018-02-20 22:48:00',NULL,2),(41,'2018-02-20 22:51:20',NULL,2),(42,'2018-02-21 09:32:57','{\"username\":\"bernhard\"}',5),(43,'2018-02-21 09:32:57','{\"username\":\"bernhard\"}',5),(44,'2018-02-21 09:33:26','{\"username\":\"bernhard\"}',5),(45,'2018-02-21 09:33:26','{\"username\":\"bernhard\"}',5),(46,'2018-02-21 09:33:39','{\"username\":\"drmuncan\"}',5),(47,'2018-02-21 09:38:38','{\"username\":\"bernhard\"}',5),(48,'2018-02-21 09:38:38','{\"username\":\"bernhard\"}',5),(49,'2018-02-21 09:39:41','{\"username\":\"bernhard\"}',5),(50,'2018-02-21 09:39:41','{\"username\":\"bernhard\"}',5),(51,'2018-02-21 09:41:57','{\"username\":\"bernhard\"}',5),(52,'2018-02-21 09:41:57','{\"username\":\"bernhard\"}',5),(53,'2018-02-21 09:44:08','{\"username\":\"bernhard\"}',5),(54,'2018-02-21 09:44:09','{\"username\":\"bernhard\"}',5),(55,'2018-02-21 09:45:52','{\"username\":\"bernhard\"}',5),(56,'2018-02-21 09:45:52','{\"username\":\"bernhard\"}',5),(57,'2018-02-21 09:49:03','{\"username\":\"bernhard\"}',5),(58,'2018-02-21 09:49:04','{\"username\":\"bernhard\"}',5),(59,'2018-02-21 09:50:00','{\"username\":\"bernhard\"}',5),(60,'2018-02-21 09:50:00','{\"username\":\"bernhard\"}',5),(61,'2018-02-21 09:57:22','{\"username\":\"bernhard\"}',5),(62,'2018-02-21 09:57:23','{\"username\":\"bernhard\"}',5),(63,'2018-02-21 09:58:08','{\"username\":\"bernhard\"}',5),(64,'2018-02-21 09:58:08','{\"username\":\"bernhard\"}',5),(65,'2018-02-21 09:59:58','{\"username\":\"bernhard\"}',5),(66,'2018-02-21 09:59:58','{\"username\":\"bernhard\"}',5),(67,'2018-02-21 10:02:59','{\"username\":\"bernhard\"}',5),(68,'2018-02-21 10:02:59','{\"username\":\"bernhard\"}',5),(69,'2018-02-21 10:04:54','{\"username\":\"bernhard\"}',5),(70,'2018-02-21 10:04:54','{\"username\":\"bernhard\"}',5),(71,'2018-02-21 10:09:18','{\"username\":\"bernhard\"}',5),(72,'2018-02-21 10:09:18','{\"username\":\"bernhard\"}',5),(73,'2018-02-21 10:12:53','{\"username\":\"bernhard\"}',5),(74,'2018-02-21 10:12:54','{\"username\":\"bernhard\"}',5),(75,'2018-02-21 10:14:26','{\"username\":\"bernhard\"}',5),(76,'2018-02-21 10:14:27','{\"username\":\"bernhard\"}',5),(77,'2018-02-21 19:53:58','{\"username\":\"drmuncan\"}',5),(78,'2018-02-21 20:24:21','{\"username\":\"bernhard\"}',5),(79,'2018-02-21 20:24:21','{\"username\":\"bernhard\"}',5),(80,'2018-02-21 20:26:31','{\"username\":\"bernhard\"}',5),(81,'2018-02-21 20:26:31','{\"username\":\"bernhard\"}',5),(82,'2018-02-21 20:27:05','{\"username\":\"bernhard\"}',5),(83,'2018-02-21 20:27:05','{\"username\":\"bernhard\"}',5),(84,'2018-02-21 20:53:54','{\"username\":\"bernhard\"}',5),(85,'2018-02-21 20:53:55','{\"username\":\"bernhard\"}',5),(86,'2018-02-21 20:55:21','{\"username\":\"bernhard\"}',5),(87,'2018-02-21 20:55:22','{\"username\":\"bernhard\"}',5),(92,'2018-02-21 22:22:07',NULL,1),(93,'2018-02-22 09:34:50','{\"username\":\"bernhard\"}',5),(94,'2018-02-22 09:34:51','{\"username\":\"bernhard\"}',5),(95,'2018-02-22 09:35:15','{\"username\":\"drmuncan\"}',5),(96,'2018-02-22 09:37:04','{\"username\":\"bernhard\"}',5),(97,'2018-02-22 09:37:05','{\"username\":\"bernhard\"}',5),(98,'2018-02-22 09:42:00','{\"username\":\"bernhard\"}',5),(99,'2018-02-22 09:42:01','{\"username\":\"bernhard\"}',5),(100,'2018-02-22 10:24:42','{\"username\":\"bernhard\"}',5),(101,'2018-02-22 10:24:42','{\"username\":\"bernhard\"}',5),(102,'2018-02-22 10:24:42','{\"username\":\"bernhard\"}',5),(103,'2018-02-22 10:24:43','{\"username\":\"bernhard\"}',5),(104,'2018-02-22 10:25:27','{\"username\":\"bernhard\"}',5),(105,'2018-02-22 10:25:27','{\"username\":\"bernhard\"}',5),(106,'2018-02-22 10:31:37','{\"username\":\"raphael\"}',5),(107,'2018-02-22 10:32:21','{\"username\":\"bernhard\"}',5),(108,'2018-02-22 10:32:21','{\"username\":\"bernhard\"}',5),(109,'2018-02-22 10:32:28','{\"username\":\"bernhard\"}',5),(110,'2018-02-22 10:32:28','{\"username\":\"bernhard\"}',5),(111,'2018-02-22 10:32:35','{\"username\":\"bernhard\"}',5),(112,'2018-02-22 10:32:35','{\"username\":\"bernhard\"}',5),(113,'2018-02-22 16:49:08','{\"username\":\"bernhard\"}',5),(114,'2018-02-22 16:49:09','{\"username\":\"bernhard\"}',5),(115,'2018-02-22 16:49:29','{\"username\":\"drmuncan\"}',5),(116,'2018-02-22 16:50:57','{\"username\":\"bernhard\"}',5),(117,'2018-02-22 16:50:57','{\"username\":\"bernhard\"}',5),(118,'2018-02-22 16:55:52','{\"username\":\"bernhard\"}',5),(119,'2018-02-22 16:55:53','{\"username\":\"bernhard\"}',5),(120,'2018-02-22 17:06:42','{\"username\":\"bernhard\"}',5),(121,'2018-02-22 17:06:43','{\"username\":\"bernhard\"}',5),(122,'2018-02-22 17:10:46','{\"username\":\"bernhard\"}',5),(123,'2018-02-22 17:10:47','{\"username\":\"bernhard\"}',5),(124,'2018-02-22 17:12:35','{\"username\":\"bernhard\"}',5),(125,'2018-02-22 17:12:36','{\"username\":\"bernhard\"}',5),(126,'2018-02-22 17:14:21','{\"username\":\"bernhard\"}',5),(127,'2018-02-22 17:14:22','{\"username\":\"bernhard\"}',5),(128,'2018-02-22 17:16:19','{\"username\":\"bernhard\"}',5),(129,'2018-02-22 17:16:19','{\"username\":\"bernhard\"}',5),(130,'2018-02-22 17:22:41','{\"username\":\"bernhard\"}',5),(131,'2018-02-22 17:22:42','{\"username\":\"bernhard\"}',5),(132,'2018-02-22 17:29:51','{\"username\":\"bernhard\"}',5),(133,'2018-02-22 17:29:52','{\"username\":\"bernhard\"}',5),(134,'2018-02-22 17:31:23','{\"username\":\"bernhard\"}',5),(135,'2018-02-22 17:31:23','{\"username\":\"bernhard\"}',5),(136,'2018-02-22 17:33:54','{\"username\":\"bernhard\"}',5),(137,'2018-02-22 17:33:54','{\"username\":\"bernhard\"}',5),(138,'2018-02-22 17:35:53','{\"username\":\"bernhard\"}',5),(139,'2018-02-22 17:35:54','{\"username\":\"bernhard\"}',5),(140,'2018-02-22 17:38:59','{\"username\":\"bernhard\"}',5),(141,'2018-02-22 17:38:59','{\"username\":\"bernhard\"}',5),(142,'2018-02-22 17:39:50','{\"username\":\"bernhard\"}',5),(143,'2018-02-22 17:39:51','{\"username\":\"bernhard\"}',5),(144,'2018-02-22 17:41:17','{\"username\":\"bernhard\"}',5),(145,'2018-02-22 17:41:18','{\"username\":\"bernhard\"}',5),(146,'2018-02-22 17:43:29','{\"username\":\"bernhard\"}',5),(147,'2018-02-22 17:43:30','{\"username\":\"bernhard\"}',5),(148,'2018-02-22 17:47:45','{\"username\":\"bernhard\"}',5),(149,'2018-02-22 17:47:46','{\"username\":\"bernhard\"}',5),(150,'2018-02-22 17:50:11','{\"username\":\"bernhard\"}',5),(151,'2018-02-22 17:50:12','{\"username\":\"bernhard\"}',5),(152,'2018-02-22 17:57:05','{\"username\":\"bernhard\"}',5),(153,'2018-02-22 21:21:47','{\"username\":\"bernhard\"}',5),(154,'2018-02-22 21:21:47','{\"username\":\"bernhard\"}',5),(155,'2018-02-22 21:29:24',NULL,3),(156,'2018-02-22 21:40:12',NULL,3),(157,'2018-02-22 21:44:17',NULL,3),(158,'2018-02-22 21:49:11',NULL,3),(159,'2018-02-22 22:02:01',NULL,4),(160,'2018-02-22 22:17:16','{\"username\":\"bernhard\"}',5),(161,'2018-02-22 22:17:17','{\"username\":\"bernhard\"}',5),(162,'2018-02-22 22:17:27','{\"username\":\"bernhard\"}',5),(163,'2018-02-22 22:19:03','{\"username\":\"bernhard\"}',5),(164,'2018-02-22 22:19:04','{\"username\":\"bernhard\"}',5),(165,'2018-02-22 22:19:15','{\"username\":\"bernhard\"}',5),(166,'2018-02-22 22:19:49','{\"username\":\"bernhard\"}',5),(167,'2018-02-22 22:19:49','{\"username\":\"bernhard\"}',5),(168,'2018-02-22 22:19:56','{\"username\":\"bernhard\"}',5),(169,'2018-02-22 22:21:15','{\"username\":\"bernhard\"}',5),(170,'2018-02-22 22:21:16','{\"username\":\"bernhard\"}',5),(171,'2018-02-22 22:21:23','{\"username\":\"bernhard\"}',5),(172,'2018-02-22 22:21:26','{\"username\":\"bernhard\"}',5),(173,'2018-02-22 22:21:27','{\"username\":\"bernhard\"}',5),(174,'2018-02-22 22:21:36','{\"username\":\"bernhard\"}',5),(175,'2018-02-22 22:22:41','{\"username\":\"bernhard\"}',5),(176,'2018-02-22 22:22:41','{\"username\":\"bernhard\"}',5),(177,'2018-02-22 22:22:49','{\"username\":\"bernhard\"}',5),(178,'2018-02-22 22:24:03','{\"username\":\"bernhard\"}',5),(179,'2018-02-22 22:24:03','{\"username\":\"bernhard\"}',5),(180,'2018-02-22 22:25:45','{\"username\":\"bernhard\"}',5),(181,'2018-02-22 22:25:46','{\"username\":\"bernhard\"}',5),(182,'2018-02-22 22:30:19','{\"username\":\"bernhard\"}',5),(183,'2018-02-22 22:31:00','{\"username\":\"bernhard\"}',5),(184,'2018-02-22 22:32:41','{\"username\":\"bernhard\"}',5),(185,'2018-02-22 22:32:42','{\"username\":\"bernhard\"}',5),(186,'2018-02-22 22:33:01','{\"username\":\"bernhard\"}',5),(187,'2018-02-22 22:33:02','{\"username\":\"bernhard\"}',5),(188,'2018-02-22 22:33:41','{\"username\":\"bernhard\"}',5),(189,'2018-02-22 22:33:41','{\"username\":\"bernhard\"}',5),(190,'2018-02-22 22:37:16','{\"username\":\"bernhard\"}',5),(191,'2018-02-22 22:37:16','{\"username\":\"bernhard\"}',5),(192,'2018-02-22 22:38:52','{\"username\":\"bernhard\"}',5),(193,'2018-02-22 22:38:52','{\"username\":\"bernhard\"}',5),(194,'2018-02-22 22:44:10','{\"username\":\"bernhard\"}',5),(195,'2018-02-22 22:44:10','{\"username\":\"bernhard\"}',5),(196,'2018-02-22 22:46:53','{\"username\":\"bernhard\"}',5),(197,'2018-02-22 22:47:20','{\"username\":\"bernhard\"}',5),(198,'2018-02-22 22:48:32','{\"username\":\"drmuncan\"}',5),(199,'2018-02-22 22:52:56','{\"username\":\"bernhard\"}',5),(200,'2018-02-22 22:52:56','{\"username\":\"bernhard\"}',5),(201,'2018-02-22 22:53:14','{\"username\":\"bernhard\"}',5),(202,'2018-02-22 22:53:14','{\"username\":\"bernhard\"}',5),(203,'2018-02-23 09:53:13','{\"username\":\"drmuncan\"}',5),(204,'2018-02-23 09:58:24','{\"username\":\"drmuncan\"}',5),(205,'2018-02-23 10:01:48',NULL,3),(206,'2018-02-23 10:02:06',NULL,3),(207,'2018-02-23 10:02:29',NULL,3),(208,'2018-02-23 10:02:44',NULL,3),(209,'2018-02-23 10:03:20','{\"username\":\"drmuncan\"}',5),(214,'2018-02-23 11:36:35',NULL,4),(215,'2018-02-23 11:36:35',NULL,4),(216,'2018-02-23 11:36:42',NULL,4),(217,'2018-02-23 11:36:42',NULL,4),(218,'2018-02-23 11:36:42',NULL,4),(219,'2018-02-23 11:36:42',NULL,4),(220,'2018-02-23 11:36:56',NULL,4),(221,'2018-02-23 11:36:56',NULL,4),(222,'2018-02-23 11:36:56',NULL,4),(223,'2018-02-23 11:37:14',NULL,4),(224,'2018-02-23 11:37:14',NULL,4),(225,'2018-02-23 11:37:14',NULL,4),(226,'2018-02-23 11:37:23',NULL,4),(227,'2018-02-23 11:37:26',NULL,4),(228,'2018-02-23 11:37:31',NULL,4),(229,'2018-02-23 11:37:31',NULL,4),(230,'2018-02-23 11:37:31',NULL,4),(231,'2018-02-23 11:37:43',NULL,4),(232,'2018-02-23 11:38:50',NULL,4),(233,'2018-02-23 11:38:50',NULL,4),(234,'2018-02-23 12:37:14','{\"username\":\"drmuncan\"}',5),(235,'2018-02-23 12:37:22',NULL,4),(236,'2018-02-23 12:37:22',NULL,4),(237,'2018-02-23 12:37:22',NULL,4),(238,'2018-02-23 12:38:52',NULL,2),(239,'2018-02-23 12:52:47',NULL,4),(240,'2018-02-23 12:52:47',NULL,4),(241,'2018-02-23 12:52:47',NULL,4),(242,'2018-02-23 12:54:14',NULL,4),(243,'2018-02-23 12:54:14',NULL,4),(244,'2018-02-23 12:58:36',NULL,4),(245,'2018-02-23 12:58:36',NULL,4),(246,'2018-02-23 12:58:36',NULL,4),(247,'2018-02-23 19:35:38','{\"username\":\"drmuncan\"}',5),(248,'2018-02-23 19:35:47',NULL,4),(249,'2018-02-23 19:35:47',NULL,4),(250,'2018-02-23 19:36:00',NULL,4),(251,'2018-02-23 19:36:00',NULL,4),(252,'2018-02-23 20:06:34','{\"username\":\"drmuncan\"}',5),(253,'2018-02-23 20:36:10',NULL,4),(254,'2018-02-23 20:36:10',NULL,4),(255,'2018-02-23 20:36:30',NULL,4),(256,'2018-02-23 20:36:30',NULL,4),(257,'2018-02-23 20:36:30',NULL,4),(258,'2018-02-23 20:43:54',NULL,4),(259,'2018-02-23 20:43:54',NULL,4),(260,'2018-02-23 21:21:46',NULL,4),(261,'2018-02-23 21:21:46',NULL,4),(262,'2018-02-23 21:21:52',NULL,4),(263,'2018-02-23 21:21:52',NULL,4),(264,'2018-02-23 21:21:52',NULL,4),(265,'2018-02-23 21:21:56',NULL,4),(266,'2018-02-23 21:21:56',NULL,4),(267,'2018-02-23 21:21:56',NULL,4),(268,'2018-02-23 21:21:56',NULL,4),(269,'2018-02-23 23:19:30',NULL,4),(270,'2018-02-23 23:19:30',NULL,4),(271,'2018-02-23 23:19:30',NULL,4),(272,'2018-02-23 23:19:30',NULL,4),(273,'2018-02-23 23:19:36',NULL,4),(274,'2018-02-23 23:19:36',NULL,4),(275,'2018-02-23 23:31:57',NULL,4),(276,'2018-02-23 23:31:57',NULL,4),(277,'2018-02-23 23:31:57',NULL,4),(278,'2018-02-23 23:31:57',NULL,4),(279,'2018-02-23 23:32:04',NULL,4),(280,'2018-02-23 23:32:04',NULL,4),(281,'2018-02-23 23:32:06',NULL,4),(282,'2018-02-23 23:32:08',NULL,4),(283,'2018-02-23 23:32:08',NULL,4),(284,'2018-02-23 23:32:08',NULL,4),(285,'2018-02-23 23:32:08',NULL,4),(286,'2018-02-23 23:32:10',NULL,4),(287,'2018-02-23 23:32:10',NULL,4),(288,'2018-02-23 23:32:10',NULL,4),(289,'2018-02-23 23:32:11',NULL,4),(290,'2018-02-23 23:33:57',NULL,4),(291,'2018-02-23 23:33:57',NULL,4),(292,'2018-02-23 23:33:57',NULL,4),(293,'2018-02-23 23:34:04',NULL,4),(294,'2018-02-23 23:34:04',NULL,4),(295,'2018-02-23 23:34:10',NULL,4),(296,'2018-02-23 23:34:10',NULL,4),(297,'2018-02-23 23:35:56',NULL,4),(298,'2018-02-23 23:35:56',NULL,4),(299,'2018-02-23 23:35:56',NULL,4),(300,'2018-02-23 23:35:56',NULL,4),(301,'2018-02-23 23:36:43',NULL,4),(302,'2018-02-23 23:36:43',NULL,4),(303,'2018-02-23 23:36:43',NULL,4),(304,'2018-02-23 23:36:43',NULL,4),(305,'2018-02-23 23:36:45',NULL,4),(306,'2018-02-23 23:36:45',NULL,4),(307,'2018-02-23 23:36:45',NULL,4),(308,'2018-02-23 23:36:58',NULL,4),(309,'2018-02-23 23:36:58',NULL,4),(310,'2018-02-23 23:36:58',NULL,4),(311,'2018-02-23 23:36:58',NULL,4),(312,'2018-02-23 23:37:02',NULL,4),(313,'2018-02-23 23:37:02',NULL,4),(314,'2018-02-23 23:37:02',NULL,4),(315,'2018-02-23 23:38:16',NULL,4),(316,'2018-02-23 23:38:16',NULL,4),(317,'2018-02-23 23:38:16',NULL,4),(318,'2018-02-24 07:58:21','{\"username\":\"drmuncan\"}',5),(319,'2018-02-24 07:58:25',NULL,4),(320,'2018-02-24 07:59:13',NULL,4),(321,'2018-02-24 09:20:50','{\"username\":\"drmuncan\"}',5),(322,'2018-02-24 09:24:24',NULL,4),(323,'2018-02-24 09:24:24',NULL,4),(324,'2018-02-24 09:24:24',NULL,4),(325,'2018-02-24 09:24:28',NULL,4),(326,'2018-02-24 09:24:28',NULL,4),(327,'2018-02-24 09:26:11',NULL,4),(328,'2018-02-24 09:26:11',NULL,4),(329,'2018-02-24 09:27:20',NULL,4),(330,'2018-02-24 09:48:46',NULL,4),(331,'2018-02-24 09:50:46',NULL,4),(332,'2018-02-24 16:40:48','{\"username\":\"drmuncan\"}',5),(333,'2018-02-24 16:41:02',NULL,4),(334,'2018-02-24 20:06:38','{\"username\":\"drmuncan\"}',5),(335,'2018-02-24 20:12:03','{\"username\":\"drmuncan\"}',5),(336,'2018-02-24 20:59:50','{\"username\":\"drmuncan\"}',5),(337,'2018-02-24 22:44:04','{\"username\":\"drmuncan\"}',5),(338,'2018-02-24 22:48:27','{\"username\":\"drmuncan\"}',5),(339,'2018-02-24 22:52:41',NULL,4),(340,'2018-02-24 22:53:33',NULL,4),(341,'2018-02-24 22:53:33',NULL,4),(342,'2018-02-24 22:58:25',NULL,4),(343,'2018-02-24 22:58:25',NULL,4),(344,'2018-02-24 22:58:31',NULL,4),(345,'2018-02-24 22:58:31',NULL,4);
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
INSERT INTO `p_patient` VALUES (3048280984,'Ing','W','Saric','Sarah','28.09.1984','15','Perchtoldsdorf','2380',NULL,NULL,'AT','20','Marktplatz','bushwookie@debil.com','43036097816'),(4294280984,'Mag','W','Müller','Anna','28.09.1984','12','Perchtoldsdorf','2380','9987654321','Keine Werbung','AT','21','Bahngasse',NULL,NULL),(5047060999,'Prof','M','Markovic','Predrag','06.09.1999','123','Wien','1100','1234567890','Keine Werbung','AT','12','Favoriten',NULL,NULL),(6032060899,'Mag.','M','Tobolka','Anton','06.08.1999',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6666280984,'Dipl.Ing','M','Neuberger','Christopher','28.09.1984','11','Sulz','2392','435346435','Keine Werbung','AT','32','Hauptstra├ƒe',NULL,NULL),(7078280984,'Msc','M','Icme','Eren','28.09.1984','56','Wien','1010','235676453','Keine Werbung','AT','1','K├ñrtnerstra├ƒe',NULL,NULL);
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
INSERT INTO `ver_versicherungen` VALUES ('11',3048280984,1),('11',6032060899,0),('11',7078280984,1),('25',3048280984,0),('28',6032060899,1),('40',3048280984,0),('8D',4294280984,1),('8D',6032060899,0);
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
INSERT INTO `w_warteliste` VALUES (3048280984,1,1519376508,1,NULL),(6032060899,2,1519376549,3,NULL);
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

-- Dump completed on 2018-02-24 23:01:27
