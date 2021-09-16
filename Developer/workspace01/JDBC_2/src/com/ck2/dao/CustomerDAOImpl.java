package com.ck2.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.ck0.jdbc.utils.Customer;

public class CustomerDAOImpl extends BaseDAO implements CustomerDAO
{

	@Override
	public void insert(Connection conn, Customer cust)
	{
		// TODO Auto-generated method stub
		String sql = "insert into customers(name,email,birth) values(?,?,?)";
		
		update(conn,sql,cust.getName(),cust.getEmail(),cust.getBirth());
			
	}

	@Override
	public void deleteById(Connection conn, int id)
	{
		// TODO Auto-generated method stub
		String sql = "delete from customers where id = ?";
		update(conn,sql,id);
	}

	@Override
	public void updateById(Connection conn, Customer cust)
	{
		// TODO Auto-generated method stub
		String sql = "update customers set name = ?,email = ?,birth = ? where id = ?";
		update(conn,sql,cust.getName(),cust.getEmail(),cust.getBirth(),cust.getId());
	}

	@Override
	public Customer getCustomerById(Connection conn, int id)
	{
		// TODO Auto-generated method stub
		String sql = "select id,name,email,birth from customers where id = ?";
		
		
		
		return getInstance(conn,Customer.class,sql,id);
	}

	@Override
	public List<Customer> getAll(Connection conn)
	{
		// TODO Auto-generated method stub
		String sql = "select id,name,email,birth from customers";
		return getMutilyInstance(conn,Customer.class,sql);
	}

	@Override
	public Date getMaxBirth(Connection conn)
	{
		// TODO Auto-generated method stub
		String sql = "select max(birth) from customers";
		
		return getValue(conn,sql);
	}

	@Override
	public long getCount(Connection conn)
	{
		
		// TODO Auto-generated method stub
		String sql = "select count(*) from customers";
		
		return getValue(conn,sql);
	}

}
