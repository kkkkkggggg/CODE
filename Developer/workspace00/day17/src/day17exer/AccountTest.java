package day17exer;

public class AccountTest
{
	public static void main(String args[])
	{
		Account acct1 = new Account();
		
		Account acct2 = new Account("232568", 5000);
		Account.setLilv(0.012);
		Account.setMinBalance(100);
		System.out.println(acct1);
		System.out.println(acct2);
		
		System.out.println(acct1.getLilv());
		System.out.println(acct1.getMinBalance());
	}
}
