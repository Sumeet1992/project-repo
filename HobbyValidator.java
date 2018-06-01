package com.sumeet.studentController;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * A validator clas used by a custom annotation always - implements the ConstraintValidator and Overrides two of its methods
 * i.e. initialize and isValid. 
 */
public class HobbyValidator implements ConstraintValidator<IsValidHobby, String>{

	private String listOfValidHobbies;
	
	@Override
	public void initialize(IsValidHobby isValidHobby) {
		
		this.listOfValidHobbies = isValidHobby.listOfValidHobbies();
	}

	@Override
	public boolean isValid(String studentHobby, ConstraintValidatorContext ctx) {
		if(studentHobby == null){
			return false;
		}
		if(studentHobby.matches(listOfValidHobbies)){
			return true;
		}
		else{
			return false;
		}
		
	}
	

	
}
