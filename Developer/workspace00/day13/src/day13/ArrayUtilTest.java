package day13;

public class ArrayUtilTest
{
	public static void main(String args[])
	{
		int[] arr = {7,3,10,4,2,6,9,8,1,5};//类型推断,不用写new int
		ArrayUtil testArr = new ArrayUtil();
//		***********************************
//		求数组最大值
		System.out.println("最大值是:" + testArr.getMax(arr));
//		***********************************
//		求数组最小值
		System.out.println("最小值是:" + testArr.getMin(arr));
//		***********************************
//		求数组总和
		System.out.println("总和是:" + testArr.getSum(arr));
//		***********************************
//		求数组平均值
		System.out.println("平均值是:" + testArr.getAverage(arr));
//		***********************************
//		反转数组
		testArr.reverse(arr);
		for(int i = 0;i < arr.length;i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
//		***********************************
//		复制数组
		int[] copy = testArr.copy(arr);
		for(int i = 0;i < copy.length;i++)
		{
			System.out.print(copy[i] + " ");
		}
		System.out.println();
		
//		***********************************
//		数组排序
		testArr.sort(arr);
		for(int i = 0;i < arr.length;i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
//		***********************************
//		遍历数组
		testArr.print(arr);
//		***********************************
//		查找指定值
		testArr.search(arr, 6);
		
		
	}
}
