package com.SpringApp1;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import com.SpringApp1.repository.CouponRepository;
import com.SpringApp1.model.Coupons;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CouponRepositoryTest {

	@Autowired
	private CouponRepository repo;
	
	@Test
	public void testAddNew() {
		Coupons coup = new Coupons();
		coup.setDescription("Offer aviailed on order above 1000Rs only");
		coup.setDiscount_percentage("15");
		coup.setCcode("NIKE15");
		
		Coupons savedCoupons = repo.save(coup);
		
		Assertions.assertThat(savedCoupons).isNotNull();
		Assertions.assertThat(savedCoupons.getCid()).isGreaterThan(0);
	}
	
	@Test
	public void testListAll() {
		Iterable<Coupons> coups = repo.findAll();
		Assertions.assertThat(coups).hasSizeGreaterThan(0);
		
		for(Coupons coup : coups) {
			System.out.println(coup);
		}
	}
	
	@Test
	public void testUpdate() {
		Integer Cid = 1;
		Optional<Coupons> optionalCoupons = repo.findById(Cid);
		Coupons coup = optionalCoupons.get();
		coup.setDiscount_percentage("20");
		repo.save(coup);
		
		Coupons updateCoupons = repo.findById(Cid).get();
		Assertions.assertThat(updateCoupons.getDiscount_percentage()).isEqualTo("20");
	}
	
	@Test
	public void testGet() {
		Integer Cid = 2;
		Optional<Coupons> optionalCoupons = repo.findById(Cid);
		Assertions.assertThat(optionalCoupons).isPresent();
		System.out.println(optionalCoupons.get());
	}
	
	@Test
	public void testDelete() {
		Integer Cid = 2;
		repo.deleteById(Cid);
		
		Optional<Coupons> optionalCoupons = repo.findById(Cid);
		Assertions.assertThat(optionalCoupons).isNotPresent();
	}
}
