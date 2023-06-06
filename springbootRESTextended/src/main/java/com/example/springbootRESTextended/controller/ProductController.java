package com.example.springbootRESTextended.controller;

import com.example.springbootRESTextended.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/add/{name}")
    public void addProduct(@PathVariable String name){
        productService.addProduct(name);
    }
}
