package com.example.springdatacontracts.controller;

import com.example.springdatacontracts.entity.Product;
import com.example.springdatacontracts.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/sort")
    public Iterable<Product> getAllSortedDescendingByID(){
        return productRepository.findAll(Sort.by("id").descending());
    }

    @GetMapping("/page/ascending/{page}")
    public List<Product> getProductsByPageAscending(@PathVariable int page){
        Sort s = Sort.by("id").ascending();
        return productRepository.findAll(PageRequest.of(page, 3,s)).getContent();
    }

    @GetMapping("/page/{page}")
    public List<Product> getProductsByPage(@PathVariable int page){
        return productRepository.findAll(PageRequest.of(page, 3)).getContent();
    }

    @GetMapping("/name/{name}")
    public List<Product> getProductsByName(@PathVariable String name){
        return productRepository.findProductsByName(name);
    }

    @GetMapping("/name/sort/{name}")
    public List<Product> getProductsByNameSorted(@PathVariable String name){
        return productRepository.findProductsByName(name, Sort.by("id").descending());
    }

    @GetMapping("/name/{name}/{page}")
    public List<Product> getProductsByNamePage(@PathVariable String name, @PathVariable int page){
        Pageable p = PageRequest.of(page, 3);
        return productRepository.findProductsByName(name, p);
    }


}
