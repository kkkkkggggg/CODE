package day14exer1;

public class Girl
{
	private String name;
	private int age;
	
	public Girl()
	{
		
	}
	
	public Girl(String name)
	{
		this.name = name;
	}
	
	public Girl(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	
	
	public void setName(String i)
	{
		name = i;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void marry(Boy boy)
	{
		System.out.println("我想嫁给" + boy.getName());
		boy.marry(this);
	}
	//比较两个对象的大小，如果返回值是正数，当前对象大，负数，当前对象小
	//0，当前对象与形参对象一样大
	public int compare(Girl girl)
	{
//		 if(this.age > girl.age)
//		 {
//			 return 1;
//		 }else if(this.age < girl.age)
//		 {
//			 return -1;
//		 }else
//		 {
//			 return 0;
//		 }
			return this.age - girl.age; 
	}
}
