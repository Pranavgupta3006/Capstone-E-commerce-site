package com.SpringApp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringApp1.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
