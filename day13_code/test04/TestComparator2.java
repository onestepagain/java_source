package com.atguigu.test04;


/*
 * 需求：编写一个MyArrays的数组工具类，这个工具类，想要为任意的对象数组，进行升序排序
 */
public class TestComparator2 {
	public static void main(String[] args) {
		Student[] all = new Student[5];
		all[0] = new Student("杨洪强", 24, 89);
		all[1] = new Student("苏海波", 23, 100);
		all[2] = new Student("张三",23,88);
		all[3] = new Student("李四",24,44);
		all[4] = new Student("王五",25,45);
		
		AgeComparator c = new AgeComparator();
		MyArrays.sort(all, c);
		
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);//打印对象，自动调用对象toString
		}
	}
}
