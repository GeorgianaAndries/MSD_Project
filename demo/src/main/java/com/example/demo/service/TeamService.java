package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;
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
		this.teamRepository = teamRepository;
		this.modelMapper = modelMapper;
	}
	
	public List<TeamDto> getAllTeams(){
		return teamRepository.findAll().stream().map(this::transformToDto).collect(Collectors.toList());
	}

    
	public Team save(TeamDto teamDto){
	    Team team = modelMapper.map(teamDto, Team.class);
	    teamRepository.save(team);
	    return team;
	}

	
	public List<String> getAllTeamNames(){
		List<Team> teams = teamRepository.findAll();
		List<String> result = newArrayList();
		teams.forEach(team->{
			result.add(team.getTeamName());
		});
		
		return result;
	}
	
	
	public void delete(int id){
	     teamRepository.deleteById(id);
	}

	
	public void update(TeamDto teamDto){
		Team team = transformToModel(teamDto);
		teamRepository.save(team);
	}
	
	
	private TeamDto transformToDto(Team team){
			return modelMapper.map(team,TeamDto.class);
	}
	
	
	private Team transformToModel(TeamDto teamDto){
			return modelMapper.map(teamDto, Team.class);
	}
    
}
