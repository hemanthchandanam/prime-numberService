package com.sample.example.primeNumberService.component;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.sample.example.primeNumberService.exception.PrimeNumberServiceException;

@RunWith(MockitoJUnitRunner.class)
public class PrimeNumberComponetTest {

	PrimeNumberComponent primeNumberComponent;

	@Before
	public void setUp() throws Exception {
		primeNumberComponent = new PrimeNumberComponent();
	}

	@Test
	public void shouldGetPrimeNumbers_ForValidInput() {
		String returnStr = primeNumberComponent.getPrimeNumbersForGivenRange(2, 10);
		Assert.assertNotNull("Return value should not be null ", returnStr);

	}

	@Test(expected = PrimeNumberServiceException.class)
	public void shouldThrowException_WhenInvalidForInValidInpur() {
		primeNumberComponent.getPrimeNumbersForGivenRange(12, 10);
	}

}
