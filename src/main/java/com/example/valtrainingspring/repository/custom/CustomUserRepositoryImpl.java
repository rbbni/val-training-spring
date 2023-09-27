package com.example.valtrainingspring.repository.custom;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.valtrainingspring.model.User;

import jakarta.persistence.criteria.Expression;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CustomUserRepositoryImpl implements CustomUserRepository {
	@Autowired
	EntityManager entityManager;

	@Override
	public User findByMailCustom(String mail) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);

		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("mail"), mail));

		return entityManager.createQuery(criteriaQuery).getSingleResult();
	}

	@Override
	// prima lettera del nome e ultima del cognome

	public String findMailByJobLevelIfEvaluator(String jobLevel) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);

		Predicate isEvaluator = criteriaBuilder.equal(root.get("evalutator"), 1);
		Predicate byJobLevel = criteriaBuilder.equal(root.get("job_level"), jobLevel);

		jakarta.persistence.criteria.Expression<String> penultimateLetterExpression = criteriaBuilder.substring(root.get("surname"),
				
				
				root.ge,
				
				1);

		criteriaQuery.select(root).where(isEvaluator, byJobLevel).orderBy(criteriaBuilder.asc(root.get("name")),
				criteriaBuilder.asc(root.get("surname")));

		return null;
	}

}
