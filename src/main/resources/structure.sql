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
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity` (
  `activity_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `date_time_id` int NOT NULL,
  PRIMARY KEY (`activity_id`),
  UNIQUE KEY `activity_id_UNIQUE` (`activity_id`),
  KEY `fk_activity_date_time_idx` (`date_time_id`),
  CONSTRAINT `fk_activity_date_time` FOREIGN KEY (`date_time_id`) REFERENCES `date_time` (`date_time_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `date_time`
--

DROP TABLE IF EXISTS `date_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `date_time` (
  `date_time_id` int NOT NULL AUTO_INCREMENT,
  `planned_start_date` datetime DEFAULT NULL,
  `actual_start_date` datetime DEFAULT NULL,
  `deadline` datetime DEFAULT NULL,
  `actual_end_date` datetime DEFAULT NULL,
  PRIMARY KEY (`date_time_id`),
  UNIQUE KEY `date_time_id_UNIQUE` (`date_time_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `person_id` int NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`person_id`),
  KEY `fk_person_user_idx` (`user_id`),
  CONSTRAINT `fk_person_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `project_id` int NOT NULL AUTO_INCREMENT,
  `activity_id` int NOT NULL,
  PRIMARY KEY (`project_id`),
  UNIQUE KEY `activity_id_UNIQUE` (`activity_id`),
  KEY `fk_project_activity_idx` (`activity_id`),
  CONSTRAINT `fk_project_activity` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`activity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `project_subproject`
--

DROP TABLE IF EXISTS `project_subproject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_subproject` (
  `project_id` int NOT NULL,
  `subproject_id` int NOT NULL,
  PRIMARY KEY (`project_id`,`subproject_id`),
  KEY `fk_project_subproject_subproject_idx` (`subproject_id`),
  CONSTRAINT `fk_project_subproject_project` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_project_subproject_subproject` FOREIGN KEY (`subproject_id`) REFERENCES `subproject` (`subproject_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `project_view`
--

DROP TABLE IF EXISTS `project_view`;
/*!50001 DROP VIEW IF EXISTS `project_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `project_view` AS SELECT 
 1 AS `project_id`,
 1 AS `project_activity_id`,
 1 AS `project_name`,
 1 AS `date_time_id`,
 1 AS `planned_start_date`,
 1 AS `actual_start_date`,
 1 AS `deadline`,
 1 AS `actual_end_date`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `subproject`
--

DROP TABLE IF EXISTS `subproject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subproject` (
  `subproject_id` int NOT NULL AUTO_INCREMENT,
  `activity_id` int NOT NULL,
  PRIMARY KEY (`subproject_id`),
  UNIQUE KEY `sub_project_id_UNIQUE` (`subproject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `subproject_task`
--

DROP TABLE IF EXISTS `subproject_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subproject_task` (
  `subproject_id` int NOT NULL,
  `task_id` int NOT NULL,
  PRIMARY KEY (`subproject_id`,`task_id`),
  KEY `fk_subproject_task_task_idx` (`task_id`),
  CONSTRAINT `fk_subproject_task_subproject` FOREIGN KEY (`subproject_id`) REFERENCES `subproject` (`subproject_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_subproject_task_task` FOREIGN KEY (`task_id`) REFERENCES `task` (`task_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `subproject_view`
--

DROP TABLE IF EXISTS `subproject_view`;
/*!50001 DROP VIEW IF EXISTS `subproject_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `subproject_view` AS SELECT 
 1 AS `subproject_id`,
 1 AS `subproject_activity_id`,
 1 AS `subproject_name`,
 1 AS `date_time_id`,
 1 AS `planned_start_date`,
 1 AS `actual_start_date`,
 1 AS `deadline`,
 1 AS `actual_end_date`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `subtask`
--

DROP TABLE IF EXISTS `subtask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subtask` (
  `subtask_id` int NOT NULL,
  `activity_id` int NOT NULL,
  PRIMARY KEY (`subtask_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `subtask_view`
--

DROP TABLE IF EXISTS `subtask_view`;
/*!50001 DROP VIEW IF EXISTS `subtask_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `subtask_view` AS SELECT 
 1 AS `subtask_id`,
 1 AS `subtask_activity_id`,
 1 AS `subtask_name`,
 1 AS `date_time_id`,
 1 AS `planned_start_date`,
 1 AS `actual_start_date`,
 1 AS `deadline`,
 1 AS `actual_end_date`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task` (
  `task_id` int NOT NULL AUTO_INCREMENT,
  `activity_id` int NOT NULL,
  PRIMARY KEY (`task_id`),
  UNIQUE KEY `task_id_UNIQUE` (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `task_subtask`
--

DROP TABLE IF EXISTS `task_subtask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task_subtask` (
  `task_id` int NOT NULL,
  `subtask_id` int NOT NULL,
  PRIMARY KEY (`task_id`,`subtask_id`),
  KEY `fk_task_subtask_subtask_idx` (`subtask_id`),
  CONSTRAINT `fk_task_subtask_subtask` FOREIGN KEY (`subtask_id`) REFERENCES `subtask` (`subtask_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_task_subtask_task` FOREIGN KEY (`task_id`) REFERENCES `task` (`task_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `task_view`
--

DROP TABLE IF EXISTS `task_view`;
/*!50001 DROP VIEW IF EXISTS `task_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `task_view` AS SELECT 
 1 AS `task_id`,
 1 AS `task_activity_id`,
 1 AS `task_name`,
 1 AS `date_time_id`,
 1 AS `planned_start_date`,
 1 AS `actual_start_date`,
 1 AS `deadline`,
 1 AS `actual_end_date`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Final view structure for view `project_view`
--

/*!50001 DROP VIEW IF EXISTS `project_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `project_view` AS select `p`.`project_id` AS `project_id`,`p`.`activity_id` AS `project_activity_id`,`a`.`name` AS `project_name`,`dt`.`date_time_id` AS `date_time_id`,`dt`.`planned_start_date` AS `planned_start_date`,`dt`.`actual_start_date` AS `actual_start_date`,`dt`.`deadline` AS `deadline`,`dt`.`actual_end_date` AS `actual_end_date` from ((`project` `p` join `activity` `a` on((`p`.`activity_id` = `a`.`activity_id`))) join `date_time` `dt` on((`a`.`date_time_id` = `dt`.`date_time_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `subproject_view`
--

/*!50001 DROP VIEW IF EXISTS `subproject_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `subproject_view` AS select `s`.`subproject_id` AS `subproject_id`,`s`.`activity_id` AS `subproject_activity_id`,`a`.`name` AS `subproject_name`,`dt`.`date_time_id` AS `date_time_id`,`dt`.`planned_start_date` AS `planned_start_date`,`dt`.`actual_start_date` AS `actual_start_date`,`dt`.`deadline` AS `deadline`,`dt`.`actual_end_date` AS `actual_end_date` from ((`subproject` `s` join `activity` `a` on((`s`.`activity_id` = `a`.`activity_id`))) join `date_time` `dt` on((`a`.`date_time_id` = `dt`.`date_time_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `subtask_view`
--

/*!50001 DROP VIEW IF EXISTS `subtask_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `subtask_view` AS select `s`.`subtask_id` AS `subtask_id`,`s`.`activity_id` AS `subtask_activity_id`,`a`.`name` AS `subtask_name`,`dt`.`date_time_id` AS `date_time_id`,`dt`.`planned_start_date` AS `planned_start_date`,`dt`.`actual_start_date` AS `actual_start_date`,`dt`.`deadline` AS `deadline`,`dt`.`actual_end_date` AS `actual_end_date` from ((`subtask` `s` join `activity` `a` on((`s`.`activity_id` = `a`.`activity_id`))) join `date_time` `dt` on((`a`.`date_time_id` = `dt`.`date_time_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `task_view`
--

/*!50001 DROP VIEW IF EXISTS `task_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `task_view` AS select `t`.`task_id` AS `task_id`,`t`.`activity_id` AS `task_activity_id`,`a`.`name` AS `task_name`,`dt`.`date_time_id` AS `date_time_id`,`dt`.`planned_start_date` AS `planned_start_date`,`dt`.`actual_start_date` AS `actual_start_date`,`dt`.`deadline` AS `deadline`,`dt`.`actual_end_date` AS `actual_end_date` from ((`task` `t` join `activity` `a` on((`t`.`activity_id` = `a`.`activity_id`))) join `date_time` `dt` on((`a`.`date_time_id` = `dt`.`date_time_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-29 17:37:05
