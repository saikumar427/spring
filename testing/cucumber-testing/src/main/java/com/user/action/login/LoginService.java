package com.user.action.login;

public class LoginService {

	public boolean isValid(String username, String password) {
		System.out.println("In loginService....!");
		return username.contains("sai") && password.contains("kumar");
	}
}
