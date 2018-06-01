package com.sumeet.studentController;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Interceptor is used if we want the application to perform a simple task or
 * validation before processing any further and handling the request. if the
 * task returns true, then only spring mvc proceeds further to handle the
 * request sent by the user.
 */
public class DayOfWeekBasedAccessInteceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws java.lang.Exception {
		// if the method returns true then, application will further handle the request
		// if this method returns false then, application will not further handle the request
		
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(cal.DAY_OF_WEEK); //getting the day on which request is made
		if(dayOfWeek == 1){ // 1 means Sunday, 2 means Monday, ...7 means Saturday
			response.getWriter().write("The website is closed on Sunday ; Please try accessing it "
										+"on any other week day !!");
			return false;
			
		}

		return true;
	}
	
	public void postHandle(javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response,  java.lang.Object handler) throws java.lang.Exception{

		//	This method would be called after spring mvc executes the request handler method for the request
		System.out.println("Handler InterceptorAdaptor : Spring mvc called post handle method for "+
							request.getRequestURI().toString());
		
		
	}

	public void afterCompletion(javax.servlet.http.HttpServletRequest request,  
			javax.servlet.http.HttpServletResponse response,  java.lang.Object handler) throws java.lang.Exception{
		

		//		This method would be called after the response object is produced by the view for the request
			System.out.println("Handler InterceptorAdaptor : Spring mvc called afterCompletion method for "+
								request.getRequestURI().toString());
		
	}
	
}
