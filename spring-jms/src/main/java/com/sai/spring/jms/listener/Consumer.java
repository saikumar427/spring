package com.sai.spring.jms.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "standalone.queue")
    @SendTo("standalone.queue_two")
    public String consumeQueue(String message) {
        System.out.println("Received Message Queue: " + message);
        return "FORWARD :: "+message;
    }
    
    @JmsListener(destination = "standalone.queue_two")
    public void consumeQueueTwo(String message) {
        System.out.println("Received Message Queue two: " + message);
    }
    
    @JmsListener(destination = "standalone.topic")
    public void consumeTopic(String message) {
        System.out.println("Received Message Topic: " + message);
    }
    
    @JmsListener(destination = "standalone.topic")
    public void consumeQueueTopic(String message) {
        System.out.println("Received Message Topic two: " + message);
    }
    
    
}
