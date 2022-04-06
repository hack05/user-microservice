package com.microservice.usermicroservice.music.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.usermicroservice.music.entity.Genre;

@Repository
public interface IGenreRepository extends JpaRepository<Genre, Long>{

	Optional<Genre> findByName(String name);
	boolean existsByName(String name);
	
}
