package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoanMongoRepository extends MongoRepository<Loan, String> {}


