package com.microservice.usermicroservice.user.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.usermicroservice.user.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, String>{

	
}
