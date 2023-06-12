package com.example.springdataMongoDB.repository;

import com.example.springdataMongoDB.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

}
