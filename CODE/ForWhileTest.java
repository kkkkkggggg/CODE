/*
��Ŀ���Ӽ��̶��������ȷ�������������ж϶���������͸����ĸ���������Ϊ0ʱ��������

˵��������ѭ�������������ƴ����Ľṹ��for(;;)��while��true��

����ѭ���м��ַ�ʽ
һ��ѭ���������ַ���false
������ѭ�����У�ִ��break
*/
import java.util.Scanner;

class ForWhileTest 
{
	public static void main(String[] args) 
	{
		Scanner scan =new Scanner(System.in);

		int numPositive = 0;
		int numNegetive = 0;
		
		while (true)
		{
			int number = scan.nextInt();


			if (number > 0)
			{
				numPositive++;
			}
			else if (number < 0)
			{
				numNegetive++;
			}
			else
			{
				break;
			}
		}



		System.out.println("�����ĸ���:" + numPositive);
		System.out.println("�����ĸ���:" + numNegetive);
		

	}
}
