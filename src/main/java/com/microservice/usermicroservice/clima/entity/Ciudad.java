package com.microservice.usermicroservice.clima.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
@Entity
public class Ciudad implements Serializable{

	@Id
	private Long id;
	@Column(unique = true, nullable = false)
	private String cityName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "temperatura_id")
	private Temperatura temperatura;
	
	@OneToMany(mappedBy = "ciudad")
	private List<User> user;
	
	
	
	private static final long serialVersionUID = -2756138833963386926L;
	
}
