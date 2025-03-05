package com.ebrain.todo_list.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ebrain.todo_list.entity.ToDoList;
@Repository
public interface ToDoRepository extends JpaRepository<ToDoList, Long> {

	
	@Query(value = "SELECT * FROM `todo-list` WHERE title LIKE LOWER(CONCAT('%',:title,'%')) OR description LIKE LOWER(CONCAT('%',:description,'%')) OR status LIKE LOWER(CONCAT('%',:status,'%'))",nativeQuery = true)
   public List<ToDoList> filterToDoList(String title, String description, String status);

	@Query(value = "SELECT * FROM `todo-list` WHERE title LIKE LOWER(CONCAT('%',:searchKey,'%'))OR description LIKE LOWER(CONCAT('%',:searchKey,'%')) OR status LIKE LOWER(CONCAT('%',:searchKey,'%'))",nativeQuery = true)
	public List<ToDoList> searchByKey(String searchKey);
	

	
}
