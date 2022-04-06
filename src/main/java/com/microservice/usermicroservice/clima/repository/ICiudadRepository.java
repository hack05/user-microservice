package com.microservice.usermicroservice.clima.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.usermicroservice.clima.entity.Ciudad;

@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Long>{

	Optional<Ciudad> findByCityName(String cityName);
	boolean existsByCityName(String cityName);
}
