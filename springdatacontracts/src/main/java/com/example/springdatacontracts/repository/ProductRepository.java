package com.example.springdatacontracts.repository;

import com.example.springdatacontracts.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    List<Product> findProductsByName(String name);
    List<Product> findProductsByName(String name, Sort s);

    List<Product> findProductsByName(String name, Pageable p);

}
