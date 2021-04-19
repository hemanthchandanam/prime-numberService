package com.sample.example.primeNumberService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages="com.sample.example")
public class InvalidPrimeNumberValueAdvice {

	
	@ExceptionHandler(PrimeNumberServiceException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	ResponseEntity<String> exceptionHandler(PrimeNumberServiceException ex) {
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InvalidPrimeNumberValueException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> exceptionHandler(InvalidPrimeNumberValueException ex) {
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
}
