package com.sample.example.primeNumberService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan({"com.sample.example"})
@SpringBootApplication
public class PrimeNumberServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeNumberServiceApplication.class, args);
	}

}