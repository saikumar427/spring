package com.sai.spring.ssm.domain;

public enum PaymentState {
	New, 
	PRE_AUTH, 
	PRE_AUTH_ERROR,
	AUTH,
	AUTH_ERROR; 
}
