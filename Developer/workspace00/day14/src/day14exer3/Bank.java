package day14exer3;

public class Bank
{
	private Customer[] customer;
	private int numberOfCustomer;
	
	
	
	public Bank()
	{
		customer = new Customer[10];
		
	}
	
	//创建一个新的Customer类的对象并存储到customer[]数组中
	public void addCustomer(String firstName,String lastName)
	{
		Customer cust = new Customer(firstName,lastName);
		customer[numberOfCustomer++] = cust;
		
	}
	
	//获取客户的个数
	public int getNumberOfCustomers()
	{
		return numberOfCustomer;
	}
	
	//获取指定位置上的客户
	public Customer getCustomer(int index)
	{
		if(index >= 0 && index < numberOfCustomer)
		{
			return customer[index];
		}
		
		return null;
//		return customer[index];可能报异常
	}
}
