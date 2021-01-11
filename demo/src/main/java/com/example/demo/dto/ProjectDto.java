package com.example.demo.dto;

import com.example.demo.model.Intern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProjectDto {
	private int id;
	
	private String projectName;
	
	private String startDate;
	
	private String endDate;
	
	private String client;
	
	private String team;
	
	private Double salary;
	
}