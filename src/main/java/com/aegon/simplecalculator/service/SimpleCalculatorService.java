package com.aegon.simplecalculator.service;

import org.springframework.stereotype.Service;
import com.aegon.simplecalculator.model.Calculator;

@Service
public interface SimpleCalculatorService {

	public Double performOperation(Calculator calculator);
	
}
