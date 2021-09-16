package day18exer2;

public class ComparableCircle extends Circle implements CompareObject
{
	public ComparableCircle(double radius)
	{
		super(radius);
	}
	
	@Override
	public int compareTo(Object o)
	{
		// TODO Auto-generated method stub
		if(this == o)
		{
			return 0;
		}
		
		if(o instanceof ComparableCircle)
		{
			ComparableCircle c = (ComparableCircle)o;
			//正确的方式一
//			if(this.getRadius() > o.getRadius())
//			{
//				return 1;
//			}else if(this.getRadius() < o.getRadius())
//			{
//				return -1;
//			}else
//			{
//				return 0;
//			}
			//错误的
			//return (int)(this.getRadius() - o.getRadius());
			
			//正确的方式二
			//当属性radius声明为Double类型时，可以调用包装类方法
			return this.getRadius().compareTo(c.getRadius());
		}else
		{
			return 0;
			//throw new RuntimeException("传入的数据类型不匹配");
		}
	}
}


