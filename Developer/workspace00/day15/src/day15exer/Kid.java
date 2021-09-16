package day15exer;

public class Kid extends ManKind
{
	
	int yearsOld;
	
	
	public Kid()
	{
		
	}


	public Kid(int yearsOld)
	{
		
		this.yearsOld = yearsOld;
	}


	public void printYearsOld()
	{
		System.out.println(yearsOld);
	}


	public int getYearsOld()
	{
		return yearsOld;
	}


	public void setYearsOld(int yearsOld)
	{
		this.yearsOld = yearsOld;
	}
	
	
}
