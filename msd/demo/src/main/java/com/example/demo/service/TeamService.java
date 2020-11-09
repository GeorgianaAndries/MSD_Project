package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TeamDto;
import com.example.demo.model.Team;
import com.example.demo.repository.TeamRepository;

@Service
public class TeamService {
	private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;
    
	public TeamService(TeamRepository teamRepository, ModelMapper modelMapper) {
		super();
		this.teamRepository = teamRepository;
		this.modelMapper = modelMapper;
	}
	
	public List<TeamDto> getAllTeams(){
        return teamRepository.findAll().stream().map(this::transformToDto).collect(Collectors.toList());
    }
	
	public Team getTeamById (int id){
        return teamRepository.findById(id).get();
    }

	public Team save(TeamDto teamDto){
	    Team team = modelMapper.map(teamDto, Team.class);
	    teamRepository.save(team);
	    return team;
	}

	public void delete(int id){
	     teamRepository.deleteById(id);
	}

	public void update(TeamDto teamDto){
	     teamRepository.updateTeam(teamDto.getTeamName(),teamDto.getId());
	}
	 public TeamDto transformToDto(Team team){
	        return modelMapper.map(team,TeamDto.class);

	    }
    
}
