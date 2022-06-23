package com.SpringApp1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringApp1.model.Products;
import com.SpringApp1.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	public List<Products> getAllProduct()
	{
		return productRepository.findAll();
	}
	
	public void addProduct(Products product)
	{
		productRepository.save(product);
	}
	
	public void removeProductById(Integer id)
	{
		productRepository.deleteById(id);
	}
	
	public Optional<Products> getProductById(Integer id)
	{
		return productRepository.findById(id);
	}
	
	public List<Products> getAllProductsByCategoryId(int id)
	{
		return productRepository.findAllByCategory_Id(id);
	}

}
