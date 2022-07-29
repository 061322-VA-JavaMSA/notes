package com.revature.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.clients.TaskClient;
import com.revature.dtos.TaskDTO;
import com.revature.events.Operation;
import com.revature.events.UserChangeEvent;
import com.revature.models.Role;
import com.revature.models.Task;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.services.MessageService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class UserController {

	private UserRepository ur;
	private TaskClient tc;
	private MessageService ms;

	@Autowired
	public UserController(UserRepository ur, TaskClient tc, MessageService ms) {
		this.ur = ur;
		this.tc = tc;
		this.ms = ms;
	}
	
	// /users/1/tasks - PUT
	@PutMapping("/{id}/tasks")
	public ResponseEntity<User> assignTasks(@PathVariable("id")int id, @RequestBody List<Task> tasks){
		User user = ur.findById(id).orElse(null);

		if (user == null) {
			return ResponseEntity.notFound().build();
		}

		user.setTasks(tasks);
		
		ur.save(user);
		
		UserChangeEvent event = new UserChangeEvent();
		event.setUserId(user.getId());
		event.setTasks(user.getTasks());
		event.setOperation(Operation.UPDATE);
		event.setTimestamp(LocalDateTime.now());
		
		ms.triggerEvent(event);
		
		return ResponseEntity.ok(user);
	}

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> users = ur.findAll();

		if (users.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(users);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") int id) {
		User user = ur.findById(id).orElse(null);

		if (user == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(user);
	}
	
	@CircuitBreaker(name="tc", fallbackMethod ="fallbackExample")
	@GetMapping("/{id}/tasks")
	public ResponseEntity<List<TaskDTO>> findTasksByUserId(@PathVariable("id") Integer id) {
		
		User user = ur.findById(id).orElse(null);

		if (user == null) {
			return ResponseEntity.notFound().build();
		}

		List<TaskDTO> tasks = this.tc.getTaskByUserId(id);

		if(tasks.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(tasks);
	}

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user) {
		// Service logic, setting/overriding values to defaults
		Role basicUser = new Role();
		basicUser.setId(2);

		user.setId(0);
		user.setRole(basicUser);

		ur.save(user);

		return ResponseEntity.status(201).body(user);
	}

	@GetMapping("/tasks/{id}")
	public ResponseEntity<List<User>> findByTaskId(@PathVariable("id")int id) {
		List<User> users = ur.findAllByTasks_Id(id);
		
		
		return ResponseEntity.ok(users);
	}

	@CircuitBreaker(name="tc", fallbackMethod ="fallbackExample")
	@GetMapping("/tasks/port")
	public ResponseEntity<String> getPort(){
		String port = this.tc.getPort();
		
		return ResponseEntity.ok(port);
	}
	
	public ResponseEntity<String> fallbackExample(Exception e){
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Task service is currently unavailable.");
	}
	
}
