package dk.kea.projectplanner.repositories;

import dk.kea.projectplanner.models.ProjectModel;
import dk.kea.projectplanner.models.SubProjectModel;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional
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
            @Result(property="actualEndDate", column="actual_end_date"),
            @Result(property="subProjects", javaType=List.class, column="id",
                    many=@Many(select="findSubProjectsByProjectId"))})
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
            @Result(property="actualEndDate", column="actual_end_date"),
            @Result(property="subProjects", javaType=List.class, column="id",
                    many=@Many(select="findProjectsByProjectId"))})
    ProjectModel findById(long id);

    @Delete("DELETE FROM project WHERE project_id = #{id}")
    int deleteById(long id);

    @Update("UPDATE date_time SET planned_start_date = #{plannedStartDate} WHERE date_time_id = #{dateTimeId}")
    int updatePlannedStartDate(ProjectModel projectModel);

    @Update("UPDATE date_time SET actual_start_date = #{actualStartDate} WHERE date_time_id = #{dateTimeId}")
    int updateActualStartDate(ProjectModel projectModel);

    @Update("UPDATE date_time SET deadline = #{deadline} WHERE date_time_id = #{dateTimeId}")
    int updateDeadline(ProjectModel projectModel);

    @Update("UPDATE date_time SET actual_end_date = #{actualEndDate} WHERE date_time_id = #{dateTimeId}")
    int updateActualEndDate(ProjectModel projectModel);

    @Insert("INSERT INTO date_time (date_time_id, planned_start_date, actual_start_date, deadline, actual_end_date)" +
            "VALUES (#{dateTimeId}, #{plannedStartDate}, #{actualStartDate}, #{deadline}, #{actualEndDate})")
    @Options(useGeneratedKeys = true, keyColumn = "date_time_id", keyProperty = "dateTimeId")
    void createDateTime(ProjectModel projectModel);

    @Insert("INSERT INTO activity (activity_id, name, date_time_id) VALUES (#{activityId}, #{name}, #{dateTimeId});")
    @Options(useGeneratedKeys = true, keyColumn = "activity_id", keyProperty = "activityId")
    void createActivity(ProjectModel projectModel);

    @Insert("INSERT INTO project (project_id, activity_id) VALUES (#{id}, #{activityId})")
    @Options(useGeneratedKeys = true, keyColumn = "project_id", keyProperty = "id")
    void createProject(ProjectModel projectModel);

    @Insert("INSERT INTO project_subproject (project_id, subproject_id) VALUES (#{projectModel.id}, #{subProjectModel.id})")
    void addSubProjectToProject(ProjectModel projectModel, SubProjectModel subProjectModel);

    @Select("SELECT * FROM subproject_view sv INNER JOIN project_subproject ps ON sv.subproject_id=ps.subproject_id WHERE project_id = #{id}")
    List<SubProjectModel> findSubProjectsByProjectId(long id);
    // return map instead, change from List to Map in findById, find out how this works in ibatis(?), change in class
}
