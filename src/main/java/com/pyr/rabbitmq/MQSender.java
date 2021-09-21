package com.pyr.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQSender {

    @Autowired
    AmqpTemplate amqpTemplate;

    public static Logger log = LoggerFactory.getLogger(MQReceiver.class);


    public void send(String message){
        log.info("send message:"+message);
        amqpTemplate.convertAndSend(MQConfig.QUEUE,message);
    }
}
