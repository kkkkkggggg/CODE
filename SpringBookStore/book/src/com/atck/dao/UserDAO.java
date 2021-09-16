package com.atck.dao;

import com.atck.pojo.User;

public interface UserDAO
{
    /**
     * 根据用户名查询用户信息s
     * @param username 用户名
     * @return 如果返回null，说明没有这个用户，反之亦然
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户
     * @param password
     * @param uername
     * @return 如果返回null，说明用户名或密码错误，反之亦然
     */
    public User queryUserByUsernameAndPassword(String password, String uername);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int saveUser(User user);


}
