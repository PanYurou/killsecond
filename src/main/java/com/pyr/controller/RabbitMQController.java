package com.pyr.controller;

import com.pyr.rabbitmq.MQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/mq")
public class RabbitMQController {

    @Autowired
    MQSender mqSender;

    @RequestMapping("/send")
    public void mq() {
        mqSender.send("hello word!");
    }
}
