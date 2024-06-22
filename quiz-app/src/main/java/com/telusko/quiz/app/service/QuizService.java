package com.telusko.quiz.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.quiz.app.dao.QuestionDao;
import com.telusko.quiz.app.dao.QuizDao;
import com.telusko.quiz.app.model.Question;
import com.telusko.quiz.app.model.Quiz;
import com.telusko.quiz.app.model.Response;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<String> createQuiz(String category,int numQ,String title){
		
		List<Question> questions=questionDao.findRandomQuestionsByCategory(category, numQ);
		
		Quiz quiz=new Quiz();
		
		quiz.setTitle(title);
		quiz.setQuestion(questions);
		
		quizDao.save(quiz);
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
		
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		// TODO Auto-generated method stub
		
		Optional<Quiz> quiz=quizDao.findById(id);
		
		List<Question> questions = quiz.get().getQuestion();
		int right=0,i=0;
		
		for(Response response:responses) {
			
			if(response.getResponse().equals(questions.get(i).getRight_answer())) {
				right++;
			}
			i++;
		}
		
		return new ResponseEntity<>(right, HttpStatus.OK);
	}

}
