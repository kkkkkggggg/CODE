package day15;
/*
 * 面向对象的特征之二：继承性
 * 一、继承性的好处
 * ①减少代码的冗余，提高了代码的复用性
 * ②便于功能的扩展
 * ③为之后多态性的使用，提供了前提
 * 
 * 二、继承性的格式：class A extends B{}
 * 	  A:子类、派生类、subclass
 *    B:父类、超类、基类、superclass
 *    
 *    2.1体现：一旦子类A继承了父类B之后，子类A中就获取了父类B中声明的所有结构
 *    属性、方法，特别的，父类中声明的私有的属性和方法，子类继承父类以后
 *    ，仍然认为获取了父类中私有的结构，只是因为封装性的影响，使得子类不能
 *    直接调用父类的结构而已
 *    
 *    2.2子类继承父类以后，还可以声明自己特有的属性和方法，实现功能的拓展
 *    子类和父类的关系，不同于子集和集合的关系
 *    extends:扩展，延展
 *    
 * 三、Java中关于继承性的规定
 * 	    1.一个类可以被多个子类继承
 * 		2.Java中类的单继续性:一个类子类有一个父类
 * 		3.子父类是相对的概念。
 * 			public B extends A{}
 * 				public C extends B{}
 * 					B是C的直接父类，A是C的间接父类
 * 		4.子类直接继承的父类称为直接父类，间接继承的父类称为间接父类，子类
 * 		在继承了父类之后，就拥有了父类和所有间接父类声明的属性和方法
 *四、1.如果我们没有显式的声明一个类的父类的话，则此类继承于java.lang.Object类
 *		2.所有的java类(除java.lang.Object类之外)都直接或间接继承于java.lang.Object类
 *		3.意味着，所有的java类都具有java.lang.Object类中声明的功能			
*/
public class ExtendsTest
{
	public static void main(String args[])
	{
		Person p1 = new Person();
		
		p1.age = 1;
		p1.eat();
		
		Student s1 = new Student();
		
		s1.age = 1;
		s1.eat();
		s1.sleep();
		s1.name = "tom";
	}
}
