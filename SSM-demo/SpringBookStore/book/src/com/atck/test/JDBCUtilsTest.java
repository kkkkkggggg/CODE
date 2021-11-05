package com.atck.test;

import com.atck.dao.impl.BaseDAO;
import com.atck.pojo.Book;
import com.atck.utils.JDBCUtils;
import com.atck.web.BookServlet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtilsTest
{
    @Test
    public void test() throws Exception
    {
        Connection conn = JDBCUtils.getConnection();

        String sql = "insert into t_user(username,password,email) values(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,"abc");
        ps.setObject(2,"abc");
        ps.setObject(3,"abc");
        ps.execute();



    }

}
