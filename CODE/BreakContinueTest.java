/*
break��continue�ؼ��ֵ�ʹ��
                ʹ�÷�Χ        ѭ����ʹ�õ�����   
break           switch-case
                ѭ���ṹ��      ������ǰѭ��

continue        ѭ���ṹ��      ��������ѭ��

��ͬ�� �ؼ��ֺ��治������ִ�����

*/
class BreakContinueTest 
{
	public static void main(String[] args) 
	{
		for (int i = 1;i <= 10 ;i++ )
		{
			if (i % 4 == 0)
			{
				//break;//123
				continue;//1235678910
			}
		}
		System.out.print(i);
		//**********************************

		Label1:for (int i = 1;j <= 10 ;j++ )
		{
			for (int j = 1;j <= 10 ;j++ )
			{
				if (j % 4 == 0)
				{
					//break;//Ĭ�����������˹ؼ��������һ��ѭ��
					//continue;//

					//break Label1;//����ָ����ʶ��һ��ѭ���ṹ
					continue Label1;//����ָ����ʶ��һ��ѭ���ṹ����ѭ��
				}
					System.out.print(j);
			}
			System.out.println();
		}
	}
}
