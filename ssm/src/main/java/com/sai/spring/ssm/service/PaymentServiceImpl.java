package com.sai.spring.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

import com.sai.spring.ssm.domain.Payment;
import com.sai.spring.ssm.domain.PaymentEvent;
import com.sai.spring.ssm.domain.PaymentState;
import com.sai.spring.ssm.repository.PayementRepository;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PayementRepository paymentRepository;
	
	private StateMachine<PaymentState, PaymentEvent> machine;

	@Override
	public Payment newPayment(Payment payment) {
		payment.setState(PaymentState.New);
		return paymentRepository.save(payment);
	}

	@Override
	public StateMachine<PaymentState, PaymentEvent> preAuth(Long paymantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StateMachine<PaymentState, PaymentEvent> declinePayment(Long payemtId) {
		// TODO Auto-generated method stub
		return null;
	}

}
