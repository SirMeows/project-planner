CREATE DATABASE IF NOT EXISTS `project_planner` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `project_planner`;

-- Table structure for table `activity`
--

DROP TABLE IF EXISTS activity;
CREATE TABLE activity (
  activity_id int NOT NULL AUTO_INCREMENT,
  level_id int NOT NULL,
  name varchar(45) NOT NULL,
  date_time_id int NOT NULL,
  PRIMARY KEY (`activity_id`),
  UNIQUE KEY (`activity_id`),
  KEY (`date_time_id`),
  FOREIGN KEY (`date_time_id`) REFERENCES `date_time` (`date_time_id`),
  FOREIGN KEY (level_id) REFERENCES activity_level(level_id)
);

DROP TABLE IF EXISTS `activity_level`;
CREATE TABLE activity_level (
    level_id int NOT NULL,
    name varchar(45) NOT NULL,
    PRIMARY KEY (level_id)
);

DROP TABLE IF EXISTS activity_subactivity;
CREATE TABLE activity_subactivity (
                          activity_id int NOT NULL AUTO_INCREMENT,
                          subactivity_id int NOT NULL,
                          PRIMARY KEY (activity_id, subactivity_id),
                          FOREIGN KEY (`activity_id`) REFERENCES `activity` (`activity_id`) ON DELETE CASCADE,
                          FOREIGN KEY (subactivity_id) REFERENCES activity(activity_id) ON DELETE CASCADE
);

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

