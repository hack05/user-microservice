package com.microservice.usermicroservice.user.dto;


import java.awt.geom.Point2D;

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
public class UserDto {

	private String name;
	private String email;
	
	private Ciudad ciudad;
	private Genre genre;
	//private Point2D coordinates;
}
