package com.atckd.test;

import com.atckd.dao.AccountDao;
import com.atckd.dao.AccountDaoImpl;
import com.atckd.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test
{
    @org.junit.Test
    public void test()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext("bean1.xml");

        AccountService accountService = context.getBean("accountService", AccountService.class);

        accountService.cheque("1","2",100);
    }
}
