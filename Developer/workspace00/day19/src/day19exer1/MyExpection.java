package day19exer1;
/*
 * 如何自定义异常类？
 * 1.继承于现有的异常结构：RunTimeException、Expection
 * 2.提供serialVersionUID
 * 3.提供重载的构造器
 */
public class MyExpection extends RuntimeException
{
	static final long serialVersionUID = -7034897190745766939L;
	
	public MyExpection()
	{
		
	}
	
	public MyExpection(String msg)
	{
		super(msg);
	}
}
