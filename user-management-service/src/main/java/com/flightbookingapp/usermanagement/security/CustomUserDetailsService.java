package com.flightbookingapp.usermanagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.flightbookingapp.usermanagement.exception.UserExecption;
import com.flightbookingapp.usermanagement.model.User;
import com.flightbookingapp.usermanagement.repository.UserManagementRepository;
import com.flightbookingapp.usermanagement.utils.ErrorCode;
import com.flightbookingapp.usermanagement.utils.ErrorMessage;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserManagementRepository userRepository;
	
	@Autowired
	private ErrorMessage errMsg;
	
	@Autowired
	private ErrorCode errCode;
	
	@Override
	public UserDetails loadUserByUsername(String input) {
		User user = userRepository.findByEmail(input).orElseThrow(() -> 
		new UserExecption(errMsg.getUserNotFound(), errCode.getUserNotFound(), HttpStatus.NOT_FOUND));
		return new CustomUserDetails(user);
	}
	
}
