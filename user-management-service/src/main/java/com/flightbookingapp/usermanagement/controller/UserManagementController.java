package com.flightbookingapp.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.flightbookingapp.commonservice.dto.UserDTO;
import com.flightbookingapp.commonservice.utils.JsonUtils;
import com.flightbookingapp.usermanagement.service.UserManagementService;

import jakarta.servlet.http.HttpServletRequest;

@RestController()
@RequestMapping("/user")
public class UserManagementController {
	
	@Autowired
	private UserManagementService userManagementService;
	
	@PostMapping("/register")	
	public ResponseEntity<UserDTO> registerUser(HttpServletRequest request) {
		UserDTO userDTO = JsonUtils.bindRequestToObject(request, new TypeReference<UserDTO>() {});
		return new ResponseEntity<>(userManagementService.register(userDTO), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable int id) {
		return new ResponseEntity<>(userManagementService.getUser(id), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<UserDTO> updateUser(HttpServletRequest request) {
		UserDTO userDTO = JsonUtils.bindRequestToObject(request, new TypeReference<UserDTO>() {});
		return new ResponseEntity<>(userManagementService.updateUser(userDTO), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/remove/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Boolean> removeUser(@PathVariable int id) {
		return new ResponseEntity<>(userManagementService.removeUser(id), HttpStatus.OK);
	}
	
}

