package com.microservice.usermicroservice.clima.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.microservice.usermicroservice.music.entity.Genre;

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
public class Temperatura {

	@Id
	private Long id;
	private Double temp;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="genre_id")
	private Genre genre;
}
