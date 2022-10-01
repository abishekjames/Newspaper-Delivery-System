-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: newspaper
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `Customer_id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Address` varchar(40) NOT NULL,
  `Contact_num` varchar(15) NOT NULL,
  `Delivery_area` varchar(20) NOT NULL,
  PRIMARY KEY (`Customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (100,'Abhi','Willow Park ','3538906780889','Willow'),(101,'Zhou','Willow','0870870877','Athlone');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_docket`
--

DROP TABLE IF EXISTS `delivery_docket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_docket` (
  `Customer_id` int NOT NULL,
  `Type` varchar(40) NOT NULL,
  `Customer_name` varchar(45) NOT NULL,
  `Delivery_person_id` int NOT NULL,
  `Delivery_address` varchar(40) NOT NULL,
  `Contact_num` varchar(15) NOT NULL,
  `Delivery_time` varchar(45) NOT NULL,
  PRIMARY KEY (`Customer_id`,`Type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_docket`
--

LOCK TABLES `delivery_docket` WRITE;
/*!40000 ALTER TABLE `delivery_docket` DISABLE KEYS */;
INSERT INTO `delivery_docket` VALUES (100,'News Paper','Abhi',300,'Willow Park','3538906780889','Morning');
/*!40000 ALTER TABLE `delivery_docket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_person`
--

DROP TABLE IF EXISTS `delivery_person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_person` (
  `Delivery_person_id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Delivery_address` varchar(40) NOT NULL,
  `Contact_num` varchar(15) NOT NULL,
  `Delivery_area` varchar(20) NOT NULL,
  `Working_hours` int NOT NULL,
  `Day_Off` varchar(45) NOT NULL,
  PRIMARY KEY (`Delivery_person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=303 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_person`
--

LOCK TABLES `delivery_person` WRITE;
/*!40000 ALTER TABLE `delivery_person` DISABLE KEYS */;
INSERT INTO `delivery_person` VALUES (300,'Hong','Willow Park','35372637389','Willow',10,'Work'),(302,'mike','qwerty','08712345678','asa',5,'Work');
/*!40000 ALTER TABLE `delivery_person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(24) NOT NULL,
  `position` varchar(9) NOT NULL,
  PRIMARY KEY (`id`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'Honggggg','zhouhonggggg','Manager'),(2,'Abishekkk','999999999999','Customer');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publication`
--

DROP TABLE IF EXISTS `publication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publication` (
  `pub_id` int NOT NULL AUTO_INCREMENT,
  `pub_name` varchar(15) NOT NULL,
  `price` double NOT NULL,
  `details` varchar(40) NOT NULL,
  `message` varchar(15) NOT NULL,
  PRIMARY KEY (`pub_id`)
) ENGINE=InnoDB AUTO_INCREMENT=203 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publication`
--

LOCK TABLES `publication` WRITE;
/*!40000 ALTER TABLE `publication` DISABLE KEYS */;
INSERT INTO `publication` VALUES (201,'magazine',2,'dddddd','fffffff'),(202,'magazine',2,'rrrrrrrr','rrrrrrrrr');
/*!40000 ALTER TABLE `publication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscriptions`
--

DROP TABLE IF EXISTS `subscriptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscriptions` (
  `Subscription_id` varchar(40) NOT NULL,
  `Customer_id` varchar(40) NOT NULL,
  `Type` varchar(40) NOT NULL,
  `Price` double NOT NULL,
  `State` varchar(45) NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`Subscription_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscriptions`
--

LOCK TABLES `subscriptions` WRITE;
/*!40000 ALTER TABLE `subscriptions` DISABLE KEYS */;
INSERT INTO `subscriptions` VALUES ('200','100','News Paper',2,'Active','2020-01-01'),('a0000','b0000','magazine',80,'suspend','2019-01-01');
/*!40000 ALTER TABLE `subscriptions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-22 11:27:13
