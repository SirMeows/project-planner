/*
Author Peter & He
13.12.2021
 */

package dk.kea.projectplanner.repositories;

import dk.kea.projectplanner.models.ActivityModel;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional// Only executes a method if all parts succeed
public interface ActivityRepository {

    @Select("SELECT * FROM activity NATURAL JOIN date_time")
    @Results(value = {
            @Result(property="id", column="activity_id"),
            @Result(property="name", column="name"),
            @Result(property="levelId", column="level_id"),
            @Result(property="level", column="level_id", one=@One(select="findLevelById")),
            @Result(property="dateTimeId", column="date_time_id"),
            @Result(property="plannedStartDate", column="planned_start_date"),
            @Result(property="actualStartDate", column="actual_start_date"),
            @Result(property="deadline", column="deadline"),
            @Result(property="actualEndDate", column="actual_end_date"),
            @Result(property="taskSize", column="task_size")})
    List<ActivityModel> findAll();

    @Select("SELECT name from activity_level WHERE level_id = #{id}")
    String findLevelById(int id);

    @Select("SELECT subactivity_id, name, level_id, date_time_id, planned_start_date, actual_start_date, deadline, actual_end_date FROM activity_subactivity a_s JOIN activity ON a_s.subactivity_id=activity.activity_id NATURAL JOIN date_time WHERE a_s.activity_id = #{id}")
    @Results(value = {
            @Result(property="id", column="subactivity_id"),
            @Result(property="name", column="name"),
            @Result(property="levelId", column="level_id"),
            @Result(property="level", column="level_id", one=@One(select="findLevelById")),
            @Result(property="dateTimeId", column="date_time_id"),
            @Result(property="plannedStartDate", column="planned_start_date"),
            @Result(property="actualStartDate", column="actual_start_date"),
            @Result(property="deadline", column="deadline"),
            @Result(property="actualEndDate", column="actual_end_date"),
            @Result(property="taskSize", column="task_size")})
    List<ActivityModel> findSubActivitiesByParentId(long id);

    @Insert("INSERT INTO activity_subactivity (activity_id, subactivity_id) VALUES (#{subActivityId}, #{activity.id})")
    void addSubActivity(long subActivityId, ActivityModel activity);

    @Update("UPDATE date_time SET planned_start_date = #{plannedStartDate} WHERE date_time_id = #{dateTimeId}")
    int updatePlannedStartDate(ActivityModel activity);

    @Update("UPDATE date_time SET actual_start_date = #{actualStartDate} WHERE date_time_id = #{dateTimeId}")
    int updateActualStartDate(ActivityModel activity);

    @Update("UPDATE date_time SET deadline = #{deadline} WHERE date_time_id = #{dateTimeId}")
    int updateDeadline(ActivityModel activity);

    @Update("UPDATE date_time SET actual_end_date = #{actualEndDate} WHERE date_time_id = #{dateTimeId}")
    int updateActualEndDate(ActivityModel activity);

    @Insert("INSERT INTO date_time (date_time_id, planned_start_date, actual_start_date, deadline, actual_end_date)" +
            "VALUES (#{dateTimeId}, #{plannedStartDate}, #{actualStartDate}, #{deadline}, #{actualEndDate})")
    @Options(useGeneratedKeys = true, keyColumn = "date_time_id", keyProperty = "dateTimeId")
    void createDateTime(ActivityModel activity);

    @Insert("INSERT INTO activity (activity_id, name, date_time_id, level_id, task_size) VALUES (#{id}, #{name}, #{dateTimeId}, #{levelId}, #{taskSize});")
    @Options(useGeneratedKeys = true, keyColumn = "activity_id", keyProperty = "id")
    void createActivity(ActivityModel activity);

    @Select("SELECT level_id FROM activity_level where name LIKE #{name}")
    int findLevelIdByName(String name);

    @Select("SELECT * FROM activity NATURAL JOIN date_time where activity_id = #{id}")
    @Results(value = {
            @Result(property="id", column="activity_id"),
            @Result(property="name", column="name"),
            @Result(property="levelId", column="level_id"),
            @Result(property="level", column="level_id", one=@One(select="findLevelById")),
            @Result(property="dateTimeId", column="date_time_id"),
            @Result(property="plannedStartDate", column="planned_start_date"),
            @Result(property="actualStartDate", column="actual_start_date"),
            @Result(property="deadline", column="deadline"),
            @Result(property="actualEndDate", column="actual_end_date"),
            @Result(property="taskSize", column="task_size")})
    ActivityModel findById(long id);

    @Delete("DELETE FROM activity WHERE activity_id = #{id}")
    int deleteActivity(long id);
}
