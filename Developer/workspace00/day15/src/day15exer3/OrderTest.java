package day15exer3;

public class OrderTest
{
	public static void main(String args[])
	{
		Order order = new Order();
		
		order.orderDefault = 1;
		order.orderProtected = 2;
		order.orderPublic = 3;
		
		order.methodDefault();
		order.methodProtected();
		order.methodPublic();
//		order.orderPrivate = 4;
//		order.methodPrivate();
//		同一个包的其他类，不可以调用Order类中私有的属性、方法
	}
}
