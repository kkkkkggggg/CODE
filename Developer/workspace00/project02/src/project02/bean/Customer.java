package project02.bean;
//Customer为实体对象，用来封装客户信息
public class Customer
{
	private String name;
	private char gender;
	private int age;
	private String phoneNumber;
	private String email;
	
	public Customer()
	{
		
	}
	
	public Customer(String name,char gender,int age,String phoneNumber,String email)
	{
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public char getGender()
	{
		return gender;
	}

	public void setGender(char gender)
	{
		this.gender = gender;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	
	
	
}
