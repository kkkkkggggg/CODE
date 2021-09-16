package day15exer2;

public class Student extends Person
{
	 String major;
	 
	 public Student()
	 {
		 
	 }
	 
	 public Student(String major)
	 {
		 this.major = major;
	 }
	 
	 public void study()
	 {
		 System.out.println("专业是" + major);
	 }
	 
	 public void eat()//覆盖掉父类中同名同参数的方法eat，在调用时会调用子类覆盖之后的方法
		{
			System.out.println("吃饭，吃点好的");
		}
}
