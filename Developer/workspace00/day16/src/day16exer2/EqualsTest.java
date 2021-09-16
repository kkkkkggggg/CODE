package day16exer2;
/*
 * 面试题， == 和 equals()的区别
 * 
 * 一、回顾== 的使用
 * ==：运算符
 * 1.可以使用在基本数据类型变量和引用数据类型变量中
 * 2.如果比较的是基本数据类型的变量，比较两个变量保存的数据是否相同，(不一定
 * 数据类型相同
 * 
 * 3.如果比较的是引用数据类型的变量，比较的是两个对象的地址值是否相同，即两个对象
 * 是否指向同一个对象实体
 * 
 * 二、equals()方法的使用
 * 1.是一个方法，而非运算符
 * 2.不能使用在基本数据类型中，只能适用于引用数据类型
 * 3.Object类中equals()的定义：
 * 	public boolean equals(Object obj)
 * 		{	
 * 			return this == obj;
 * 		}
 * 		说明，Object类中定义的equals()和==的作用是相同的，比较两个对象的地址值是否
 * 		相同
 * 4.像String、Data、File，包装类等都重写了Object类的equals()方法，重写以后，比较的不是
 * 两个引用的地址值是否相同，而是比较两个对象的“实体内容是否相同”
 * 
 * 5.通常情况下，我们自定义的类如果使用equals()的话，也通常是比较两个对象实体是否相同，因此
 * 我们就需要对Object类中的equals()进行重写
 * 重写的原则：比较两个对象的实体内容是否相同
 * 
 * 
*/
public class EqualsTest
{
	public static void main(String args[])
	{
		int i = 10;
		int j = 10;
		double d = 10.0;
		System.out.println(i == j);//true
		System.out.println(i == d);//true
		
		boolean b = true;
		
		char c = 10;
		System.out.println(i == c);
		
		char c1 = 'A';
		char c2 = 65;
		
		System.out.println(c1 == c2);//true
		
		
	}
}
