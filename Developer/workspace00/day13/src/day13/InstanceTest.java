package day13;
/*
 * 一、理解“万事万物皆对象”
 * 1.在Java语言中，我们将功能、结构等封装到类中，通过类的实例化来调用
 * 具体的功能结构
 * 		>Scanner、String等
 * 		>文件、File
 * 		>网络资源、URL
 * 2.涉及到Java语言与前端HTML、后端数据库交互时，前端的结构在Java层面交互时
 * ，都体现为类、对象
 * 
 * 二、内存解析的说明
 * 1.引用类型的变量，只可能存储两类值：null 或 地址值（包含变量类型信息在内的地址值）
 * 
 * 三、匿名对象的使用
 * 1.理解：我们创建的对象没有显式的赋给一个变量名。即为匿名对象
 * 2.匿名对象只能调用一次
*/
public class InstanceTest
{
	public static void main(String args[])
	{
		Phone p = new Phone();
		//p = null
		System.out.println(p);
		
		p.sendEmail();
		p.playGame();
		
		
		
		//匿名对象
//		new Phone().sendEmail();
//		new Phone().playGame();
//		
//		两次创建的对象是不同的对象，给第一个的属性赋值并不会影响第二个
//		对象的属性
		new Phone().price  = 1999;//执行结果：价格为1999
		new Phone().showPrice();//执行结果：0.0
		
//		*******************************************
		PhoneMall mall = new PhoneMall();
//		mall.show(p);
//		匿名对象的使用
		mall.show(new Phone());
		
	}
	
}

class PhoneMall
{
	public void show(Phone phone)
	{
		phone.sendEmail();
		phone.playGame();
	}
}

class Phone
{
	double price;//价格
	
	public void sendEmail()
	{
		System.out.println("发送邮件");
	}
	
	public void playGame()
	{
		System.out.println("玩游戏");
	}
	
	public void showPrice()
	{
		System.out.println("价格为" + price);
	}
		
}