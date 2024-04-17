package com.flightbookingapp.usermanagement.validators.annotations;
import javax.validation.Constraint;
import javax.validation.Payload;

import com.flightbookingapp.usermanagement.constants.ValidationMessages;
import com.flightbookingapp.usermanagement.validators.EmailValidator;

import java.lang.annotation.*;

@Constraint(validatedBy = EmailValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmail {
    String message() default ValidationMessages.INVALID_EMAIL;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
