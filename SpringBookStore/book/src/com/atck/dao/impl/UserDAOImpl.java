package com.atck.dao.impl;

import com.atck.dao.UserDAO;
import com.atck.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO
{


    @Override
    public User queryUserByUsername(String username)
    {
        String sql = "select id,username,password,email from t_user where username = ?";

        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String password, String username)
    {
        String sql = "select id,username,password,email from t_user where username = ? and password = ?";

        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user)
    {
        String sql = "insert into t_user(`username`,`password`,`email`) values(?,?,?)";


        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
