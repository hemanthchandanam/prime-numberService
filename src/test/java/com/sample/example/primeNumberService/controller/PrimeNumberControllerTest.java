package com.sample.example.primeNumberService.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.sample.example.primeNumberService.component.ValidateInputRequest;
import com.sample.example.primeNumberService.exception.InvalidPrimeNumberValueException;
import com.sample.example.primeNumberService.exception.PrimeNumberServiceException;
import com.sample.example.primeNumberService.service.PrimeNumberService;

@RunWith(MockitoJUnitRunner.class)
public class PrimeNumberControllerTest {

	@Mock
	PrimeNumberService primeNumberService;

	@Mock
	ValidateInputRequest validateInputRequest;

	@InjectMocks
	PrimeNumberController primeNumberController;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void shouldReturnPrimeNumbers_ForValidInput() {

		long inputValue = 12L;
		String outPutStr = "2,3,5,7,11,";
		Mockito.when(validateInputRequest.isValidNumber(inputValue)).thenReturn(true);
		Mockito.when(primeNumberService.fetchPrimeNumbers(inputValue)).thenReturn(outPutStr);
		String retValue = primeNumberController.getPrimeNumbers(inputValue);

		verify(validateInputRequest, times(1)).isValidNumber(inputValue);
		verify(primeNumberService, times(1)).fetchPrimeNumbers(inputValue);

		Assert.notNull("should not be null ", retValue);
	}

	@Test(expected = InvalidPrimeNumberValueException.class)
	public void shouldReturnPrimeNumbers_ForInValidInput() {

		Mockito.when(validateInputRequest.isValidNumber(0)).thenReturn(false);
		 primeNumberController.getPrimeNumbers(0l);
		// verify(validateInputRequest,times(1)).isValidNumber(0);

	}

	@Test(expected = PrimeNumberServiceException.class)
	public void shouldReturnExceptionForInternalError() {

		long inputValue = 12L;
		Mockito.when(validateInputRequest.isValidNumber(inputValue)).thenReturn(true);
		Mockito.when(primeNumberService.fetchPrimeNumbers(inputValue)).thenThrow(new PrimeNumberServiceException());
		 primeNumberController.getPrimeNumbers(inputValue);

		verify(validateInputRequest, times(1)).isValidNumber(inputValue);
		primeNumberController.getPrimeNumbers(inputValue);

	}

}
