package com.atck.gmall.config;

import com.alibaba.dubbo.config.*;
import com.atck.gmall.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyDubboConfig
{
    @Bean
    public ApplicationConfig applicationConfig()
    {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("boot-user-service-provider");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig()
    {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper00:2181");
        registryConfig.setProtocol("zookeeper");
        return registryConfig;
    }

    @Bean
    public ProtocolConfig protocolConfig()
    {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }

    @Bean
    public ServiceConfig<UserService> serviceConfig(UserService userService)
    {
       ServiceConfig serviceConfig = new ServiceConfig();

       serviceConfig.setInterface(UserService.class);
       serviceConfig.setRef(userService);
       serviceConfig.setVersion("1.0.0");

        /*配置每一个method的信息*/
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(1000);

        //将method的设置关联到service配置中
        List<MethodConfig> methods = new ArrayList<>();
        methods.add(methodConfig);
        serviceConfig.setMethods(methods);
        return serviceConfig;
    }

    // ProviderConfig
    // MonitorConfig

}
