package com.atck.springcloud.controller;

import com.atck.springcloud.entities.CommonResult;
import com.atck.springcloud.entities.Payment;
import com.atck.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController
{

    // public static final String PAYMENT_URL="http://localhost:8001";

    public static final String PAYMENT_SRV = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment)
    {
        return restTemplate.postForObject(PAYMENT_SRV + "/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getPaymentById")
    public CommonResult<Payment> getPaymentBuId(Long id)
    {
        log.info("id:------------------------------" + id);
        return restTemplate.getForObject(PAYMENT_SRV + "/payment/getPaymentById?id=" + id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getPaymentByIdForEntity")
    public CommonResult<Payment> getPaymentById2(Long id)
    {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_SRV + "/payment/getPaymentById?id=" + id,CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful())
        {
            return entity.getBody();
        }else
        {
            return new CommonResult<>(444,"操作失败");
        }
    }

    @ResponseBody
    @GetMapping("/consumer/payment/getEntity")
    public ResponseEntity getEntity(Long id)
    {
        ResponseEntity entity = restTemplate.getForEntity(PAYMENT_SRV + "/payment/getPaymentById?id=" + id,CommonResult.class);
        log.info(entity.getStatusCode().toString());
        return entity;
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB()
    {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0)
        {
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instances(instances);

        URI uri = serviceInstance.getUri();
        System.out.println(uri + "/payment/lb");
        return restTemplate.getForObject(uri + "/payment/lb",String.class);
    }

    // ====================> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin/", String.class);
        return result;
    }

}
