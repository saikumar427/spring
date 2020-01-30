package com.sai.spring.ssm.design_patterns.factory;

public class DesktopFactory implements AbstractComputerFactory {

	@Override
	public Computer createComputer() {
		return new Desktop();
	}

}
