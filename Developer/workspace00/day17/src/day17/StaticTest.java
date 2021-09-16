package day17;
/*
 * static关键字的使用
 * 
 * 1.static静态的
 * 
 * 2.static可以用来修饰：属性、方法、代码块、内部类
 * 
 * 3.使用static修饰属性:静态变量(或类变量)
 * 			3.1属性：按是否使用static修饰，又分为：静态属性 VS 非静态属性(实例变量)
 * 			实例变量：我们创建了类的多个对象，每一个对象都独立拥有一套类中的非静态
 * 				属性，当修改一个对象中的非静态属性时，不会导致其他对象中同样的属性值的
 * 				修改
 * 			静态变量：我们创建了类的多个对象，多个对象共享一个静态变量，当通过某一个对
 * 				像修改静态变量时，会导致其他对象调用此静态变量时，是修改过了的
 * 			3.2static修饰属性的其他说明
 * 				①静态变量随着类的加载而加载,可以通过"类.静态变量"的方式进行调用
 * 				②静态变量的加载要早于对象的创建
 *				③由于类只会加载一次，则静态变量在内存中也只会存在一份，存在方法区的静态域中
 *				
 *				④		类变量		实例变量
 *				类		yes			
 * 				对象		yes			yes
 * 			3.3 静态属性举例：System.out;  Math.PI;
 * 
 * 
 * 4.使用static修饰方法
 * 		①随着类的加载而加载，可以通过 “类.方法名”进行调用
 * 
 * 		②		静态方法		非静态方法 
 *		类		yes			
 * 		对象		yes			yes
 * 		③静态方法中：只能调用静态的方法或属性
 * 		④非静态方法中既可以调用静态方法和属性，又可以调用非静态方法和属性
 * 5.static
 * 		5.1 在静态方法内，不能使用this关键字和super关键字
 * 		5.2 关于静态属性和静态方法的使用，从生命周期的角度去理解
 * 
 * 6.开发中，如何确定一个属性要不要声明为static？
 * 		>属性是可以被多个对象共享的，不会随着对象的不同而不同的
 * 		>类中的常量也常常声明为static 
 * 	
 *  开发中，如何确定一个方法要不要声明为static？
 *  	>操作静态属性的方法，通常设置为静态的
 *  	>工具类中的方法习惯的声明为static的，比如Math、Arrays
*/
public class StaticTest
{
	public static void main(String args[])
	{
		Chinese.nation = "中国";
		Chinese c1 = new Chinese();
		c1.name = "xxx";
		c1.age = 12;
		c1.nation = "CHN";
		
		Chinese c2 = new Chinese();
		c2.name = "zzz";
		c2.age = 50;
		c2.nation = "CHINA";
		
		double a = Math.PI;
		
		System.out.println(c1.nation);
	}
	
	
}


class Chinese
{
	String name;
	int age;
	static String nation;
}
