package com.scratchdeveloper.app.ws.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.scratchdeveloper.app.ws.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionalHandler  {
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handleAnyException(Exception ex,WebRequest request){
		
		String errorMessageDescription=ex.getLocalizedMessage();
		
		if(errorMessageDescription==null) errorMessageDescription=ex.toString();
		
		ErrorMessage errorMessage=new ErrorMessage(new Date(),errorMessageDescription);
		return new ResponseEntity<>(errorMessage,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/* This two methods are to handle two different exception
	 * 
	 * 
	 * @ExceptionHandler(value = NullPointerException.class) public
	 * ResponseEntity<Object> handleNullPointerException(NullPointerException
	 * ex,WebRequest request){
	 * 
	 * String errorMessageDescription=ex.getLocalizedMessage();
	 * 
	 * if(errorMessageDescription==null) errorMessageDescription=ex.toString();
	 * 
	 * ErrorMessage errorMessage=new ErrorMessage(new
	 * Date(),errorMessageDescription); return new ResponseEntity<>(errorMessage,new
	 * HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR); }
	 * 
	 * @ExceptionHandler(value = UserServiceException.class) public
	 * ResponseEntity<Object> handleUserServiceException(UserServiceException
	 * ex,WebRequest request){
	 * 
	 * String errorMessageDescription=ex.getLocalizedMessage();
	 * 
	 * if(errorMessageDescription==null) errorMessageDescription=ex.toString();
	 * 
	 * ErrorMessage errorMessage=new ErrorMessage(new
	 * Date(),errorMessageDescription); return new ResponseEntity<>(errorMessage,new
	 * HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR); }
	 */
	
	
	//This exception handler will handle above two exception in single method
	
	@ExceptionHandler(value = {NullPointerException.class,UserServiceException.class})
	public ResponseEntity<Object> handleSpecificException(Exception ex,WebRequest request){
		
		String errorMessageDescription=ex.getLocalizedMessage();
		
		if(errorMessageDescription==null) errorMessageDescription=ex.toString();
		
		ErrorMessage errorMessage=new ErrorMessage(new Date(),errorMessageDescription);
		return new ResponseEntity<>(errorMessage,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	/*
	 * @ExceptionHandler(value = Exception.class) public ResponseEntity<Error>
	 * handleAnyException(Exception ex,WebRequest request){ Error error= new
	 * Error(); error.setMessage(ex.getMessage()); error.setErrorCode(500);
	 * error.setExceptionType("Exception");
	 * 
	 * System.out.println("HEADER : "+request.getHeader("Accept"));
	 * System.out.println("HEADER : "+request.getHeader("None")); return new
	 * ResponseEntity<Error>(error,new
	 * HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR); }
	 * 
	 * @ExceptionHandler(value = NullPointerException.class) public
	 * ResponseEntity<Error> handleNullPointerException(NullPointerException
	 * ex,WebRequest request){ Error error= new Error();
	 * error.setMessage(ex.getMessage()); error.setErrorCode(500);
	 * error.setExceptionType("NullPointerException");
	 * 
	 * System.out.println("HEADER : "+request.getHeader("Accept"));
	 * System.out.println("HEADER : "+request.getHeader("None")); return new
	 * ResponseEntity<Error>(error,new
	 * HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR); }
	 */
}
