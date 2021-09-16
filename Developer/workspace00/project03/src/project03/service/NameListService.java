package project03.service;


import project03.domain.*;


public class NameListService
{
	private Employee[] employee;
	
	public NameListService()
	{
		initializeEmployee();	
	}
	
	
	public Employee[] getAllEmployee()//返回存储所有员工信息的Employee数组
	{
		return employee;
	}
	
	
	public Employee getEmployee(int id) throws TeamException//获取指定id的员工，并返回一个Employee对象
	{
		if(id < 1 || id > employee.length)
		{
			throw new TeamException("找不到指定的员工");
		}
		return employee[id - 1];
	}
	
	
	
	
	//根据项目提供的Data类构建相应大小的employees数组
	//再根据Data类中的数据构建不同的对象，包括Employee、
	//Programmer、Designer和Architect对象，以及相关联
	//的Equipment子类的对象,将对象存于数组中
public void initializeEmployee()
	{
		Equipment[] equipment = new Equipment[Data.EQUIPMENTS.length];
		
		for(int i = 0;i < equipment.length;i++)
		{
			int type = 0;//用于判断员工所领取的设备类型
			String x = "";//设备名称
			String y = "";//设备描述
			try
			{
				type = Integer.parseInt(Data.EQUIPMENTS[i][0]);//获取该设备的类型，并将其转换为int型，用于判断设备类型
				x = Data.EQUIPMENTS[i][1];//获取Data中与员工id所对应的领用设备的名称
				y = Data.EQUIPMENTS[i][2];//获取Data中与员工id所对应的领用设备的描述
			}catch(NumberFormatException e)
			{
				
			}catch(ArrayIndexOutOfBoundsException e)
			{
				
			}

			if(type == 0)//判断设备类型，并将获取的该设备的名称和描述作为实参，传入对应类型的设备类的构造器，创建相应的设备类的对象
			{
				equipment[i] = new PC(x,y);
			}else if(type == Data.PC)
			{
				equipment[i] = new PC(x,y);
			}else if(type == Data.NOTEBOOK)
			{
				equipment[i] = new NoteBook(x,y);
			}else
			{
				equipment[i] = new Printer(x,y);
			}
		}
		
		
		
		
		employee = new Employee[Data.EMPLOYEES.length];
		
		for(int i = 0;i < employee.length;i++)
		{
			int type = Integer.parseInt(Data.EMPLOYEES[i][0]);//获取员工职位标识
			int id = Integer.parseInt(Data.EMPLOYEES[i][1]);//获取员工id
			String name = Data.EMPLOYEES[i][2];//获取员工名字
			int age = Integer.parseInt(Data.EMPLOYEES[i][3]);//获取员工年龄
			
			double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);//获取员工工资
			if(type == Data.EMPLOYEE)//根据员工职位标识符判断员工职位，并将获取到的信息作为实参传入对应员工类的构造器中
			{						//创建对象，存入Employee数组中
				employee[i] = new Employee(id, name, age, salary);
			}else if(type == Data.PROGRAMMER)
			{
				employee[i] = new Programmer(id, name, age, salary,equipment[i]);
			}else if(type == Data.DESIGNER)
			{
				double bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
				employee[i] = new Designer(id, name, age, salary,equipment[i],bonus);
			}else
			{
				double bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
				int stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
				employee[i] = new Architect(id, name, age, salary,equipment[i],bonus,stock);
			}
		}
	}
}
