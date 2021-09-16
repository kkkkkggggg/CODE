package day15exer6;
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
		
	}
}
