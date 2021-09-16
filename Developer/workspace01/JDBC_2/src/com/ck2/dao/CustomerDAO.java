package com.ck2.dao;
/*
 * �˽ӿ����ڹ淶�����customers��ĳ��ò���
 */

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import com.ck0.jdbc.utils.Customer;

public interface CustomerDAO
{
	/**
	 * ��cust������ӵ���������ݿ���
	 * @param conn
	 * @param cust
	 */
	void insert(Connection conn,Customer cust);
	
	/**
	 * ����ָ����idɾ�����е�һ����¼
	 * @param conn
	 * @param id
	 */
	void deleteById(Connection conn,int id);
	
	/**
	 * ����ڴ��е�cust����ȥ�޸����ݱ��еļ�¼
	 * @param conn
	 * @param cust
	 */
	void updateById(Connection conn,Customer cust);
	
	/**
	 * ����ָ����id��ѯ�õ���Ӧ��Customer����
	 */
	Customer getCustomerById(Connection conn,int id);
	
	/**
	 * ��ѯ���ݱ��е��������ݣ�������һ���������ݹ��ɵļ���
	 * @param conn
	 * @return
	 */
	List<Customer> getAll(Connection conn);
	
	
	long getCount(Connection conn);	
	/**
	 * �������ݱ�����������
	 * @param conn
	 * @return
	 */
	Date getMaxBirth(Connection conn);
}

