package com.atguigu.test01.review;

import java.util.ArrayList;

/*
 * 请编写代码演示OOM。
 * OOM：OutOfMemoryError
 * 
 * 答案有太多：
 */
public class TestError2 {
	public static void main(String[] args) {
		//1、答案一：创建一个超级大数组，
		//数组的长度的类型是int
//		int[] arr = new int[Integer.MAX_VALUE];
		
		//2、答案二：不断的创建对象
		ArrayList list = new ArrayList();//容器，用来装对象
		while(true){
			list.add(new Object());
		}
		
		//3、搜集
	}
}
