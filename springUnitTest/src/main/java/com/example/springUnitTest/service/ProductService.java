package com.example.springUnitTest.service;

import com.example.springUnitTest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<String> getProductNamesEvenChar(){
        List<String> names = productRepository.getProduct();
//        List<String> result = new ArrayList<>();
//
//        for (String n : names){
//            if (n.length() % 2 == 0){
//                result.add(n);
//            }
//        }
//
//        return result;
        return names.stream()
                .filter(n -> n.length() % 2 == 0)
                .collect(Collectors.toList());
    }
}
