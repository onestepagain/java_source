package com.atguigu.test10;

/*
1、匿名内部类练习1
（1）声明一个抽象类Father，包含抽象方法：public abstract void method();
（2）用匿名内部类继承Father，并重写抽象方法，打印“hello 孩子"
并调用子类对象的method方法
 */
public class TestExer3 {
	public static void main(String[] args) {
		/*new Father(){
			public void method(){
				System.out.println("hello 孩子");
			}
		}.method();*/
		
		Father f = new Father(){
			public void method(){
				System.out.println("hello 孩子");
			}
		};
		f.method();
	}
}
abstract class Father{
	public abstract void method();
}
