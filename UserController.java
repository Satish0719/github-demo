package com.user.service.userService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.userService.entities.User;
import com.user.service.userService.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		User user1=userService.SaveUser(user);
		System.out.println("user details "+user1);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	
	@GetMapping("/{user_id}")
	public ResponseEntity<User>getsingleUser(@PathVariable String user_id){
		User user=userService.getUser(user_id);
		
		return ResponseEntity.ok(user);
	}
		
	@GetMapping
	public ResponseEntity<List<User>>getAllUsers(){
		List <User>allUser=userService.getAllUser();
		
		return ResponseEntity.ok(allUser);
	}

}
