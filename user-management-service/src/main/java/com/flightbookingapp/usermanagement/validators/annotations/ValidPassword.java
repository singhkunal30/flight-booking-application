package com.flightbookingapp.usermanagement.validators.annotations;
import javax.validation.Constraint;
import javax.validation.Payload;

import com.flightbookingapp.usermanagement.constants.ValidationMessages;
import com.flightbookingapp.usermanagement.validators.PasswordValidator;

import java.lang.annotation.*;


@Constraint(validatedBy = PasswordValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
    String message() default ValidationMessages.INVALID_PASSWORD;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
