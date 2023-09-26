package com.example.valtrainingspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.valtrainingspring.model.User;
import com.example.valtrainingspring.repository.custom.CustomUserRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, CustomUserRepository {

}
