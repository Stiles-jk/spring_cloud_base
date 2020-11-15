package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @auther Stiles-JKY
 * @date 2020/11/15-21:00
 */
@Service
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "---------PaymentFallbackService fall back-paymentInfo_OK ............";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "---------PaymentFallbackService fall back-paymentInfo_OK ............";
    }
}
