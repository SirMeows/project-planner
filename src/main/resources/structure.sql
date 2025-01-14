-- Author He & Peter
-- 11.12.2021

-- CREATE DATABASE IF NOT EXISTS `project_planner`;
-- USE `project_planner`;

--
-- Table structure for table `date_time`
--

DROP TABLE IF EXISTS `activity_level`;
CREATE TABLE activity_level (
                                level_id int NOT NULL,
                                name varchar(45) NOT NULL,
                                PRIMARY KEY (level_id)
);

DROP TABLE IF EXISTS `date_time`;
CREATE TABLE `date_time` (
                             `date_time_id` int NOT NULL AUTO_INCREMENT,
                             `planned_start_date` datetime NOT NULL,
                             `actual_start_date` datetime DEFAULT NULL,
                             `deadline` datetime NOT NULL,
                             `actual_end_date` datetime DEFAULT NULL,
                             PRIMARY KEY (`date_time_id`),
                             UNIQUE KEY `date_time_id_UNIQUE` (`date_time_id`)
) AUTO_INCREMENT=49;

-- Table structure for table `activity`

DROP TABLE IF EXISTS activity;
CREATE TABLE activity (
  activity_id int NOT NULL AUTO_INCREMENT,
  level_id int NOT NULL,
  name varchar(45) NOT NULL,
  date_time_id int NOT NULL,
  task_size int NOT NULL,
  PRIMARY KEY (`activity_id`),
  UNIQUE KEY (`activity_id`),
  KEY (`date_time_id`),
  FOREIGN KEY (`date_time_id`) REFERENCES `date_time` (`date_time_id`),
  FOREIGN KEY (level_id) REFERENCES activity_level(level_id)
);

DROP TABLE IF EXISTS activity_subactivity;
CREATE TABLE activity_subactivity (
                          activity_id int NOT NULL AUTO_INCREMENT,
                          subactivity_id int NOT NULL,
                          PRIMARY KEY (activity_id, subactivity_id),
                          FOREIGN KEY (`activity_id`) REFERENCES `activity` (`activity_id`) ON DELETE CASCADE,
                          FOREIGN KEY (subactivity_id) REFERENCES activity(activity_id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
                          `person_id` int NOT NULL,
                          `first_name` varchar(45) NOT NULL,
                          `last_name` varchar(45) NOT NULL,
                          `user_id` int DEFAULT NULL,
                          PRIMARY KEY (`person_id`),
                          KEY `fk_person_user_idx` (`user_id`),
                          CONSTRAINT `fk_person_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB;

