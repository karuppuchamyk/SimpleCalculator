package com.aegon.simplecalculator.model;

public class CalculatorResponse {

	private Double result;
	private int responseCode;
	private String responseMessage;
	private String responseDetails;

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getResponseDetails() {
		return responseDetails;
	}

	public void setResponseDetails(String responseDetails) {
		this.responseDetails = responseDetails;
	}
	
	
	
}
