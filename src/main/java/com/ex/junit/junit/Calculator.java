package com.ex.junit.junit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class Calculator {
    
	CalculatorService service;
	
	 Calculator(CalculatorService service) {
		this.service=service;
	}
	
	public int perform(int i,int j) {
		return service.add(i, j)*i;
		//return (i+j)*i;
	}

	@GetMapping("/hello ")
	public String hello(){
	 	return "hello world!";
	}
}
