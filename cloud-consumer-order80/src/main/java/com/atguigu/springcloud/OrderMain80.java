package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 消费端:
 * 消费端通过RestTemplate调用支付模块提供的接口
 *
 * @auther Stiles-JKY
 * @date 2020/11/3-13:47
 */
@SpringBootApplication
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
