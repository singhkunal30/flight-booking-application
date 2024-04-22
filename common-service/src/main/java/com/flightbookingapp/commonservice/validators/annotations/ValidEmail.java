package com.flightbookingapp.commonservice.validators.annotations;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.flightbookingapp.commonservice.constants.ValidationMessages;
import com.flightbookingapp.commonservice.validators.EmailValidator;

@Constraint(validatedBy = EmailValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmail {
    String message() default ValidationMessages.INVALID_EMAIL;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
