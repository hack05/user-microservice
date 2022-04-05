package com.microservice.usermicroservice.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.usermicroservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	
}
