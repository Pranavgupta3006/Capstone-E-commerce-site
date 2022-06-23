package com.SpringApp1;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.SpringApp1.model.CartItem;
import com.SpringApp1.repository.CartRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CartRepositoryTests {
	
		@Autowired
		private CartRepository repo;
		
		@Test
		public void testAddNew() {
			CartItem cart = new CartItem();
			cart.setId(1);
			cart.setProduct_id(2);
			cart.setUserid(1);
		
			
			
			CartItem savedCartItem = repo.save(cart);
			
			Assertions.assertThat(savedCartItem).isNotNull();
			Assertions.assertThat(savedCartItem.getId()).isGreaterThan(0);
		}
		
		@Test
		public void testListAll() {
			Iterable<CartItem> carts = repo.findAll();
			Assertions.assertThat(carts).hasSizeGreaterThan(0);
			
			for(CartItem cart : carts) {
				System.out.println(cart);
			}
		}
		
		
		
		@Test
		public void testGet() {
			Integer id = 2;
			Optional<CartItem> optionalCartItem = repo.findById(id);
			Assertions.assertThat(optionalCartItem).isPresent();
			System.out.println(optionalCartItem.get());
		}
		
		@Test
		public void testDelete() {
			Integer id = 2;
			repo.deleteById(id);
			
			Optional<CartItem> optionalCartItem = repo.findById(id);
			Assertions.assertThat(optionalCartItem).isNotPresent();
		}

}
