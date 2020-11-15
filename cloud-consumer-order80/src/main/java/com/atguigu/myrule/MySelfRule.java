package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther Stiles-JKY
 * @date 2020/11/11-20:47
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {

        return new RandomRule();//随机访问规则
    }
}
