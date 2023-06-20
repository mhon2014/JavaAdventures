package com.example.springUnitTest.repository;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {

    public List<String> getProduct(){
        return Arrays.asList("aa", "bbb", "cccc", "ddddd");
    }
}
