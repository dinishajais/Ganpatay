package com.telusko.quiz.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.quiz.app.dao.QuizDao;
import com.telusko.quiz.app.model.Question;
import com.telusko.quiz.app.model.QuestionWrapper;
import com.telusko.quiz.app.model.Quiz;
import com.telusko.quiz.app.model.Response;
import com.telusko.quiz.app.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	@Autowired
	QuizDao quizDao;

	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title ){
		return quizService.createQuiz(category, numQ, title);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id){
		
		Optional<Quiz> quiz= quizDao.findById(id);
		List<Question> questionsFromDB= quiz.get().getQuestion();
		List<QuestionWrapper> questionsForUser=new ArrayList<>();
		
		for(Question q: questionsFromDB) {
			QuestionWrapper qw= new QuestionWrapper(q.getId(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4(), q.getQuestion_title());
			questionsForUser.add(qw);
		}
		
		return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
	}
	
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitResponse(@PathVariable Integer id, @RequestBody List<Response> responses){
		
		return quizService.calculateResult(id,  responses);
		
	}
	
}
