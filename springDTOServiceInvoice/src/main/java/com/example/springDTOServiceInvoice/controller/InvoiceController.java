package com.example.springDTOServiceInvoice.controller;

import com.example.springDTOServiceInvoice.dto.Invoice;
import com.example.springDTOServiceInvoice.dto.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvoiceController {

    @PostMapping("/invoice")
    public Invoice createInvoice(@RequestBody Product p){
        Invoice i = new Invoice();
        i.setProducts(List.of(p));
        return i;
    }

}
