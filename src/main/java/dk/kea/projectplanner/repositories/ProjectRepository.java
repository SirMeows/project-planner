package dk.kea.projectplanner.repositories;

import dk.kea.projectplanner.models.ProjectModel;
import dk.kea.projectplanner.models.SubProjectModel;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface ProjectRepository extends ActivityRepository<ProjectModel>{

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

    @Insert("INSERT INTO project (project_id, activity_id) VALUES (#{id}, #{activityId})")
    @Options(useGeneratedKeys = true, keyColumn = "project_id", keyProperty = "id")
    void createProject(ProjectModel projectModel);

    @Insert("INSERT INTO project_subproject (project_id, subproject_id) VALUES (#{projectModel.id}, #{subProjectModel.id})")
    void addSubProjectToProject(ProjectModel projectModel, SubProjectModel subProjectModel);

    @Select("SELECT * FROM subproject_view sv INNER JOIN project_subproject ps ON sv.subproject_id=ps.subproject_id WHERE project_id = #{id}")
    List<SubProjectModel> findSubProjectsByProjectId(long id);
}
