package com.sai.spring.ssm.design_patterns.factory;

public class Server implements Computer {

	@Override
	public void doSometing() {
		System.out.println("Server doing something ...");
	}

}
