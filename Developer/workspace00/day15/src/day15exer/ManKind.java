package day15exer;
import java.util.Scanner;
public class ManKind
{
	int sex;
	int salary;
	
	
	public ManKind()
	{
		
	}
	
	

	public ManKind(int sex, int salary)
	{
		
		this.sex = sex;
		this.salary = salary;
	}



	public void manOrWoman()
	{
		if(sex == 1)
		{
			System.out.println("man");
		}else if(sex == 0)
		{
			System.out.println("woman");
		}else
		{
			System.out.println("请输入正确的性别");
		}
	}
	
	public void employeed()
	{
		
		if(salary != 0)
		{
			System.out.println("job");
		}else
		{
			System.out.println("no job");
		}
	}



	public int getSex()
	{
		return sex;
	}



	public void setSex(int sex)
	{
		this.sex = sex;
	}



	public int getSalary()
	{
		return salary;
	}



	public void setSalary(int salary)
	{
		this.salary = salary;
	}
	
	
	
}
