package com.sai.spring.ssm.config;

import java.util.EnumSet;
import java.util.logging.Logger;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

import com.sai.spring.ssm.domain.PaymentEvent;
import com.sai.spring.ssm.domain.PaymentState;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableStateMachineFactory
public class StateMachineConfig extends StateMachineConfigurerAdapter<PaymentState, PaymentEvent> {

	private static Logger log = Logger.getLogger(StateMachineConfig.class.getName());
	
	@Override
	public void configure(StateMachineStateConfigurer<PaymentState, PaymentEvent> states) throws Exception {
		states.withStates()
			.initial(PaymentState.New, System.out::println)
			.states(EnumSet.allOf(PaymentState.class))
			.end(PaymentState.AUTH)
			.end(PaymentState.PRE_AUTH_ERROR)
			.end(PaymentState.AUTH_ERROR);
	}

	@Override
	public void configure(StateMachineTransitionConfigurer<PaymentState, PaymentEvent> transitions) throws Exception {
		transitions
				.withExternal()
					.source(PaymentState.New)
					.target(PaymentState.New)
					.event(PaymentEvent.PRE_AUTHORIZE)
			.and()
				.withExternal()
					.source(PaymentState.New)
					.target(PaymentState.PRE_AUTH)
					.event(PaymentEvent.PRE_AUTHORIZE_APPROVED)
			.and()
				.withExternal()
					.source(PaymentState.New)
					.target(PaymentState.PRE_AUTH_ERROR)
					.event(PaymentEvent.PRE_AUTHORIZE_DECLINED)
			.and()
				.withExternal()
					.source(PaymentState.PRE_AUTH)
					.target(PaymentState.PRE_AUTH)
					.event(PaymentEvent.AUTHORIZE)
			.and()
				.withExternal()
					.source(PaymentState.PRE_AUTH)
					.target(PaymentState.AUTH)
					.event(PaymentEvent.AUTHORIZE_APPROVED)		
			.and()
				.withExternal()
					.source(PaymentState.PRE_AUTH)
					.target(PaymentState.AUTH_ERROR)
					.event(PaymentEvent.AUTHORIZE_DECLINED)		
					;
					
	}

	@Override
	public void configure(StateMachineConfigurationConfigurer<PaymentState, PaymentEvent> config) throws Exception {
		StateMachineListenerAdapter<PaymentState, PaymentEvent> adapter = new StateMachineListenerAdapter<PaymentState, PaymentEvent>() {

			@Override
			public void stateChanged(State<PaymentState, PaymentEvent> from, State<PaymentState, PaymentEvent> to) {
				logMsg("stateChanged", from, to);
				super.stateChanged(from, to);
			}

			@Override
			public void stateEntered(State<PaymentState, PaymentEvent> state) {
				logMsg("stateEntered", state,null);
				super.stateEntered(state);
			}

			@Override
			public void stateExited(State<PaymentState, PaymentEvent> state) {
				logMsg("stateExited", state,null);
				super.stateExited(state);
			}

			@Override
			public void transitionStarted(Transition<PaymentState, PaymentEvent> transition) {
				logMsg("transitionStarted", "" ,"");
				super.transitionStarted(transition);
			}

			@Override
			public void transitionEnded(Transition<PaymentState, PaymentEvent> transition) {
				logMsg("transitionEnded", "" ,"");
				super.transitionEnded(transition);
			}
			
			private void logMsg(String event, State<PaymentState, PaymentEvent> from, State<PaymentState, PaymentEvent> to) {
				logMsg(event, from == null ? null : from.getId(), to == null ? null : to.getId());
			}
			private void logMsg(String event, PaymentState paymentState, PaymentState paymentState2) {
				String s1 = "",s2 = "";
				if(paymentState != null)
					s1 = paymentState.toString();
				if(paymentState2 != null)
					s2 = paymentState2.toString();
				logMsg(event, s1, s2);
			}
			private void logMsg(String event, String paymentState, String paymentState2) {
				log.info(String.format("%s occured and state changed from %s to %s", event, paymentState, paymentState2));
			}
			
		};
		config.withConfiguration().listener(adapter);
	}

}
