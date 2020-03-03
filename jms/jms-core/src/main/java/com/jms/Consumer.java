package com.jms;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Consumer {
	Logger logger = LoggerFactory.getLogger(Consumer.class);

	public void consume() throws JMSException {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		try (Connection connection = activeMQConnectionFactory.createConnection()) {
			connection.start();
			try (Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)) {
				Destination destination = session.createQueue("foo.bar.abc");
				try (MessageConsumer consumer = session.createConsumer(destination)) {

					consumer.setMessageListener(message -> {
						try {
							message.acknowledge();
						} catch (JMSException e1) {
							logger.error(e1.getMessage());
						}
						TextMessage tMessage = (TextMessage) message;
						try {
							logger.info(tMessage.getText());
						} catch (JMSException e) {
							logger.error(e.getMessage());
						}
					});

					try {
						Thread.sleep(30000);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						logger.error(e.getMessage());
					}
				}
			}
		}
	}
}
