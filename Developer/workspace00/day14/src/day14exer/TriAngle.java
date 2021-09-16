package day14exer;

public class TriAngle
{
	private int base;//私有属性
	private int height;//私有属性
	
	public TriAngle()//构造器
	{
		
	}
	
	public TriAngle(int n,int m)//构造器：在创建对象时对属性进行设置
	{
		base = n;
		height = m;
	}
	
	public void setBase(int n)//设置底边长
	{
		if(n <= 0)
		{
			System.out.println("输入数据不符合要求");
		}else
		{
			base = n;
		}
	}
	
	public void setHeight(int n)//设置高长
	{
		if(n <= 0)
		{
			System.out.println("输入数据不符合要求");
		}else
		{
			height = n;
		}
	}
	
	public int getBase()//获取底边长
	{
		return base;
	}
	
	public int getHeight()//获取高长
	{
		return height;
	}
	
	public int getArea()//计算面积
	{
		return base * height;
	}
}
