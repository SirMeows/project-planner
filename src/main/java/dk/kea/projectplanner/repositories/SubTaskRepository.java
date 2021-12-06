package dk.kea.projectplanner.repositories;

import dk.kea.projectplanner.models.SubTaskModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SubTaskRepository extends ActivityRepository<SubTaskModel> {

    @Select("SELECT * FROM subtask_view")
    @Results(value = {
            @Result(property="id", column="subtask_id"),
            @Result(property="activityId", column="subtask_activity_id"),
            @Result(property="name", column="subtask_name"),
            @Result(property="dateTimeId", column="date_time_id"),
            @Result(property="plannedStartDate", column="planned_start_date"),
            @Result(property="actualStartDate", column="actual_start_date"),
            @Result(property="deadline", column="deadline"),
            @Result(property="actualEndDate", column="actual_end_date")})
    List<SubTaskModel> findAllSubTasks();

    @Select("SELECT * FROM subtask_view WHERE subtask_id = #{id}")
    @Results(value = {
            @Result(property="id", column="subtask_id"),
            @Result(property="activityId", column="subtask_activity_id"),
            @Result(property="name", column="subtask_name"),
            @Result(property="dateTimeId", column="date_time_id"),
            @Result(property="plannedStartDate", column="planned_start_date"),
            @Result(property="actualStartDate", column="actual_start_date"),
            @Result(property="deadline", column="deadline"),
            @Result(property="actualEndDate", column="actual_end_date")})
    SubTaskModel findById(long id);

    @Delete("DELETE FROM subtask WHERE subtask_id = #{id}")
    int deleteById(long id);

    @Insert("INSERT INTO subtask (subtask_id, activity_id) VALUES (#{id}, #{activityId})")
    @Options(useGeneratedKeys = true, keyColumn = "task_id", keyProperty = "id")
    void createSubTask(SubTaskModel subTaskModel);
}
