package com.atck.dao;

import com.atck.bean.Key;

public interface KeyDAO
{
    /**
     * 将钥匙和锁的信息一起查出
     * @param id
     * @return
     */
    public Key getKeyById(Integer id);

    public Key getKeyByIdSimple(Integer id);
}
