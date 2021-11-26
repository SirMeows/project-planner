INSERT INTO `project_planner`.`date_time` (`date_time_id`, `planned_start_date`, `actual_start_date`, `deadline`, `actual_end_date`) VALUES (1, '2021-10-01 12:00', '2021-11-01 12:00', '2022-06-01 12:00', '2022-07-01 12:00');
INSERT INTO `project_planner`.`date_time` (`date_time_id`, `planned_start_date`, `actual_start_date`, `deadline`, `actual_end_date`) VALUES (2, '2021-10-02 12:00', '2021-11-02 12:00', '2022-06-02 12:00', '2022-07-02 12:00');
INSERT INTO `project_planner`.`date_time` (`date_time_id`, `planned_start_date`, `actual_start_date`, `deadline`, `actual_end_date`) VALUES (3, '2021-10-03 12:00', '2021-11-03 12:00', '2022-06-03 12:00', '2022-07-03 12:00');

INSERT INTO `project_planner`.`activity` (`activity_id`, `name`, `date_time_id`) VALUES ('1', 'activity 1', '1');
INSERT INTO `project_planner`.`activity` (`activity_id`, `name`, `date_time_id`) VALUES ('2', 'activity 2', '2');
INSERT INTO `project_planner`.`activity` (`activity_id`, `name`, `date_time_id`) VALUES ('3', 'activity 3', '3');

INSERT INTO `project_planner`.`project` (`project_id`, `activity_id`) VALUES ('1', '1');
INSERT INTO `project_planner`.`project` (`project_id`, `activity_id`) VALUES ('2', '2');

INSERT INTO `project_planner`.`subproject` (`subproject_id`, `activity_id`) VALUES ('1', '1');
INSERT INTO `project_planner`.`subproject` (`subproject_id`, `activity_id`) VALUES ('2', '2');
INSERT INTO `project_planner`.`subproject` (`subproject_id`, `activity_id`) VALUES ('3', '3');

INSERT INTO `project_planner`.`project_subproject` (`project_id`, `subproject_id`) VALUES ('1', '1');
INSERT INTO `project_planner`.`project_subproject` (`project_id`, `subproject_id`) VALUES ('1', '2');
INSERT INTO `project_planner`.`project_subproject` (`project_id`, `subproject_id`) VALUES ('2', '3');

INSERT INTO `project_planner`.`task` (`task_id`, `activity_id`) VALUES ('1', '1');
INSERT INTO `project_planner`.`task` (`task_id`, `activity_id`) VALUES ('2', '2');
INSERT INTO `project_planner`.`task` (`task_id`, `activity_id`) VALUES ('3', '3');

INSERT INTO `project_planner`.`subproject_task` (`subproject_id`, `task_id`) VALUES ('1', '1');
INSERT INTO `project_planner`.`subproject_task` (`subproject_id`, `task_id`) VALUES ('1', '2');
INSERT INTO `project_planner`.`subproject_task` (`subproject_id`, `task_id`) VALUES ('2', '3');

INSERT INTO `project_planner`.`subtask` (`subtask_id`, `activity_id`) VALUES ('1', '1');
INSERT INTO `project_planner`.`subtask` (`subtask_id`, `activity_id`) VALUES ('2', '2');
INSERT INTO `project_planner`.`subtask` (`subtask_id`, `activity_id`) VALUES ('3', '3');

INSERT INTO `project_planner`.`task_subtask` (`task_id`, `subtask_id`) VALUES ('1', '1');
INSERT INTO `project_planner`.`task_subtask` (`task_id`, `subtask_id`) VALUES ('1', '2');
INSERT INTO `project_planner`.`task_subtask` (`task_id`, `subtask_id`) VALUES ('1', '3');

INSERT INTO `project_planner`.`person` (`person_id`, `first_name`, `last_name`, `user_id`) VALUES ('1', 'Adam', 'Adamsen', '1');
INSERT INTO `project_planner`.`person` (`person_id`, `first_name`, `last_name`, `user_id`) VALUES ('2', 'Bertha', 'Berthilsen', '2');
INSERT INTO `project_planner`.`person` (`person_id`, `first_name`, `last_name`, `user_id`) VALUES ('3', 'Cecil', 'Cesilsen', '3');

INSERT INTO `project_planner`.`user` (`user_id`, `username`, `password`) VALUES ('1', 'Username1', '123');
INSERT INTO `project_planner`.`user` (`user_id`, `username`, `password`) VALUES ('2', 'Username2', '12_ghKO!r');
INSERT INTO `project_planner`.`user` (`user_id`, `username`, `password`) VALUES ('3', 'Username3', 'megakitten');