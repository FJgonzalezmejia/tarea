package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookMongoRepository extends MongoRepository<Book, String> {}

