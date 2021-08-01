package com.pyr.controller;

import com.pyr.result.CodeMsg;
import com.pyr.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 使用@Controller而不用@RESTController是因为这里返回一个页面而不是一个值，如果只是使用@RestController注解Controller
 *则Controller中的方法无法返回jsp页面，配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
*/
@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/success")
    public Result<String> success() {
        return Result.success("hello world!");
    }

    @RequestMapping("/error")
    public Result<String> error() {
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("name", "张三");
        return "index";
    }
}
