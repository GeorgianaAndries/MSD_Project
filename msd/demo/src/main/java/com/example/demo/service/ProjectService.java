package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProjectDto;
import com.example.demo.model.Project;
import com.example.demo.service.ProjectService;

import com.example.demo.repository.ProjectRepository;

@Service
public class ProjectService {
	private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;
    
	public ProjectService(ProjectRepository projectRepository, ModelMapper modelMapper) {
		this.projectRepository = projectRepository;
		this.modelMapper = modelMapper;
	}
    
	public List<ProjectDto> getAllProjects(){
        return projectRepository.findAll().stream().map(this::transformToDto).collect(Collectors.toList());
    }

    public Project save(ProjectDto projectDto){
        Project project = modelMapper.map(projectDto, Project.class);
        projectRepository.save(project);
        return project;
    }

    public void delete(int id){
        projectRepository.deleteById(id);
    }

    public void update(ProjectDto projectDto){
        projectRepository.updateProject(projectDto.getProjectName(),projectDto.getId());
    }

    public Project getProjectById (int id){
        return projectRepository.findById(id).get();
    }

    public ProjectDto transformToDto(Project source){
        return modelMapper.map(source,ProjectDto.class);

    }
}


