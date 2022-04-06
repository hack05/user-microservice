package com.microservice.usermicroservice.clima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.usermicroservice.clima.entity.Temperatura;
import com.microservice.usermicroservice.clima.service.TemperaturaService;
import com.microservice.usermicroservice.mensajes.Mensaje;


@RestController
@RequestMapping("/temperatura")
public class TemperaturaController {

	@Autowired
	TemperaturaService temperaturaService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Temperatura>> list(){
		List<Temperatura> list = temperaturaService.list();
		return new ResponseEntity<List<Temperatura>>(list, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/temperatura-actual/{id}")
	public ResponseEntity<Temperatura> getById(@PathVariable("id") Long id){
		if(!temperaturaService.existsById(id))
			return new ResponseEntity(new Mensaje("Temperatura no existe"), HttpStatus.NOT_FOUND);
		Temperatura temperatura = temperaturaService.getOne(id).get();
		return new ResponseEntity<Temperatura>(temperatura, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/temperatura-actual/{temp}")
	public ResponseEntity<Temperatura> getByPlan(@PathVariable("temp") Double temp){
		if(!temperaturaService.existsByTemp(temp))
			return new ResponseEntity(new Mensaje("Temperatura no resgitrada"), HttpStatus.NOT_FOUND);
		if(temp.equals(300.00))
			return new ResponseEntity(new Mensaje("Musica para la fiesta"), HttpStatus.OK);
		if(temp >= 150.00 && temp < 300.00)
			return new ResponseEntity(new Mensaje("Musica Pop"), HttpStatus.OK);
		if(temp >= 100.00 && temp <= 140.00)
			return new ResponseEntity(new Mensaje("Musica Rock"), HttpStatus.OK);
		if(temp < 100.00)
			return new ResponseEntity(new Mensaje("Musica Clasica"), HttpStatus.OK);
		Temperatura temperatura = temperaturaService.getByTemp(temp).get();
		return new ResponseEntity<Temperatura>(temperatura, HttpStatus.OK);
	}
	
	
}
