/*
������в�ͬ���Ƶ�ʹ��˵��

���������������ֱ�ʾ��ʽ��
>�����ƣ�binary����0��1 ����2��1����0b��0B��ͷ
>ʮ���ƣ�decimal��:0-9,��10��1
>�˽��ƣ�octal����0-7����8��1��������0��ͷ��ʾ��
>ʮ�����ƣ�hex����0-9��A-F����16��1����0x��0X��ͷ��ʾ���˴�A-F�����ִ�Сд
��0x21AF + 1 = 0X21B0
   



*/


class BinaryTest 
{
	public static void main(String[] args) 
	{
		int num1 = 0b110;
		int num2 = 110;
		int num3 = 0127;
		int num4 = 0x110A;

		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		System.out.println("num3 = " + num3);
		System.out.println("num4 = " + num4);
	}
}
