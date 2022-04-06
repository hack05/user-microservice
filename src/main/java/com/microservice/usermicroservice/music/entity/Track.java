package com.microservice.usermicroservice.music.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.microservice.usermicroservice.clima.entity.Temperatura;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Track {

	@Id
	private Long id;
	private String trackName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "genre_id")
	private Genre genre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "temperatura_id")
	private Temperatura temperatura;
}
