/*
�Ż�100000���������������ʵ�ַ�ʽһ
*/
class PrimeNumberTest1 
{
	public static void main(String[] args) 
	{
		boolean isFlag = true;
		int count = 0;//��¼�����ĸ���

		long start = System.currentTimeMillis();

		for (int i = 2;i <= 100000 ;i++ )//����100���ڵ���Ȼ��
		{ 
			//�Ż������Ա�������������Ȼ������Ч��
			for (int j = 2;j <= Math.sqrt(i) ;j++ )//j����iȥ��
			{//          ��j <= i
				if (i % j == 0)//i��j����
				{
					isFlag = false;
					break;//�Ż�һ��ֻ�Ա������������Ȼ����Ч
				}
				/*
				if (isFlag == false)
				{
					break;
				}
				*/
			}

			if (isFlag == true)
			{
				//System.out.println(i);
				count++;
			}

			isFlag = true;//����isFlag
		}
		System.out.println(count);
		long end = System.currentTimeMillis();
		
		System.out.println("�����ѵ�ʱ��Ϊ��" + (end - start));//20039-2386-826-15
	}
}
