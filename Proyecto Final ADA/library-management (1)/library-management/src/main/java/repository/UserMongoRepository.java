package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<User, String> {

}

