package com.microservice.usermicroservice.clima.dto;

import java.awt.geom.Point2D;
import java.util.List;

import com.microservice.usermicroservice.clima.entity.Temperatura;
import com.microservice.usermicroservice.user.entity.User;

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
public class CiudadDto {

	private String cityName;
	private Temperatura temperatura;
	private List<User> user;
	
}
