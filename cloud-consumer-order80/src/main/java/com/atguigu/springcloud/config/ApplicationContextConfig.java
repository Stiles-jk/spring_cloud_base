package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @auther Stiles-JKY
 * @date 2020/11/3-13:57
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced//给RestTemplate提供默认负载均衡机制(轮询)
    //使用自己写的负载均衡算法
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
