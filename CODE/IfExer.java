/*





*/

class IfExer 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		System.out.println("�����������ߣ� ��cm��");
		int height = scan.nextInt();

		System.out.println("��������ĲƸ��� ��ǧ��");
		double wealth = scan.nextDouble();

		System.out.println("���������Ƿ�˧�� ����\��");
		boolean isHandsome = scan.nextBoolean;

		if(height >= 180 && wealth >= 1 && isHandsome.equals("��"))
		{
			System.out.println("��һ��Ҫ�޸���");
		}
		else if (height >= 180 || wealth >= 1 || isHandsome.equals("��"))
		{
			System.out.println("�ްɣ����ϲ����������");
		}
		else
		{
			System.out.println("����");
		}


	}
}
