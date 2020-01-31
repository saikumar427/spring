package com.sai.spring.springcache.bean;

import java.time.Instant;

import org.springframework.stereotype.Component;

@Component
public class Exception {

	private Integer statusCode;
	private String error;
	private Instant instant;
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Instant getInstant() {
		return instant;
	}
	public void setInstant(Instant instant) {
		this.instant = instant;
	}
	
	
	
}
