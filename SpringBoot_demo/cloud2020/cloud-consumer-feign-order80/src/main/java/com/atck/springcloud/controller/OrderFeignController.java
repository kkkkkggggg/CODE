package com.atck.springcloud.controller;

import com.atck.springcloud.entities.CommonResult;
import com.atck.springcloud.entities.Payment;
import com.atck.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController
{
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/getPaymentById")
    public CommonResult<Payment> getPaymentById(Long id)
    {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout()
    {
        return paymentFeignService.payFeignTomeout();
    }
}
