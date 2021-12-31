package com.atck.springcloud.service.impl;

import com.atck.springcloud.entities.CommonResult;
import com.atck.springcloud.entities.Payment;
import com.atck.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService
{
    @Override
    public CommonResult<Payment> paymentSQL(Long id)
    {
        return new CommonResult<>(444,"服务降级返回,没有该流水信息",new Payment(id, "errorSerial......"));
    }
}
