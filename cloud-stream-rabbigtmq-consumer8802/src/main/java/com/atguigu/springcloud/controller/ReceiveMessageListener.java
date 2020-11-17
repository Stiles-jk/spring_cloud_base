package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @auther Stiles-JKY
 * @date 2020/11/16-22:44
 */
@Component
@EnableBinding(Sink.class)//消费端
public class ReceiveMessageListener {

    @Value("${server.port}")
    private String serverPort;

    //消息接收：Sink.INPUT
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者1号 ---------> 收到消息: " + message.getPayload() + "\t" + "port: " + serverPort);
    }
}
