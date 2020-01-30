package com.sai.spring.ssm.design_patterns.factory;

public class Laptop implements Computer{

	@Override
	public void doSometing() {
		System.out.println("Laptop doing work...");
	}

}
