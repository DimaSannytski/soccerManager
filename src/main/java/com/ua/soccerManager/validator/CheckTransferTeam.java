package com.ua.soccerManager.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckTransferTeamValidation.class)
public @interface CheckTransferTeam {

	String message() default "Team to is wrong";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default {};
}
