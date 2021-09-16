package day16exer3;
import java.util.Vector;
import java.util.Scanner;
/*
	利用Vector代替数组处理:从键盘读入学生成绩（以负数代表输入结束），找
	出最高分，并输出学生成绩等级提示:数组一旦创建，长度就固定不变，所
	以在创建数组前就需要知道它的长度。
	而向量类java.util.Vector可以根据需要动态伸缩。
	创建Vector对象: Vector v = new vector();
	给向量添加元素: v.addElement(0bject obj);//obj必须是对象
	取出向量中的元素:Object obj = v.elementAt(0);
	注意第一个元素的下标是0,返回值是Object类型的。
	计算向量的长度:v.size();
	若与最高分相差10分内:A等;20分内:B等;
	30分内:C等;其它:D等

*/
public class ScoreTest
{
	public static void main(String args[])
	{
		
		ScoreTest s = new ScoreTest();
		int[] arr = s.getScore();
		int max = s.getMax(arr);
		s.printLevel(max, arr);
//		Scanner scan = new Scanner(System.in);
//		Vector v = new Vector();
//		
//		System.out.println("请输入学生成绩:");
//		for(;;)
//		{
//			int i = scan.nextInt();
//			if(i >= 0)
//			{
//				Integer s = i;
//				v.addElement(s);
//			}else
//			{
//				break;
//			}
//		}
//		
//		int[] arr = new int[v.size()];
//		
//		for(int i = 0;i < arr.length;i++)
//		{
//			Object obj = v.elementAt(i);
//			Integer s = (Integer)obj;
//			arr[i] = s.intValue();
//			System.out.println(arr[i]);
//		}
//		
//		
//		int max = 0;
//		for(int i = 0;i < arr.length;i++)
//		{
//			if(arr[i] > max)
//			{
//				max = arr[i];
//			}
//		}
//		
////		int max = arr[arr.length - 1];
//		
//		for(int i = 0;i < arr.length;i++)
//		{
//			if(max - arr[i] <= 10)
//			{
//				System.out.println("成绩是: " + arr[i] + "  等级是:A");
//			}else if(max - arr[i] <= 20)
//			{
//				System.out.println("成绩是: " + arr[i] + "  等级是:B");
//			}else if(max - arr[i] <= 30)
//			{
//				System.out.println("成绩是: " + arr[i] + "  等级是:C");
//			}else
//			{
//				System.out.println("成绩是: " + arr[i] + "  等级是:D");
//			}
//		}
		
	}
	
	public int[] getScore()
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		Vector<Integer> v = new Vector<Integer>();
		
		System.out.println("请输入学生成绩:");
		for(;;)
		{
			int i = scan.nextInt();
			if(i >= 0)
			{
				Integer s = i;
				v.addElement(s);
			}else
			{
				break;
			}
		}
		
		int[] arr = new int[v.size()];
		
		for(int i = 0;i < arr.length;i++)
		{
			Object obj = v.elementAt(i);
			Integer s = (Integer)obj;
			arr[i] = s.intValue();
			System.out.println(arr[i]);
		}
		
		return arr;
	}
	
	public int getMax(int[] arr)
	{
		int max = 0;
		for(int i = 0;i < arr.length;i++)
		{
			if(arr[i] > max)
			{
				max = arr[i];
			}
		}
		System.out.println("最高分是:" + max);
		return max;
	}
	
	public void printLevel(int max,int[] arr)
	{
		for(int i = 0;i < arr.length;i++)
		{
			if(max - arr[i] <= 10)
			{
				System.out.println("成绩是: " + arr[i] + "  等级是:A");
			}else if(max - arr[i] <= 20)
			{
				System.out.println("成绩是: " + arr[i] + "  等级是:B");
			}else if(max - arr[i] <= 30)
			{
				System.out.println("成绩是: " + arr[i] + "  等级是:C");
			}else
			{
				System.out.println("成绩是: " + arr[i] + "  等级是:D");
			}
		}
	}
}
