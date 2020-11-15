package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @auther Stiles-JKY
 * @date 2020/11/12-15:07
 */
@SpringBootApplication
@EnableFeignClients//开启OpenFeign服务
public class OrderFeign80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeign80.class, args);
    }
}
