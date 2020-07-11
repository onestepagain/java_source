package com.atguigu.test04;

import java.util.Comparator;//JDK的核心类中写好的，不用我们写

/*
 * 需求：编写一个MyArrays的数组工具类，这个工具类，想要为任意的对象数组，进行升序排序
 */
public class MyArrays {
	public static void sort(Object[] arr, Comparator c){
		for (int i = 1; i < arr.length; i++) {
			System.out.println("第" + i +"轮");
			for (int j = 0; j < arr.length-i; j++) {
				System.out.println("比较：arr["+j+"]和arr["+(j+1)+"]");
				System.out.println(arr[j]);
				System.out.println(arr[j+1]);
				System.out.println();
				//前面的元素对象  ＞  后面的元素对象，交换
				//if(arr[j] > arr[j+1]){
				//标准  Comparator 接口，里面有一个int compare(Object o1, Object o2)
				//规定：o1大于o2对象，一定返回正整数，o1小于o2对象，一定返回负整数，o1等于o2对象，一定返回0，
				if(c.compare(arr[j], arr[j+1]) > 0){//执行时，compare执行的是实现类的compare方法
					Object temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}
