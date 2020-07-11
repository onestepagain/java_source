package com.atguigu.test07;

import java.util.Arrays;

/*
 * Java中对象要比较大小，：（1）实现Comparable(2)实现Comparator
 * 
 * 我们发现：java.lang.String类型，实现了Comparable接口，
 * 	说明String类型中有int compareTo(Object obj)
 */
public class TestString {
	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "hai";
		
/*		if(s1 > s2){//因为String类型是引用数据类型，是无法直接用>和<等比较运算符比较大小的
			//...
		}*/
		
		/*
		 * h和c比较，h>c，直接就决定了s1>s2
		 */
		if(s1.compareTo(s2)>0){
			System.out.println("s1 > s2");
		}else if(s1.compareTo(s2)<0){
			System.out.println("s1 < s2");
		}else{
			System.out.println("s1 = s2");
		}
		
		Employee[] all = new Employee[3];
		all[0] = new Employee("2", "王小二", 22, 20000);
		all[1] = new Employee("3", "张三", 23, 13000);
		all[2] = new Employee("1", "李四", 24, 8000);
		
		Arrays.sort(all);
		
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}
	}
}
