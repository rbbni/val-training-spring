package com.example.valtrainingspring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.valtrainingspring.model.Token;
import com.example.valtrainingspring.model.User;
import com.example.valtrainingspring.repository.TokenRepository;
import com.example.valtrainingspring.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TokenRepository tokenRepository;
	
	@Autowired
	private Token token;
	
	
	public User findByMail(String mail) {
		return userRepository.findByMail(mail);
	}
	
	public String login(String mail, String password) {
		User user = userRepository.login(mail, password);
		if(user.getId() == null) {
			String tokenString = UUID.randomUUID().toString();
			token.setUser(user);
			token.setTokenValue(tokenString);
			token.setExpirationDate(new Date(85763437858735L));
			tokenRepository.save(token);
			return tokenString;
		}
		return "muito mal";
	}
	
	public List<User> findMailByJobLevelIfEvaluator(String jobLevel) {
		return userRepository.findMailByJobLevelIfEvaluator(jobLevel);
	}
	
	public Optional<User> findByToken(String token) {
		return Optional.of(userRepository.findByToken(token));
	}
}
