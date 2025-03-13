package com.ebrain.todo_list.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ebrain.todo_list.entity.ToDoList;
@Repository
public interface ToDoRepository extends JpaRepository<ToDoList, Long> {

	
	@Query(value = "SELECT * FROM `todo-list` WHERE " +
		       "(:title IS NULL OR title = :title) AND " +
		       "(:description IS NULL OR description = :description ) AND "+
		       "(:status IS NULL OR status = :status)",
		       nativeQuery = true)
   public List<ToDoList> filterToDoList(String title, String description, String status);

	@Query("SELECT t FROM ToDoList t WHERE " +
		       "(:searchKey IS NOT NULL AND :searchKey <> '' AND " +
		       "(t.title LIKE %:searchKey% OR t.description LIKE %:searchKey% OR t.status LIKE %:searchKey%))")
		List<ToDoList> searchByKey(@Param("searchKey") String searchKey);


	
}
