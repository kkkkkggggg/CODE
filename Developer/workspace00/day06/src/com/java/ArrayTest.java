package com.java;

/*
 * 一、数组的概述
 * 1.数组的理解：数组（Array）,是多个相同类型数据按一定顺序排列的组合，
 * 并使用一个名字命名，并通过编号的方式对这些数据进行统一管理
 * 
 * 2.数组的常见概念
 * >数组名
 * >元素
 * >角标、下标、索引
 * >数组的长度
 * 
 * 3.数组的特点，
 * >1数组是有序排列的
 * 
 * >2数组属于引用数据类型的变量，数组的元素，既可以是基本数据类型，也可以是
 * 引用数据类型
 * 
 * >3创建数组对象会在内存中开辟一整块连续的空间
 * 
 * >4数组的长度一旦确定就不能修改
 * 
 * 4.数组的分类
 * 按照维数，一维数组、二维数组。。。。
 * 按照数组元素类型：基本数据类型的数组、引用数据类型元素的数组
 * 
 * 5.一维数组的使用
 * ①一维数组的声明和初始化
 * ②如何调用数组的指定位置的元素
 * ③如何获取数组的长度
 * ④如何遍历数组
 * ⑤数组元素的默认初始化值
 * ⑥数组的内存解析
 * 
 */

public class ArrayTest 
{
	public static void main(String[] args) 
	{
		//①一维数组的声明和初始化
		int num;//声明
		num = 10;//初始化
		int id = 1001;//声明+初始化
		
		int[] ids;//声明
		//1.1静态初始化:数组的初始化和数组元素的赋值操作同时进行
		ids = new int[]{1001,1002,1003,1004};
		//1.2动态初始化:数组的初始化和数组元素的赋值操作分开进行
		
		String[] names = new String[5];
		
		//2.如何调用数组的指定位置的元素:通过角标的方式调用
		//数组的角标（或索引），从0开始，到数组长度-1结束
		
		names[0] = "看看";
		names[1] = "涂鸦";
		names[2] = "改要";
		names[3] = "关于";
		names[4] = "特点";//charAt(0);涉及到索引，角标基本上是从第0位开始
		
		//3.如何获取数组的长度
		//属性：length
		System.out.println(names.length);
		System.out.println(ids.length);
		
		//4.如何遍历数组
		System.out.println(names[0]);
		System.out.println(names[1]);
		System.out.println(names[2]);
		System.out.println(names[3]);
		System.out.println(names[4]);
		
		for(int i = 0;i < names.length;i++)
		{
			System.out.println(names[i]);
		}
	}
	
	

}
