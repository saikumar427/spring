package com.sai.spring.ssm.design_patterns.factory;

public class ComputerFactory {

	public static Computer getInstance(AbstractComputerFactory computerFactory) {
		return computerFactory.createComputer();
	}
}
