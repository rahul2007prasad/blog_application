package com.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.exceptions.ResourceNotFoundException;
import com.app.pojos.User;
import com.app.repository.UserRepo;

@Service
public class CustomerUserDetailService implements UserDetailsService{

	//loading user from db by username
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user=	this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User", "Email :" +username, 0));
	return user;
	
	}
	
	
}
