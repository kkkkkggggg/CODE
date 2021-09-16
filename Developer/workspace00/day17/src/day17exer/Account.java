package day17exer;
/*
 * 编写一个类实现银行账户的概念，包含的属性有"帐号"、"密码”、""存款余额”
 * 、"利率”、最小余额”，定义封装这些属性的方法。账号要自动生成。
 * 编写主类,使用银行账户类,输入、输出3个储户的上述信息.。考虑:哪些属性可
 * 以设计成static属性。
 * 
 * 
 * 
 * 
*/
public class Account
{
	private int id;
	private String passWord = "000000";
	private double balance;
	private static double minBalance = 1.0;
	private static double lilv;
	private static int init = 1001;//用于自动生成id
	
	public Account()
	{
		id = init++;
	}
	
	public Account(String passWord,double balance)
	{
		this.balance = balance;
		this.passWord = passWord ; 
	}
	
	@Override
	public String toString()
	{
		return "Account [id=" + id + ", passWord=" + passWord + ", balance=" + balance + "]";
	}

	public String getPassWord()
	{
		return passWord;
	}

	public void setPassWord(String passWord)
	{
		this.passWord = passWord;
	}

	public static double getMinBalance()
	{
		return minBalance;
	}

	public static void setMinBalance(double minBalance)
	{
		Account.minBalance = minBalance;
	}

	public static double getLilv()
	{
		return lilv;
	}

	public static void setLilv(double lilv)
	{
		Account.lilv = lilv;
	}

	public int getId()
	{
		return id;
	}

	public double getBalance()
	{
		return balance;
	}

	
	
	
}
