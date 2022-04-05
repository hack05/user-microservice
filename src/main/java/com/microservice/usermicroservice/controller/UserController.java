package com.microservice.usermicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.usermicroservice.entity.User;
import com.microservice.usermicroservice.model.Spotify;
import com.microservice.usermicroservice.service.UserService;

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
	
	
	
	@GetMapping("/spotify/all")
	public ResponseEntity<List<Spotify>> getAllGenre(){
		List<Spotify> genre = userService.getAllGenre();
		if(genre==null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(genre);
	}
	
	
	@GetMapping("/spotify/{clientId}")
	public ResponseEntity<List<Spotify>> getGenre(@PathVariable("clientId") String clientId){
		User user = userService.getUserById(clientId);
		if(user == null)
			return ResponseEntity.notFound().build();
		List<Spotify> genre = userService.getGenre(clientId);
		return ResponseEntity.ok(genre);
	}

}
