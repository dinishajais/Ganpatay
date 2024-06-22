package com.example.LibManagement.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LibManagement.model.BooksLib;
import com.example.LibManagement.model.Loan;
import com.example.LibManagement.model.Member;
import com.example.LibManagement.repository.Bookrepo;
import com.example.LibManagement.repository.Loanrepo;
import com.example.LibManagement.repository.Memberrepo;

@Service
public class LoanService {

	@Autowired
	Bookrepo bookRepository;

	@Autowired
	Memberrepo memberRepository;

	@Autowired
	Loanrepo loanRepository;

	public Loan save(Long id, Long id2) {
		BooksLib book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
		String status = book.getStatus();
		Member member = memberRepository.findById(id2).orElseThrow(() -> new RuntimeException("Member not found"));
		Loan loan = new Loan();
		if (!status.equalsIgnoreCase("available")) {
			throw new RuntimeException("Book is not available for loan");
		}

		loan.setStartdate(LocalDate.now());
		loan.setDueDate(LocalDate.now().plusWeeks(2));
		loan.setStatus("lended");
		bookRepository.findById(id).get().setStatus("not");
		loan.setBook(book);
		loan.setMember(member);

		return loanRepository.save(loan);

	}

	public Loan update(Long loanId) {
		Loan loan=loanRepository.findById(loanId).orElseThrow(()->new RuntimeException("Loan not found"));
		loan.setStatus("returned");
		loan.getBook().setStatus("available");
		return loan;
	}

	public List<Loan> findAll() {
		return loanRepository.findAll();	}
	}
