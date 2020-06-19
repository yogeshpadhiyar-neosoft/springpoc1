-- MySQL dump 10.13  Distrib 5.7.30, for Linux (x86_64)
--
-- Host: localhost    Database: SpringPOC2
-- ------------------------------------------------------
-- Server version	5.7.30-0ubuntu0.16.04.1

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
-- Table structure for table `user_contracts`
--

DROP TABLE IF EXISTS `user_contracts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_contracts` (
  `project_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_project` bit(1) NOT NULL,
  `company` varchar(255) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `project_details` varchar(255) DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `user_master_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  KEY `FKski54rptmh3vtaf4pbbljff66` (`user_master_user_id`),
  CONSTRAINT `FKski54rptmh3vtaf4pbbljff66` FOREIGN KEY (`user_master_user_id`) REFERENCES `user_master` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_contracts`
--

LOCK TABLES `user_contracts` WRITE;
/*!40000 ALTER TABLE `user_contracts` DISABLE KEYS */;
INSERT INTO `user_contracts` VALUES (1,_binary '','dsfdfs','2020-06-18','hfgsssdggs','SHSAD','2020-06-18',1),(2,_binary '','dsfdfs','2020-06-18','hfgsssdggs','SHSAD','2020-06-18',1),(3,_binary '','dsfdfs','2020-06-18','hfgsssdggs','SHSAD','2020-06-18',2),(4,_binary '','dsfdfs','2020-06-18','hfgsssdggs','SHSAD','2020-06-18',2),(5,_binary '','dsfdfs','2020-06-18','hfgsssdggs','SHSAD','2020-06-18',3),(6,_binary '','dsfdfs','2020-06-18','hfgsssdggs','SHSAD','2020-06-18',3);
/*!40000 ALTER TABLE `user_contracts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-18 15:19:06
