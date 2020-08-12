package com.aegon.simplecalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aegon.simplecalculator.constants.SimpleCalculatorConstants;
import com.aegon.simplecalculator.model.Calculator;
import com.aegon.simplecalculator.model.CalculatorResponse;
import com.aegon.simplecalculator.service.SimpleCalculatorService;

@RestController
@RequestMapping("simplecalculator")
public class SimpleCalculatorController {

	@Autowired
	private SimpleCalculatorService simpleCalculatorService;
	
	@PostMapping(value = "/performOperation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CalculatorResponse>  performOperation(@RequestBody Calculator calculator) {
		Double result = simpleCalculatorService.performOperation(calculator);
		return new ResponseEntity<CalculatorResponse>(buildResponse(result),HttpStatus.OK);
	}
	
	private CalculatorResponse buildResponse(Double result){
		CalculatorResponse calculatorResponse = new CalculatorResponse();
		calculatorResponse.setResult(result);
		calculatorResponse.setResponseCode(HttpStatus.OK.value());
		calculatorResponse.setResponseMessage(HttpStatus.OK.getReasonPhrase());
		calculatorResponse.setResponseDetails(SimpleCalculatorConstants.SUCCESS);
		return calculatorResponse;		
	}

}
