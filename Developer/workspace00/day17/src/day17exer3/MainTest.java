package day17exer3;
/*
 * main()方法的使用说明
 * 
 * 1.main()方法作为程序的入口
 * 
 * 2.main()方法也是一个普通的静态方法
 * 
 * 3.main()方法也可以作为我们与控制台交互的方式(之前，使用Scanner)
*/
public class MainTest
{
	public static void main(String[] args)
	{
		Main.main(new String[100]);
		show();
	}
	
	public static void show() 
	{
		
	}
}

class Main
{
	public static void main(String[] args)
	{
		args = new String[100];
		for(int i = 0;i < args.length;i++)
		{
			args[i] = "args_" + i;
			System.out.println(args[i]);
		}
	}
}