package com.scratchdeveloper.app.ws.exception;

import org.springframework.web.context.request.WebRequest;

public class Error {
	
	private String message;
	private int errorCode;
	private String exceptionType;	

	public String getExceptionType() {
		return exceptionType;
	}

	public void setExceptionType(String exceptionType) {
		this.exceptionType = exceptionType;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
