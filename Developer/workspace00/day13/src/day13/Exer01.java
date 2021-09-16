package day13;
//此程序是对Exer.java的优化
public class Exer01
{
	public static void main(String args[])
	{
		//声明一个Student类型的数组
		Student01[] stus = new Student01[20];
		//String[] arr = new String[20];
		//数组的元素可以是任何数据类型，包括类类型
		for(int i = 0;i < stus.length;i++)
		{
			stus[i] = new Student01();
			stus[i].number = (i + 1);
			stus[i].getState();
			stus[i].getScore();
			System.out.println(stus[i].studentInfo());
			
		}
		
		System.out.println("************************************");
		
		//将输出指定年级学生信息的功能和根据成绩对学生进行排序的功能
		//封装进Exer01类所包含的方法中，再在main方法中对类Exer01进行
		//实例化，调用其中的方法,与将功能封装在Student类中效果一样，
		//只是在调用方法时，实例化方法所在类的不同 Exer01/Student
		//输出年级为6的学生的信息
		Exer01 stu1 = new Exer01();
		stu1.findState(stus, 6);
		
		
		System.out.println("************************************");
		
		
		//根据分数对学生进行排序
		stu1.sort(stus);
	}
	
	//将查找年级并输出学生信息封装进方法中
	public void findState(Student01[] stus,int state)
	{
		for(int i = 0;i < stus.length;i++)
		{
			if(stus[i].state == state)
			{
				System.out.println(stus[i].studentInfo());
			}
		}
	}
	
	//将排序封装进方法中
	public void sort(Student01[] stus)
	{
		for(int i = 0;i < stus.length;i++)
		{
			for(int j = 0;j < stus.length - 1 - i;j++)
			{
				if(stus[j].score > stus[j + 1].score)
				{
					Student01 temp = new Student01();
					temp = stus[j];//Student temp = stus[j];
					stus[j] = stus[j + 1];
					stus[j + 1] = temp;
				}
				
			}
			System.out.println(stus[stus.length - 1 - i].studentInfo() );
		} 
	}
	
	
}


class Student01
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
