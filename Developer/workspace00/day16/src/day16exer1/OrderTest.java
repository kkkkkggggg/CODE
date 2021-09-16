package day16exer1;

public class OrderTest
{
	public static void main(String args[])
	{
		Order o1 = new Order();
		o1.setOrderId(20);
		o1.setOrderName("www");
		
		Order o2 = new Order(20, "www");
		
		System.out.println(o1.equals(o2));
		boolean s = (o1 instanceof Object);
		
		Object obj = new Order();
		Order order = (Order)obj;
		
		Object ob = new Object();
		
		Order o3 = new Order();
		
		ob = o3;
		
		System.out.println(ob == o3);
		Order s1 = (Order)ob;
		s1.setOrderId(200);
		
		System.out.println(s);
	}
}
