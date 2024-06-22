package com.telusko.quiz.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.quiz.app.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> { 
	
	
}
