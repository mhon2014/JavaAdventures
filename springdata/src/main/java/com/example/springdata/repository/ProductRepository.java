package com.example.springdata.repository;

import com.example.springdata.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    public List<Product> findAllProductByName(String name);

    @Query("Select p FROM Product p where p.id =:id")
    public Product findProductByID(String id);
}
