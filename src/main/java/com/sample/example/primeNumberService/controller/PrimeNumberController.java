package com.sample.example.primeNumberService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sample.example.primeNumberService.component.ValidateInputRequest;
import com.sample.example.primeNumberService.exception.InvalidPrimeNumberValueException;
import com.sample.example.primeNumberService.exception.PrimeNumberServiceException;
import com.sample.example.primeNumberService.service.PrimeNumberService;

@RestController
public class PrimeNumberController {

	@Autowired
	PrimeNumberService primeNumberService;

	@Autowired
	ValidateInputRequest validateInputRequest;

	@GetMapping("/primeNumbers/{number}")
	 String getPrimeNumbers(@PathVariable Long number) {
		try {
			if (validateInputRequest.isValidNumber(number))
				return primeNumberService.fetchPrimeNumbers(number);
			else {
				throw new InvalidPrimeNumberValueException(number+"");
			}
		} catch (InvalidPrimeNumberValueException e) {
			throw new InvalidPrimeNumberValueException(number.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new PrimeNumberServiceException();
		}

	}

}
