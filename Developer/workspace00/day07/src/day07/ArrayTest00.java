package day07;

public class ArrayTest00
{
	public static void main(String[] args)
	{
		String[] arr = new String[]{"aa","bb","cc","dd","ee","ff"};
		
		String[] arr1 = new String[arr.length];
		for(int i = 0;i < arr.length;i++)
		{
			arr1[i] = arr[i];
		}
		
		for(int i = 0;i < arr.length/2;i++)
		{
			String tem = "";
			tem = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = tem;
		}
		
		for(int i = 0;i < arr.length;i++)
		{
			System.out.print(arr[i] + "  ");
		}
		
		
		//查找：线性查找
		String dest = "bb";
		boolean isFlag = true;
		for(int i = 0;i < arr.length;i++)
		{
			if(dest.equals(arr[i]))
			{
				System.out.println("找到了指定的元素，位置为：" + i);
				
				isFlag = false;
				break;
				
			}
		}
		
		if(isFlag = false)
		{
			System.out.println("没有找到");
		}
		
		//二分法查找：
		//前提：所要查找的数组必须有序
		int[] arr2 = new int[]{1,7,46,53,88,90,120,231,318,456};
		int dest1 = 120;
		int head = 0;
		int end = arr2.length - 1;
		boolean isFlag1 = false;
		
		while(head <= end)
		{
			int middle = (head + end)/2;
			
			if(dest1 == arr2[middle])
			{
				System.out.println("找到了指定元素，位置为：" + middle);
				isFlag1 = false;
				break;
			}
			else if(arr2[middle] > dest1)
			{
				end = middle - 1;
			}
			else
			{
				head = middle + 1;
			}
		}
		
		if(isFlag1)
		{
			System.out.println("没有找到");
		}
		
	}
	

}
