package com.microservice.usermicroservice.music.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.usermicroservice.music.entity.Genre;
import com.microservice.usermicroservice.music.repository.IGenreRepository;
import com.microservice.usermicroservice.musica.model.Spotify;

@Service
@Transactional
public class GenreService {

	@Autowired
	IGenreRepository iGenreRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<Genre> list(){
		return iGenreRepository.findAll();
	}
	
	@SuppressWarnings("unchecked")
	public List<Spotify> getAllMusicGeneros(){
		List<Spotify> spotify = restTemplate.getForObject("https://api.spotify.com/v1/recommendations/available-genre-seeds", List.class);
		return spotify;	
	}
	
	public Genre getGenreById(Long id) {
		return iGenreRepository.findById(id).orElse(null);
	}
	
	public Optional<Genre> getByGenreName(String name) {
		return iGenreRepository.findByName(name);
	}
	
	
	public Optional<Genre> getOne(Long id){
		return iGenreRepository.findById(id);
	}
	
	public boolean existsById(Long id) {
		return iGenreRepository.existsById(id);
	}
	
	public boolean existsByGenreName(String name) {
		return iGenreRepository.existsByName(name);
	}
	
	public void save(Genre genre) {
		iGenreRepository.save(genre);
	}
}
