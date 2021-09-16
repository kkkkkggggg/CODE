package interviewtest;

import org.junit.Test;
/*
 * 关于包装类使用的面试题
 * 
*/
public class InterviewTest
{
	@Test
	public void test1()
	{	
		Object o1 = true ? new Integer(1) : new Double(2.0);
		System.out.println(o1);
	}
	
	@Test
	public void test2()
	{
		Object o1;
		if(true)
		{
			o1 = new Integer(1);
		}else
		{
			o1 = new Double(2.0);
		}
		System.out.println(o1);
	}
	
	@Test
	public void test3()
	{
		Integer i = new Integer(1);
		Integer j = new Integer(1);
		System.out.println(i == j);//false
		//Integer内部定义了IntegerCache结构，IntegerCache中定义了Integer[],
		//保存了从-128~127范围的整数。如果我们使用自动装箱的方式，给Integer赋值的范围在
		//-128~127范围内时，可以直接使用数组中的元素，不用再去new了，目的是提高效率
		Integer m = 1;
		Integer n = 1;
		System.out.println(m == n);//true
		
		Integer x = 128;//相当于new了一个对象
		Integer y = 128;//相当于new了一个对象
		boolean b = x.intValue() == y.intValue();
		System.out.println(b);
		System.out.println(x == y);//false
	}
}
