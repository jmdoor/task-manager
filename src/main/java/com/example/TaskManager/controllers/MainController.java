package com.example.TaskManager.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.TaskManager.entities.User;
import com.example.TaskManager.services.TaskService;
import com.example.TaskManager.services.UserService;
@Controller
public class MainController {
	
	@GetMapping("/")
    public String showIndexPage() {   
		 return "index";
    }
	
	@GetMapping ("/login")
	public String showLogin(ModelMap model) {
		return "login"; 
	}
		
	@GetMapping(value="/register")
    public String showRegisterUser() {   
		 return "register";
    }
	
	@GetMapping(value="/createtask")
    public String showTaskPage() {   

		return "displaytask";
	}
	
	

	
	
	
	
	
	
	
}