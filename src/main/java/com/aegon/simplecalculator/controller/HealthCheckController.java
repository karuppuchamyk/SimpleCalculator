package com.aegon.simplecalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("simplecalculator")
public class HealthCheckController {

	@Autowired
	private HealthEndpoint healthEndpoint;

	@RequestMapping(value = "/ready", produces = MediaType.APPLICATION_JSON_VALUE)
	public String checkReady() {
		return healthEndpoint.health().getStatus().getCode();
	}

}
