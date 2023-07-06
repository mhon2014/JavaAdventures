package com.example.springsecuritycontracts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController
//public class HelloController {
//    @GetMapping("/hello")
//    public String hello(){
//        return "Hello";
//    }
//}

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello.html";
    }
}
