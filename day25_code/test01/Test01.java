package com.atguigu.test01;

import org.junit.Test;

/*
 * Lambda表达式是函数式编程的风格，是为了给SAM接口的变量和形参赋值的一种语法。
 * 目的：减少代码的冗余，增加可读性。
 * 
 * 示例1：
 * 开启一个线程，这个线程的任务：打印“hello”
	要求用实现Runnable接口的方式来创建多线程
	
	Runnable接口符合SAM特征：  public abstract void run();
 */
public class Test01 {	
	@Test
	public void test05(){
		//使用Lambda表达式
		new Thread(()->System.out.println("hello")).start();
	}
	
	@Test
	public void test04(){
		//匿名内部类，匿名对象
		new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("hello");
			}
		}).start();
	}
	
	@Test
	public void test03(){
		//匿名内部类，匿名对象
		Thread t = new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("hello");
			}
		});
		t.start();
	}
	
	@Test
	public void test02(){
		//匿名内部类，对象有名字
		Runnable my = new Runnable(){
			@Override
			public void run() {
				System.out.println("hello");
			}
		};
		Thread t = new Thread(my);
		t.start();
	}
	
	@Test
	public void test01(){
//		非Lambda表达式方式实现，并且有名字的实现类实现
		MyRunnable my = new MyRunnable();
		Thread t = new Thread(my);
		t.start();
	}
}
class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("hello");
	}
	
}