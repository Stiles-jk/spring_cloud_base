package com.atguigu.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @auther Stiles-JKY
 * @date 2020/11/16-12:02
 */
@Component
@Slf4j
public class MyGatewayFilter implements GlobalFilter, Ordered {

    //过滤器入口，执行过滤操作
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("************* come in MyLogGatewayFilter: " + new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");//获取请求参数列表中的首个参数
        if (uname == null) {
            log.info("******* 用户名为空，非法用户");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);//设置响应状态码
            return exchange.getResponse().setComplete();//setComplete表示当前请求已经处理完毕
        }
        return chain.filter(exchange);//传递到下一个过滤器
    }

    //加载过滤器的顺序，数字越小，越优先，一般来说全局过滤器优先级最高
    @Override
    public int getOrder() {
        return 0;
    }
}
