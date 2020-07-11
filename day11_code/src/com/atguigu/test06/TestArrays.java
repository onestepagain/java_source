package com.atguigu.test06;

import java.util.Arrays;

/*
 * API:应用程序编程接口，俗称，帮助文档
 * 
 * java.util.Arrays：
 * （1）public static int binarySearch(int[] a,int key)
 * 使用二分搜索法来搜索指定的 int 型数组，以获得指定的值。
 * 要求数组是有序的，否则结果不确定。
 * 如果key在a数组中存在，就返回找到的第一个的下标，如果不存在返回负数。
 * 
 * (2)public static int[] copyOf(int[] original,int newLength)：从original原数组中复制得到一个新数组，
 * 新数组的长度为newLength
 * 
 * (3)public static int[] copyOfRange(int[] original,int from,int to)：从original原数组中把[from,to)复制出来，构成新数组
 * 要求from必须在original的合理下标范围内，to可以超过长度
 * 
 * (4)public static boolean equals(int[] a,int[] a2)：比较两个数组的长度和内容是否一致
 * 
 * (5)public static void fill(int[] a,int val)：把a数组的元素中val填充
 *
 * (6)public static void sort(int[] a)：把数组a按照升序排列
 * 
 * (7)public static String toString(int[] a)：把a数组的元素，遍历，拼接为一个字符串返回，效果[1,3,5]
 */
public class TestArrays {
	public static void main(String[] args) {
/*		int[] arr = {1,3,5,7,9};
		System.out.println(Arrays.binarySearch(arr, 4));
		System.out.println(Arrays.binarySearch(arr, 7));*/
		
/*		int[] arr = {1,3,5,7,9};
//		int[] newArr = Arrays.copyOf(arr, 5);
//		int[] newArr = Arrays.copyOf(arr, 15);
		int[] newArr = Arrays.copyOf(arr, 3);
		for (int i = 0; i < newArr.length; i++) {
			System.out.print(newArr[i]+" ");
		}
		System.out.println();*/
		
/*		int[] arr = {1,3,5,7,9};
//		int[] newArr = Arrays.copyOfRange(arr, 1, 3);
//		int[] newArr = Arrays.copyOfRange(arr, 1, 13);
		int[] newArr = Arrays.copyOfRange(arr, 10, 13);
		for (int i = 0; i < newArr.length; i++) {
			System.out.print(newArr[i]+" ");
		}
		System.out.println();*/
		
/*		int[] arr1 = {1,3,5,7,9};
		int[] arr2 = {1,3,5,8,9};
		System.out.println(Arrays.equals(arr1, arr2));*/
		
/*		int[] arr = new int[5];
		Arrays.fill(arr, 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();*/
		
		/*int[] arr = {4,2,7,9,4};
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();*/
		
		int[] arr = {4,2,7,9,4};
		System.out.println(Arrays.toString(arr));//[4, 2, 7, 9, 4]
	}
}
