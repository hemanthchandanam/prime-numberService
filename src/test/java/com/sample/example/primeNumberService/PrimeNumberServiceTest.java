package com.sample.example.primeNumberService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.sample.example.primeNumberService.component.PrimeNumberComponent;
import com.sample.example.primeNumberService.component.ThreadPoolExecuterService;
import com.sample.example.primeNumberService.service.PrimeNumberServiceImpl;

public class PrimeNumberServiceTest {
	
	

	
	
	@Mock 
	private PrimeNumberComponent primeNumberComponent;

	@Mock 
	private ThreadPoolExecuterService executeService;
	
	
	@InjectMocks
	private PrimeNumberServiceImpl  primeNumberService;
	
	
	@BeforeAll 
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	
     @Test
      public void shouldReturnStringValue_WhenInputIsValid_Invoke_primeNumberComponent(){
    	 long value =10L;
    	 
    	String returnString = primeNumberService.fetchPrimeNumbers(value);
    	
    	Mockito.when(primeNumberComponent.getPrimeNumbersForGivenRange(Mockito.anyLong(), Mockito.anyLong())).thenReturn("2,3,5,7,");
    	
    	verify(primeNumberComponent, times(1)).getPrimeNumbersForGivenRange(2,10L);
    	Assert.notNull("Return value should not be null ",returnString);
    	
    	 
    	 
     }



	
}
