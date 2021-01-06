package com.fisrt.test.exception;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class UserDefinedException {
	
	public UserDefinedException () {}
	
private  int statusCode;
private String errorMSG;
private StackTraceElement[] stackTraceElements;
public StackTraceElement[] getStackTraceElements() {
	return stackTraceElements;
}
public void setStackTraceElements(StackTraceElement[] stackTraceElements) {
	this.stackTraceElements = stackTraceElements;
}

private Date timeStamp;
public int getStatusCode() {
	return statusCode;
}
public void setStatusCode(int statusCode) {
	this.statusCode = statusCode;
}
public String getErrorMSG() {
	return errorMSG;
}
public void setErrorMSG(String errorMSG) {
	this.errorMSG = errorMSG;
}

public Date getTimeStamp() {
	return timeStamp;
}
public void setTimeStamp(Date timeStamp) {
	this.timeStamp = timeStamp;
}
public UserDefinedException(int statusCode, String errorMSG, StackTraceElement[] stackTraceElements, Date timeStamp) {
	super();
	this.statusCode = statusCode;
	this.errorMSG = errorMSG;
	this.stackTraceElements = stackTraceElements;
	this.timeStamp = timeStamp;
}

	
}
