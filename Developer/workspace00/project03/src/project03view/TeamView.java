package project03view;

import project03.domain.*;
import project03.service.*;


public class TeamView
{
	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();
//	 private Employee[] e = listSvc.getAllEmployee();//Employee数组存储了所有员工的信息
	
//	private static int programmer = 0;//这三个变量用于记录架构师，程序员和设计师的数量
//	private static int designer = 0;//每次添加一个成员，相对应的计数变量增加一，但是还没有解决删除了成员后，相应的计数变量没有减一的问题
//	private static int architect = 0;
	
	public void enterMainMenu()
	{
		boolean flag = true;
		do
		{
			listAllEmployees();
			System.out.println("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4): ");
			int select = TSUtility.readMenuSelection();
			switch(select)
			{
				case '1':
					
						getTeam();
						break;
					
				case '2':
						try
						{
							addMember();
						}catch(TeamException e)
						{
							System.out.println(e.getMessage());
						}
					
					TSUtility.readReturn();
					break;
				case '3':
						try
						{
							deleteMember();
						}catch(TeamException e)
						{
							System.out.println(e.getMessage());
						}
					
					TSUtility.readReturn();
					break;
				case '4':
					System.out.println("确认是否退出？(Y/N):");
					
					char c = TSUtility.readConfirmSelection();
					if(c == 'Y')
					{
						flag = false;
					}
					break;
			}
			
		}while(flag);
		
	}
	
	private void listAllEmployees()
	{
		System.out.println("--------------------------------------开发团队调度软件------------------------------------");
		System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
		Employee[] e = listSvc.getAllEmployee();
		for(int i = 0;i < e.length;i++)
		{
			int type = Integer.parseInt(Data.EMPLOYEES[i][0]);//获取每个员工的职位标识，并进行判断，输出每个员工对应的个人信息
//			System.out.print(e[i].getId() + "\t" + e[i].getName() + "\t" + e[i].getAge() + "\t" + e[i].getSalary());//重写了Employee类及其子类的toString方法后代码更加简洁
			
			if(type == Data.EMPLOYEE)
			{
				System.out.println(e[i].toString());
			}else if(type == Data.PROGRAMMER)
			{
				Programmer p = (Programmer)e[i];
//				System.out.println("\t" +"程序员" + "\t" + p.getStatus() + "\t" + "" + "\t" + "" + "\t" + p.getEquipment().getDescription());
				System.out.println(p.toString());
			}else if(type == Data.DESIGNER)
			{
				Designer d = (Designer)e[i];
//				System.out.println("\t" +"设计师" + "\t" + d.getStatus() + "\t" + d.getBonus() + "\t" + "" + "\t" + d.getEquipment().getDescription());
				System.out.println(d.toString());
			}else
			{
				Architect a = (Architect)e[i];
//				System.out.println("\t" +"架构师" + "\t" + a.getStatus() + "\t" + a.getBonus() + "\t" + a.getStock() + "\t" + a.getEquipment().getDescription());
				System.out.println(a.toString());
			}
		}
		
		System.out.println("------------------------------------------------------------------------------------------");
	
	}
	
	//打印出所有成员的信息
	private void getTeam()
	{
		System.out.println("--------------------------------------团队成员列表------------------------------------");
		System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
		if(TeamService.getTotal() == 0)
		{
			System.out.println("--------------------------------------没有团队成员------------------------------------");
			return;
		}
		Programmer[] p = teamSvc.getTeam();//获取团队成员
		for(int i = 0;i < p.length;i++)
		{
			int type = Integer.parseInt(Data.EMPLOYEES[p[i].getId() - 1][0]);//获取团队成员对应的职位标识，并根据标识打印个人信息
//			System.out.print(p[i].getMemberId() + "/" + p[i].getId() + "\t" + p[i].getName() + "\t" + p[i].getAge() + "\t" + p[i].getSalary());
			if(type == Data.PROGRAMMER)
			{
//				System.out.println("\t" +"程序员" + "\t" + p[i].getStatus() + "\t" + "" + "\t" + "" + "\t" + p[i].getEquipment().getDescription());
				System.out.println(p[i].getMemberId() + "/" + p[i].toString());
			}else if(type == Data.DESIGNER)
			{
				Designer d = (Designer)p[i];
//				System.out.println("\t" +"设计师" + "\t" + d.getStatus() + "\t" + d.getBonus() + "\t" + "" + "\t" + d.getEquipment().getDescription());
				System.out.println(p[i].getMemberId() + "/" + p[i].toString());
			}else
			{
				Architect a = (Architect)p[i];
//				System.out.println("\t" +"架构师" + "\t" + a.getStatus() + "\t" + a.getBonus() + "\t" + a.getStock() + "\t" + a.getEquipment().getDescription());
				System.out.println(p[i].getMemberId() + "/" + p[i].toString());
			}
		}
		System.out.println("---------------------------------------------------------------------------------------");
		
		
	}
	
	//添加成员，还没解决添加成员后状态怎么改变
	private void addMember() throws TeamException
	{
		System.out.println("---------------------添加成员---------------------");
		System.out.println("请输入要添加的员工ID:");
		
		
		int s = TSUtility.readInt();//从键盘读取输入的员工id
		
//		Programmer[] p = teamSvc.getTeam();
		Employee employee = listSvc.getEmployee(s);//获取用户输入的对应位置的员工对象
		
		teamSvc.addMember(employee);
		
//		int type = Integer.parseInt(Data.EMPLOYEES[s - 1][0]);//获取从键盘输入的序号的员工的职位标识
		
		
		
//		if(TeamService.getTotal() > 0)//判断这个人是不是已经是团队成员
//		{
//			Programmer[] p = teamSvc.getTeam();
//			for(int i = 0;i < p.length;i++)
//			{
//				if(p[i].getId() == employee.getId())
//				//if(p[i].getId() == listSvc.getEmployee(s).getId())
//				{
//					throw new TeamException("此人已经是团队成员");
//				}
//			}
//			
//		}
		
//		if(TeamService.getTotal() == teamSvc.getMAX_MEMBER())
//		{
//			throw new TeamException("成员已满，无法添加");
//		}
		
		
//		if(type == Data.PROGRAMMER && programmer < 3)//判断该员工的职位是不是程序员，以及团队中的程序员个数
//																			//是不是已经超过要求
//			{
//				teamSvc.addMember(employee);//通过TeamSvrvice中的addMember方法将对应员工id的员工添加进团队中
//				//teamSvc.addMember(listSvc.getEmployee(s));
//				programmer++;//添加完成后，程序员的人数加一
//				Programmer p = (Programmer)employee;
//				//Programmer p = (Programmer)listSvc.getEmployee(s);
//				p.setStatus(Status.BUSY);//添加成员后，改变该员工的状态
//			}else if(type == Data.DESIGNER && designer < 2)
//			{
//				
//				teamSvc.addMember(employee);
//				//teamSvc.addMember(listSvc.getEmployee(s));
//				designer++;
//				Programmer p = (Programmer)employee;
//				//Programmer p = (Programmer)listSvc.getEmployee(s);
//				p.setStatus(Status.BUSY);
//			}else if(type == Data.ARCHITECT && architect < 1)
//			{
//				teamSvc.addMember(employee);
//				//teamSvc.addMember(listSvc.getEmployee(s));
//				architect++;
//				//Programmer p = (Programmer)e[s - 1];
//				Programmer p = (Programmer)employee;
//				p.setStatus(Status.BUSY);
//			}else
//			{
//				throw new TeamException("成员中只能有三名程序员，两名设计师，一名架构师\n目前已有" + programmer + "名程序员," + designer + "名设计师" + architect + "名架构师");
//			}
//		
//			
//		
//		System.out.println("添加成功");
		
	}	
		
		

	//删除成员
	private void deleteMember()
	{
		Programmer[] p = teamSvc.getTeam();//获取所有团队成员
		
		System.out.println("---------------------添加成员---------------------");
		System.out.println("请输入要删除的员工TeamID:");
		int s = TSUtility.readInt();
		System.out.println("确认是否删除(Y/N):");
		char a = TSUtility.readConfirmSelection();
		if(a == 'Y')
		{
//			for(int i = 0;i < p.length;i++)
//			{
//				int type = Integer.parseInt(Data.EMPLOYEES[p[i].getId() - 1][0]);
//				int memberId = p[i].getMemberId();
				 
//				if(type == Data.PROGRAMMER && memberId == s)
//				{
//					programmer--;
//					p[i].setStatus(Status.FREE);
//					
//					break;
//				}else if(type == Data.DESIGNER && memberId == s)
//				{
//					designer--;
//					p[i].setStatus(Status.FREE);
//					
//					break;
//				}else if(type == Data.ARCHITECT && memberId == s)
//				{
//					architect--;
//					p[i].setStatus(Status.FREE);
//					
//					break;
//				}
//			}
			teamSvc.removeMember(s);
		}
		
		
		
		
	}
	
	public static void main(String[] args)
	{
		TeamView t = new TeamView();
		t.enterMainMenu();
	}
}
