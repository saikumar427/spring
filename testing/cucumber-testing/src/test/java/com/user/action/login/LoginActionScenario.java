package com.user.action.login;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;

import com.user.action.login.LoginAction;
import com.user.action.login.LoginService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginActionScenario {

	
	LoginService loginService = Mockito.mock(LoginService.class);
	LoginAction loginAction = new LoginAction(loginService);
	
	@Given("^user enterd username as \"([^\"]*)\"$")
	public void user_enterd_username_as(String username) throws Throwable {
		loginAction.setUsername(username);
		System.out.println("user enterted username as "+username);
	}

	@Given("^and password as \"([^\"]*)\"$")
	public void and_password_as(String password) throws Throwable {
		loginAction.setPassword(password);
		System.out.println("user enterted password as "+password);
	}

	@When("^user clicked login button$")
	public void user_clicked_login_button() throws Throwable {
		System.out.println("user clicked login button");
	}

	@Then("^valid user \"([^\"]*)\"$")
	public void valid_user(String arg1) throws Throwable {
		when(loginService.isValid("sai","kumar")).thenReturn(true);
		if(loginAction.isValidUser())
			System.out.println("valid user "+arg1);
		else
			System.out.println("not valid user "+arg1);
		verify(loginService).isValid(anyString(),anyString());
	}

}
