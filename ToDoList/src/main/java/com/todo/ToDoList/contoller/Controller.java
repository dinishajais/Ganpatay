package com.todo.ToDoList.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.ToDoList.model.Model;
import com.todo.ToDoList.service.Service;

@RestController
@RequestMapping("/todo")
public class Controller {

	@Autowired
	Service service;

	@PostMapping("/create")
	public ResponseEntity<Model> add(@RequestBody Model model) {
		return service.add(model);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Model> find(@PathVariable Long id, @RequestBody Model model) {
		if (service.find(id).isPresent()) {
			model.setId(id);
			return service.add(model);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/all")
	public ResponseEntity<List<Model>> get() {
		return service.get();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<List<Model>> delete(@PathVariable Long id) {
		service.delete(id);
		return service.get();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Model>>  getid(@PathVariable Long id) {
		return new ResponseEntity<> (service.getid(id), HttpStatus.FOUND);
	}
}
