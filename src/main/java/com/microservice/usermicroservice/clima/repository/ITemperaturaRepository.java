package com.microservice.usermicroservice.clima.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.microservice.usermicroservice.clima.entity.Temperatura;


@Repository
public interface ITemperaturaRepository extends JpaRepository<Temperatura, Long>{

	Optional<Temperatura> findByTemp(Double temp);
	boolean existsByTemp(Double temp);
}
