package com.sumeet.studentController;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//Used if we want to write the exception handler at just one place which can be used by more than
// controller classes

@ControllerAdvice
public class GlobalExceptionHandlerMethods {

//	with the help of response status annotation, we can instruct spring mvc frmwrk to send an appropriate status code 
//	along with customized error webpage when it makes a call to a specific exception handler method like below
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException(Exception e){
		System.out.println("Null pointer occured : "+e);
		return "NullPointerException";
	}

}
