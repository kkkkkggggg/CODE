package project03.service;



import project03.domain.*;

public class TeamService
{
	private static int counter = 1;//用于生成团队成员的MemberId
	private final int MAX_MEMBER = 5;//定义最大的团队成员人数
	private Programmer[] team = new Programmer[MAX_MEMBER];//创建一个Programmer数组用于存储团队成员
	private static int total = 0;//用于记录团队成员人数，同时在添加成员成功时total加一，删除成功后total减一，作为添加或
								//删除成员时的数组脚标使用
	private static int programmer = 1;//这三个变量用于记录架构师，程序员和设计师的数量
	private static int designer = 1;//每次添加一个成员，相对应的计数变量增加一，但是还没有解决删除了成员后，相应的计数变量没有减一的问题
	private static int architect = 1;
	
	
//	getTeam()方法：返回当前团队的所有对象
//	返回：包含所有成员对象的数组，数组大小与成员人数一致

	public static int getTotal()
	{
		return total;
	}

	public Programmer[] getTeam() throws TeamException//获取所有团队成员，返回一个Programmer数组，数组的长度和成员数量一致
	{
		if(total == 0)
		{
			throw new TeamException("没有成员");
		}
		Programmer[] allMember = new Programmer[total];
		for(int i = 0;i < allMember.length;i++)
		{
			allMember[i] = team[i];
		}
		return allMember;
	}
	
//	向团队中添加成员
	public void addMember(Employee e) throws TeamException
	{
		if(total == MAX_MEMBER)
		{
			throw new TeamException("成员已满，无法添加");
		}
		
		if(!(e instanceof Programmer))
		{
			throw new TeamException("该成员不是开发人员，无法添加");
		}
		
		if(total > 0)//判断这个人是不是已经是团队成员
		{
			Programmer[] p = getTeam();
			for(int i = 0;i < p.length;i++)
			{
				if(p[i].getId() == e.getId())
				//if(p[i].getId() == listSvc.getEmployee(s).getId())
				{
					throw new TeamException("此人已经是团队成员");
				}
			}
			
		}
		
		Programmer s = (Programmer)e;
		if(s.getStatus() == Status.VOCATION)
		{
			throw new TeamException("该成员在休假，不能添加");
		}
		
		
		int type = Integer.parseInt(Data.EMPLOYEES[e.getId() - 1][0]);
		
		switch(type)
		{
			case Data.PROGRAMMER:
				if(programmer == 4)
				{
					throw new TeamException("团队中最多只能有三名程序员");
				}
				
				team[total] = (Programmer) e;//将传入的Employee对象向下转型为Programmer存入team中
				team[total].setMemberId(counter);//设置成员的成员id
				counter++;//添加成员成功后，counter加一，用于生成成员id
				total++;//添加成员成功后，total加一，记录人数
				programmer++;//添加完成后，程序员的人数加一
				Programmer p = (Programmer)e;
			
				p.setStatus(Status.BUSY);//添加成员后，改变该员工的状态
				
				break;
			case Data.DESIGNER:
				if(designer == 3)
				{
					throw new TeamException("团队中最多只能有两名设计师");
				}
				team[total] = (Programmer) e;//将传入的Employee对象向下转型为Programmer存入team中
				team[total].setMemberId(counter);//设置成员的成员id
				counter++;//添加成员成功后，counter加一，用于生成成员id
				total++;//添加成员成功后，total加一，记录人数
				designer++;
				Programmer d = (Programmer)e;
				
				d.setStatus(Status.BUSY);
				break;
			case Data.ARCHITECT:
				if(architect == 2)
				{
					throw new TeamException("团队中最多只能有一名架构师");
				}
				team[total] = (Programmer) e;//将传入的Employee对象向下转型为Programmer存入team中
				team[total].setMemberId(counter);//设置成员的成员id
				counter++;//添加成员成功后，counter加一，用于生成成员id
				total++;//添加成员成功后，total加一，记录人数
				
				architect++;
				
				Programmer a = (Programmer)e;
				a.setStatus(Status.BUSY);
				break;
		}
	
		
		
		System.out.println("添加成功");

	}
	

	//	从团队中删除成员
	public void removeMember(int memberId) throws TeamException
	{
		if(total == 0)//判断团队中是否有成员
		{
			throw new TeamException("没有成员，无法删除");
		}
		
		Programmer[] t = getTeam();//获取团队成员
		boolean flag = true;//定义一个布尔型的标识，声明为true，在删除成功后将其赋值为false，用于判断是否成功删除成员
		for(int i = 0;i < t.length;i++)
		{
			int type = Integer.parseInt(Data.EMPLOYEES[t[i].getId() - 1][0]);
			if(t[i].getMemberId() == memberId)//当用户输入的memberId等于某个成员的memberId时，删除该成员
			{
				if(type == Data.PROGRAMMER)
				{
					programmer--;
					t[i].setStatus(Status.FREE);
				}else if(type == Data.DESIGNER)
				{
					designer--;
					t[i].setStatus(Status.FREE);
				}else if(type == Data.ARCHITECT)
				{
					architect--;
					t[i].setStatus(Status.FREE);
				}
				
				if(i == t.length - 1)//当该成员是团队中最后一位时，直接删除
				{
					team[i] = null;
					flag = false;
					break;
					
				}
				
				do//当该成员不是最后一名时，删除该成员，并将其后的成员向前移一位，填补空隙
				{
					team[i] = team[i + 1];
					i++;
				}while(i < t.length - 1);
				team[t.length - 1] = null;
				flag = false;
			
			}
			
			
		}
		if(flag)
		{
			throw new TeamException("没有找到对应memberID的成员");
		}else
		{
			System.out.println("删除成功");
			total--;
			
		}
		
	}
	
	public int getMAX_MEMBER()
	{
		return MAX_MEMBER;
	}

}
