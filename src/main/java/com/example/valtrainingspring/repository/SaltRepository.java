package com.example.valtrainingspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.valtrainingspring.model.Salt;

@Repository
public interface SaltRepository extends JpaRepository<Salt, Long>{

}
