package day14exer3;

public class Customer
{
	private String firstName;
	private String lastName;
	private Account account;
	
	public Customer(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
//	public void addCustomer(String firstName,String lastName)
//	{
//		this.firstName = firstName;
//		this.lastName = lastName;
//	}
//	获取账户信息
	public Account getAccount()
	{
		return account;
	}

	//创建一个Account
	public void setAccount(Account account)
	{
		this.account = account;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}
}
