package com.productserver.main.exception;




import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.productserver.main.response.ResponseExceptionModel;


@RestControllerAdvice
public class DefaultHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Object handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
		ResponseExceptionModel erro = new ResponseExceptionModel(HttpStatus.FORBIDDEN.value());
		StringBuilder message = new StringBuilder();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String errorMessage = error.getDefaultMessage();
	        message.append(errorMessage+"; ");     
	    });
	    erro.setMessage(message.toString());
	    
		return new ResponseEntity<Object>(erro, new HttpHeaders(), HttpStatus.FORBIDDEN);
	}
	

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> handlerNullException(HttpServletRequest request, NullPointerException ex) {
		ResponseExceptionModel erro = new ResponseExceptionModel(HttpStatus.INTERNAL_SERVER_ERROR.value());
		System.out.println(ex.toString());
		erro.setMessage(ex.getMessage());
		return new ResponseEntity<Object>(erro, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> EntityNotFoundExceptionHandler(HttpServletRequest request, Exception ex) {
		ResponseExceptionModel erro = new ResponseExceptionModel(HttpStatus.INTERNAL_SERVER_ERROR.value());
		erro.setMessage(ex.getMessage());
		return new ResponseEntity<Object>(erro, new HttpHeaders(), HttpStatus.NOT_FOUND.value());
	}
	

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handlerException(HttpServletRequest request, Exception ex) {
		ResponseExceptionModel erro = new ResponseExceptionModel(HttpStatus.INTERNAL_SERVER_ERROR.value());
		erro.setMessage(ex.getMessage());
		return new ResponseEntity<Object>(erro, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
	
	
}