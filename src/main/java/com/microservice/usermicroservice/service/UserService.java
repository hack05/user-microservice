package com.microservice.usermicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.usermicroservice.entity.User;
import com.microservice.usermicroservice.model.Spotify;
import com.microservice.usermicroservice.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	public User getUserById(String id) {
		return userRepository.findById(id).orElse(null);
	}
	
	@SuppressWarnings("unchecked")
	public List<Spotify> getAllGenre(){
		List<Spotify> spotify = restTemplate.getForObject("https://api.spotify.com/v1/recommendations/available-genre-seeds", List.class);
		return spotify;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Spotify> getGenre(String clientId){
		List<Spotify> spotify = restTemplate.getForObject("https://api.spotify.com/v1/recommendations/available-genre-seeds" + clientId, List.class);
		return spotify;
		
	}
	

/*	
	@SuppressWarnings("unchecked")
	public List<Weather> getWeather(Long id){
		List<Weather> weather = 
				restTemplate.getForObject
				("https://api.openweathermap.org/data/2.5/weather?q={city name}&appid=" + id, List.class);
		return weather;
		
	}*/
	

}
