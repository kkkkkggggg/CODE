package exercise;

public class HuiXingShu
{
	public static void main(String[] args) 
	{
		int n = 10;
		int[][] arr = new int[n][n];
		
		int cout = 0; //要显示的数据
		int maxX = n-1; // x 轴最大下标
		int maxY = n-1; // Y 轴最大下标
		int minX = 0;//X 轴最小下标
		int minY = 0;//Y 轴最小下标
		while(minX <= maxX) 
		{
			for(int x = minX;x <= maxX; x++) 
			{
				arr[minY][x] = ++cout;
			}
			minY++;
			for(int y = minY;y <= maxY;y++) 
			{
				arr[y][maxX] = ++cout;
			}
			maxX--;
			for(int x = maxX; x>= minX; x--) 
			{
				arr[maxY][x] = ++cout;
			}
			maxY--;
			for(int y = maxY; y>=minY; y--) 
			{
				arr[y][minX] = ++cout;
			}
			minX++;
		}
		
		// 打印
		for(int i=0;i<n;i++)  
		{
			for(int j=0;j<n;j++) 
			{
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}
		
	}

}
