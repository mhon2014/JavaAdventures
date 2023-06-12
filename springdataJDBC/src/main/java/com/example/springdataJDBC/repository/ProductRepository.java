package com.example.springdataJDBC.repository;

import com.example.springdataJDBC.model.Product;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository  extends CrudRepository<Product, Integer> {

    @Query("SELECT * FROM productdemo WHERE name= :name")
    Iterable<Product> findProductsByName(String name);
}
