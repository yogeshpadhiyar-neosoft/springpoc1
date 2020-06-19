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
-- Table structure for table `user_master_user_contracts`
--

DROP TABLE IF EXISTS `user_master_user_contracts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_master_user_contracts` (
  `user_master_user_id` bigint(20) NOT NULL,
  `user_contracts_project_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_s2su9bmv3hnfmxwjclm406ggu` (`user_contracts_project_id`),
  KEY `FKnlmvedw8tssoqo3di0lfdlbln` (`user_master_user_id`),
  CONSTRAINT `FKnlmvedw8tssoqo3di0lfdlbln` FOREIGN KEY (`user_master_user_id`) REFERENCES `user_master` (`user_id`),
  CONSTRAINT `FKpjbvvk07masaixc6sxdlqqb56` FOREIGN KEY (`user_contracts_project_id`) REFERENCES `user_contracts` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_master_user_contracts`
--

LOCK TABLES `user_master_user_contracts` WRITE;
/*!40000 ALTER TABLE `user_master_user_contracts` DISABLE KEYS */;
INSERT INTO `user_master_user_contracts` VALUES (1,1),(1,2),(2,3),(2,4),(3,5),(3,6);
/*!40000 ALTER TABLE `user_master_user_contracts` ENABLE KEYS */;
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
