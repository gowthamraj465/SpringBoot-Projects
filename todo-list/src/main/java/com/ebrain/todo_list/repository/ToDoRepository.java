package com.ebrain.todo_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ebrain.todo_list.entity.ToDoList;
@Repository
public interface ToDoRepository extends JpaRepository<ToDoList, Long> {

}
