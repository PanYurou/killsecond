package com.pyr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/aa")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
