package com.microservice.usermicroservice.clima.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.usermicroservice.clima.entity.Ciudad;
import com.microservice.usermicroservice.clima.models.Weather;
import com.microservice.usermicroservice.clima.service.CiudadService;
import com.microservice.usermicroservice.mensajes.Mensaje;

@RestController
@RequestMapping("/ciudad")
public class CiudadController {
	
	@Autowired
	CiudadService ciudadService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Ciudad>> list(){
		List<Ciudad> list = ciudadService.list();
		return new ResponseEntity<List<Ciudad>>(list, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/{id}")
	public ResponseEntity<Ciudad> getById(@PathVariable("id") Long id){
		if(!ciudadService.existsById(id))
			return new ResponseEntity(new Mensaje("Ciudad no existe"), HttpStatus.NOT_FOUND);
		Ciudad ciudad = ciudadService.getOne(id).get();
		return new ResponseEntity<Ciudad>(ciudad, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@GetMapping("/{cityName}")
	public ResponseEntity<Ciudad> getByCityName(@PathVariable("cityName") String cityName){
		if(!ciudadService.existsByCityName(cityName))
			return new ResponseEntity(new Mensaje("La ciudad no existe"), HttpStatus.NOT_FOUND);
		Optional<Weather> ciudad = ciudadService.getByCityName(cityName);
		return new ResponseEntity<Ciudad>(HttpStatus.OK);
	}
	
	

}
