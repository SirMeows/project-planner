package dk.kea.projectplanner.repositories;

import dk.kea.projectplanner.models.SubTaskModel;
import dk.kea.projectplanner.models.TaskModel;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface TaskRepository extends ActivityRepository<TaskModel> {

    @Select("SELECT * FROM task_view")
    @Results(value = {
            @Result(property="id", column="task_id"),
            @Result(property="activityId", column="task_activity_id"),
            @Result(property="name", column="task_name"),
            @Result(property="dateTimeId", column="date_time_id"),
            @Result(property="plannedStartDate", column="planned_start_date"),
            @Result(property="actualStartDate", column="actual_start_date"),
            @Result(property="deadline", column="deadline"),
            @Result(property="actualEndDate", column="actual_end_date")})
    List<TaskModel> findAllTasks();

    @Select("SELECT * FROM task_view WHERE task_id = #{id}")
    @Results(value = {
            @Result(property="id", column="task_id"),
            @Result(property="activityId", column="task_activity_id"),
            @Result(property="name", column="task_name"),
            @Result(property="dateTimeId", column="date_time_id"),
            @Result(property="plannedStartDate", column="planned_start_date"),
            @Result(property="actualStartDate", column="actual_start_date"),
            @Result(property="deadline", column="deadline"),
            @Result(property="actualEndDate", column="actual_end_date"),
            @Result(property="subTasks", javaType=List.class, column="id",
                    many=@Many(select="findTasksBySubProjectId"))})
    TaskModel findById(long id);

    @Delete("DELETE FROM task WHERE task_id = #{id}")
    int deleteById(long id);

    @Insert("INSERT INTO task (task_id, activity_id) VALUES (#{id}, #{activityId})")
    @Options(useGeneratedKeys = true, keyColumn = "task_id", keyProperty = "id")
    void createTask(TaskModel taskModel);

    @Insert("INSERT INTO task_subtask (task_id, subtask_id) VALUES (#{taskModel.id}, #{subTaskModel.id})")
    void addSubTaskToTask(TaskModel taskModel, SubTaskModel subTaskModel);

    @Select("SELECT * FROM subtask_view sv INNER JOIN task_subtask ts ON sv.subtask_id=ts.subtask_id WHERE task_id = #{id}")
    List<SubTaskModel> findSubTasksByTaskId(long id);
}
