package day18exer;
//按小时付工资的员工
public class HourlyEmployee extends Employee
{
	
	private static double wage;
	private static double hour;
	
	public HourlyEmployee(String name, int number, MyDate birthday)
	{
		super(name, number, birthday);
		
	}
	
	public HourlyEmployee(String name, int number, MyDate birthday,int wage,int hour)
	{
		super(name, number, birthday);
		this.wage = wage;
		this.hour = hour;
	}

	public static double getWage()
	{
		return wage;
	}

	public static void setWage(double wage)
	{
		HourlyEmployee.wage = wage;
	}

	public static double getHour()
	{
		return hour;
	}

	public static void setHour(double hour)
	{
		HourlyEmployee.hour = hour;
	}

	//重写抽象父类中的earning方法
	@Override
	public double earning()
	{
		// TODO Auto-generated method stub
		return wage * hour;
	}
	
	//输出员工信息
	public String toString()
	{
		return "HourlyEmployee[" + super.toString() + "]";
	}
	
}
