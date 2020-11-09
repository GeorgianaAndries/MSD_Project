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

import com.example.demo.dto.TeamDto;
import com.example.demo.model.Team;
import com.example.demo.service.TeamService;

@RestController
public class TeamController {
	private final TeamService teamService;
	private final ModelMapper modelMapper;
	
	@Autowired
	public TeamController(TeamService teamService, ModelMapper modelMapper) {
		super();
		this.teamService = teamService;
		this.modelMapper = modelMapper;
	}
	
	@GetMapping("/teams")
    private List<TeamDto> getTeams(){
        return teamService.getAllTeams();
    }

    @GetMapping("/team/{team_id}")
    private Team getTeamById(@PathVariable("team_id") int teamId){
        return teamService.getTeamById(teamId);
    }
    
    @DeleteMapping("/team/{team_id}")
    private void deleteTeamById(@PathVariable("team_id") int teamId){
        teamService.delete(teamId);
    }

    @PutMapping("/team_update")
    private void update(@RequestBody TeamDto teamDto){
        teamService.update(teamDto);
    }
    
    @PostMapping("/teams")
    private int saveTeam(@RequestBody TeamDto teamDto){
        Team teamCreated = teamService.save(teamDto);
        TeamDto team = modelMapper.map(teamCreated, TeamDto.class);
        return team.getId();
    }
	
}
