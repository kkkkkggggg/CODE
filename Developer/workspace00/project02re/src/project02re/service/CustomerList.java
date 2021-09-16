package project02re.service;

import project02re.bean.Customer;

public class CustomerList
{
	private Customer[] customers;
	private int total = 0;
	
	public CustomerList()
	{
		
	}
	
	public CustomerList(int totalCustomer)
	{
		this.customers = new Customer[totalCustomer];
	}
	
	//添加客户，添加成功返回true，添加失败返回false
	public boolean addCustomer(Customer customer)
	{
		if(total < customers.length)
		{
			customers[total++] = customer;
			return true;
		}else
		{
			return false;
		}
	}
	
	//替换客户，替换成功返回true，替换失败返回false
	public boolean replaceCustomer(int index,Customer cust)
	{
		if(index > 0 && index <= total)
		{
			customers[index - 1] = cust;
			return true;
		}else
		{
			return false;
		}
	}
	
	//删除指定位置的客户，并将该客户后面所有的客户往前移一位 
	
	
	public boolean deleteCustomer(int index)
	{
		if((index - 1) >= 0 && (index - 1)< total)
		{
			for(int i = (index - 1);i < total - 1;i++)
			{
				customers[i] = customers[i + 1];
			}
//			customers[total - 1] = null;
//			total--;//存储的总人数减少1.
				customers[--total] = null;
				return true;
		}
				return false;
	}	
	
	//我的版本，只将要删除的客户对象指向空指针：null，没有将删除客户后，这名客户后面的客户都往前移一位
	/*public boolean deleteCustomer(int index)
	{
		if(index > 0 && index <= total)
		{
			customers[index - 1] = new Customer();
			return true;
		}else
		{
			return false;
		}
	}*/
	
	//获取所有的客户信息
	public Customer[] getAllCustomers()
	{
		Customer[] temp = new Customer[total];
		for(int i = 0;i < total;i++)
		{
			temp[i] = customers[i];
		}
		return temp;
	}
	
	//获取指定位置的客户
	public Customer getCustomer(int index)
	{
		if(index > 0 && index <= total)
		{
			return customers[index - 1];
		}else
		{
			return null;
		}
	}
	
	
	//获取用户总人数
	public int getTotal()
	{
		return total;
	}
	
}
