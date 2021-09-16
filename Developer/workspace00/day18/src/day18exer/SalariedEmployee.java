package day18exer;
//按月付工资的员工，如果员工当月生日，加100元工资
public class SalariedEmployee extends Employee
{
	private double monthlySalary;
	
	public SalariedEmployee(String name, int number, MyDate birthday)
	{
		super(name, number, birthday);
		
	}
	
	public SalariedEmployee(String name, int number, MyDate birthday,double monthlySalary)
	{
		super(name, number, birthday);
		this.monthlySalary = monthlySalary;
	}
	
	public double getMonthlySalary()
	{
		return monthlySalary;
	}



	public void setMonthlySalary(double monthlySalary)
	{
		this.monthlySalary = monthlySalary;
	}



	@Override
	public double earning()
	{
		return monthlySalary;
	}
	
	
	public String toString()
	{
		return "SalariedEmployee[" + super.toString() + "]";
	}
}
