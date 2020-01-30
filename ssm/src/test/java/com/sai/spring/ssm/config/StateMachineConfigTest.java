package com.sai.spring.ssm.config;


import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

import com.sai.spring.ssm.domain.PaymentEvent;
import com.sai.spring.ssm.domain.PaymentState;

@SpringBootTest
class StateMachineConfigTest {

	@Autowired
	private StateMachineFactory<PaymentState, PaymentEvent> stateMachineFactory; 

	@Test
	void testStateMachine() {
		StateMachine<PaymentState, PaymentEvent> machine = stateMachineFactory.getStateMachine(UUID.randomUUID());
		machine.start();
		System.out.println(machine.getState());
		machine.sendEvent(PaymentEvent.PRE_AUTHORIZE);
		System.out.println(machine.getState());
		machine.sendEvent(PaymentEvent.PRE_AUTHORIZE_APPROVED);
		System.out.println(machine.getState());
		machine.sendEvent(PaymentEvent.AUTHORIZE);
		System.out.println(machine.getState());
		machine.sendEvent(PaymentEvent.AUTHORIZE_APPROVED);
		System.out.println(machine.getState());
	}
}
