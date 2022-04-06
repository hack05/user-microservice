package com.microservice.usermicroservice.music.dto;

import java.util.List;

import com.microservice.usermicroservice.music.entity.Track;

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
public class GenreDto {

	private String name;
	private List<Track> list;
}
