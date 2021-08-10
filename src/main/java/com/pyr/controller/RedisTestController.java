package com.pyr.controller;


import com.pyr.pojo.User;
import com.pyr.redis.RedisSevice;
import com.pyr.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/redis")
public class RedisTestController {

    @Autowired
    private RedisSevice redisSevice;

    @RequestMapping("/set")
    @ResponseBody
    public Result<Boolean> set() {
        User user = new User();
        user.setId(1);
        user.setName("zhangsan");
        boolean result = redisSevice.set(user.getName(), user);
        return Result.success(result);
    }

    @RequestMapping("/get")
    @ResponseBody
    public Result<User> get() {
        User user = redisSevice.get("zhangsan", User.class);
        return Result.success(user);
    }
}