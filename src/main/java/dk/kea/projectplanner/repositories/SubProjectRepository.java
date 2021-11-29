package dk.kea.projectplanner.repositories;

import dk.kea.projectplanner.models.SubProject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SubProjectRepository {

    @Select("SELECT * FROM subproject_view")
    @Results(value = {
            @Result(property="id", column="subproject_id"),
            @Result(property="activityId", column="subproject_activity_id"),
            @Result(property="name", column="subproject_name"),
            @Result(property="dateTimeId", column="date_time_id"),
            @Result(property="plannedStartDate", column="planned_start_date"),
            @Result(property="actualStartDate", column="actual_start_date"),
            @Result(property="deadline", column="deadline"),
            @Result(property="actualEndDate", column="actual_end_date")})
    List<SubProject> findAllSubProjects();
}
