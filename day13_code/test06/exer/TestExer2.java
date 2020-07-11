package com.atguigu.test06.exer;

import java.util.Arrays;

/*
 * 接口的练习2：
（1）声明一个员工类Employee，有属性：编号、姓名、年龄、薪资
（2）让Employee员工类实现java.lang.Comparable接口，
		重写抽象方法，按照编号从小到大排序
（3）在测试类中创建Employee[]数组，调用java.util.Arrays的sort方法进行排序，遍历结果
（4）声明SalaryComparator类，实现java.util.Comparator接口，
		重写抽象方法，按照薪资从高到低排序
	用SalaryComparator对象重新对Employee[]数组进行排序，遍历结果
 */
public class TestExer2 {
	public static void main(String[] args) {
		Employee[] all = new Employee[3];
		all[0] = new Employee(2, "王小二", 22, 20000);
		all[1] = new Employee(3, "张三", 23, 13000);
		all[2] = new Employee(1, "李四", 24, 8000);
		
		//调用java.util.Arrays的sort方法进行排序，遍历结果
		Arrays.sort(all);
		
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}
		System.out.println("-----------------------------");
		
		//再次调用java.util.Arrays的sort方法进行排序，遍历结果
		Arrays.sort(all, new SalaryComparator());
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}
	}
}
