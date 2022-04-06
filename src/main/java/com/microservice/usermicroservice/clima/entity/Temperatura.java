package com.microservice.usermicroservice.clima.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.microservice.usermicroservice.music.entity.Genre;
import com.microservice.usermicroservice.music.entity.Track;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Temperatura implements Serializable{

	@Id
	private Long id;
	private Double temp;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="genre_id")
	private Genre genre;
	
	@OneToMany(mappedBy = "temperatura")
	private Collection<Track> track;
	
	private static final long serialVersionUID = -7241536462611498490L;
}
