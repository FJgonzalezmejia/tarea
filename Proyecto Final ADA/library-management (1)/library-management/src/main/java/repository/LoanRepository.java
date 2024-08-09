package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {}


