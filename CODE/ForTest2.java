/*
��Ŀ����������������m��n,�������Լ������С������

˵����break�ؼ��ֵ�ʹ��
*/
import java.util.Scanner;
class ForTest2 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("�������һ��������");
		int m = scan.nextInt();

		System.out.println("������ڶ���������");
		int n = scan.nextInt();
		//��ȡ���Լ��
		//��ȡ�������е���Сֵ
		
		int min = (m <= n)? m : n;

		for (int i = min;i >= 1 ;i-- )
		{
				if (m % i == 0 && n % i == 0)
			{
				System.out.println(i);
				break;//һ����ѭ����ִ�е�break,������ѭ��
			}
		}
		

		//��ȡ��С������
		//��ȡ�������еĽϴ�ֵ
		int max = (m >= n)? m : n;
		//����
		for (int i = max;i <= m*n ;i++ )
		{
			if(i % m == 0 && i % n == 0)
			{
			 
			 System.out.println(i);
		
			 break;
			}
		}
	}
}
