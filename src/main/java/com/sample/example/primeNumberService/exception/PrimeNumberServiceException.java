package com.sample.example.primeNumberService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sample.example.primeNumberService.PrimeNumberConstant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@AllArgsConstructor
@Getter
@Setter
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = PrimeNumberConstant.ERROR_MESSAGE)
public @Value class PrimeNumberServiceException extends RuntimeException {

	public PrimeNumberServiceException() {
		super(PrimeNumberConstant.ERROR_MESSAGE);
	}

}