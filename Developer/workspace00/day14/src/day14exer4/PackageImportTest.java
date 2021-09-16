package day14exer4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import day14exer.Customer;
import day14exer3.Bank;

import static java.lang.System.*;

/*
 *一、package关键字的使用
 *1. 为了更好的实现项目中类的管理，提供包的概念
 *2.使用package来声明类或者接口所属的包，声明在源文件的首行 
 *3.包名属于标识符，遵循标识符的命名规则和规范，见名知意
 *4.每“.”一次，就代表一层文件目录。
 *
 *补充：同一个包下，不能命名同名的接口、类，不同的包下可以命名同名的
 *接口和类
 *
 *二、import 关键字的使用
 *import：导入
 *1.在源文件中显式的使用import导入指定包下的：类、接口
 *2.声明在包的声明package和类的声明之间
 *3.如果需要导入多个结构，则并列写入即可
 *4.可以使用“包名.*”的方式导入包下的所有结构
 *5.如果使用的类或接口是定义在java.lang包下的，可以省略import
 *6.如果使用的类或接口是本包下定义的，也可以省略import
 *7.如果在源文件中使用了不同包下的同名类，则至少有一个对类使用全类名的
 *方式显示
 *8.使用“ 包名 . * ”的方式可以调用该包下所有的结构，但如果使用的是该包
 *子包下的结构，则仍需要显式全类名调用
 *9.使用 “import static”的方式导入指定类或接口中的静态结构：属性、方法
*/
public class PackageImportTest
{
	public static void main(String args)
	{
		String info = Arrays.toString(new int[]{1,2,3});
		
		Bank bank = new Bank();
		
		ArrayList list = new ArrayList();
		
		HashMap map = new HashMap();
		
		Scanner s = null;
		
		Customer cust = new Customer();
		
		day14exer2.Customer cust1 = new day14exer2.Customer("2", "3");
		//全类名
//		System.out.println();
		out.println();//使用import static java.lang.System.*;导入
		//java.lang.System类中的所有静态结构  
	}

}
