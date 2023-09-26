package com.example.valtrainingspring.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.valtrainingspring.model.User;

import jakarta.persistence.*;
import jakarta.persistence.criteria.*;

public class CustomUserRepositoryImpl implements CustomUserRepository{
	
	@Autowired
	private EntityManager em;
	
	@Override
	public User findByMail(String mail) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		
		Predicate hasMail = builder.equal(root.get("mail"), mail);
		
		query.where(hasMail);
		
		return em.createQuery(query.select(root)).getSingleResult();
	}

}
