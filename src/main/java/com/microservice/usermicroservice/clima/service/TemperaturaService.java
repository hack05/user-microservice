package com.microservice.usermicroservice.clima.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.usermicroservice.clima.entity.Temperatura;
import com.microservice.usermicroservice.clima.repository.ITemperaturaRepository;


@Service
public class TemperaturaService {

	@Autowired
	ITemperaturaRepository iTemperaturaRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public Temperatura getGenreById(Long id) {
		return iTemperaturaRepository.findById(id).orElse(null);
	}
	
	public Optional<Temperatura> getByTemp(Double temp) {
		return iTemperaturaRepository.findByTemp(temp);
	}
	
	public Optional<Temperatura> getOne(Long id){
		return iTemperaturaRepository.findById(id);
	}
	
	public List<Temperatura> list(){
		return iTemperaturaRepository.findAll();
	}
	
	public boolean existsById(Long id) {
		return iTemperaturaRepository.existsById(id);
	}
	
	public boolean existsByTemp(Double temp) {
		return iTemperaturaRepository.existsByTemp(temp);
	}
	
	public void save(Temperatura temp) {
		iTemperaturaRepository.save(temp);
	}
	
}
