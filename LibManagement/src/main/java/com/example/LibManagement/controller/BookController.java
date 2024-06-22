package com.example.LibManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibManagement.model.BooksLib;
import com.example.LibManagement.repository.Bookrepo;
import com.example.LibManagement.service.BookService;

@RestController
@RequestMapping("/lib")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	Bookrepo bookrepo;
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public BooksLib save(@RequestBody BooksLib lib) {
		return bookService.save(lib);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public BooksLib find(@PathVariable String id, @RequestBody BooksLib lib) {
		return bookService.save( bookService.find(id,lib));
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable String id) {
		return bookService.delete(id);
	}
	@PostMapping("/{id}")
	public BooksLib find(@PathVariable Long id) {
		return bookrepo.findById(id).get();
	}
	
}
