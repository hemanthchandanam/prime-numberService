package com.sample.example.primeNumberService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.example.primeNumberService.PrimeNumberConstant;
import com.sample.example.primeNumberService.component.PrimeNumberComponent;
import com.sample.example.primeNumberService.component.ThreadPoolExecuterService;

@Service
public class PrimeNumberServiceImpl implements PrimeNumberService {

	@Autowired
	PrimeNumberComponent primeNumberComponent;

	@Autowired
	ThreadPoolExecuterService executeService;

	@Override
	public String fetchPrimeNumbers(long number) {

		int p;

		if (number > PrimeNumberConstant.DENOMINATOR_VALUE) {
			p = (int) (number / PrimeNumberConstant.THREAD_POOL_SIZE);
			return executeService.execute(p, number);

		} else {
			
			return primeNumberComponent.getPrimeNumbersForGivenRange(2, number);
		}

	}

}