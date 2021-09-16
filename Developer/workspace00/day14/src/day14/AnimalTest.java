package day14;
/*
面向对象的特征一：封装与隐藏
一、问题的引入：
	当我们创建一个类的对象后，我们可以通过“对象.属性”对属性进行赋值，这里，赋值
	操作要受到属性的数据类型和存储范围的制约，除此之外，没有其他制约条件，但是在
	实际问题中，我们往往需要给属性赋值加入额外的限制条件，这个条件不能在声明属性
	时体现，我们只能通过方法进行限制条件的添加。同时我们需要避免用户再使用“对象.属性”
	的方法进行对象的属性的赋值，则需要将属性声明为私有的(private).此时针对属性就体现
	了封装性
	
二、封装性的体现：
我们将类的属性xxx私有化(private),同时，提供公共的(public)方法来获取(getXxx)和设置
(setXxx)来设置属性的值
	
拓展：封装性的体现：① 如上 ②不对外暴露的私有的方法
三、封装性的体现，需要权限修饰符来配合

1.Java 规定的四种权限（从小到大排列）：private\缺省\protected\public
2.4种权限可以用来修饰类及类的内部结构：属性、方法、构造器、内部类
					修饰类的话只能用缺省、public 
出了类所属的包之后，私有的结构、缺省声明的结构就不可以调用了
修饰符		类内部		同一个包			不同包的子类			同一个工程
private		yes			
缺省			yes			yes
protected	yes			yes				yes	
public		yes			yes				yes					yes


总结封装性：Java提供了四种修饰符来修饰类及类的成员，体现了类及类的成员在调用时的可见性



*/
public class AnimalTest
{
	public static void mian(String args[])
	{
		Animal a = new Animal();
		a.name = "大王";
		a.age = 1;
//		a.legs = 4;
		a.setLegs(6);
		a.show(a);
	}

}

class Animal
{
	String name;
	int age;
	private int legs;//腿的个数，加private，相当于对属性legs进行了封装、隐藏
//	只能在类的内部调用属性
//	对属性的设置
	public void setLegs(int l)//对属性的赋值添加限制
	{
		if(l >= 0 && l % 2 == 0)
		{
			legs = l;
		}else
		{
			legs = 0;//抛出一个异常，暂时没有讲
		}
	}
	
//	对属性的获取
	public int getLegs()
	{
		return legs;
	}
	
	
	public void eat()
	{
		System.out.println("动物进食");
	}
	
	
	public void show(Animal a)
	{
		System.out.println("name =" + a.name + "age = " + a.age + "legs" + a.legs);
	}
}