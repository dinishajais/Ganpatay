package com.todo.ToDoList.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.todo.ToDoList.model.Model;
import com.todo.ToDoList.repo.ToDoRepository;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	ToDoRepository toDoRepository;
	
	public ResponseEntity<Model> add(Model model) {
		return new ResponseEntity<>(toDoRepository.save(model),HttpStatus.CREATED);
	}
	
	public Optional<Model>  find(Long id) {
		return toDoRepository.findById(id);
	}
	public ResponseEntity<List<Model>> get() {
		return new ResponseEntity<> (toDoRepository.findAll(),HttpStatus.FOUND);
	}
	public void delete(Long id) {
		toDoRepository.deleteById(id);
	}
	public Optional<Model>  getid(Long id) {
		return toDoRepository.findById(id);
	}
}
