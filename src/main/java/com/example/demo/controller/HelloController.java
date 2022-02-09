package com.example.demo.controller;

import com.example.demo.model.Hello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public String hello(){
        return "hello world !!!";
    }

    @GetMapping("/api/main")
    public String main(){
        return "hello world !!!";
    }

    @GetMapping("/api/add")
    public int add(){
        Hello hello = new Hello();
        return hello.add(3,5);
    }
}
