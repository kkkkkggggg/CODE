package project02re.view;

import project02re.util.CMUtility;
import project02re.bean.Customer;
import project02re.service.CustomerList;

public class CustomerView
{
	private CustomerList customerList = new CustomerList(10);
	
	
	private void enterMainMenu()
	{
		boolean flag = true;
		do
		{

			System.out.println("\t\t客户信息管理软件\t\t");
			System.out.println("\t\t 1.添  加  客  户\t\t");
			System.out.println("\t\t 2.修  改  客  户\t\t");
			System.out.println("\t\t 3.删  除  客  户\t\t");
			System.out.println("\t\t 4.客  户  列  表\t\t");
			System.out.println("\t\t 5.退             出\t\t");
			System.out.println("\t\t  请 选 择(1-5)\t\t");
			int select = CMUtility.readMenuSelection();
			switch (select)
			{
				case '1':
					this.addNewCustomer();
					break;
				case '2':
					this.modifyCustomer();
					break;
				case '3':
					this.deleteCustomer();
					break;
				case '4':
					this.listAllCustomer();
				case '5':
					System.out.println("确认是否退出(Y/N)");
					char isExit = CMUtility.readConfirmSelection();
					if(isExit == 'Y')
					{
						flag = false;
					}
					break;
			}
		}while(flag);
		
	}
	
	private void addNewCustomer()
	{
		System.out.println("\t\t添加客户\t\t");
		System.out.println("姓名：");
		String name = CMUtility.readString(4);
		System.out.println("性别：");
		char gender = CMUtility.readChar();
		System.out.println("年龄：");
		int age = CMUtility.readInt();
		System.out.println("电话：");
		String phone = CMUtility.readString(11);
		System.out.println("邮箱：");
		String email = CMUtility.readString(11);
		
		Customer customer = new Customer(name, gender, age, phone, email);
		boolean flag = customerList.addCustomer(customer);
		if(flag == true)
		{
			System.out.println("\t\t添加成功\t\t");
			
		}else
		{
			System.out.println("\t\t超过人数上限，添加失败\t\t");
		}
	}
	
	private void modifyCustomer()
	{
		System.out.println("\t\t修改客户信息");
		Customer cust;
		int index;
		for(;;)
		{
			System.out.println("\t\t请输入需要修改信息的客户编号(-1退出)");
			index = CMUtility.readInt();
			
			if(index == -1)
			{
				return;
			}
			
			cust = customerList.getCustomer(index);
			if(cust == null)
			{
				System.out.println("无法找到指定客户");
			}else
			{
				break;
			}
		}
		if(customerList.getCustomer(index) == null)
		{
			System.out.println("\t\t请输入正确的客户编号");
		}else
		{
			System.out.println("姓名(" + /*customerList.getCustomer(index)*/cust.getName() + "):");
			String name = CMUtility.readString(11, customerList.getCustomer(index).getName());
			
			System.out.println("性别(" + /*customerList.getCustomer(index)*/cust.getGender() + "):");
			char gender = CMUtility.readChar(customerList.getCustomer(index).getGender());
			
			System.out.println("年龄(" + /*customerList.getCustomer(index)*/cust.getAge() + "):");
			int age = CMUtility.readInt(customerList.getCustomer(index).getAge());
			
			System.out.println("电话(" + /*customerList.getCustomer(index)*/cust.getPhone() + "):");
			String phone = CMUtility.readString(11,customerList.getCustomer(index).getPhone());
			
			System.out.println("邮箱(" + /*customerList.getCustomer(index)*/cust.getEmail() + "):");
			String email = CMUtility.readString(11, customerList.getCustomer(index).getEmail());
			
			cust = new Customer(name, gender, age, phone, email);
			
			customerList.replaceCustomer(index, cust);
			System.out.println("\t\t修改成功");
		}
	}
	
	private void deleteCustomer()
	{
		System.out.println("\t\t删除客户");
		System.out.println("\t\t请输入需要删除的客户编号：");
		int index = CMUtility.readInt();
		if(customerList.getCustomer(index) == null)
		{
			System.out.println("\t\t请输入正确的客户编号");
		}else
		{
			
			customerList.deleteCustomer(index);
			System.out.println("\t\t删除成功");
		}
	}
	
	private void listAllCustomer()
	{
		if(customerList.getTotal() == 0)
		{
			System.out.println("\t\t没有用户信息");
		}else
		{
			System.out.println("姓名:" + "\t" + "性别:" + "\t" + "年龄:" + "\t" + "电话:" + "\t\t" + "邮箱:" );
			Customer[] cust;
			cust = customerList.getAllCustomers();
			for(int i = 0;i < cust.length;i++)
			{
				System.out.println(cust[i].getName() + "\t" + cust[i].getGender() + "\t" + cust[i].getAge() + "\t" + cust[i].getPhone() + "\t\t" + cust[i].getEmail());
			}
		}
	}
	
	public static void main(String args[])
	{
		
//		int[] arr = {1,2,3};
//		int[] arr1 = arr;
//		System.out.println(arr[0]);
		CustomerView view = new CustomerView();
		
		view.enterMainMenu();
	}
}
