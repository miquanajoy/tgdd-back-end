package com.group1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.group1.Entities.userEntities.User;
import com.group1.repositories.UserRepo;


public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username");
		}			
		return new CustomUserDetail(user);
	}
}
