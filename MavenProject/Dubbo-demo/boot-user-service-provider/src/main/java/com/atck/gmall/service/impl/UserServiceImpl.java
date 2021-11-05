package com.atck.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atck.gmall.bean.UserAddress;
import com.atck.gmall.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Service             //暴露服务,在使用注解或配置类的方式进行配置时使用   //保留xml配置文件后不需要再使用@Service注解
public class UserServiceImpl implements UserService
{
	@HystrixCommand
	@Override
	public List<UserAddress> getUserAddressList(String userId) {
		System.out.println("UserServiceImpl....3....");
		// TODO Auto-generated method stub
		UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", "Y");
		UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");
		/*try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		if(Math.random() > 0.5)
		{
			throw new RuntimeException();
		}

		return Arrays.asList(address1,address2);
	}

}
