package com.example.springDTOServiceProduct.dto;

import java.util.List;

public class Invoice {
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    private List<Product> products;
}
