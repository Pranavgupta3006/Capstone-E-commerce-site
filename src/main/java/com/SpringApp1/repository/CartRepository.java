package com.SpringApp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringApp1.model.CartItem;

public interface CartRepository extends JpaRepository<CartItem, Integer> {

}
