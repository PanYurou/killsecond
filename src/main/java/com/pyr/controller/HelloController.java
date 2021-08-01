package com.pyr.controller;

import com.pyr.result.CodeMsg;
import com.pyr.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/success")
    public Result<String> success(){
        return Result.success("hello world!");
    }

    @RequestMapping("/error")
    public Result<String> error(){
        return Result.error(CodeMsg.SERVER_ERROR);
    }

}
