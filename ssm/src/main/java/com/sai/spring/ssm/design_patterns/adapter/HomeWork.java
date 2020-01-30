package com.sai.spring.ssm.design_patterns.adapter;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class HomeWork {
	
	private Pen p; 

	public Pen getP() {
		return p;
	}

	public void setP(Pen p) {
		this.p = p;
	}

	public void doHomeWork(String msg) {
		p.write(msg);
	}
}
