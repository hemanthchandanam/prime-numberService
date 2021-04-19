package com.sample.example.primeNumberService.component;

import org.springframework.stereotype.Component;

@Component
public class ValidateInputRequest {
	
	public boolean isValidNumber(long number) {
		
		if(number>1)
			return true;
		
		
		return false;
	}

}
