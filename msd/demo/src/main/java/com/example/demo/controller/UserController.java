package com.example.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import javax.validation.Valid;

@RestController
public class UserController {
	private final UserService userService;
	private final ModelMapper modelMapper;
	
	@Autowired
	public UserController(UserService userService, ModelMapper modelMapper) {
		super();
		this.userService = userService;
		this.modelMapper = modelMapper;
	}

    @PostMapping("/users")
    private ResponseEntity<String> saveUser(@Valid @RequestBody UserDto userDto){
        User userCreated = userService.save(userDto);
        UserDto user = modelMapper.map(userCreated, UserDto.class);
        return ResponseEntity.ok("User is valid");
    }

	@GetMapping("/users")
    private List<UserDto> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{user_id}")
    private User getUserById(@PathVariable("user_id") int userId){
        return userService.getUserById(userId);
    }
    
    @DeleteMapping("/users/{user_id}")
    private void deleteUserById(@PathVariable("user_id") int userId){
        userService.delete(userId);
    }

    @PutMapping("/user_update")
    private void update(@RequestBody UserDto userDto){
        userService.update(userDto);
    }
	
}

