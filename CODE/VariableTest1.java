/*
 ������������֮����������

 ǰ�� �� ����ֻ����7�ֻ����������ͱ���������㣬������boolean����

 1. �Զ�����������
	������С���������͵ı�������������������͵ı���������ʱ������Զ�����Ϊ���������������
	byte��char��short-->int-->long-->float-->double
	�ر�ģ���byte��char��short�������ͱ���������ʱ�����Ϊint��





 2. ǿ������ת����







˵������ʱ��������Сָ���ǣ���ʾ���ķ�Χ�Ĵ�С�����磺float����������long������

*/
class VariableTest1
{
	public static void main(String[] args)
	{
		byte b1 = 2;
		int i1 =129;
		//byte b2 = b1 + i1;   ���벻ͨ�� byte��ȡֵ -128~127
		int l1 = b1 + i1;
		System.out.println(l1);

		char c1 = 'a';
		int c2 = 10;
		int c3 = c1 + c2;
		System.out.println(c3);
		
	}
}
