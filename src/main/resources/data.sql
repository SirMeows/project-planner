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

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (1,'activity 1 name',1),(2,'activity 2 name',2),(3,'activity 3 name',3),(4,'activity 4 name',4),(5,'activity 5 name',5),(6,'activity 6 name',6),(7,'activity 7 name',7),(8,'activity 8 name',8),(9,'activity 9 name',9),(10,'activity 10 name',10),(11,'activity 11 name',11),(12,'activity 12 name',12),(13,'act13name',13),(14,'act14name',14),(15,'act15name',15),(16,'act16name',16),(17,'act17name',17),(18,'act18name',18),(19,'act19name',19),(20,'activity 20 name',20),(21,'activity 21 name',21),(22,'activity 22 name',22),(23,'act 23 name',40),(24,'act 24 name',41),(25,'act 25 name',42),(26,'act 26 name',43),(27,'act 27 name',44),(28,'act 28 name',45),(29,'act 29 name',46),(30,'act 30 name',47),(31,'act 31 name',48);
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `date_time`
--

LOCK TABLES `date_time` WRITE;
/*!40000 ALTER TABLE `date_time` DISABLE KEYS */;
INSERT INTO `date_time` VALUES (1,'2021-10-01 12:00:00','2021-11-01 12:00:00','2022-06-01 12:00:00','2022-07-01 12:00:00'),(2,'2021-10-03 12:00:00','2021-11-03 12:00:00','2022-06-03 12:00:00','2022-07-03 12:00:00'),(3,'2021-10-03 12:00:00','2021-11-03 12:00:00','2022-06-03 12:00:00','2022-07-03 12:00:00'),(4,'2021-10-02 12:00:00','2021-11-02 12:00:00','2022-06-02 12:00:00','2022-07-02 12:00:00'),(5,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(6,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(7,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(8,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(9,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(10,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(11,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(12,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(13,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(14,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(15,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(16,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(17,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(18,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(19,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(20,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(21,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(22,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(40,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(41,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(42,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(43,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(44,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(45,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(46,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(47,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00'),(48,'2021-10-04 12:00:00','2021-11-04 12:00:00','2022-06-04 12:00:00','2022-07-04 12:00:00');
/*!40000 ALTER TABLE `date_time` ENABLE KEYS */;
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
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,1),(2,2),(3,3);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `project_subproject`
--

LOCK TABLES `project_subproject` WRITE;
/*!40000 ALTER TABLE `project_subproject` DISABLE KEYS */;
INSERT INTO `project_subproject` VALUES (1,1),(1,2),(1,3),(2,4),(3,5),(3,15),(1,16),(1,17),(3,18),(3,19),(1,20);
/*!40000 ALTER TABLE `project_subproject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `subproject`
--

LOCK TABLES `subproject` WRITE;
/*!40000 ALTER TABLE `subproject` DISABLE KEYS */;
INSERT INTO `subproject` VALUES (1,18),(2,17),(3,16),(4,4),(5,5),(15,12),(16,11),(17,10),(18,9),(19,8),(20,7),(21,1),(22,2),(23,3);
/*!40000 ALTER TABLE `subproject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `subproject_task`
--

LOCK TABLES `subproject_task` WRITE;
/*!40000 ALTER TABLE `subproject_task` DISABLE KEYS */;
INSERT INTO `subproject_task` VALUES (4,1),(4,2),(5,3),(3,4),(1,5),(3,6),(2,7);
/*!40000 ALTER TABLE `subproject_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `subtask`
--

LOCK TABLES `subtask` WRITE;
/*!40000 ALTER TABLE `subtask` DISABLE KEYS */;
INSERT INTO `subtask` VALUES (1,19),(2,23),(3,24),(4,25),(5,26),(6,27),(7,28),(8,29),(9,30),(10,31);
/*!40000 ALTER TABLE `subtask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,15),(2,14),(3,13),(4,6),(5,20),(6,21),(7,22);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `task_subtask`
--

LOCK TABLES `task_subtask` WRITE;
/*!40000 ALTER TABLE `task_subtask` DISABLE KEYS */;
INSERT INTO `task_subtask` VALUES (1,1),(1,2),(1,3),(2,4),(3,5),(4,6),(5,7),(6,8),(7,9),(7,10);
/*!40000 ALTER TABLE `task_subtask` ENABLE KEYS */;
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
