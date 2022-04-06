package com.microservice.usermicroservice.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.usermicroservice.user.entity.User;
import com.microservice.usermicroservice.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getAll(){
		List<User> users = userService.getAll();
		if(users.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable("id") String cliendId){
		User user = userService.getUserById(cliendId);
		if(user == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(user);
	}
	

}
