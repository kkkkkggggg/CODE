/*
�Ż�100000���������������ʵ�ַ�ʽ��
*/
class PrimeNumberTest2 
{
	public static void main(String[] args) 
	{
		boolean isFlag = true;
		int count = 0;//��¼�����ĸ���
		//��ȡ��ǰʱ�����1970-01-01 00��00��00�ĺ�����
		long start = System.currentTimeMillis();

		label1:for (int i = 2;i <= 100000 ;i++ )//����100���ڵ���Ȼ��
		{ 
			//�Ż������Ա�������������Ȼ������Ч��
			for (int j = 2;j <= Math.sqrt(i) ;j++ )//j����iȥ��
			{//          ��j <= i
				if (i % j == 0)//i��j����
				{
					continue label1;
				}
				
			}
				//��ִ�е��˲���ģ���������
				count++;
		}
		System.out.println(count);
		long end = System.currentTimeMillis();
		
		System.out.println("�����ѵ�ʱ��Ϊ��" + (end - start));//20039-2386-826-15
	}
}
