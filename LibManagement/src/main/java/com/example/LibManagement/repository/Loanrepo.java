package com.example.LibManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibManagement.model.Loan;

@Repository
public interface Loanrepo extends JpaRepository<Loan, Long> {

}
