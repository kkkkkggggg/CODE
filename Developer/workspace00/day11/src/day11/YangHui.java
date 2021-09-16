package day11;
import java.util.Scanner;
public class YangHui
{
	public static void main(String args[])
	{
//		@SuppressWarnings("resource")
//		Scanner scan = new Scanner(System.in);
//		System.out.println("请输入杨辉三角的行数:");
//		int hangShu = scan.nextInt();
//		
//		//确定杨辉三角每一行的元素个数并对每一行的第一个和最后一个元素赋值为1
//		int[][] yanghui = new int[hangShu][];
//		for(int i = 0;i < yanghui.length;i++)
//		{
//			for(int j = 1;j <= i+1;j++)
//			{
//				int[] arr = new int[j];
//				yanghui[i] = arr;
//				yanghui[i][0] = 1;
//				yanghui[i][yanghui[i].length - 1] = 1;
//			}
//		}
//
//		//从第三行开始，每一行的非第一个元素和最后一个元素除外，每个数yanghui[i][j] = yanghui[i - 1][j - 1] + yanghui[i - 1][j];
//		for(int i = 2;i < yanghui.length;i++)
//		{
//			for(int j = 0;j < yanghui[i].length;j++)
//			{
//				if(j != 0 && j != i)
//				{
//					yanghui[i][j] = yanghui[i - 1][j - 1] + yanghui[i -1][j];
//				}
//				
//			}
//		}
//		
//		for(int i = 0;i < yanghui.length;i++)
//		{	for(int j = 0;j < yanghui[i].length;j++)
//			{
//				System.out.print(yanghui[i][j] + "\t");
//			}
//			System.out.println();
//		}
			
		int[][] yangHui = new int[35][];
		for(int i = 0;i < yangHui.length;i++)
		{
			yangHui[i] = new int[i + 1];
			
			yangHui[i][0] = yangHui[i][i] = 1;
			
			if(i > 1)//条件语句可去可不去
			{
				for(int j = 1;j <yangHui[i].length - 1;j++)
				{
					yangHui[i][j] = yangHui[i -1][j - 1] + yangHui[i -1][j];
				}
			}
		}
		
		for(int i = 0;i < yangHui.length;i++)
			{	for(int j = 0;j < yangHui[i].length;j++)
				{
					System.out.print(yangHui[i][j] + "\t");
				}
				System.out.println();
			}
		
	}
}
