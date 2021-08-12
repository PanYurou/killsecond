package com.pyr.controller;

import com.pyr.pojo.User;
import com.pyr.result.CodeMsg;
import com.pyr.result.Result;
import com.pyr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 使用@Controller而不用@RESTController是因为这里返回一个页面而不是一个值，如果只是使用@RestController注解Controller
 *则Controller中的方法无法返回jsp页面，配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
*/
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/success")
    @ResponseBody
    public Result<String> success() {
        return Result.success("hello world!");
    }

    @RequestMapping("/error")
    @ResponseBody
    public Result<String> error() {
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("name", "张三");
        return "index";
    }

    @RequestMapping("/db/get")
    @ResponseBody
    public  Result<User> getUser(){
        User user = userService.getById(1);
        return Result.success(user);
    }
}
