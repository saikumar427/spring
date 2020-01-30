package com.sai.spring.ssm.design_patterns.adapter;

public class Main {

	public static void main(String ar[]) {
		Pen p = new PenAdapter();
		HomeWork work = new HomeWork();
		work.setP(p);
		work.doHomeWork("Please Complete homework .....!");
	}
}
