package day02exer;

/**
 * @acthor KKKKK
 * @creay 2021-04-13-{TIME}
 */
public class AccountTest
{
    public static void main(String[] args)
    {
        Account account = new Account();
        Customer c1 = new Customer(account,"储户一");
        Customer c2 = new Customer(account,"储户二");

        c1.start();
        c2.start();


    }
}

class Account
{


    private double balance = 0;

    public void setBalance(double num)
    {
        balance += num;
    }

    public double getBalance()
    {
        return balance;
    }



}

class Customer extends Thread
{
    private String name;
    private Account account;

    public Customer(Account account,String name)
    {
        this.account = account;
        this.name = name;
    }

    @Override
    public void run()
    {
        deposite();
    }

    public void deposite()
    {
        synchronized(Customer.class)
        {
            for(int i = 0; i < 3; i++)
            {
                account.setBalance(1000);
                System.out.println(this.name + "存款1000，余额为:" + account.getBalance());
            }
        }
    }

//    public void deposite(double num)
//    {
//        account.setBalance(num);
//        System.out.println("余额:" + account.getBalance());
//    }
}
