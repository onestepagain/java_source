package com.atguigu.test05;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * 1、练习1
从键盘输入两个整数a,b，求两个数的和、差、积、商
并且尝试使用try...catch处理可能发生的异常

快捷键：Alt +Shift  + Z  弹出surround with xxx
 */
public class TestExer {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			System.out.print("请输入一个整数：");
			int a = input.nextInt();
			
			System.out.print("请输入另一个整数：");
			int b = input.nextInt();
			
			System.out.println("和：" + (a+b));
			System.out.println("差：" + (a-b));
			System.out.println("积：" + (a*b));
			System.out.println("商：" + (a/b));
		} catch (InputMismatchException e) {
			System.err.println("输入错误，应该输入整数");
		} catch (ArithmeticException e) {
			System.err.println("除数不能为0");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			input.close();//资源关闭
		}
	}
}
