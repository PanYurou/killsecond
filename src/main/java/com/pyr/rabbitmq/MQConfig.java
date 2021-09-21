package com.pyr.rabbitmq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;


@Configuration
public class MQConfig {

    public static final String QUEUE = "queue";
    @Bean
    public Queue queue(){
        return new Queue(QUEUE,true);
    }
}
