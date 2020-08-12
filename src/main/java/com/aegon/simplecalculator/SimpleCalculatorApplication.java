package com.aegon.simplecalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = {"com.aegon.simplecalculator"})
public class SimpleCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleCalculatorApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/simplecalculator/performOperation").allowedOrigins("http://localhost:4200");
			}
		};

	}
}
