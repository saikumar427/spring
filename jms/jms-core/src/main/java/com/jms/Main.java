package com.jms;

import java.util.stream.IntStream;

import javax.jms.JMSException;

public class Main {

	public static void main(String ar[]) throws JMSException {
		
		Consumer consumer = new Consumer();
		consumer.consume();
	}
}
