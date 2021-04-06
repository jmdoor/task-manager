package com.example.TaskManager.controllers;

import java.util.Date;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.entities.User;
import com.example.TaskManager.services.TaskService;
import com.example.TaskManager.services.UserService;

@Controller
public class UserController {
		
	@Autowired
	UserService userService;
	
//	@Autowired
//	TaskService taskService; 
	
protected static User user;
	
	@GetMapping("/login")
	public String showForm(ModelMap model) {
		return "login";
	}
	
	@PostMapping("/login")
	public String authenticationCheck(ModelMap model, @RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
		
		if(!email.isBlank() && !password.isBlank()) {
			user = userService.getUserByEmail(email);					
			if(user != null) {
				if(user.getPassword().equals(password)) {
					model.addAttribute("userName", user.getName());
					model.addAttribute("userEmail", user.getEmail());
					model.addAttribute("userPassword", user.getPassword());
					return "home";
				}else {
					model.addAttribute("errorMessage", "Entered E-mail or Password was incorrect");
				}
			}else {
				model.addAttribute("errorMessage", "User not found!");
			}
		}else {
			model.addAttribute("errorMessage","You must enter both E-mail and Password");
		}
		
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		user = null;
		return "index";
	}
	
	@GetMapping("/userreg")
	public String showRegistration() {
		return "userreg";
	}
	
	@PostMapping("/userreg")
	public String registerUser(ModelMap model, @RequestParam(value = "id") Integer id, @RequestParam(value="name") String name, 
			@RequestParam(value="email") String email, @RequestParam(value="password") String password) {
		
				User user = new User();
				user.setId(id);
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
				userService.registerUser(user);
				model.addAttribute("message", "Congratulations, you're account has been registered!");
				return "login";
			}
		}
	
	
	