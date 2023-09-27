package com.example.valtrainingspring.repository;

import java.util.List;

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

	@Override
	public List<User> findMailByJobLevelIfEvaluator(String jobLevel) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		
		Predicate hasJobLevel = builder.equal(root.get("job_level"), jobLevel);
		Predicate ifEvaluator = builder.equal(root.get("evalutator"), 1);
		
		Path<String> surname = root.get("surname");
		Order order = builder.asc(builder.substring(surname, 
				surname.toString().charAt(surname.toString().length()-2), 1));
		
		query.where(builder.and(hasJobLevel, ifEvaluator)).orderBy(order);
		
		return em.createQuery(query.select(root)).getResultList();
	}

}
