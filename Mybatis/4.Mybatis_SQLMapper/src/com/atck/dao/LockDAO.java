package com.atck.dao;

import com.atck.bean.Lock;

public interface LockDAO
{
    //查锁的时候将所有钥匙也查出来
    public Lock getLockById(Integer id);


    public Lock getLockByIdSimple(Integer id);
}
