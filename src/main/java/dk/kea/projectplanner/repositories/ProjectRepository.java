package dk.kea.projectplanner.repositories;

import dk.kea.projectplanner.models.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectRepository {

    @Select("SELECT * FROM project_view")
    @Results(value = {
            @Result(property="id", column="project_id"),
            @Result(property="activityId", column="project_activity_id"),
            @Result(property="name", column="project_name"),
            @Result(property="dateTimeId", column="date_time_id"),
            @Result(property="plannedStartDate", column="planned_start_date"),
            @Result(property="actualStartDate", column="actual_start_date"),
            @Result(property="deadline", column="deadline"),
            @Result(property="actualEndDate", column="actual_end_date")})
    List<Project> findAllProjects();

    @Select("SELECT * FROM project_view WHERE id = #{id}") //TODO: Is id here parameter from method or column name?
    @Results(value = {
            @Result(property="id", column="project_id"),
            @Result(property="activityId", column="project_activity_id"),
            @Result(property="name", column="project_name"),
            @Result(property="dateTimeId", column="date_time_id"),
            @Result(property="plannedStartDate", column="planned_start_date"),
            @Result(property="actualStartDate", column="actual_start_date"),
            @Result(property="deadline", column="deadline"),
            @Result(property="actualEndDate", column="actual_end_date")})
    Project findById(long id);
}
