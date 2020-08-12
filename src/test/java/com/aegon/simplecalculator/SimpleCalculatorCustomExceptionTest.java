package com.aegon.simplecalculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aegon.simplecalculator.constants.SimpleCalculatorConstants;
import com.aegon.simplecalculator.exception.CustomExceptionHandler;
import com.aegon.simplecalculator.model.CalculatorResponse;

@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleCalculatorCustomExceptionTest {

	private CustomExceptionHandler customExceptionHandler;
	private Exception exception;
	
	@Before
	public void setUp() throws Exception {
		customExceptionHandler = Mockito.spy(CustomExceptionHandler.class);
		exception = new Exception();
	}


	@Test
	public void testArithmeticException() {
		
		CalculatorResponse response = customExceptionHandler.handleArithmeticException(exception);
		Assert.assertEquals(406, response.getResponseCode());
		Assert.assertEquals(SimpleCalculatorConstants.DIVIDE_BY_ZERO, response.getResponseDetails());
	}
	
	@Test
	public void testUnsupportedOperationException() {

		CalculatorResponse response = customExceptionHandler.handleUnsupportedOperationException(exception);
		Assert.assertEquals(406, response.getResponseCode());
		Assert.assertEquals(SimpleCalculatorConstants.UNSUPPORTED_OPERATION_MESSAGE, response.getResponseDetails());
	}
	
	@Test
	public void testInternalServerError() {

		CalculatorResponse response = customExceptionHandler.handleAllExceptions(exception);
		Assert.assertEquals(500, response.getResponseCode());
		Assert.assertEquals(SimpleCalculatorConstants.SERVER_ERROR, response.getResponseDetails());
	}

}
