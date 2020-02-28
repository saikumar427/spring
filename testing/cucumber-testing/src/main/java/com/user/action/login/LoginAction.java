package com.user.action.login;

public class LoginAction {

	private String username;
	private String password;
	private LoginService loginService;
	
	public LoginAction() {
		
	}
	public LoginAction(LoginService loginService) {
		this.loginService = loginService;
	}
	
	public LoginAction(String username,String password) {
		this.username = username;
		this.password = password;
	}
	
	public boolean isValidUser() {
		System.out.println("in LoginAction......!");
		return loginService.isValid(username, password);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
