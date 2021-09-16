package day18exer1;

public class NetWorkTest
{
	public static void main(String[] args)
	{
		Sever sever = new Sever();
		ProxySever p = new ProxySever(sever);
		
		p.browse();
	}
}

interface NetWork
{
	public void browse();
	
}

//被代理类
class Sever implements NetWork
{

	@Override
	public void browse()
	{
		System.out.println("真实的服务器来访问网络");
		
	}
	
}

class ProxySever implements NetWork
{
	private NetWork work;
	
	public ProxySever(NetWork work)
	{
		this.work = work;
	}
	
	public void check()
	{
		System.out.println("联网之前的检查工作");
	}
	
	@Override
	public void browse()
	{
		check();
		work.browse();
		
	}
	
}