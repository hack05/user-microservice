package com.microservice.usermicroservice.clima.dto;



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
public class TemperaturaDto {

	private Double temp;
	private Genre genre;
}
