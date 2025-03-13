package com.ebrain.todo_list.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebrain.todo_list.entity.ToDoList;
import com.ebrain.todo_list.repository.ToDoRepository;

@Service
public class ToDoService {
	
	@Autowired
	ToDoRepository repository;

	public List<ToDoList> getAllToDos() {
	
		return repository.findAll();
	}

	public Optional<ToDoList> getById(Long id) {
		
		return repository.findById(id);
	}

	public ToDoList createToDo(ToDoList todoList) {
		return repository.save(todoList);
	}

	public ToDoList updateToDo(Long id, ToDoList todoList) {
		ToDoList existingToDolist = repository.findById(id).orElseThrow(()->new RuntimeException("ToDoList Not Found"));
		
		if(existingToDolist != null) {
			existingToDolist.setTitle(todoList.getTitle());
			existingToDolist.setDescription(todoList.getDescription());
			existingToDolist.setStatus(todoList.getStatus());
			
			return repository.save(existingToDolist);
	}
		return existingToDolist;
	}

	public void deleteToDoList(Long id) {
		repository.deleteById(id);
		
	}

	public List<ToDoList> filterToDoList(String title, String description, String status) {


      	return repository.filterToDoList(title,description,status);
		
	}

	public List<ToDoList> searchToDoList(String searchKey){

		return repository.searchByKey(searchKey);
		
	}
}
