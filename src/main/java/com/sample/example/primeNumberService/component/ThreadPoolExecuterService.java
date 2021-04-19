package com.sample.example.primeNumberService.component;

import java.util.concurrent.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.example.primeNumberService.exception.PrimeNumberServiceException;


@Component
public class ThreadPoolExecuterService implements ThreadPoolService {

	private ExecutorService primeExecutorService = Executors.newFixedThreadPool(10);

	@Autowired
	PrimeNumberComponent primeNumberComponent;

	public String execute(long number,long upperlimit) {
		StringBuilder build = new StringBuilder();
		
		try {
			
			Future<String> p1 = primeExecutorService.submit(() ->{
				return primeNumberComponent.getPrimeNumbersForGivenRange(2, number);
			});
		   
			Future<String> p2 = primeExecutorService.submit(() ->{
				return primeNumberComponent.getPrimeNumbersForGivenRange(number+1, number*2);
			});
			Future<String> p3 = primeExecutorService.submit(() ->{
		         return primeNumberComponent.getPrimeNumbersForGivenRange((number*2)+1, number*3);
			});
							
			Future<String> p4 = primeExecutorService.submit(() ->{
			     return primeNumberComponent.getPrimeNumbersForGivenRange((number*3)+1, number*4);
			});
									
			Future<String> p5 = primeExecutorService.submit(() ->{
			     return primeNumberComponent.getPrimeNumbersForGivenRange((number*4)+1,upperlimit);
			});
			
			
			String s1=p1.get();
			String s2 =p2.get();
			String s3=p3.get();
			String s4=p4.get();
			String s5=p5.get();
			build= new StringBuilder().append(s1).append(s2).append(s3).append(s4).append(s5);
			
			return build.toString();
			
		}catch(ExecutionException e) {
			throw new PrimeNumberServiceException();
			
		}catch(Exception e) {
			e.getMessage();
			throw new PrimeNumberServiceException();
		}
		
	}
}
