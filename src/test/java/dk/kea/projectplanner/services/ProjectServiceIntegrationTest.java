package dk.kea.projectplanner.services;


import dk.kea.projectplanner.ProjectPlannerApplication;
import dk.kea.projectplanner.models.ProjectModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.AssertTrue;
import java.time.LocalDateTime;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = ProjectPlannerApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:integration-test.properties")
public class ProjectServiceIntegrationTest {

    private static final LocalDateTime BASE_DATE = LocalDateTime.of(2000,10,21,1,0,0);

    @Autowired
    private ProjectService projectService;

    @Before
    public void setUp(){}

    @Test
    @Transactional // Automatically rolls back changes when test is done (fx. removes added row from db)
    public void actualTest(){
        assertNotNull(projectService);
        var projectModel = createProjectModel();

        projectService.createProject(projectModel);

        assertNotEquals("expected id to be set by autoincrement id in database",0,projectModel.getId());
        assertNotEquals("expected id to be set by autoincrement id in database",0,projectModel.getDateTimeId());
        assertNotEquals("expected id to be set by autoincrement id in database",0,projectModel.getActivityId());
    }

    private ProjectModel createProjectModel() {
        var p = new ProjectModel();
        p.setActualEndDate(BASE_DATE);
        p.setActualStartDate(BASE_DATE);
        p.setDeadline(BASE_DATE);
        p.setPlannedStartDate(BASE_DATE);
        p.setName("testprjname");
        return p;
    }

    @After
    public void tearDown(){}

}
