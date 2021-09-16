package com.atckd.service;

import com.atckd.dao.AccountDao;
import com.atckd.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService
{
    @Autowired
    private AccountDao accountDao;

    public void cheque(String outId,String inId,int money)
    {

        Account chequeOut = accountDao.queryAccountById(outId);
        chequeOut.setMoney(chequeOut.getMoney() - money);

        Account chequeIn = accountDao.queryAccountById(inId);
        chequeIn.setMoney(chequeIn.getMoney() + money);
    }

    public void show()
    {
        System.out.println(accountDao);
    }
}
