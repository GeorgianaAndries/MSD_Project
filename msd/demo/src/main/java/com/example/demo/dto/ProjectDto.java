package com.example.demo.dto;

public class ProjectDto {
	private int id;
	private String projectName;
	
	public ProjectDto() {
	}
	/*
	public ProjectDto(int id, String projectName) {
		super();
		this.id = id;
		this.projectName = projectName;
	}*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
}
