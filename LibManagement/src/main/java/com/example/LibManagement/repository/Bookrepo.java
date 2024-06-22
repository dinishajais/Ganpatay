package com.example.LibManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibManagement.model.BooksLib;

@Repository
public interface Bookrepo extends JpaRepository<BooksLib, Long> {
	Optional<BooksLib> findByTitleOrAuthor(String title, String Author);
}
