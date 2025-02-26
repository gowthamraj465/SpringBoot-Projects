package com.ebrain.todo_list.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebrain.todo_list.entity.ToDoList;
import com.ebrain.todo_list.service.ToDoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name = "To-Do List",description = "Task management APIs")
@RestController
@RequestMapping("/tasks")
public class ToDoController {
	
	@Autowired
	ToDoService service;
	
	@GetMapping("/get")
    @Operation(summary = "Get All Tasks", description = "Retrieve all tasks")
	public List<ToDoList> getAllToDos(){
		return service.getAllToDos();
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<ToDoList> getById(@PathVariable Long id){
		
		Optional<ToDoList> todo = service.getById(id);
		
		if(todo.isPresent()) {
			return ResponseEntity.ok(todo.get());
		}else {
			return ResponseEntity.notFound().build();
		}	
	}
	@PostMapping("/save")
	@Operation(summary = "save new tasks",description = "creates new tasks")
	public ToDoList createToDo(@RequestBody ToDoList todoList) {
		return service.createToDo(todoList);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ToDoList> updateToDo(@PathVariable Long id, @RequestBody ToDoList todoList) {
		try {
		ToDoList updatedToDo = service.updateToDo(id,todoList);
		return ResponseEntity.ok(updatedToDo);
	}catch(RuntimeException e) {
		ResponseEntity.notFound().build();
	}
		return null;		
}
	@DeleteMapping("/delete/{id}")
	public void deleteToDoList(@PathVariable Long id) {
		service.deleteToDoList(id);
	}
}
