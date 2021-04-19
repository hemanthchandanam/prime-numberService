package com.sample.example.primeNumberService.component;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ValidateInputRequestTest {
	
	ValidateInputRequest validateInputRequest = null;

	
	@Before
	public void setUp() throws Exception {
		validateInputRequest = new ValidateInputRequest();
	}
	
	@Test
	public void shouldreturnTrue_WhenGivenValueIsmoreThenTwo() {
	
		Assert.assertTrue("Expected value should be True when input is more then 2 :",validateInputRequest.isValidNumber(5l));
	
	}
	
	@Test
	public void shouldreturnFalse_WhenGivenValueIsmoreThenTwo() {
	
		Assert.assertFalse("Expected value should be False when input is less then 2 :",validateInputRequest.isValidNumber(0));
		Assert.assertFalse("Expected value should be False when input is less then 2 :",validateInputRequest.isValidNumber(1));
		Assert.assertFalse("Expected value should be False when input is less then 2 :",validateInputRequest.isValidNumber(-24));
	}
	
	
}
