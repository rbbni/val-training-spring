package com.example.valtrainingspring.repository.custom;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.valtrainingspring.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
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

}
