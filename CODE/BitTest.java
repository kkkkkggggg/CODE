/*
�����֮�壺λ�����
����
1.λ����������Ķ������͵�����
2.<< : ��һ����Χ�ڣ�ÿ������1λ���൱��*2
  >> : ��һ����Χ�ڣ�ÿ������1λ���൱��/2

*/

class BitTest 
{
	public static void main(String[] args) 
	{
	
	int i = -21;
	System.out.println("i >> 2 :" + (i >> 2));
	int i1 = 21;
	System.out.println("i1 >> 2 :" + (i1 >> 2));


	int m = 12;
	int n = 5;
	System.out.println("m & n :" + (m & n));
	System.out.println("m & n :" + (m & n));
	System.out.println("m & n :" + (m & n));

	//��ϰ����������������ֵ
	int num1 = 10;
	int num2 = 20��
	System.out.println("num1 = " + num1 + ",num2 + " + num2);

	//��ʽһ��������ʱ�����ķ�ʽ
	//int temp = num1;
	//num1 = num2;
	//num2 = temp;

	//��ʽ�����ô������ö�����ʱ����
	//�׶ˣ�����Ӳ������ܳ����洢��Χ���о����ԣ�ֻ����������ֵ����
	num1 = num1 + num2;
	num2 = num1 - num2;
	num1 = num1 - num2;
	System.out.println("num1 = " + num1 + ",num2 = " + num2);

	//��ʽ����ʹ��λ�����
	num1 = num1 ^ num2;
	num2 = num1 ^ num2;
	num1 = num1 ^ num2;
	System.out.println("num1 = " + num1 + ",num2 = " + num2); 


	}
}
