package com.atck.test;

import com.atck.tx.TxConfig;
import com.atck.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Tx
{


    @Test
    public void test()
    {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);

        UserService userService = applicationContext.getBean("userService", UserService.class);

        userService.insertUser();

        applicationContext.close();
    }
}
