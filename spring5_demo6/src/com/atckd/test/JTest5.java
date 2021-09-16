package com.atckd.test;

import com.atckd.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// import org.junit.Test;

// @RunWith(SpringJUnit4ClassRunner.class)//指定单元测试框架版本

// @ExtendWith(SpringExtension.class)//指定单元测试框架版本
// @ContextConfiguration("classpath:bean1.xml")//加载配置文件   JUnit5注解

@SpringJUnitConfig(locations = "classpath:bean1.xml")   //JUnit5的复合注解，替代上面的两个注解
public class JTest5
{
    @Autowired
    private AccountService accountService;

    @Test
    public void test()
    {
        accountService.cheque("1","2",100);
    }

}
