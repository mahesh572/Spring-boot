package com.mayuktha.userregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayuktha.userregistration.entity.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer>{

	List<User> findByEmailAddress(String emailAddress);
	
	
}
