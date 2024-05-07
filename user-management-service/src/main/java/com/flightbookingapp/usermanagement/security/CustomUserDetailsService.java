package com.flightbookingapp.usermanagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.flightbookingapp.commonservice.exception.CommonException;
import com.flightbookingapp.commonservice.utils.ErrorCode;
import com.flightbookingapp.commonservice.utils.ErrorMessage;
import com.flightbookingapp.usermanagement.model.User;
import com.flightbookingapp.usermanagement.repository.UserManagementRepository;

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
		new CommonException(errMsg.getUserNotFound(), errCode.getUserNotFound(), HttpStatus.NOT_FOUND));
		return new CustomUserDetails(user);
	}
	
}
