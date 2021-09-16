package day13;

public class Exer
{
	public static void main(String args[])
	{
		//声明一个Student类型的数组
		Student[] stus = new Student[20];
		//String[] arr = new String[20];
		//数组的元素可以是任何数据类型，包括类类型
		for(int i = 0;i < stus.length;i++)
		{
			stus[i] = new Student();
			stus[i].number = (i + 1);
			stus[i].getState();
			stus[i].getScore();
			System.out.println(stus[i].studentInfo());
			
		}
		System.out.println("************************************");
		
		for(int i = 0;i < stus.length;i++)
		{
			if(stus[i].state == 6)
			{
				System.out.println(stus[i].studentInfo());
			}
		}
		System.out.println("************************************");
		for(int i = 0;i < stus.length;i++)
		{
			for(int j = 0;j < stus.length - 1 - i;j++)
			{
				if(stus[j].score > stus[j + 1].score)
				{
					Student temp = new Student();
					temp = stus[j];//Student temp = stus[j];
					stus[j] = stus[j + 1];
					stus[j + 1] = temp;
				}
				
			}
			System.out.println(stus[stus.length - 1 - i].studentInfo() );
		}
		
		
	}
	
}

class Student
{
	int number;
	int state;
	int score;
	public int getState()
	{
		state = (int)((Math.random() * 4) + 6);
		return state;
	}
	
	public int getScore()
	{
		score = (int)((Math.random() * 100) + 1);
		return score;
	}
	
	public String studentInfo()
	{
		String info = "学号为:" + number + " 年级为:" + state + " 成绩为:" + score;
		return info;
	} 
}