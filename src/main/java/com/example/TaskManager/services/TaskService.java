package com.example.TaskManager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.entities.User;
import com.example.TaskManager.exception.UserNotFoundException;
import com.example.TaskManager.repositories.TaskRepository;

@Service
public class TaskService {
	
	
	@Autowired
	private TaskRepository taskRepository;
	
	
	public Task addNewTask (Task task) {
		return taskRepository.save(task);
	}
	
	public void deleteTask(Integer id) {
		taskRepository.deleteById(id);
	}
	
	public void saveTask(Task newTask) {
		taskRepository.save(newTask);
	}
	
	public Task GetAllTasks(Integer id) {
	
		Optional <Task> foundTask= taskRepository.findById(id);
		
	
	if (!foundTask.isPresent()) {
		throw new UserNotFoundException();
	} return (foundTask.get());
	
	}
	
	public Optional <Task> GetTasksById(Integer taskId){
		return taskRepository.findById(taskId);
	}

	public Iterable<Task> GetTasksByUser(User user) {
		//TODO: what do we do if the user doesn't have any tasks or doesn't exist?
		
		return taskRepository.findByUser(user);
	}
}
