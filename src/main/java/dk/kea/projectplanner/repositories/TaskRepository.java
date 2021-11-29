package dk.kea.projectplanner.repositories;

import dk.kea.projectplanner.models.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TaskRepository {

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
    List<Task> findAllTasks();
}
