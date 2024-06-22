package com.telusko.quiz.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.quiz.app.dao.QuestionDao;
import com.telusko.quiz.app.model.Question;
import com.telusko.quiz.app.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("/allQuestions")
	public 	ResponseEntity<List<Question>> getAllQuestions() {
		return questionService.getAllQuestions();
		
	}
	
	@GetMapping("/category/{cat}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable("cat") String category){
		return questionService.getQuestionByCategory(category);
	}
	
	@PostMapping("/addQuestion")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}
	

}
