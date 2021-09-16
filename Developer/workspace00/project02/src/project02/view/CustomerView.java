package project02.view;

import project02.bean.Customer;
import project02.service.CustomerList;
import project02.util.CMUtility;



//CstomerView为主模块，负责菜单的显示和处理用户操作
public class CustomerView
{
	public CustomerView()
	{
		
	}
	CustomerList customerList = new CustomerList(10);

	private int index = 0;
	public void enterMainMenu()
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
	/*	boolean isSucceed = customerList.addCustomer(new Customer());
		if(isSucceed == true)
		{
			System.out.println("姓名:");
			customerList.getCustomer(index).setName(CMUtility.readString(4));
			System.out.println("性别:");
			customerList.getCustomer(index).setGender(CMUtility.readChar());
			System.out.println("年龄:");
			customerList.getCustomer(index).setAge(CMUtility.readInt());
			System.out.println("电话号码:");
			customerList.getCustomer(index).setPhoneNumber(CMUtility.readString(11));
			System.out.println("邮箱:");
			customerList.getCustomer(index).setEmail(CMUtility.readString(11));
			index++;
		}else
		{
			System.out.println("添加用户失败");
			return;
		}*/
		
		
		System.out.println("---------------------添加客户---------------------");
		System.out.print("姓名：");
		String name = CMUtility.readString(5);
		System.out.print("性别：");
		char gender = CMUtility.readChar();
		System.out.print("年龄：");
		int age = CMUtility.readInt();
		System.out.print("电话：");
		String phone = CMUtility.readString(15);
		System.out.print("邮箱：");
		String email = CMUtility.readString(20);

		// 封装为一个对象
		Customer customer = new Customer(name, gender, age, phone, email);
		// 将此对象添加到CustomerList里的数组中
		boolean flag = customerList.addCustomer(customer);
		if (flag) {
			System.out
					.println("---------------------添加完成---------------------");

		} else {
			System.out.println("人数已达上限，添加失败！");
		}
	}
	
	
	private void modifyCustomer()
	{
		System.out.println("---------------------修改客户---------------------");
		Customer customer;
		int index;
		for (;;) {
			System.out.print("请选择待修改客户编号(-1退出)：");
			index = CMUtility.readInt();
			if (index == -1) {
				// break;//不能使用break
				return;
			}
			// 对于用户来讲，我们让index 默认从1开始。
			customer = customerList.getCustomer(index);
			if (customer == null) {
				System.out.println("无法找到指定客户！");
			} else {
				break;
			}
		}
		// 修改用户的信息
		System.out.print("姓名(" + customer.getName() + "):");
		// 如果用户输入了姓名，则返回用户输入的信息，如果用户没有输入，直接回车，则返回customer.getName()
		String name = CMUtility.readString(5, customer.getName());

		System.out.print("性别(" + customer.getGender() + "):");
		char gender = CMUtility.readChar(customer.getGender());

		System.out.print("年龄(" + customer.getAge() + "):");
		int age = CMUtility.readInt(customer.getAge());

		System.out.print("电话(" + customer.getPhoneNumber() + "):");
		String phone = CMUtility.readString(13, customer.getPhoneNumber());

		System.out.print("邮箱(" + customer.getEmail() + "):");
		String email = CMUtility.readString(15, customer.getEmail());
		// 获取用户输入的属性以后，得到的最新的Customer对象
		customer = new Customer(name, gender, age, phone, email);
		// 对于用户来讲，我们让index 默认从1开始。
		boolean flag = customerList.replaceCustomer(index, customer);
		if (flag) {
			System.out
					.println("---------------------修改完成---------------------");
		} else {
			System.out
					.println("---------------------修改失败---------------------");
		}
		
		
		
		
		
		
		
		
		/*System.out.println("请输入要修改的客户编号:");
		int index = CMUtility.readInt();
		if(index > 0 && index <= customerList.getAllCustomer().length)
		{		
			Customer cust = new Customer();

			System.out.println("姓名(" + customerList.getCustomer(index).getName() + "):");
			cust.setName(CMUtility.readString(4, customerList.getCustomer(index).getName()));
			
			System.out.println("性别(" + customerList.getCustomer(index).getGender() + "):");
			cust.setGender(CMUtility.readChar(customerList.getCustomer(index).getGender()));
			
			System.out.println("年龄(" + customerList.getCustomer(index).getAge() + "):");
			cust.setAge(CMUtility.readInt(customerList.getCustomer(index).getAge()));
			
			System.out.println("电话(" + customerList.getCustomer(index).getPhoneNumber() + "):");
			cust.setPhoneNumber(CMUtility.readString(11, customerList.getCustomer(index).getPhoneNumber()));
			
			System.out.println("邮箱(" + customerList.getCustomer(index).getEmail() + "):");
			cust.setEmail(CMUtility.readString(11, customerList.getCustomer(index).getEmail()));
			
			customerList.replaceCustomer(index, cust);
		
			
			System.out.println("修改成功");
			
		}else
		{
			System.out.println("请输入正确的客户编号");
		}*/

	}
	
	private void deleteCustomer()
	{
		System.out.println("---------------------删除客户---------------------");
		Customer customer;
		int index;
		for (;;) {

			System.out.print("请选择待删除客户编号(-1退出)：");
			// 针对普通用户来讲：此index从 1开始
			index = CMUtility.readInt();
			if (index == -1) {
				return;
			}

			customer = customerList.getCustomer(index);
			if (customer == null) {
				System.out.println("无法找到指定客户！");
			} else {
				break;
			}
		}

		// 一旦找到相应的索引位置的customer以后，让用户决定是否确认删除
		System.out.print("确认是否删除(Y/N)：");
		char deleteOrNot = CMUtility.readConfirmSelection();
		if (deleteOrNot == 'Y') {
			boolean flag = customerList.deleteCustomer(index);
			if (flag) {
				System.out.println("---------------------删除完成---------------------");
			} else {
				System.out.println("---------------------删除失败---------------------");
			}
		} else {
			return;
		}
		
		
		/*System.out.println("请输入要删除的客户编号");
		int index = CMUtility.readInt();
		if(index > 0 && index <= customerList.getAllCustomer().length)
		{
			customerList.deleteCustomer(index);
		}else
		{
			System.out.println("删除失败，请输入正确的客户编号");
		}*/
		
	}
	
	public void listAllCustomer()
	{
		System.out.println("---------------------------客户列表---------------------------");
		// 获取所有的客户
		Customer[] customers = customerList.getAllCustomer();
		if (customers.length == 0) {
			System.out.println("没有任何客户记录！");

		} else {
			System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
			for (int i = 0; i < customers.length; i++) {
				Customer cust = customers[i];
				// 方式一：
				 System.out.println((i + 1) + "\t" + cust.getName() + "\t"
				 + cust.getGender() + "\t" + cust.getAge() + "\t"
				 + cust.getPhoneNumber() + "\t" + cust.getEmail());
				// 方式二：
				//System.out.println((i + 1) + "\t" + cust.info());

			}
		}
		System.out
				.println("-------------------------客户列表完成-------------------------");

		
		
		
		
		
		/*Customer[] cust = customerList.getAllCustomer();
		System.out.println("编号\t" + "\t姓名" + "\t性别" + "\t年龄" + "电话号码\t" + "\t邮箱");
		for(int i = 0;i < cust.length;i++)
		{
			System.out.println((i + 1) + "\t" + cust[i].getName() + "\t" + cust[i].getGender() + "\t" + cust[i].getAge() + "\t" + cust[i].getPhoneNumber() + "\t\t" + cust[i].getEmail());
		}*/
	}
}
