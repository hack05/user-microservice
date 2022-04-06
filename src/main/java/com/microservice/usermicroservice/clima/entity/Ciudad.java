package com.microservice.usermicroservice.clima.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Ciudad {

	@Id
	private Long id;
	private String cityName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "temperatura_id")
	private Temperatura temperatura;
}
