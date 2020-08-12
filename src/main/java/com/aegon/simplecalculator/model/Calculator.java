package com.aegon.simplecalculator.model;

import java.io.Serializable;

public class Calculator implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer firstOperand;
	private Integer secondOperand;
	private Character operator;
	
	public Integer getFirstOperand() {
		return firstOperand;
	}
	public void setFirstOperand(Integer firstOperand) {
		this.firstOperand = firstOperand;
	}
	public Integer getSecondOperand() {
		return secondOperand;
	}
	public void setSecondOperand(Integer secondOperand) {
		this.secondOperand = secondOperand;
	}
	public Character getOperator() {
		return operator;
	}
	public void setOperator(Character operator) {
		this.operator = operator;
	}
	
}
