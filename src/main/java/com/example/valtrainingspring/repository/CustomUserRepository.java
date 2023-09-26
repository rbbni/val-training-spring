package com.example.valtrainingspring.repository;

import com.example.valtrainingspring.model.User;

public interface CustomUserRepository {
	public User findByMail(String mail);
}
