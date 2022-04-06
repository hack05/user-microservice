package com.microservice.usermicroservice.user.entity;

import java.awt.geom.Point2D;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.microservice.usermicroservice.clima.entity.Ciudad;
import com.microservice.usermicroservice.music.entity.Genre;

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
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="ciudad_id")
	private Ciudad ciudad;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="genre_id")
	private Genre genre;
	
	//private Point2D coordinates;
	
	private static final long serialVersionUID = -8215972918864845232L;
}
