package com.aegon.simplecalculator.service.impl;

import org.springframework.stereotype.Service;

import com.aegon.simplecalculator.model.Calculator;
import com.aegon.simplecalculator.service.SimpleCalculatorService;

/**
 * Class to Implement the Simple Calculator
 */
@Service
public class SimpleCalculatorServiceImpl implements SimpleCalculatorService {


	/**
	 * Method to Add an given operand values
	 */
	private double add(double operand1, double operand2) {
		return operand1 + operand2;
	}

	/**
	 * Method to Subtract an given operand values
	 */
	private double substract(double operand1, double operand2) {
		return operand1 - operand2;
	}

	/**
	 * Method to Multiply an given operand values
	 */
	private double multiply(double operand1, double operand2) {
		return operand1 * operand2;
	}

	/**
	 * Method to Divide an given operand values
	 */
	private double divide(double operand1, double operand2) {

		return (int) operand1 / (int) operand2;
	}  


	/**
	 * To perform arithmetic operation based on operation.
	 * If operator is null or other than + , -, * , / ', UnsupportedOperationException will be thrown.
	 * If operand2 is 0 , ArithmeticException is thrown.
	 */

	public Double performOperation(Calculator calculator) {
		Double result = null; 
		if (calculator != null) {

			double operand1 = calculator.getFirstOperand();
			double operand2 = calculator.getSecondOperand();
			char operator = calculator.getOperator();

			if (operator == '+') {
				result = add(operand1, operand2);
			}
			else if (operator == '-') {
				result = substract(operand1, operand2);
			}
			else if (operator == '*') {
				result = multiply(operand1, operand2);
			}
			else if (operator == '/') {
				try {
					result = divide(operand1, operand2);
				}catch(ArithmeticException ex) {
					throw new ArithmeticException();
				}
			}
			else {
				throw new UnsupportedOperationException();
			} 
		}
		return result;
	}

}