package com.atck.bean;

import java.util.List;

/*
锁子表
* */
public class Lock
{
    private Integer id;
    private String lockName;

    //查询锁的时候把所有的钥匙也查询出来
    private List<Key> keyList;
    //1-1关联  1-n关联  n-n关联
    //一个key开一把lock：1-1
    //从lock看key：1-n
    //从key看lock：n-1

    //n-n
    //student表  teacher表
    //1-n,n-1,n-n,外键应该放在哪个表
    //结论：
    //1-n，外键放在n的一端
    //n-n:中间表存储对应关系

    public Lock(Integer id, String lockName, List<Key> keyList)
    {
        this.id = id;
        this.lockName = lockName;
        this.keyList = keyList;
    }

    public Lock()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public List<Key> getKeyList()
    {
        return keyList;
    }

    public void setKeyList(List<Key> keyList)
    {
        this.keyList = keyList;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getLockName()
    {
        return lockName;
    }

    public void setLockName(String lockName)
    {
        this.lockName = lockName;
    }

    @Override
    public String toString()
    {
        return "Lock{" + "id=" + id + ", lockName='" + lockName + '\'' + ", keyList=" + keyList + '}';
    }
}
