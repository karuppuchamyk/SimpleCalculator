package com.aegon.simplecalculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aegon.simplecalculator.model.Calculator;
import com.aegon.simplecalculator.service.SimpleCalculatorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleCalculatorServiceTest {

	@Autowired	
	private SimpleCalculatorService simpleCalculatorService;

	private Calculator calculator;


	@Before
	public void setUp() throws Exception {
		calculator = new Calculator();
	}

	@Test
	public void testAddOperation() {
		calculator.setFirstOperand(2.0);
		calculator.setSecondOperand(3.0);
		calculator.setOperator('+');

		Double result = simpleCalculatorService.performOperation(calculator);
		Assert.assertEquals("5.0", result.toString());
	}

	@Test
	public void testSubtractOperation() {
		calculator.setFirstOperand(4.0);
		calculator.setSecondOperand(3.0);
		calculator.setOperator('-');

		Double result = simpleCalculatorService.performOperation(calculator);
		Assert.assertEquals("1.0", result.toString());
	}

	@Test
	public void testAddMultiplyOperation() {
		calculator.setFirstOperand(2.0);
		calculator.setSecondOperand(3.0);
		calculator.setOperator('*');

		Double result = simpleCalculatorService.performOperation(calculator);
		Assert.assertEquals("6.0", result.toString());
	}

	@Test
	public void testDivideOperation() {
		calculator.setFirstOperand(10.0);
		calculator.setSecondOperand(2.0);
		calculator.setOperator('/');

		Double result = simpleCalculatorService.performOperation(calculator);
		Assert.assertEquals("5.0", result.toString());
	}


	@Test(expected = ArithmeticException.class)
	public void testDivideByZeroOperation() {
		calculator.setFirstOperand(10.0);
		calculator.setSecondOperand(0.0);
		calculator.setOperator('/');

		Double result = simpleCalculatorService.performOperation(calculator);
		Assert.assertEquals("5.0", result.toString());
	}



	@Test(expected = UnsupportedOperationException.class)
	public void testUnSupportedOperation() {
		calculator.setFirstOperand(10.0);
		calculator.setSecondOperand(2.0);
		calculator.setOperator('(');

		Double result = simpleCalculatorService.performOperation(calculator);
		Assert.assertEquals("5.0", result.toString());
	}


}
		 