package com.atck.springcloud.controller;

import com.atck.springcloud.entities.CommonResult;
import com.atck.springcloud.entities.Payment;
import com.atck.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Slf4j
@RestController
public class PaymentController
{
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment)
    {
        int result = paymentService.create(payment);

        log.info("-----插入结果-----:" + result);

        if (result > 0)
        {
            return new CommonResult(200,"插入数据库成功,ServerPort:" + serverPort,result);
        }else
        {
            return new CommonResult(444,"插入数据库失败,ServerPort:" + serverPort,null);
        }
    }

    @GetMapping(value = "/payment/getPaymentById")
    public CommonResult getPaymentById(@RequestParam("id") Long id, HttpServletRequest request) throws MalformedURLException
    {
        Payment payment = paymentService.getPaymentById(id);
        log.info("id:------------------------" + id);
        log.info("-----查询结果-----:" + payment);
        log.info(request.getRequestURI().toString());
        if (payment != null)
        {
            return new CommonResult(200,"查询成功,ServerPort:" + serverPort,payment);
        }else
        {

            return new CommonResult(444,"查询失败,ServerPort:" + serverPort,null);
        }
    }

    @ResponseBody
    @GetMapping(value = "/payment/discovery")
    public Object discovery()
    {
        List<String> services = discoveryClient.getServices();
        for (String s : services)
        {
            log.info("------service------:" + s);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        for (ServiceInstance instance : instances)
        {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout()
    {
        try
        {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return serverPort;
    }


    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }
}
