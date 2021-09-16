package day18exer;

public abstract class Employee//抽象类
{
	private String name;
	private int number;
	private MyDate birthday;
	
	public Employee(String name,int number,MyDate birthday)
	{
		this.name = name;
		this.number = number;
		this.birthday = birthday;
	}
	
	//各属性的get和set方法
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public MyDate getBirthday()
	{
		return birthday;
	}

	public void setBirthday(MyDate birthday)
	{
		this.birthday = birthday;
	}

	public abstract double earning();//抽象方法
	
	public String toString()
	{
		return "Employee [name=" + name + ", number=" + number + ", birthday=" + birthday.toDateString();
	}
}





