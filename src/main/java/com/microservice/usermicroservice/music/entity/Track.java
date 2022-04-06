package com.microservice.usermicroservice.music.entity;

import java.io.Serializable;

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
public class Track implements Serializable{

	@Id
	private Long id;
	private String trackName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "genre_id")
	private Genre genre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "temperatura_id")
	private Temperatura temperatura;
	
	private static final long serialVersionUID = -1560977074883949158L;
}
