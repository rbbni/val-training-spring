package com.example.valtrainingspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.valtrainingspring.model.Token;
import com.example.valtrainingspring.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, CustomUserRepository{
	@Query(value = "SELECT * FROM Users WHERE Users.mail = ?1 and Users.password = ?2")
	User login(String mail, String password);
	User findByToken(String token);
}