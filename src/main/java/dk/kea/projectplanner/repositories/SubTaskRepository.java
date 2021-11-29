package dk.kea.projectplanner.repositories;

import dk.kea.projectplanner.models.SubTaskModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SubTaskRepository {

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
}
