package day18;
/*
 * 抽象类的匿名子类
 * 
*/
public class PersonTest
{
	public static void main(String[] args)
	{
		PersonTest.method(new Student());//匿名对象
		
		Worker worker = new Worker();
		
		PersonTest.method1(worker);//非匿名的类非匿名的对象
		
		method1(new Worker());//非匿名的类的匿名对象
		
		System.out.println("************************");
		//创建了一个匿名类的对象：p
		Person p = new Person()
					{
						@Override
						public void eat()
						{
							System.out.println("吃东西");
							
						}
			
						@Override
						public void breath()
						{
							System.out.println("好好呼吸");
							
						}
					};
		 
		method1(p);
		
		System.out.println("************************");
		
		method1(new Person(){

			@Override
			public void eat()
			{
				System.out.println("吃好吃的");
				
			}

			@Override
			public void breath()
			{
				System.out.println("呼吸新鲜空气");
				
			}
			
		});
		
	}
	
	public static void method1(Person p)
	{
		p.eat();
		p.breath();
	}
	
	public static void method(Student s)
	{
		s.eat();
		s.walk();
		s.breath();
	}
	

	
}

class Worker extends Person
{

	@Override
	public void eat()
	{
		System.out.println("工人吃饭");
		
	}

	@Override
	public void breath()
	{
		System.out.println("工人呼吸");
		
	}
	
}



