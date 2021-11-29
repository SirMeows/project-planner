package dk.kea.projectplanner.repositories;

import dk.kea.projectplanner.models.ProjectModel;
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
    List<ProjectModel> findAllProjects();

    @Select("SELECT * FROM project_view WHERE project_id = #{id}")
    @Results(value = {
            @Result(property="id", column="project_id"),
            @Result(property="activityId", column="project_activity_id"),
            @Result(property="name", column="project_name"),
            @Result(property="dateTimeId", column="date_time_id"),
            @Result(property="plannedStartDate", column="planned_start_date"),
            @Result(property="actualStartDate", column="actual_start_date"),
            @Result(property="deadline", column="deadline"),
            @Result(property="actualEndDate", column="actual_end_date")})
    ProjectModel findById(long id);

    @Delete("DELETE FROM project WHERE project_id = #{id}")
    int deleteById(long id);

    @Update("UPDATE date_time SET planned_start_date = #{plannedStartDate} WHERE date_time_id = #{id}")
    int updatePlannedStartDate(ProjectModel projectModel);

    @Update("UPDATE date_time SET actual_start_date = #{actualStartDate} WHERE date_time_id = #{id}")
    int updateActualStartDate(ProjectModel projectModel);

    @Update("UPDATE date_time SET deadline = #{deadline} WHERE date_time_id = #{id}")
    int updateDeadline(ProjectModel projectModel);

    @Update("UPDATE date_time SET actual_end_date = #{actualEndDate} WHERE date_time_id = #{id}")
    int updateActualEndDate(ProjectModel projectModel);
}
