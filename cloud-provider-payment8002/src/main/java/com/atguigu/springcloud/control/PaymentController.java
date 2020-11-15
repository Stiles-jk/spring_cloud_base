package com.atguigu.springcloud.control;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.atguigu.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @auther Stiles-JKY
 * @date 2020/11/3-11:11
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("**** 插入结果 " + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功" + "PORT: " + serverPort, result);
        } else {
            return new CommonResult(500, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("**** 查询结果 " + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功" + "PORT: " + serverPort, payment);
        } else {
            return new CommonResult(500, "没有对应的记录,查询ID: " + id, null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return "payment port: " + serverPort;
    }

}

