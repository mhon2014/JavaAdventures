package com.example.springdataMongoDB.controller;

import com.example.springdataMongoDB.model.Movie;
import com.example.springdataMongoDB.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/test")
    public List<Movie> testProduct(){
        Pageable p = PageRequest.of(0,3);
        return movieRepository.findAll(p).getContent();
    }

    @GetMapping("/all")
    public List<Movie> findAll(){
//        Pageable p = PageRequest.of(0,3);
        return movieRepository.findAll();
    }
}
