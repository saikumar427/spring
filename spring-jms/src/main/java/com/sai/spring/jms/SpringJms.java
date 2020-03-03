package com.sai.spring.jms;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJms implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(SpringJms.class);

	@Autowired
	ActiveMQConnectionFactory activeMQConnectionFactory;

	public static void main(String[] args) {
		SpringApplication.run(SpringJms.class, args);
	}

	public void consume() throws JMSException {
		Connection connection = activeMQConnectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("standalone.queue");
		MessageConsumer consumer = session.createConsumer(destination);

		consumer.setMessageListener(message -> {
			try {
				message.acknowledge();
			} catch (JMSException e1) {
				logger.error(e1.getMessage());
			}
			TextMessage tMessage = (TextMessage) message;
			try {
				System.out.println("Received Message Queue: " + tMessage.getText());
			} catch (JMSException e) {
				logger.error(e.getMessage());
			}
		});

	}

	@Override
	public void run(String... args) throws Exception {
		consume();

	}
}
