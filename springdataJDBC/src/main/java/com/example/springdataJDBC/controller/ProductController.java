package com.example.springdataJDBC.controller;

import com.example.springdataJDBC.model.Product;
import com.example.springdataJDBC.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/all")
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    @GetMapping("/name/{name}")
    public Iterable<Product> findAll(@PathVariable String name){
        return productRepository.findProductsByName(name);
    }
}
