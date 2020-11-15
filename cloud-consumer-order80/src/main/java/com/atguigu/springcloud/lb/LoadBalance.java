package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义负载均衡接口
 *
 * @auther Stiles-JKY
 * @date 2020/11/11-21:53
 */
public interface LoadBalance {

    ServiceInstance instances (List<ServiceInstance> serviceInstances);
}
