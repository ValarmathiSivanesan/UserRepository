package com.example.demo.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.springboot.model.User;
import com.example.demo.springboot.repository.UserRepository;

@Service
public class UserServices{	
	
	@Autowired
	UserRepository userRepository;

	public void addUser(User user) {		
		userRepository.addUser(user);				
	}
	
	public List<User> getUsers() {
		return userRepository.findAllUsers();				
	}
	
	public List<User> getByList() {
		return userRepository.getByListOfUserIn();				
	}

	public List<User> getByAge() {
		return userRepository.getByAge();				
	}

}
