package com.jms;

import java.util.stream.IntStream;

import javax.jms.JMSException;

public class Main2 {

	public static void main(String ar[]) throws JMSException {
		Producer producer = new Producer();
		IntStream.range(0, 10).forEach(x->{
			try {
				Thread.sleep(1000);
				producer.produce("Hello World this is my first message"+x);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
