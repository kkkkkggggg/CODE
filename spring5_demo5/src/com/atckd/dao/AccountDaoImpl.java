package com.atckd.dao;

import com.atckd.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void updateAccount(Account account)
    {
        String sql = "update t_account set money = ? where id = ?";
        jdbcTemplate.update(sql, account.getMoney(),account.getId());
    }

    @Override
    public Account queryAccountById(String id)
    {
        String sql = "select * from t_account where id = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Account>(Account.class),id);
    }

    @Override
    public void show()
    {
        System.out.println(jdbcTemplate);
    }

}
