package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther Stiles-JKY
 * @date 2020/11/16-19:54
 */
@RestController
@RefreshScope //监控器自动刷新
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo + "server port: " + serverPort;
    }
}
