package com.SpringApp1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringApp1.model.Products;

public interface ProductRepository extends JpaRepository<Products, Integer>{

	List<Products> findAllByCategory_Id(int id);
}
