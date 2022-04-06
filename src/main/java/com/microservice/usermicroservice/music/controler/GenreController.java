package com.microservice.usermicroservice.music.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservice.usermicroservice.mensajes.Mensaje;
import com.microservice.usermicroservice.music.entity.Genre;
import com.microservice.usermicroservice.music.service.GenreService;


@RestController
@RequestMapping("/musica/categoria")
@CrossOrigin(origins = "*")
public class GenreController {

	@Autowired
	GenreService genreService;
	
	@GetMapping("/genero/lista")
	public ResponseEntity<List<Genre>> list(){
		List<Genre> list = genreService.list();
		return new ResponseEntity<List<Genre>>(list, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/genero/{id}")
	public ResponseEntity<Genre> getById(@PathVariable("id") Long id){
		if(!genreService.existsById(id))
			return new ResponseEntity(new Mensaje("Genero no registrado"), HttpStatus.NOT_FOUND);
		Genre name = genreService.getOne(id).get();
		return new ResponseEntity<Genre>(name, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/genero-por-nombre/{name}")
	public ResponseEntity<Genre> getByGenre(@PathVariable("name") String name){
		if(!genreService.existsByGenreName(name))
			return new ResponseEntity(new Mensaje("Genero no existe"), HttpStatus.NOT_FOUND);
		Genre genre= genreService.getByGenreName(name).get();
		return new ResponseEntity<Genre>(genre, HttpStatus.OK);
		
	}
	
}
