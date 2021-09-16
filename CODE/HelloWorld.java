/*class HelloWorld  
{
	public static void main(String[] args) 
	{
		//单行注释：如下的main方法是程序的入口

		
		1.java规范的三种注释方法
		单行注释
		多行注释
		文档注释（java特有）

		2.
		单行注释和多行注释的作用
		对所写的程序进行解释说明，增强可读性，方便自己，方便别人
		可以对所写代码进行调试
		3.
		注释的内容不参与编译，换句话说就是编译后会生成字节码文件不包括
		注释的信息
*/


		
		/**
		4.
		文档注释：可被jdk提供的javadoc解析
		@author ck
		@version v1.0
		*/



		

		
		/*5.
		多行注释不可嵌套
		
		System.out.println("Hello World!");
	}
}


		6.
在同一个Java源文件内可以声明多个类，但是只有一个类可以被声明为public
而且要求声明为public的类的类名必须与源文件名相同
*/
例子如下
public class HelloWorld			//类1，被声明为public
{
	public static void main(String[] args)		//args=arguments=参数
	{
		System.out.println("Hello World");		//输出语句 System.out.println(); 先输出数据然后换行
												//输出语句 System.out.print();   只输出数据不换行
	}

}
class Person		//类2
{

}
class Animal		//类3
{

}
//程序的入口是main（）方法，格式是固定的
//每个执行语句都以 ;  结尾
//编译以后会生成多个字节码文件，有几个类就会有几个字节码文件
//且每个字节码文件的文件名与所对应的类名相同