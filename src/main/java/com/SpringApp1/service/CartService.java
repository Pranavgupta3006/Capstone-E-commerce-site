package com.SpringApp1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringApp1.exception.CartItemNotFoundException;
import com.SpringApp1.model.CartItem;
import com.SpringApp1.model.Products;
import com.SpringApp1.repository.CartRepository;

@Service
public class CartService {
	@Autowired
	private CartRepository repo;
	
	public static List<Products> cart;
	static {
		cart = new ArrayList<Products>();
	}
	
	public List<CartItem> listAll(){
		return (List<CartItem>) repo.findAll();
	}
	
	
	public void save(CartItem cart) {
		repo.save(cart);
	}
	
	public CartItem get(int id) throws CartItemNotFoundException {
		Optional<CartItem> result = repo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}throw new CartItemNotFoundException("Could Not Find Any CartItem With Id " +id);
		
	}
	
	public void delete(int id) throws CartItemNotFoundException{
		repo.deleteById(id);
	}


	public void save(Products products) {
		// TODO Auto-generated method stub
		
	}
	
	
//	public void addCartItem(CartItem cartitem) {
//		cartRepository.save(cartitem);
//	}
//	
//	public Optional<CartItem> getCartItemById(int id){
//		return cartRepository.findById(id);
//	}
//
//	public void save(CartItem cart) {
//		// TODO Auto-generated method stub
//		
//	}
}
