package com.example.valtrainingspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.valtrainingspring.model.CompetenceField;

@Repository
public interface CompetenceFieldRepository extends JpaRepository<CompetenceField, Long> {

}
