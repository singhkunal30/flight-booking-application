package com.flightbookingapp.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.flightbookingapp.commonservice.dto.UserDTO;
import com.flightbookingapp.commonservice.exception.UserExecption;
import com.flightbookingapp.commonservice.utils.ErrorCode;
import com.flightbookingapp.commonservice.utils.ErrorMessage;
import com.flightbookingapp.usermanagement.mapper.DTOMapper;
import com.flightbookingapp.usermanagement.model.User;
import com.flightbookingapp.usermanagement.repository.UserManagementRepository;

@Service
public class UserManagementServiceImpl implements UserManagementService{
	
	@Autowired
	UserManagementRepository userManagementRepository;	
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	DTOMapper mapper;
	
	@Autowired
	ErrorMessage errMsg;
	
	@Autowired
	ErrorCode errCode;
	
	@Override
	public UserDTO register(UserDTO userDTO) {
		try {
			userManagementRepository.findByEmail(userDTO.getEmail()).ifPresent(existingUser -> {
	            throw new UserExecption(errMsg.getUserAlreadyExist() + " " + userDTO.getEmail(),
	                    errCode.getUserAlreadyExist(), HttpStatus.UNPROCESSABLE_ENTITY);
	        });
			String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
			userDTO.setPassword(encodedPassword);
			User user = mapper.toUser(userDTO);
			User savedUser = userManagementRepository.save(user);
			return mapper.toUserDTO(savedUser);
		}catch (UserExecption ue) {
			throw ue;
		}
		catch (Exception e) {
			throw new UserExecption(e.getMessage(), errCode.getInvalidRequest() , HttpStatus.BAD_REQUEST);
		}
	}
	
	@Override
	public UserDTO getUser(long id) {
		User user = userManagementRepository.findById(id).orElseThrow(
				()-> new UserExecption(errMsg.getUserNotFound(), errCode.getUserNotFound(), HttpStatus.NOT_FOUND));
		return mapper.toUserDTO(user);
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO) {
		userManagementRepository.findById(userDTO.getUserId())
				.orElseThrow(() -> new UserExecption(errMsg.getUserNotFound() + " " +userDTO.getUserId(), 
						errCode.getUserNotFound(), HttpStatus.NOT_FOUND));
		User updatedUser = mapper.toUser(userDTO);
		updatedUser.setUserId(userDTO.getUserId());
		userManagementRepository.save(updatedUser);
		return mapper.toUserDTO(updatedUser);
	}

	@Override
	public boolean removeUser(long id) {
		User user = userManagementRepository.findById(id)
				.orElseThrow(() -> new UserExecption(errMsg.getUserNotFound()+ " " +id, 
						errCode.getUserNotFound(), HttpStatus.NOT_FOUND));
		userManagementRepository.delete(user);
		return true;
	}
	
}
