package com.flightbookingapp.commonservice.validators;

import java.util.regex.Pattern;

import com.flightbookingapp.commonservice.constants.ValidationMessages;
import com.flightbookingapp.commonservice.validators.annotations.ValidPassword;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null || password.isBlank()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ValidationMessages.PASSWORD_REQUIRED).addConstraintViolation();
            return false;
        }
        return Pattern.matches(PASSWORD_REGEX, password);
    }
}