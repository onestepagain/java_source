package com.atguigu.test05;

import java.util.Arrays;

/*
 * 总结：
 * Arrays的sort方法有两种：
 * （1）void sort(Object[] arr)：
 * 		根据元素的自然顺序对指定对象数组按升序进行排序。数组中的所有元素都必须实现 Comparable 接口。
 * （2）void sort(Object[] arr, Comparator c)：
 * 		根据“指定比较器”产生的顺序对指定对象数组进行排序。数组中的所有元素都必须是通过“指定比较器”可相互比较的
 */

public class TestArrays {
	public static void main(String[] args) {
		Student[] all = new Student[5];
		all[0] = new Student("杨洪强", 24, 89);
		all[1] = new Student("苏海波", 23, 100);
		all[2] = new Student("张三",23,88);
		all[3] = new Student("李四",24,44);
		all[4] = new Student("王五",25,45);
		
		//如果我们的学生类Student，实现了java.lang.Comparable接口，
		//能不能按照自然排序的规则进行排序呢
		//Arrays中有这样的方法
		//public static void sort(Object[] a)
		
		Arrays.sort(all);//这里面排序过程中，调用了元素本身的compareTo()方法
		//因为元素本身是Student类型，它实现了java.lang.Comparable接口
		//本身就具备比较大小的能力，即拥有compareTo()方法
		
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}
	}
}
