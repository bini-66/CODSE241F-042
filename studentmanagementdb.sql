CREATE DATABASE  IF NOT EXISTS `studentmanagementdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `studentmanagementdb`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: studentmanagementdb
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `branch` (
  `branch_id` int NOT NULL AUTO_INCREMENT,
  `branchName` varchar(100) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `TP` varchar(15) NOT NULL,
  PRIMARY KEY (`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (1,'Lily Branch-Maharagama','123 Main Street, Maharagama','0112345678'),(2,'Tulip Branch-Gampaha','45 North Road,Gampaha','0112233445'),(3,'Rose Branch-Negombo','78 South Lane, Negombo','0112456789'),(4,'Araliya Branch-Kandy','90 East Avenue, Kandy','0112123456');
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fees`
--

DROP TABLE IF EXISTS `fees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fees` (
  `fee_id` int NOT NULL AUTO_INCREMENT,
  `admission_no` int DEFAULT NULL,
  `month` varchar(25) DEFAULT NULL,
  `fee` float DEFAULT NULL,
  `paid` float DEFAULT NULL,
  `due` float DEFAULT NULL,
  PRIMARY KEY (`fee_id`),
  KEY `fk_stdId_idx` (`admission_no`),
  CONSTRAINT `fk_stdId` FOREIGN KEY (`admission_no`) REFERENCES `student` (`admission_no`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fees`
--

LOCK TABLES `fees` WRITE;
/*!40000 ALTER TABLE `fees` DISABLE KEYS */;
INSERT INTO `fees` VALUES (1,1000,'January',5000,3000,2000),(2,1001,'February',5000,5000,0),(3,1002,'March',5000,4000,1000),(4,1003,'April',5000,5000,0),(5,1004,'May',5000,4500,500),(6,1005,'June',5000,2000,3000),(7,1006,'July',5000,5000,0),(8,1007,'August',5000,5000,0),(9,1007,'September',5000,4500,500),(10,1009,'October',5000,5000,0),(11,1010,'November',5000,5000,0),(12,1011,'December',5000,5000,0),(13,1012,'January',5000,5000,0),(14,1013,'February',5000,5000,0),(15,1014,'March',5000,5000,0),(16,1003,'January',5000,5000,0);
/*!40000 ALTER TABLE `fees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marks`
--

DROP TABLE IF EXISTS `marks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marks` (
  `mark_id` int NOT NULL AUTO_INCREMENT,
  `admission_no` int NOT NULL,
  `Month` varchar(25) NOT NULL,
  `Combined Mathematics` float DEFAULT NULL,
  `Physics` float DEFAULT NULL,
  `Chemistry` float DEFAULT NULL,
  `Total` float DEFAULT NULL,
  PRIMARY KEY (`mark_id`),
  KEY `fk_constraint_name` (`admission_no`),
  CONSTRAINT `fk_constraint_name` FOREIGN KEY (`admission_no`) REFERENCES `student` (`admission_no`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marks`
--

LOCK TABLES `marks` WRITE;
/*!40000 ALTER TABLE `marks` DISABLE KEYS */;
INSERT INTO `marks` VALUES (1,1000,'January',85,78,90,253),(2,1001,'February',92,80,88,260),(3,1002,'March',75,85,79,239),(4,1003,'April',88,82,91,261),(5,1004,'May',80,75,83,238),(6,1005,'June',89,88,84,261),(7,1000,'July',78,80,86,244),(8,1001,'August',91,89,87,267),(9,1002,'September',77,81,78,236),(10,1003,'October',84,83,85,252),(11,1006,'January',90,85,87,262),(12,1007,'February',80,78,82,240),(13,1007,'March',85,88,80,253),(14,1009,'April',83,79,85,247),(15,1010,'May',92,90,91,273),(16,1011,'June',76,81,77,234),(17,1012,'July',87,85,89,261),(18,1013,'August',93,91,90,274),(19,1014,'September',79,84,82,245),(20,1014,'October',88,80,85,253);
/*!40000 ALTER TABLE `marks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `admission_no` int NOT NULL,
  `branch_id` int DEFAULT NULL,
  `fname` varchar(45) NOT NULL,
  `iniName` varchar(30) NOT NULL,
  `DOB` date NOT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Father` varchar(50) DEFAULT NULL,
  `Mother` varchar(45) DEFAULT NULL,
  `TP` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`admission_no`),
  KEY `fk_branch` (`branch_id`),
  CONSTRAINT `fk_branch` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1000,1,'Diana Thisansa Wickramasinghe','D T Wickramasinghe','2004-01-20','No. 123, Temple Road, Maharagama','Mr. Sunil Wickramasinghe','Mrs. Kanthi Wickramasinghe','0775698563'),(1001,2,'Nuwani Sandunika Perera','N S Perera','2004-02-25','No. 45, Lake View Road, Gampaha','Mr. Ruwan Perera','Mrs. Dilhani Perera','0719546325'),(1002,3,'Tharindu Lakshan Silva','T L Silva','2004-03-18','No. 9, Hill Side Road, Negombo','Mr. Anura Silva','Mrs. Chamila Silva','0762345869'),(1003,4,'Dineth Kaveeshan Fernando','D K Fernando','2004-04-14','No. 7, Flower Avenue, Kandy','Mr. Nimal Fernando','Mrs. Roshini Fernando','0756894956'),(1004,1,'Ayesha Roshini Perera','A R Perera','2004-11-10','No. 21, Lake Side Road, Colombo 5','Mr. Harsha Perera','Mrs. Renuka Perera','0772345670'),(1005,2,'Nadeesha Manori Silva','N M Silva','2005-02-18','No. 52, Main Street, Kandy','Mr. Ruwan Silva','Mrs. Indika Silva','0712345678'),(1006,3,'Tharushi Kanishka Kumari','T K Kumari','2006-07-30','No. 12, Hill Road, Negombo','Mr. Ramesh Kumari','Mrs. Pooja Kumari','0773456789'),(1007,4,'Ravindu Nalin Fernando','R N Fernando','2003-05-15','No. 68, Park Avenue, Colombo 6','Mr. Lalith Fernando','Mrs. Dilani Fernando','0764567892'),(1009,4,'Samanthi Nethmini Samarasinghe','S N Samarasinghe','2007-03-25','No. 43, Beach Road, Matara','Mr. Priyantha Samarasinghe','Mrs. Kamani Samarasinghe','0785678901'),(1010,3,'Yashoda Manel Lakshan','Y M Lakshan','2004-12-01','No. 11, Forest Road, Galle','Mr. Arjuna Lakshan','Mrs. Nuwanika Lakshan','0756789012'),(1011,2,'Anura Manjula Jayasinghe','A M Jayasinghe','2005-08-20','No. 34, Sunset Lane, Kurunegala','Mr. Nimal Jayasinghe','Mrs. Shashi Jayasinghe','0771234568'),(1012,1,'Kalpana Neelika Perera','K N Perera','2006-03-05','No. 29, Kings Road, Nugegoda','Mr. Chaminda Perera','Mrs. Shehani Perera','0717654321'),(1013,3,'Roshan Kanishka Wijesinghe','R K Wijesinghe','2007-01-10','No. 50, Mountain View, Kandy','Mr. Upul Wijesinghe','Mrs. Chandani Wijesinghe','0779876543'),(1014,4,'Chandana Ranathunga','C Ranathunga','2004-06-25','No. 22, Main Road, Colombo 4','Mr. Gamini Ranathunga','Mrs. Kanchana Ranathunga','0781234567');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `userType` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('bini','Admin','123'),('kamal','Teacher','kamal@123');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-09 22:26:37
