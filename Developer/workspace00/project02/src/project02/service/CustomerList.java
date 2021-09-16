package project02.service;

import project02.bean.Customer;

//CustomerList为Customer对象的管理模块，内部用数组管理一组Customer对象
//并提供相应的添加、修改、删除和遍历方法，供CUstomerView使用
public class CustomerList
{/*
	public static void main(String args[])
	{
		CustomerList customerList = new CustomerList(5);
		customerList.addCustomer(new Customer("1", '男', 1, "1", "1"));
		customerList.addCustomer(new Customer("2", '男', 2, "2", "2"));
		customerList.addCustomer(new Customer("3", '男', 3, "3", "3"));
		customerList.addCustomer(new Customer("4", '男', 4, "4", "4"));
		customerList.addCustomer(new Customer("5", '男', 5, "5", "5"));
		
		customerList.replaceCustomer(2, new Customer());
		
		customerList.deleteCustomer(3);
		
		Customer[] temp = customerList.getAllCustomer();
		System.out.println(temp.length);
		
		for(int i = 0;i < temp.length;i++)
		{
			System.out.println(temp[i].getName());
		}
		
		Customer cust = customerList.getCustomer(4);
		
		System.out.println(cust.getName());
		
		int total = customerList.getTotal();
		System.out.println(total);
		
		
		
	}
	*/

	private Customer[] customerList;//用于保存客户对象数据的数组
	private int total = 0;//记录已保存客户对象的数量
	
	public CustomerList(int totalCustomer)//调用构造器创建CustomerList的对象时，对数组customerList的长度进行赋值	
	{
		customerList = new Customer[totalCustomer]; 
	}
	
	
	public boolean addCustomer(Customer customer)//添加客户
	{
	
		if(total < customerList.length)
		{
			customerList[total++] = customer;
			return true;
		}else
		{
			return false;
		}
		
	}
	
	public boolean replaceCustomer(int index,Customer cust)//替换客户
	{
		
		if(index > 0 && index <= total) 
		{
			customerList[index - 1] = cust;
			return true;
		}else
		{
			return false;
		}
	}
	
	
	
	//删除指定位置的客户，并将该用户之后的客户都往前移一位
	public boolean deleteCustomer(int index)
	{
		if(index >= 0 && index < total)
		{
			for(int i = index;i < total - 1;i++)
			{
				customerList[i] = customerList[i + 1];
			}
//			customers[total - 1] = null;
//			total--;//存储的总人数减少1.
				customerList[--total] = null;
				return true;
		}
				return false;
	}	
	
	/*public boolean deleteCustomer(int index)//删除客户
	{
		if(index > 0 && index <= total)
		{
			customerList[index - 1] = new Customer();
			return true;
		}else
		{
			return false;
		}
		
	}*/
	
	public Customer[] getAllCustomer()//获取所有客户
	{
		Customer[] temp = new Customer[total];
		for(int i = 0;i < total;i++)
		{
			temp[i] = customerList[i];
		}
		return temp;
	}
	
	public Customer getCustomer(int index)//获取指定位置的客户信息
	{
		if(index > 0 && index <= total)
		{
			return customerList[index - 1];
		}else
		{
			return null;
		}
	}
	
	
	
	public int getTotal()//获取客户总数
	{
		return total;
	}
}
