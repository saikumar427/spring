package com.jms;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Producer {
	Logger logger = LoggerFactory.getLogger(Producer.class);

	public void produce(String message) throws JMSException {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		try (Connection connection = activeMQConnectionFactory.createConnection()) {
			connection.start();
			try (Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)) {
				Destination destination = session.createQueue("foo.bar.abc");
				try (MessageProducer createProducer = session.createProducer(destination)) {
					TextMessage textMessage = session.createTextMessage();
					textMessage.setText(message);
					createProducer.send(textMessage);
				}
				logger.info("msg sent");
			}
		}
	}
}
