package day19exer1;

public class StudentTest
{
	public static void main(String[] args)
	{
		
				try
				{
					Student s = new Student();
					s.regist(-1001);
					System.out.println(s);
				} catch (RuntimeException e)
				{
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			
		
	}
}

class Student
{
	private int id;
	
	public void regist(int id) throws RuntimeException//异常的处理
	{
		if(id > 0)
		{
			this.id = id;
		}else
		{
			//System.out.println("输入的数据非法");
			//手动抛出异常
//			throw new RuntimeException("输入的数据非法");
//			throw new Exception("输入的数据非法");//手动生成一个异常的对象
			throw new MyExpection("不能输入负数");
		}
	}
}