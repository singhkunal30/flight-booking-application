package com.flightbookingapp.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.flightbookingapp.commonservice.dto.UserDTO;
import com.flightbookingapp.commonservice.utils.JsonUtils;
import com.flightbookingapp.usermanagement.service.UserManagementService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.servlet.http.HttpServletRequest;

@RestController("/user")
public class UserManagementController {
	
	@Autowired
	private UserManagementService userManagementService;
	
	@PostMapping("/register")	
	public ResponseEntity<UserDTO> registerUser(HttpServletRequest request) {
		UserDTO userDTO = JsonUtils.bindRequestToObject(request, new TypeReference<UserDTO>() {});
		return new ResponseEntity<>(userManagementService.register(userDTO), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getContact(@PathVariable int id) {
		return new ResponseEntity<>(userManagementService.getUser(id), HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<UserDTO> updateContact(HttpServletRequest request) {
		UserDTO userDTO = JsonUtils.bindRequestToObject(request, new TypeReference<UserDTO>() {});
		return new ResponseEntity<>(userManagementService.updateUser(userDTO), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/remove/{id}")
	@RolesAllowed(value = "ROLE_ADMIN")
	public ResponseEntity<Boolean> removeUser(@PathVariable int id) {
		return new ResponseEntity<>(userManagementService.removeUser(id), HttpStatus.OK);
	}
	
}

