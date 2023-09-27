package com.example.valtrainingspring.repository;

import java.util.List;

import com.example.valtrainingspring.model.User;

public interface CustomUserRepository {
	public User findByMail(String mail);
	
	public List<User> findMailByJobLevelIfEvaluator(String jobLevel);
}
