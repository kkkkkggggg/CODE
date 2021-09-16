package day16;
/*
 * 面向对象特征之三：多态性
 * 
 * 1.理解多态性，可以理解为一个事物的多种形态
 * 2.对象的多态性:父类的引用指向子类的对象(或者子类的对象赋给父类的引用)
 * 
 * 3.多态的使用：虚拟方法调用
 * 		有了对象的多态性以后，我们在编译期，只能调用父类中声明的方法，但在
 * 		运行时，实际执行的是子类重写父类的方法
 * 		
 * 		总结：编译：看左边  运行：看右边  Person p2 = new Man();
 * 
 * 4.多态性的使用前提：①要有类的继承关系 ②子类中要有重写父类的方法
 * 
 * 5.对象的多态性只适用于方法，不适用于属性
 * 
 * ***********************************************************
 * 6.若子类重写了父类的方法，就意味着子类里定义的方法彻底覆盖了父类里的
 * 同名方法，系统不可能把父类里的方法转移到子类中，编译看左边，运行看右边
 * 
 * 对于实例变量则不存在这样的现象，即使子类定义了与父类完全相同的实例变量
 * 这个实例变量依然不可能覆盖父类中定义的实例变量，编译运行都看左边
*/

public class PersonTest
{
	public static void main(String args[])
	{
		Person p1 = new Person();
		p1.eat();
		
		Man man = new Man();
		man.eat();
		man.age = 25;
		man.earnMoney();
		
		//***********************************
		//多态性\对象的多态性:父类的引用指向子类的对象
		Person p2 = new Man();
		
//		Person p3 = new Women();
//		多态的使用：当调用子父类同名同参的方法时，实际执行的是子类重写
//		父类的方法---虚拟方法调用
		p2.eat(); 
		p2.walk();
		
//		p2.earnMoney();
		
		System.out.println(p2.id);//1001? 1002? 结果1001，父类中定义的属性
		
		//******************************************
		
		//不能调用子类所特有的方法
		//p2.earnMoney();
//		p2.name = "tom";
//		p2.isSmoking = true;
		//有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法，但是
		//由于变量声明为父类类型，导致编译时只能调用父类中声明的属性、方法，子类
		//特有的属性、方法不能调用
		
		
		//如何才能调用子类特有的属性和方法呢
		//向下转型：使用强制类型转换符
		Man m1 = (Man) p2;
		m1.earnMoney();
		m1.idSmoking = true;
		
		//使用强转时，可能会出现ClassCastException的异常
//		Women w1 = (Women)p2;
//		w1.goShopping();
		
		/*
		 * 
		 * instanceof:
		 * 
		 * a instanceof A:判断对象a是否是类A的实例，如果是返回true，不是则返回false
		 * 
		 * 使用情境，为了避免向下转型之前出现ClassCastException的异常，我们在向下转型之前
		 * 先进行instanceof的判断，一旦返回true,就向下进行转型，如果返回false则不能向下转型
		 * 
		 *如果a instanceof A返回true，则a instanceof B也返回true，其中B是A的父类
		 *
		 *
		*/
		
		if(p2 instanceof Women)
		{
			Women w1 = (Women)p2;
			w1.goShopping();
			System.out.println("******women******");
		}
		
		if(p2 instanceof Man)
		{
			Man m2 = (Man)p2;
			m2.earnMoney();
			System.out.println("*****man*****");
		}
		
		
		//练习
		//问题一：编译时通过，运行时不通过
		//举例一：
//		Person p3 = new Person();
//		Man m3 = (man)p3;
		//举例二
//		Person p4 = new Women();
//		Man m4 = (Man)p4;
		
//		问题二，编译时通过运行时也通过
//		Object obj = new Women();
//		Person p = (Person)obj;
		
		//问题三
//		Man m5 = new Women();
		
//		String str = new Data();
		
	}
}
