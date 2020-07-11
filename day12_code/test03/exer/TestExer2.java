package com.atguigu.test03.exer;

import java.util.Scanner;

/*
 * （5）定义测试类PayrollSystem，创建Employee变量数组并初始化，
 * 该数组存放各类雇员对象的引用。利用循环结构遍历数组元素，
 * 输出各个对象的类型,name,birthday,以及该对象的实发工资。
 * 当键盘输入本月月份值时，如果本月是某个Employee对象的生日，还要体现增加工资信息。
 */
public class TestExer2 {
	public static void main(String[] args) {
		Employee[] all = new Employee[2];
		all[0] = new SalariedEmployee("杨洪强", 1995, 12, 14, 25000, 20, 23);
		all[1] = new HourlyEmployee("崔志恒", new MyDate(1993, 3, 8), 50, 100);
		
		Scanner input = new Scanner(System.in);
		System.out.print("请输入月份：");
		int month = input.nextInt();
		
		for (int i = 0; i < all.length; i++) {
			if(all[i].getBirthday().getMonth() == month){
				System.out.println(all[i].toString() + "，实发工资：" +( all[i].earnings()+100));
			}else{
				System.out.println(all[i].toString() + "，实发工资：" +all[i].earnings());
			}
		}
		
	} 
}
