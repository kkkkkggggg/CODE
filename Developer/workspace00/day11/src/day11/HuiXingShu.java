package day11;
import java.util.Scanner;
public class HuiXingShu
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入回形数的边长：\n");
		int edge = scan.nextInt();
		int[][] arr = new int[edge][edge];
		
		int count = 0;
		int maxX = edge - 1;
		int maxY = edge - 1;
		int minX = 0;
		int minY = 0;
		while(minX <= maxX)
		{
			for(int x = minX;x <= maxX;x++)
			{
				arr[minX][x] = ++count;
			}
			minY++;
			for(int y = minY;y <= maxY;y++)
			{
				arr[y][maxX] = ++count;
			}
			maxX--;
			for(int x = maxX;x >= minX;x--)
			{
				arr[maxY][x] = ++count;
			}
			maxY--;
			for(int y = maxY;y >= minY;y--)
			{
				arr[y][minX] = ++count;
			}
			minX++;
		}
		
		for(int i = 0;i < arr.length;i++)
		{
			for(int j = 0;j < arr[i].length;j++)
			{
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
}
