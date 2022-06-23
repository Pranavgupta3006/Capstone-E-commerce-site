package com.SpringApp1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringApp1.repository.CouponRepository;
import com.SpringApp1.exception.CouponsNotFoundException;
import com.SpringApp1.model.Coupons;

@Service
public class CouponService {

	@Autowired
	private CouponRepository repo;
	
	public List<Coupons> listAll(){
		return (List<Coupons>) repo.findAll();
	}
	
	public void save(Coupons coup) {
		repo.save(coup);
	}
	
	public Coupons get(int Cid) throws CouponsNotFoundException{
		Optional<Coupons> result = repo.findById(Cid);
		if(result.isPresent()) {
			return result.get();
		}
		throw new CouponsNotFoundException("Could not find any coupon with Cid" +Cid);
	}
	
	public void delete(int Cid) throws CouponsNotFoundException{
		repo.deleteById(Cid);
	}
}
