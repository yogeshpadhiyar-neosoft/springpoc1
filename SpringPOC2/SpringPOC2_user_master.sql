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
-- Table structure for table `user_master`
--

DROP TABLE IF EXISTS `user_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_master` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `updated_date` date DEFAULT NULL,
  `active` bit(1) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_detail_user_detail_id` bigint(20) DEFAULT NULL,
  `user_education_user_education_id` bigint(20) DEFAULT NULL,
  `user_employeement_details_user_employee_id` bigint(20) DEFAULT NULL,
  `user_role_role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FKau09atd23ixwcclwof20tgyo0` (`user_detail_user_detail_id`),
  KEY `FKtjubs0e1pi2c52qcdk6opxpwe` (`user_education_user_education_id`),
  KEY `FKfk8e77kdde6lk72qmp27lh00s` (`user_employeement_details_user_employee_id`),
  KEY `FK4qfygv4egjuofwf5y7hum3mtu` (`user_role_role_id`),
  CONSTRAINT `FK4qfygv4egjuofwf5y7hum3mtu` FOREIGN KEY (`user_role_role_id`) REFERENCES `user_role` (`role_id`),
  CONSTRAINT `FKau09atd23ixwcclwof20tgyo0` FOREIGN KEY (`user_detail_user_detail_id`) REFERENCES `user_detail` (`user_detail_id`),
  CONSTRAINT `FKfk8e77kdde6lk72qmp27lh00s` FOREIGN KEY (`user_employeement_details_user_employee_id`) REFERENCES `user_employeement_details` (`user_employee_id`),
  CONSTRAINT `FKtjubs0e1pi2c52qcdk6opxpwe` FOREIGN KEY (`user_education_user_education_id`) REFERENCES `user_education` (`user_education_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_master`
--

LOCK TABLES `user_master` WRITE;
/*!40000 ALTER TABLE `user_master` DISABLE KEYS */;
INSERT INTO `user_master` VALUES (1,'2020-06-18',_binary '','2020-06-18','Yogi@123','yogi123',1,1,1,1),(2,'2020-06-18',_binary '','2020-06-18','Yogi@123','yogi123',2,2,2,2),(3,'2020-06-18',_binary '','2020-06-18','Yogi@123','yogi123',3,3,3,3);
/*!40000 ALTER TABLE `user_master` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-18 15:19:07
