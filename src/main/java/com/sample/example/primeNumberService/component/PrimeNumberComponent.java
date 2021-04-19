package com.sample.example.primeNumberService.component;

import org.springframework.stereotype.Component;

import com.sample.example.primeNumberService.exception.PrimeNumberServiceException;

@Component
public class PrimeNumberComponent {

	public String getPrimeNumbersForGivenRange(long start, long end) {
		
		
		if(start>end) {
			throw new PrimeNumberServiceException();
		}
		

		long i = start;
		long num = 0;
		long n = end;
		StringBuilder primeNumbers = new StringBuilder().append("");
		
		
		for (i = start; i <= n; i++) {
			int counter = 0;
			for (num = i; num >= 1; num--) {
				if (i % num == 0) {
					counter = counter + 1;
				}
			}
			if (counter == 2) {
				primeNumbers.append(i).append(",");
			}
		}
		System.out.println(primeNumbers);
		return primeNumbers.toString();
	}

	
	
	public static void main(String[] arg) {
		
		PrimeNumberComponent c = new PrimeNumberComponent();
		
		c.getPrimeNumbersForGivenRange(21L,90L);
		
		
		
	}
	
	
	
	
}
