package com.flightbookingapp.usermanagement.validators;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.flightbookingapp.usermanagement.constants.ValidationMessages;
import com.flightbookingapp.usermanagement.validators.annotations.ValidEmail;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    @Override
    public void initialize(ValidEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || email.isEmpty()) {
	    	context.disableDefaultConstraintViolation();
	        context.buildConstraintViolationWithTemplate(ValidationMessages.EMAIL_REQUIRED).addConstraintViolation();
            return false;
        }
        return Pattern.matches(EMAIL_REGEX, email);
    }
}