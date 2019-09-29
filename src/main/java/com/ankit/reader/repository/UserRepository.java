package com.ankit.reader.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ankit.reader.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	Optional<User> findByEmail(String email);
	
Optional<User> findById(Long userId);
	
	boolean existsByEmail(String email);

}
