package com.example.TaskManager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManager.entities.User;
import com.example.TaskManager.exception.UserNotFoundException;
import com.example.TaskManager.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Iterable<User> GetAllUsers() {
		return userRepository.findAll();
	}

	public User GetUserByName(String email) {
		User foundUser = userRepository.findByEmail(email);
		
		return foundUser;
	}

	

	
	public User save(User user) {
		User foundUser = userRepository.save(user);
		return foundUser;
	}

	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public void registerUser(User user) {
		userRepository.save(user);
	}


}

