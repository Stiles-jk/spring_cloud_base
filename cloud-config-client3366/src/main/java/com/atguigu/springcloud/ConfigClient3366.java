package com.atguigu.springcloud;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @auther Stiles-JKY
 * @date 2020/11/16-19:47
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClient3366 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3366.class, args);
    }
}
