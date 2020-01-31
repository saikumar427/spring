package com.sai.spring.springcache.exceptions;

import java.time.Instant;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sai.spring.springcache.bean.Exception;

@RestControllerAdvice
public class CustomException {

	@ExceptionHandler
	public Exception customException(java.lang.Exception e) {
		Exception exception = new Exception();
		exception.setStatusCode(500);
		exception.setError(e.getMessage());
		exception.setInstant(Instant.now());
		return exception;
	}
}
