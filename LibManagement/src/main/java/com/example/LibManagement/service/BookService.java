package com.example.LibManagement.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.LibManagement.model.BooksLib;
import com.example.LibManagement.repository.Bookrepo;

@Service
public class BookService {
	
	@Autowired
	Bookrepo bookrepo;
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	public BooksLib save(BooksLib lib) {
		return bookrepo.save(lib);
	}
	
	@ResponseStatus(HttpStatus.FOUND)
	public BooksLib find(String id,BooksLib lib) {
		Optional<BooksLib> book=bookrepo.findByTitleOrAuthor(id, id);
		if(book.isPresent()) {
			lib.setId(book.get().getId());
			return lib;
		}
		else {
			return null;
		}
	}

	public String delete(String id) {
		if(id.matches("\\d+")) {
			Long ide=Long.parseLong(id);
			if((bookrepo.findById(ide)).isPresent()) {
				bookrepo.deleteById(ide);
				return "deleted by ID :)";
			}
			else {
				return "Could not find this ID";
			}
		}
		else {
			if((bookrepo.findByTitleOrAuthor(id,id)).isPresent()) {
				bookrepo.deleteById((bookrepo.findByTitleOrAuthor(id,id)).get().getId());
				return"Deleted by title or author";
			}
			else {
				return "no such author or title present";
			}
		}
	}

}
