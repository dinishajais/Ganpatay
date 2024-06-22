package com.example.LibManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibManagement.model.Author;

@Repository
public interface Authorrepo extends JpaRepository<Author, Long> {

}
