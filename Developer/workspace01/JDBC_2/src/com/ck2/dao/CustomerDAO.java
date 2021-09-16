package com.ck2.dao;
/*
 * 此接口用于规范针对于customers表的常用操作
 */

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import com.ck0.jdbc.utils.Customer;

public interface CustomerDAO
{
	/**
	 * 将cust对象添加到对象的数据库中
	 * @param conn
	 * @param cust
	 */
	void insert(Connection conn,Customer cust);
	
	/**
	 * 根据指定的id删除表中的一条记录
	 * @param conn
	 * @param id
	 */
	void deleteById(Connection conn,int id);
	
	/**
	 * 针对内存中的cust对象去修改数据表中的记录
	 * @param conn
	 * @param cust
	 */
	void updateById(Connection conn,Customer cust);
	
	/**
	 * 根据指定的id查询得到对应的Customer对象
	 */
	Customer getCustomerById(Connection conn,int id);
	
	/**
	 * 查询数据表中的所有数据，并返回一个所有数据构成的集合
	 * @param conn
	 * @return
	 */
	List<Customer> getAll(Connection conn);
	
	
	long getCount(Connection conn);	
	/**
	 * 返回数据表中最大的生日
	 * @param conn
	 * @return
	 */
	Date getMaxBirth(Connection conn);
}

