//package com.example.demo;
//
//import com.example.demo.model.Intern;
//import com.example.demo.model.Project;
//import com.example.demo.model.Team;
//import com.example.demo.repository.InternRepository;
//import com.example.demo.repository.ProjectRepository;
//import com.example.demo.repository.TeamRepository;
//import com.example.demo.service.InternService;
//import com.example.demo.service.ProjectService;
//import com.example.demo.service.TeamService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.io.File;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.springframework.boot.test.context.SpringBootTest.*;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class DemoApplicationTests {
//
//	@Autowired
//	ObjectMapper objectMapper;
//
//	@MockBean
//	private InternService internService;
//
//	@MockBean
//	private InternRepository internRepository;
//
//	@MockBean
//	private ProjectService projectService;
//
//	@MockBean
//	private ProjectRepository projectRepository;
//
//	@MockBean
//	private TeamService teamService;
//
//	@MockBean
//	private TeamRepository teamRepository;
//
//	@Test
//	public void retrieveIntern() throws Exception {
//		Intern intern = new Intern(1, "Ioana Test", "10/10/2020", "10/01/2021");
//		Mockito.when(internService.getInternById(Mockito.anyInt())).
//				thenReturn(intern);
//
//		Intern found = internService.getInternById(1);
//
//		Intern expected = objectMapper.readValue(new File("src/test/java/com/example/demo/intern.json"), Intern.class);
//
//		assertEquals(expected.getName(), found.getName());
//		assertEquals(expected.getStartDate(), found.getStartDate());
//		assertEquals(expected.getEndDate(), found.getEndDate());
//
//	}
//
//	@Test
//	public void retrieveProject() throws Exception {
//		Project project = new Project(1, "First Project");
//		Mockito.when(projectService.getProjectById(Mockito.anyInt())).
//				thenReturn(project);
//
//		Project found = projectService.getProjectById(1);
//
//		Project expected = objectMapper.readValue(new File("src/test/java/com/example/demo/project.json"), Project.class);
//
//		assertEquals(expected.getProjectName(), found.getProjectName());
//	}
//
//	@Test
//	public void retrieveTeam() throws Exception {
//		Team team = new Team(1, "Team Test", 1);
//		Mockito.when(teamService.getTeamById(Mockito.anyInt())).
//				thenReturn(team);
//
//		Team found = teamService.getTeamById(1);
//
//		Team expected = objectMapper.readValue(new File("src/test/java/com/example/demo/team.json"), Team.class);
//
//		assertEquals(expected.getTeamName(), found.getTeamName());
//		assertEquals(expected.getProjectId(), found.getProjectId());
//	}
//
//}
//
