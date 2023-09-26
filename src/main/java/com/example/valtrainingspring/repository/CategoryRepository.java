package com.example.valtrainingspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.valtrainingspring.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
