package com.SpringApp1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SpringApp1.model.CustomUserDetails;
import com.SpringApp1.model.User;
import com.SpringApp1.repository.UserRepository;


@Service
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		Optional<User> user = userRepository.findUserByEmail(email);
		user.orElseThrow(() -> new UsernameNotFoundException("User not Found"));
		
		return user.map(CustomUserDetails::new).get();
	}

}
