package com.example.valtrainingspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.valtrainingspring.model.User;
import com.example.valtrainingspring.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User findByMail(String mail) {
		return userRepository.findByMail(mail);
	}

}
