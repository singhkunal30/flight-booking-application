package com.flightbookingapp.usermanagement.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.flightbookingapp.commonservice.dto.UserDTO;
import com.flightbookingapp.usermanagement.model.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DTOMapper {
	
	User toUser(UserDTO userDTO);
	
	UserDTO toUserDTO(User user);
	
	List<UserDTO> toUserDTOs(List<User> users);

	List<User> toUsers(List<UserDTO> users);
}
