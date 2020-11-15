package com.atguigu.springcloud.service.iml;

import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Service;
import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @auther Stiles-JKY
 * @date 2020/11/3-11:05
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
