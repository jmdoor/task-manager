package com.example.TaskManager.controllers;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.services.TaskService;
import com.example.TaskManager.entities.User;

@Controller
public class TaskController {
		
	@Autowired
	TaskService taskService;	
	
	
	@PostMapping("/createtask")
	public String SubmitTaskPage(ModelMap model, @RequestParam (value ="name") String name,@RequestParam (value = "description") String description, @RequestParam (value = "start_date") Date start, @RequestParam (value = "end_date") Date end,
			@RequestParam (value = "email") String email, @RequestParam(value = "severity") String severity, @RequestParam(value ="user") User user) {
		
		Task tasks = new Task();
		tasks.setName(name);
		tasks.setDescription(description);
		tasks.setStartDate(start);
		tasks.setEndDate(end);
		tasks.setSeverity(severity);
		taskService.saveTask(tasks);
		tasks.setUser(user);
		
		
		return "updatetask";
	

	}
}
