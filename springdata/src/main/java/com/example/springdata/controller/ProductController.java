package com.example.springdata.controller;

import com.example.springdata.entity.Product;
import com.example.springdata.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/add")
    public void addProduct(@RequestBody Product p){
        productRepository.save(p);
    }

    @GetMapping("/find/{name}")
    public List<Product> getProduct(@PathVariable String name){
        return productRepository.findAllProductByName(name);
    }

    @GetMapping("/findtest/{name}")
    public Product getTestProduct(@PathVariable String name){
        return productRepository.findProductByID(name);
    }
}
