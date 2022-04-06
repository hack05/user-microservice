package com.microservice.usermicroservice.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.usermicroservice.user.entity.User;
import com.microservice.usermicroservice.user.repository.IUserRepository;


@Service
public class UserService {
	
	@Autowired
	IUserRepository iUserRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<User> getAll(){
		return iUserRepository.findAll();
	}
	
	public User getUserById(String id) {
		return iUserRepository.findById(id).orElse(null);
	}
	
	
}
