package com.example.valtrainingspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.valtrainingspring.model.Outcome;

@Repository
public interface OutcomeRepository extends JpaRepository<Outcome, Long> {

}
