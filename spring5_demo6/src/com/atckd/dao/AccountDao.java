package com.atckd.dao;

import com.atckd.pojo.Account;

public interface AccountDao
{


    void updateAccount(Account account);

    Account queryAccountById(String id);
}
