-- Author He & Peter
-- 11.12.2021
CREATE DATABASE  IF NOT EXISTS `project_planner` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `project_planner`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: project_planner
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


INSERT INTO activity_level VALUES (0,'Project'),(1,'SubProject'),(2,'Task'),(3,'SubTask');

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (1, 0, 'activity 1 name',1, 3000),(2,0,'activity 2 name',2, 1000),(3,0,'activity 3 name',3, 1000),(4,1,'activity 4 name',4, 1000),(5,1,'activity 5 name',5, 10),(6,1,'activity 6 name',6, 10),(7,2,'activity 7 name',7, 500),(8,2,'activity 8 name',8, 500),(9,3,'activity 9 name',9, 250),(10,3,'activity 10 name',10, 250);
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `date_time`
--

LOCK TABLES `date_time` WRITE;
/*!40000 ALTER TABLE `date_time` DISABLE KEYS */;
INSERT INTO `date_time` VALUES (1,'2021-10-01 12:00:00','2021-11-01 12:00:00','2022-06-01 12:00:00','2022-07-01 12:00:00'),(2,'2021-10-03 12:00:00','2021-11-03 12:00:00','2021-12-03 12:00:00','2022-07-03 12:00:00'),(3,'2021-11-03 12:00:00','2022-01-03 12:00:00','2022-02-03 12:00:00','2022-07-03 12:00:00'),(4,'2021-10-02 12:00:00','2021-11-02 12:00:00','2022-06-02 12:00:00','2022-07-02 12:00:00'),(5,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(6,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(7,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(8,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(9,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(10,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00');
/*!40000 ALTER TABLE `date_time` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `activity_subactivity` WRITE;
/*!40000 ALTER TABLE `activity_subactivity` DISABLE KEYS */;
INSERT INTO `activity_subactivity` VALUES (1,4),(1,5),(1,6),(4,7),(4,8),(7,9),(7,10);
/*!40000 ALTER TABLE `activity_subactivity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'Adam','Adamsen',1),(2,'Bertha','Berthilsen',2),(3,'Cecil','Cesilsen',3);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Username1','123'),(2,'Username2','12_ghKO!r'),(3,'Username3','megakitten');
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

-- Dump completed on 2021-11-29 17:37:28
