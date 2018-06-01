package com.sumeet.studentController;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = HobbyValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidHobby {

//	default is used when suppose we dont want to five any parameter in the isValidHobby annotation in the student class, it 
//	will automatically take this default value
	String listOfValidHobbies() default "Music|Football|Cricket|Hockey";
	
	String message() default "Please provide a valid Hobby; "+
							"accepted hobbies are - Music, Football, Cricket and Hockey (choose anyone)";
	
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};

}
