package com.microservice.usermicroservice.music.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservice.usermicroservice.mensajes.Mensaje;
import com.microservice.usermicroservice.music.entity.Track;
import com.microservice.usermicroservice.music.service.TrackService;

@RestController
@RequestMapping("/musica/canciones")
public class TrackController {

	@Autowired
	TrackService trackService;
	
	@GetMapping("/track/lista")
	public ResponseEntity<List<Track>> list(){
		List<Track> list = trackService.list();
		return new ResponseEntity<List<Track>>(list, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/track/{id}")
	public ResponseEntity<Track> getById(@PathVariable("id") Long id){
		if(!trackService.existsById(id))
			return new ResponseEntity(new Mensaje("Track no encontrado"), HttpStatus.NOT_FOUND);
		Track track = trackService.getOne(id).get();
		return new ResponseEntity<Track>(track, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/trackname/{trackName}")
	public ResponseEntity<Track> getByTrackName(@PathVariable("trackName") String trackName){
		if(!trackService.existsByTrackName(trackName))
			return new ResponseEntity(new Mensaje("Track no existe"), HttpStatus.NOT_FOUND);
		Track track= trackService.getByTrackName(trackName).get();
		return new ResponseEntity<Track>(track, HttpStatus.OK);
		
	}
	
	/*@GetMapping("/track/{id}")
	public ResponseEntity<List<Track>> getAllTracksByGenre(@PathVariable("id")Long idGenre){
		return ResponseEntity.ok(trackService.findAllByGenre(idGenre));
	}*/
}
