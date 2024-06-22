package com.example.LibManagement.controller;

import java.util.List;
import java.util.Map;

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

import com.example.LibManagement.model.Author;
import com.example.LibManagement.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	AuthorService authorService;

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/save")
	public Author save(@RequestBody Author author) {
		return authorService.save(author);
	}

	@ResponseStatus(HttpStatus.FOUND)
	@PutMapping("/{id}")
	public Author update(@PathVariable Long id, @RequestBody Map<String, String> update) {
		String name = "", biography = "";
		name = update.get("name");
		biography = update.get("biography");
		return authorService.update(id, name, biography);
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/all")
	public List<Author> findAll() {
		return authorService.findAll();
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		return authorService.delete(id);
	}

}