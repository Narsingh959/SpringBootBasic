package com.fisrt.test.exception;

import javax.xml.ws.soap.Addressing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javassist.NotFoundException;
  
@ControllerAdvice
public class GlobalExceptions extends ResponseEntityExceptionHandler {
	
	@Autowired
	private UserDefinedException userDefinedException;
	
	public UserDefinedException notFoundExceptiion(Exception exception) {
		
		userDefinedException.setErrorMSG(exception.getMessage());
		userDefinedException.setStackTraceElements(exception.getStackTrace());
		
		//userDefinedException.setStatusCode(exception.get);
		return userDefinedException;
				 
	}
	
	
	

}
