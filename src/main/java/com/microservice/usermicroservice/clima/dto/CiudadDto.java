package com.microservice.usermicroservice.clima.dto;


import com.microservice.usermicroservice.clima.entity.Temperatura;

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
}
