package com.aegon.simplecalculator.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.aegon.simplecalculator.constants.SimpleCalculatorConstants;
import com.aegon.simplecalculator.model.CalculatorResponse;


@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(UnsupportedOperationException.class)
	  public final CalculatorResponse handleUnsupportedOperationException(Exception ex) {
		CalculatorResponse errorDetails = new CalculatorResponse();
		errorDetails.setResponseCode(HttpStatus.NOT_ACCEPTABLE.value());
		errorDetails.setResponseMessage(HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());
		errorDetails.setResponseDetails(SimpleCalculatorConstants.UNSUPPORTED_OPERATION_MESSAGE);
	    return errorDetails;
	  }
	
	
	@ExceptionHandler(ArithmeticException.class)
	  public final CalculatorResponse handleArithmeticException(Exception ex) {
		CalculatorResponse errorDetails = new CalculatorResponse();
		errorDetails.setResponseCode(HttpStatus.NOT_ACCEPTABLE.value());
		errorDetails.setResponseMessage(HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());
		errorDetails.setResponseDetails(SimpleCalculatorConstants.DIVIDE_BY_ZERO);
	    return errorDetails;
	  }
	
	@ExceptionHandler(Exception.class)
	  public final CalculatorResponse handleAllExceptions(Exception ex) {
		CalculatorResponse errorDetails = new CalculatorResponse();
		errorDetails.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorDetails.setResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		errorDetails.setResponseDetails(SimpleCalculatorConstants.SERVER_ERROR);
	    return errorDetails;
	  }
	
	
}
