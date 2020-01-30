package com.sai.spring.ssm.service;

import org.springframework.statemachine.StateMachine;

import com.sai.spring.ssm.domain.Payment;
import com.sai.spring.ssm.domain.PaymentEvent;
import com.sai.spring.ssm.domain.PaymentState;

public interface PaymentService {

	Payment newPayment(Payment payment); 
	StateMachine<PaymentState, PaymentEvent> preAuth(Long paymantId);
	StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId);
	StateMachine<PaymentState, PaymentEvent> declinePayment(Long payemtId);
}
