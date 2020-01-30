package com.sai.spring.ssm.design_patterns.factory;

public class ServerFactory implements AbstractComputerFactory {

	@Override
	public Computer createComputer() {
		return new Server();
	}

}
