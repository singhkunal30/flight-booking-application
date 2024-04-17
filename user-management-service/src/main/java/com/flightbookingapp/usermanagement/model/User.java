package com.flightbookingapp.usermanagement.model;

import java.util.HashSet;
import java.util.Set;

import com.flightbookingapp.usermanagement.constants.ValidationMessages;
import com.flightbookingapp.usermanagement.enums.Role;
import com.flightbookingapp.usermanagement.validators.annotations.ValidEmail;
import com.flightbookingapp.usermanagement.validators.annotations.ValidPassword;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @ValidEmail
    private String email;    
    
    @ValidPassword
    private String password;
    
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @NotNull(message = ValidationMessages.ROLES_REQUIRED)
    private Set<Role> roles = new HashSet<>();
    
}