package com.atck.springcloud.controller;

import com.atck.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
// @DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystirxController
{
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id)
    {
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    // @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
    //         @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2000")})
    // @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id)
    {
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }


    public String paymentInfo_TimeOutHandler(@PathVariable("id") Integer id)
    {
        return "线程池:"+Thread.currentThread().getName()+":系统繁忙,我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,id: "+id+"\t"+"╥﹏╥...";
    }

    //下面是全局fallback方法
    public String payment_Global_FallbackMethod()
    {
        return "Clobal异常处理信息，请稍后再试。。。";
    }

}
