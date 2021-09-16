package com.atck.bean;
//钥匙表
public class Key
{
    private Integer id;//钥匙的id
    private String keyName;


    private Lock lock;//当前钥匙能开哪个锁

    public Key(Integer id, String keyName, Lock lock)
    {
        this.id = id;
        this.keyName = keyName;
        this.lock = lock;
    }

    public Lock getLock()
    {
        return lock;
    }

    public void setLock(Lock lock)
    {
        this.lock = lock;
    }

    public Key()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getKeyName()
    {
        return keyName;
    }

    public void setKeyName(String keyName)
    {
        this.keyName = keyName;
    }

    @Override
    public String toString()
    {
        return "Key{" + "id=" + id + ", keyName='" + keyName + '\'' + ", lock=" + lock + '}';
    }
}
