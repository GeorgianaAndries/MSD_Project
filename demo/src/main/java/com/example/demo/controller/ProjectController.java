package com.example.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProjectDto;
import com.example.demo.model.Project;
import com.example.demo.service.ProjectService;

@RestController
public class ProjectController {
		private final ProjectService projectService;
		private final ModelMapper modelMapper;
		
		@Autowired
			public ProjectController(ProjectService projectService, ModelMapper modelMapper) {
			this.projectService = projectService;
			this.modelMapper = modelMapper;
		}
		
		@PostMapping("/projects")
			private int saveProject(@RequestBody ProjectDto projectDto){
			Project projectCreated = projectService.save(projectDto);
			ProjectDto project = modelMapper.map(projectCreated, ProjectDto.class);
			return project.getId();
		}
		
		@GetMapping("/project")
		private List<ProjectDto> getProjects(){
				return projectService.getAllProjects();
		}
		
			@GetMapping("/project-by-id/{id}")
		private ProjectDto getProject(int id){
				return projectService.getProject(id);
		}
	
	
		@DeleteMapping("/projects/{project_id}")
		private void deleteProjectById(@PathVariable("project_id") int projectId){
				projectService.delete(projectId);
		}
		
		
		@PutMapping("/project_update")
		private void update(@RequestBody ProjectDto projectDto){
			projectService.update(projectDto);
	}
}

