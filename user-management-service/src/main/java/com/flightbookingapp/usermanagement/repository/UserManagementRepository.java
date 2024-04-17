package com.flightbookingapp.usermanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightbookingapp.usermanagement.model.User;

@Repository
public interface UserManagementRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByEmail(String email);

}
