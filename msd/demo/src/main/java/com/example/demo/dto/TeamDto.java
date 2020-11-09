package com.example.demo.dto;

public class TeamDto {
	private int id;
	private int projectId;
	private String teamName;
	
	public TeamDto() {
		
	}
	public TeamDto(int id, int projectId, String teamName) {
		this.id = id;
		this.projectId = projectId;
		this.teamName = teamName;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	
	
	
	
}
