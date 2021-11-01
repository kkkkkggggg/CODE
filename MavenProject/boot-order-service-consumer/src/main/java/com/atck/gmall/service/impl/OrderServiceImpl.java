package com.atck.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atck.gmall.bean.UserAddress;
import com.atck.gmall.service.OrderService;
import com.atck.gmall.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 1、将服务提供者注册到注册中心（暴露服务）
 * 		1）、导入dubbo依赖（2.6.2）\操作zookeeper的客户端(curator)
 * 		2）、配置服务提供者
 * 
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 * @author lfy
 *
 * 1.SpringBoot与Dubbo整合的三种方式
 * 		1.导入dubbo-starter，在application-properties配置属性，使用@Service【暴露服务】，使用@Reference【引用服务】
 * 		2.保留dubbo xml配置文件
 * 			导入dubbo-starter,使用@ImportResource导入dubbo配置文件即可
 * 		3.使用注解api的方式
 * 			将每一个组件手动创建到容器中,让dubbo来扫描其他的组件
 *
 *
 */
@Service
public class OrderServiceImpl implements OrderService
{

	// @Autowired
	// @Reference(url = "127.0.0.1:20882") //dubbo直连
	@Reference(loadbalance = "random")
	UserService userService;

	@HystrixCommand(fallbackMethod="hello")
	@Override
	public List<UserAddress> initOrder(String userId) {
		// TODO Auto-generated method stub
		System.out.println("用户id："+userId);
		//1、查询用户的收货地址
		List<UserAddress> addressList = userService.getUserAddressList(userId);
		for (UserAddress userAddress : addressList) {
			System.out.println(userAddress.getUserAddress());
		}

		return  addressList;
	}


	public List<UserAddress> hello(String userId)
	{

		return Arrays.asList(new UserAddress(10,"测试地址","1","测试","测试","Y"));
	}

}
