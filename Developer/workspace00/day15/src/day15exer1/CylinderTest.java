package day15exer1;

public class CylinderTest
{
	public static void main(String args[])
	{
		Cylinder c = new Cylinder();
		
		c.setRadius(5);
		c.setLength(6);
		double vomule = c.findVomule();
		System.out.println(vomule);
	}
}
