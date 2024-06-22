package com.example.LibManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.LibManagement.model.Author;
import com.example.LibManagement.repository.Authorrepo;

@Service
public class AuthorService {
	@Autowired
	Authorrepo authorrepo;

	@ResponseStatus(HttpStatus.ACCEPTED)
	public Author save(Author author) {
		return authorrepo.save(author);
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	public Author update(Long id, String name, String biography) {
		Author found = authorrepo.findById(id).get();
		if (name != null) {
			found.setName(name);
			save(found);
			return found;
		}
		if (biography != null) {
			found.setBiography(biography);
			save(found);
			return found;
		}
		return found;
	}
	@ResponseStatus(HttpStatus.ACCEPTED)
	public List<Author> findAll() {

		return authorrepo.findAll();
	}
	public String delete(Long id) {
		if(authorrepo.findById(id).isPresent()) {
			authorrepo.deleteById(id);
		return "as u say my lord, Its deleted";
		}
		else {
			return "sorry my lord, this id ain't present";
		}
	}


}
