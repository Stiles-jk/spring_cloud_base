package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @auther Stiles-JKY
 * @date 2020/11/14-21:56
 */
@Service
public class PaymentService {

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " paymentInfo_OK, id: " + id + "\t" + "^_^哈";
    }

    /**
     * 模拟出错
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")//5秒内是正常逻辑
    })
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 1;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName() + " paymentInfo_TimeOut 系统繁忙, id: " + id + "\t" + "^_^哈" + "耗时(秒)" + timeNumber;
    }

    //fallbackMethod
    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + " paymentInfo_TimeOutHandler, id: " + id + "\t" + "呜呜===============";
    }
}
