package com.jms;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MqConfig {

	private MqConfig() {
		
	}
	public static Session createSession() throws JMSException {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		try (Connection connection = activeMQConnectionFactory.createConnection()) {
			connection.start();
			return connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		}
	}
}
