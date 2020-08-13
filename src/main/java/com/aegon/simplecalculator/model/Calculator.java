package com.aegon.simplecalculator.model;

import java.io.Serializable;

public class Calculator implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Double firstOperand;
	private Double secondOperand;
	private Character operator;
	

	public Double getFirstOperand() {
		return firstOperand;
	}
	public void setFirstOperand(Double firstOperand) {
		this.firstOperand = firstOperand;
	}
	public Double getSecondOperand() {
		return secondOperand;
	}
	public void setSecondOperand(Double secondOperand) {
		this.secondOperand = secondOperand;
	}
	
	public Character getOperator() {
		return operator;
	}
	public void setOperator(Character operator) {
		this.operator = operator;
	}
	
}
