package com.atck.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Component
public class UserDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert()
    {
        String sql = "insert into `tbl_user`(`user_name`,`age`) values(?,?)";
        String substring = UUID.randomUUID().toString().substring(0, 5);
        jdbcTemplate.update(sql,substring,19);
    }
}
