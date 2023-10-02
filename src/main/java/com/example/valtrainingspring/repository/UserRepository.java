package com.example.valtrainingspring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.valtrainingspring.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByMail(String mail);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String mail);

}
