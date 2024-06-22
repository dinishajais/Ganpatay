package com.example.LibManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibManagement.model.Loan;
import com.example.LibManagement.service.LoanService;

@RestController
@RequestMapping("/loan")
public class LoanController {
	
	@Autowired
	LoanService loanService;
	
	@PostMapping("/{bookId}/member/{memberId}")
	public Loan save(@PathVariable Long bookId, @PathVariable Long memberId) {
		return loanService.save(bookId,memberId);
	}
	@PutMapping("/{loanId}")
	public Loan update(@PathVariable Long loanId) {
		return loanService.update(loanId);
	}
	@PostMapping("/all")
	public List<Loan> findAll(){
		return loanService.findAll();
	}

}
