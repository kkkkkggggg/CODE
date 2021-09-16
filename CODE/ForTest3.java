class ForTest3 
{
	public static void main(String[] args) 
	{
		

		for (int i = 100;i < 1000 ;i++ )
		{
			int bai = i / 100;
			int shi = i % 100 / 10;
			int ge = i % 10;
			if (i == (bai * bai * bai + shi * shi * shi + ge * ge * ge))
			{
				System.out.println(i);
			}

		}
	}
}
//水仙花数，一个三位数的各个位上的三次方相加等于这个数