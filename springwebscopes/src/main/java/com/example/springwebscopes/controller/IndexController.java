package com.example.springwebscopes.controller;

import com.example.springwebscopes.service.NumberService;
import com.example.springwebscopes.service.RandomNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private NumberService randomNumberService;
    @GetMapping("/home")
    public String indexAction(Model model){
        model.addAttribute("message", randomNumberService.getValue());
        return "index.html";
    }
}
