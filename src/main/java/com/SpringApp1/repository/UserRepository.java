package com.SpringApp1.repository;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringApp1.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	Optional<User>findUserByEmail(String email);
//	@Override
//	<S extends User> Optional<S> findOne(Example<S> example);

}
