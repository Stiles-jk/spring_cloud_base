package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @auther Stiles-JKY
 * @date 2020/11/16-22:13
 */
@EnableBinding(Source.class)//定义消息的推送管道
public class MessageProvider implements IMessageProvider {

    @Resource
    private MessageChannel output;//消息发送管道


    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        Message<String> serialMessage = MessageBuilder.withPayload(serial).build();//构建消息
        output.send(serialMessage);//发送消息
        System.out.println("*************serial: " + serial);
        return null;
    }
}
