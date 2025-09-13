package com.example.springbootmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class MyConsumei {
    //监听队列
    @RabbitListener(queues = "my_boot_fanout_queue1")
    public void process(Message message) {
        byte[] body = message.getBody();
        System.out.println("接收到的消息："+new String(body, StandardCharsets.UTF_8));
    }
}
