package com.flightbookingapp.usermanagement.service;

import com.flightbookingapp.usermanagement.dto.UserDTO;

public interface UserManagementService {
	
	UserDTO register(UserDTO userDTO);
	
	UserDTO getUser(long id);
	
	UserDTO updateUser(UserDTO userDTO);
	
	boolean removeUser(long id);
	
}
