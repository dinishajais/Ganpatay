package com.todo.ToDoList.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.ToDoList.model.Model;

@Repository
public interface ToDoRepository extends JpaRepository<Model, Long> {
	
	

}
