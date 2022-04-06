package com.microservice.usermicroservice.music.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Genre implements Serializable{

	@Id
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "genre", fetch = FetchType.EAGER)
	private List<Track> list;
	
	private static final long serialVersionUID = -438550027517015175L;
}
