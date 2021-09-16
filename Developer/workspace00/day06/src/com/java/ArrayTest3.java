package com.java;
/*
 * 二维数组的使用：
 * 规定：
 * 规定：二维数组分为外层数组的元素，内层数组的元素
 * int[][] arr = new int[4][3];
 * 外层元素：arr[0],arr[1]等
 * 内层元素：arr[0][0],arr[1][1]
 * 
 * ⑤数组元素的默认初始化值
 * 针对于初始化方式一：int[][] arr = new int[4][3];
 * 		外层元素的初始化值为：地址值
 * 		内层元素的初始化值为：与一维数组初始化情况相同
 * 
 * 针对于初始化方式二：int[][] arr = new int[4][];
 * 外层元素初始化值为：null
 * 内层元素的初始化值为：不能调用，否则报错
 * 
 * 
 * 
 * ⑥数组的内存解析
 * 
 * 
 */

public class ArrayTest3
{
	public static void main(String[] args)
	{
		int[][] arr = new int[4][3];
		System.out.println(arr[0]);//[I@15db9742
		System.out.println(arr[0][0]);//0
		System.out.println(arr);//[[I@6d06d69c
		
		float[][] arr1 = new float[4][3];
		System.out.println(arr1[0]);//地址值
		System.out.println(arr1[0][0]);//0.0
		
		String[][] arr2 = new String[4][2];
		System.out.println(arr2[0]);//地址值
		System.out.println(arr2[0][0]);//null
		
		double[][] arr3 = new double[4][];
		System.out.println(arr3[1]);//null
		//System.out.println(arr3[1][0]);//报错
		
		//遍历二维数组
		int[][] arr4 = new int[][]{{1,2,3},{4,5},{6,7,8}};
		for(int i = 0;i < arr4.length;i++)
		{
			for(int j = 0;j < arr4[i].length;j++)
			{
				System.out.print(arr4[i][j] + "  ");
			}
			System.out.println();
		}
		
	}

}
