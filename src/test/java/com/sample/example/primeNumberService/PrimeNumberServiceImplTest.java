package com.sample.example.primeNumberService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.sample.example.primeNumberService.component.PrimeNumberComponent;
import com.sample.example.primeNumberService.component.ThreadPoolExecuterService;
import com.sample.example.primeNumberService.service.PrimeNumberServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class PrimeNumberServiceImplTest {

	@InjectMocks
	private PrimeNumberServiceImpl primeNumberService;

	@Mock
	private PrimeNumberComponent primeNumberComponent;

	@Mock
	private ThreadPoolExecuterService threadPoolExecuterService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

    @Test
	public void shouldReturnStringValue_WhenInputIsValid_Invoke_primeNumberComponent() {
		long value = 10L;

		Mockito.when(primeNumberComponent.getPrimeNumbersForGivenRange(Mockito.anyLong(), Mockito.anyLong()))
				.thenReturn("2,3,5,7,");
		
		String returnString = primeNumberService.fetchPrimeNumbers(value);
		
		verify(primeNumberComponent, times(1)).getPrimeNumbersForGivenRange(2, 10L);
		
		Assert.assertNotNull("Return value should not be null ", returnString);

	}

	@Test
	public void whenGivenValueMoreThan5000_thenUseThreadPoolService() {
		String expectedValue="2,3,5,7,";
		long value = 10000L;
		Mockito.when(threadPoolExecuterService.execute(Mockito.anyLong(), Mockito.anyLong())).thenReturn(expectedValue);;
		String returnString = primeNumberService.fetchPrimeNumbers(value);

		Assert.assertNotNull("Return value should not be null ", returnString);
		Assert.assertEquals("Return value should not be null ", returnString,expectedValue);
		
	

	}

}
