package com.sai.spring.ssm.design_patterns.factory;

public class LaptopFactory implements AbstractComputerFactory {

	@Override
	public Computer createComputer() {
		return new Laptop();
	}

}
