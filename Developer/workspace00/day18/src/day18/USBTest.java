package day18;
//1.接口的使用体现了多态性
//2.接口实际上是定义了一种规范
//3.在开发中，体会面向接口编程

public class USBTest
{
	public static void main(String[] args)
	{
		Computer c = new Computer();
		//1.创建了接口的非匿名实现类的非匿名对象
		Flash flash = new Flash();
		c.transferData(flash);
		
		//2..创建了接口的非匿名实现类的匿名对象
		c.transferData(new Printer());
		
		//3.创建了接口的匿名实现类的非匿名对象
		
		USB phone = new USB()
				{

					@Override
					public void start()
					{
						System.out.println("手机开始工作");
						
					}

					@Override
					public void stop()
					{
						System.out.println("手机结束工作");
						
					}
			
				};
				c.transferData(phone);
		
	//4.创建了接口的匿名实现类的匿名对象
				c.transferData(new USB(){

					@Override
					public void start()
					{
						System.out.println("mp3开始工作");
						
					}

					@Override
					public void stop()
					{
						System.out.println("mp3结束工作");
						
					}
					
				});
	}

}


class Computer
{
	public void transferData(USB usb)//USB usb = new Flash;
	{
		usb.start();
		System.out.println("具体的传输细节");
		
		usb.stop();
	}
}

interface USB
{
	//定义了长、宽、最大最小的传输速度
	void start();
	
	void stop();
}


class Flash implements USB
{

	@Override
	public void start()
	{
		System.out.println("U盘开始工作");
		
	}

	@Override
	public void stop()
	{
		
		System.out.println("U盘结束工作");
	}
	
}

class Printer implements USB
{
	@Override
	public void start()
	{
		System.out.println("打印机开始工作");
		
	}

	@Override
	public void stop()
	{
		
		System.out.println("打印机结束工作");
	}
	
}