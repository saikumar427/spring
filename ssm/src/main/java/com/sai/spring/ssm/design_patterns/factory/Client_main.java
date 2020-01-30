package com.sai.spring.ssm.design_patterns.factory;

public class Client_main {

	public static void main(String[] args) {
		
		
		
		AbstractComputerFactory computerFactory = new LaptopFactory();
		
		Computer computer = ComputerFactory.getInstance(computerFactory);
		
	
		computer.doSometing();

	}

}
