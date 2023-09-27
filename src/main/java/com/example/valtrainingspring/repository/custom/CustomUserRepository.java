package com.example.valtrainingspring.repository.custom;

import com.example.valtrainingspring.model.User;

public interface CustomUserRepository {

	public User findByMailCustom(String mail); 
	
	//prima lettera del nome e ultima del cognome
	public String findMailByJobLevelIfEvaluator(String jobLevel);

}
