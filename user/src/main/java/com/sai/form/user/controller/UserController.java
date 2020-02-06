package com.sai.form.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sai.form.user.bean.User;
import com.sai.form.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String userform() {
		return "user/index";
	}
	
	@PostMapping(path="/user", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String  addUSer(@RequestParam Map<String, String> body, ModelMap modelMap) {
		User user = new User();
		user.setName(body.get("name"));
		user.setEmail(body.get("email"));
		user.setPhoneNumber(body.get("phoneNumber"));
		user.setGender(body.get("gender"));
		userService.saveUser(user);
		List<User> users = new ArrayList<>();
		users.add(user);
		modelMap.put("users", users);
		return "user/view";
	}
	
	@GetMapping("/users")
	public String showUsers(ModelMap modelMap) {
		List<User> users = userService.allUsers();
		modelMap.put("users", users);
		return "user/view";
	}
	
}
