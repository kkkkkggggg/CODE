/*
ǿ������ת�����Զ�������������������㡣
��Ҫʹ��ǿ��ת����������



*/

class VariableTest2 
{
	public static void main(String[] args) 
	{
	double d1 = 12.3;//������ʧ��һ

	int i1 = (int)d1;//�ضϲ�����ֻȡ�������֣����ܻ���ʧ����

	System.out.println(i1);

	long l1 = 123;  //û�о�����ʧ
	short s1 = (short)l1;

	int i2 = 128;  //������ʧ����
	byte a = (byte)i2;
	System.out.println(a);//-128

	//�������һ
	long b = 121123;//���ͳ�����Ĭ��Ϊint�ͣ�����ֵδ����int��Χ��Ĭ��Ϊint�����ᱨ��
	System.out.println(b);
	//����ʧ�ܣ����������
	//long c = 121314125125213561412; ����int�ķ�Χ������
	long c = 121314125125213561412L; 
	

	byte d = 12;
	//byte d1 = d + 1;  ����ʧ�ܣ����ͳ���1��Ĭ��Ϊint�ͣ�ת��Ϊ��С��byte�ͻᱨ��
	
	//float f = 12.3�� ����ʧ�ܣ������ͳ���12.3��Ĭ��Ϊdouble�ͣ�ת��Ϊ��Χ��С��float�ͻᱨ��
	float f = 12.3F��//����ɹ�
	//float f1 = d + 12.3��  ����ʧ��

	}
}
