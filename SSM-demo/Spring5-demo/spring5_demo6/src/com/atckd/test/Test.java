package com.atckd.test;

import com.atckd.config.TxConfig;
import com.atckd.dao.AccountDao;
import com.atckd.dao.AccountDaoImpl;
import com.atckd.pojo.Account;
import com.atckd.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.transaction.annotation.Transactional;

public class Test
{
    @org.junit.Test
    public void test()
    {
        // ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //
        // AccountService accountService = context.getBean("accountService", AccountService.class);
        //
        // accountService.cheque("1","2",100);

        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        AccountService accountService = context.getBean("accountService", AccountService.class);

        accountService.cheque("1","2",100);
    }

    @org.junit.Test
    public void test2()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);

        AccountService accountService = context.getBean("accountService", AccountService.class);

        accountService.cheque("1","2",100);
    }

    //函数式风格创建对象，交给spring进行管理
    @org.junit.Test
    public void testGenericApplicationContext()
    {
        //1.创建GenericApplicationContext对象
        GenericApplicationContext context = new GenericApplicationContext();
        //2.调用context的方法进行对象注册
        context.refresh();
        context.registerBean("user1",User.class,() -> new User());
        //3.获取在spring注册的对象
        // User user = (User) context.getBean("com.atckd.test.User");
        User user = (User) context.getBean("user1");
        System.out.println(user);
    }
}
