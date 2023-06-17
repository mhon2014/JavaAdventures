package com.example.springDTOServiceProduct.controller;

import com.example.springDTOServiceProduct.dto.Invoice;
import com.example.springDTOServiceProduct.dto.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {
    @PostMapping("product")
    public void product(@RequestBody Product p){

        RestTemplate rest = new RestTemplate();

        HttpEntity<Product> body = new HttpEntity<>(p);

        ResponseEntity<Invoice> response = rest.postForEntity("http://localhost:9090/invoice",
                                                                body,
                                                                Invoice.class);

        System.out.println(response.getBody());
    }
}
