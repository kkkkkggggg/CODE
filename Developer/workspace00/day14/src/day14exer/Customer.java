package day14exer;
/*
JavaBean是一种java语言写成的可重用组件
	>类似公共的(使用权限修饰符public修饰)
	>有一个无参的公共构造器
	>有属性，且有get、set方法











*/
public class Customer
{
	
	private int id;
	private String name;
	
	public Customer()
	{
		
	}
	public void setId(int i)
	{
		id = i;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
}
