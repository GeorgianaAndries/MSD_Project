package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
    
	
	public UserService(UserRepository userRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	
	public List<UserDto> getAllUsers(){
		return userRepository.findAll().stream().map(this::transformToDto).collect(Collectors.toList());
	}

 
	public User save(UserDto userDto){
	    User user = modelMapper.map(userDto,User.class);
	    userRepository.save(user);
	    return user;
	}
	

	public void delete(int id){
	     userRepository.deleteById(id);
	}
	
	
	public void update(UserDto userDto){
		userRepository.updateUser(userDto.getName(),userDto.getId());
	}
	
 
	public UserDto getUserValidation(String email, String password){
		User user = userRepository.findByEmailAndPassword(email, password);
		return transformToDto(user);
	}
	

	private UserDto transformToDto(User user){
		return modelMapper.map(user,UserDto.class);
	}
}
