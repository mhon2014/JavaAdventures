package com.example.springbootRESTextended.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping(path = "/test")
    public String test(@RequestHeader String a,
                       @RequestHeader String b,
                       @RequestHeader String c) {
        return a + " " + b + " " + c;
    }

    @PostMapping (path = "/test/{name}")
    public String testName(@PathVariable String name,
                           @RequestHeader String a,
                           @RequestHeader String b,
                           @RequestHeader String c,
                           @RequestBody String body,
                           HttpServletResponse response) {
        response.addHeader("test", "good");
        return name + " " + a + " " + b + " " + c + " " + body;
    }

    @GetMapping(path = "/all")
    public Map<String, String> all(@RequestHeader Map<String, String> map){
        return map;
    }

    @GetMapping(path = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] pdf(){
        byte [] file = new byte[100];
        return file;
    }

}
