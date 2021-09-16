package com.atckd.service;

import com.atckd.dao.AccountDao;
import com.atckd.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService
{

    @Autowired
    private AccountDao accountDao;

    // @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ,timeout = 10)
    public void cheque(String outId,String inId,int money)
    {
        // try
        // {
        //     //第一步，开启事务操作

        //第二步，进行事务操作
            Account chequeOut = accountDao.queryAccountById(outId);
            chequeOut.setMoney(chequeOut.getMoney() - money);
            accountDao.updateAccount(chequeOut);

            //模拟异常
            int i = 10 / 0;

            Account chequeIn = accountDao.queryAccountById(inId);
            chequeIn.setMoney(chequeIn.getMoney() + money);
            accountDao.updateAccount(chequeIn);

            //第三步，没有异常，提交事务
        // } catch (Exception e)
        // {
        //     //第四步 出现异常，事务回滚
        //
        //     e.printStackTrace();
        //     try
        //     {
        //         throw new Exception(e);
        //     } catch (Exception ex)
        //     {
        //         ex.printStackTrace();
        //     }
        // }
    }


}
