package com.sai.form.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.form.user.bean.User;
import com.sai.form.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public List<User> allUsers(){
		return repository.findAll();
	}
	
	public User getUser(Long id) {
		return repository.getOne(id);
	}
	
	public void deleteUser(Long id) {
		repository.delete(getUser(id));
	}
}
