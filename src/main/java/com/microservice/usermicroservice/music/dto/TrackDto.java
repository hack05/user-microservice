package com.microservice.usermicroservice.music.dto;

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
public class TrackDto {

	private String trackName;
	private Genre genre;
}
