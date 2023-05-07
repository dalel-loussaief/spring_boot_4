package com.dalel.vetements.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dalel.vetements.entities.User;

public interface UserRepository  extends JpaRepository<User, Long>{
	User findByUsername (String username);


}
