package com.sample.example.primeNumberService.component;

import org.springframework.stereotype.Component;

@Component
public class PrimeNumberComponent {

	public String getPrimeNumbersForGivenRange(long start, long number) {

		int i = 0;
		int num = 0;
		StringBuilder primeNumbers = new StringBuilder().append("");
		long n = number;
		for (i = 1; i <= n; i++) {
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
		System.out.println("Prime numbers from 1 to n are :");
		System.out.println(primeNumbers);
		return primeNumbers.toString();
	}

}
