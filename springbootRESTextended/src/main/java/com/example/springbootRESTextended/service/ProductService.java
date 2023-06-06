package com.example.springbootRESTextended.service;

import com.example.springbootRESTextended.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public void addProduct(String name){
        productRepository.addProduct(name);
    }
}
