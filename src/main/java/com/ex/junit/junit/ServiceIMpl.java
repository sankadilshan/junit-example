package com.ex.junit.junit;

import org.springframework.stereotype.Service;

@Service
public class ServiceIMpl implements CalculatorService{

	@Override
	public int add(int i, int j) {
		
		return (i+j);
	}

}
