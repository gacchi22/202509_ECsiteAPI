package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Spring Boot 起動OK!";
    }

    @GetMapping("/hello")
    public String hello2() {
        return "Hello 2 OK!";
    }
}