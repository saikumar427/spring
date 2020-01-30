package com.sai.spring.ssm.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Payment {

	@Id
	@GeneratedValue
	private Long id;

	@Enumerated(EnumType.STRING)
	private PaymentState state;

	public Payment(){
		
	}
	
	public Payment(Long id, PaymentState state) {
		super();
		this.id = id;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PaymentState getState() {
		return state;
	}

	public void setState(PaymentState state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", state=" + state + "]";
	}
	
}
