package com.atguigu.test05.exer;

import java.util.Scanner;

/*
 * 4、声明一个员工数组，存储各种员工，并遍历显示他们的实发工资，
并计算工资总额
 */
public class TestExer3 {
	public static void main(String[] args) {
		Employee[] all = new Employee[3];
		
		all[0] = new SalaryEmployee("崔志恒", new MyDate(1993, 2, 29), 12000, 20, 2);
		all[1] = new HourlySalary("杨洪波", new MyDate(1995, 12, 12), 10000, 40, 50);
		all[2] = new HourlySalary("苏海波", new MyDate(1994, 3, 8), 14000, 45, 40);
		
//		、并遍历显示他们的实发工资
		double sum = 0;
		for (int i = 0; i < all.length; i++) {
			System.out.println("实发工资：" + all[i].earning());
			
			sum += all[i].earning();
		}
		System.out.println("总额：" + sum);
		
		//6、如果是正式工，本月（从键盘输入）是生日月，多发100
		Scanner input = new Scanner(System.in);
		System.out.print("请输入月份：");
		int month = input.nextInt();
		
		//再次显示实发工资
		for (int i = 0; i < all.length; i++) {
			if(all[i] instanceof SalaryEmployee){
				if(all[i].getBirthday().getMonth() == month){
					System.out.println("实发工资：" + (all[i].earning()+100));
					continue;
				}
			}
			System.out.println("实发工资：" + all[i].earning());
		}
		
	}
}
