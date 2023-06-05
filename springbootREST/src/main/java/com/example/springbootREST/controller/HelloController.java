package com.example.springbootREST.controller;

import com.example.springbootREST.dto.Person;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, path = "/hello/{name}")
    public String hello(@PathVariable("name") String name){
        return "Hello, " + name + "!" ;
    }

    @GetMapping(path = "/hello")
    public String hello(){
        return "Hello";
    }

    @PostMapping(path = "/goodbye")
    public String goodbye(@RequestBody Person p){
        return "Goodbye, " + p.getName() + "!";
    }

    @GetMapping(path = "/getall")
    public List<Person> getAllPerson(){
        Person p1 = new Person("Bill");
        Person p2 = new Person("Bob");
        return Arrays.asList(p1,p2);
    }

    @GetMapping(path = "/statustest")
    public void statusTest(HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }



}
