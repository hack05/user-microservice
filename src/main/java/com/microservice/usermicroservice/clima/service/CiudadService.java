package com.microservice.usermicroservice.clima.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.usermicroservice.clima.entity.Ciudad;
import com.microservice.usermicroservice.clima.models.Weather;
import com.microservice.usermicroservice.clima.repository.ICiudadRepository;

@Service
public class CiudadService {

	@Autowired
	ICiudadRepository iCiudadRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public Ciudad getCityById(Long id) {
		return iCiudadRepository.findById(id).orElse(null);
	}
	
	@SuppressWarnings("unchecked")
	public Optional<Weather> getByCityName(String cityName) {
		Optional<Weather> weather = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q="+cityName+"&appid=dc3efb030f8eca89ffdf7f379b630afd", Optional.class);
		return weather;
	}
	
	public Optional<Ciudad> getOne(Long id){
		return iCiudadRepository.findById(id);
	}
	
	public List<Ciudad> list(){
		return iCiudadRepository.findAll();
	}
	
	public boolean existsById(Long id) {
		return iCiudadRepository.existsById(id);
	}
	
	public boolean existsByCityName(String cityName) {
		return iCiudadRepository.existsByCityName(cityName);
	}
	
	public void save(Ciudad cityName) {
		iCiudadRepository.save(cityName);
	}
	
	//relacion de ciudad para obtener una temperatura
	
	public List<Ciudad> findAllByTemp (Long id){
		List<Ciudad> ciudadRespuesta = new ArrayList<>();
		List<Ciudad> ciudad = iCiudadRepository.findAll();
		for(int i=0; i<ciudad.size(); i++) {
			if(ciudad.get(i).getTemperatura().getId()==id) {
				ciudadRespuesta.add(ciudad.get(i));
			}
		}
		return ciudadRespuesta;
		
		}
}
