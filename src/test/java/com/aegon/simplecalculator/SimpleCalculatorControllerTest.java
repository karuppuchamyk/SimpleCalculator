package com.aegon.simplecalculator;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.aegon.simplecalculator.controller.SimpleCalculatorController;
import com.aegon.simplecalculator.model.Calculator;
import com.aegon.simplecalculator.model.CalculatorResponse;
import com.aegon.simplecalculator.service.SimpleCalculatorService;

@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleCalculatorControllerTest  {


	private SimpleCalculatorService simpleCalculatorService;

	private Calculator calculator;

	private SimpleCalculatorController simpleCalculatorController;

	@Before
	public void setUp() throws Exception {
		simpleCalculatorService = Mockito.mock(SimpleCalculatorService.class);
		simpleCalculatorController = Mockito.spy(SimpleCalculatorController.class);
		calculator = new Calculator();

		ReflectionTestUtils.setField(simpleCalculatorController, "simpleCalculatorService", simpleCalculatorService);
	}


	@Test
	public void testControllerOperation() {
		calculator.setFirstOperand(2);
		calculator.setSecondOperand(1);
		calculator.setOperator('+');

		CalculatorResponse response = simpleCalculatorController.performOperation(calculator).getBody();

		Assert.assertEquals("OK", response.getResponseMessage());
	}
}