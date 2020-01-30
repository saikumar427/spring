package com.sai.spring.ssm.design_patterns.adapter;

public class PenAdapter implements Pen{

	BlackPen pen = new BlackPen();
	@Override
	public void write(String msg) {
		pen.print(msg);
	}

}
