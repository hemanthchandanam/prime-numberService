package com.sample.example.primeNumberService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sample.example.primeNumberService.PrimeNumberConstant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



@AllArgsConstructor
@Getter @Setter
@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason= PrimeNumberConstant.ERROR_MESSAGE)
public class InvalidPrimeNumberValueException extends RuntimeException {
	
	public InvalidPrimeNumberValueException(String inputValue) {
		super(" Not a valid input range should be 2 to 2147483647  your input" + inputValue);
	}

}

