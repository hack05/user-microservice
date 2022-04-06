package com.microservice.usermicroservice.music.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.microservice.usermicroservice.music.entity.Track;
import com.microservice.usermicroservice.music.repository.ITrackRepository;

@Service
public class TrackService {

	@Autowired
	ITrackRepository iTrackRepository;

	@Autowired
	RestTemplate restTemplate;

	public Track getTrackById(Long id) {
		return iTrackRepository.findById(id).orElse(null);
	}

	public Optional<Track> getByTrackName(String trackName) {
		
		return iTrackRepository.findByTrackName(trackName);
	}

	public Optional<Track> getOne(Long id) {
		return iTrackRepository.findById(id);
	}

	public List<Track> list() {
		return iTrackRepository.findAll();
	}

	public boolean existsById(Long id) {
		return iTrackRepository.existsById(id);
	}

	public boolean existsByTrackName(String track) {
		return iTrackRepository.existsByTrackName(track);
	}

	public void save(Track track) {
		iTrackRepository.save(track);
	}

	// listado de canciones por temp

	public List<Track> findAllByTemp(Long id) {

		List<Track> tracksLista = new ArrayList<>();
		List<Track> track = iTrackRepository.findAll();
		for (int i = 0; i < track.size(); i++) {
			if (track.get(i).getTemperatura().getId() == id) {
				tracksLista.add(track.get(i));
			}
		}
		return tracksLista;
	}
	
	// listado de canciones por Genero
	
	public List<Track> findAllByGenre(Long id) {

		List<Track> tracksLista = new ArrayList<>();
		List<Track> track = iTrackRepository.findAll();
		for (int i = 0; i < track.size(); i++) {
			if (track.get(i).getGenre().getId() == id) {
				tracksLista.add(track.get(i));
			}
		}
		return tracksLista;
	}

}
