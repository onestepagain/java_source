package com.atguigu.test02.exer;

/*
 * 接口的练习1：
（1）声明一个接口MyRunnable，包含抽象方法void run()
（2）声明它的实现类Car，实现MyRunnable接口，自己随便打印点什么
（3）声明它的实现类Person，实现MyRunnable接口
（3）声明它的实现类Dog，实现MyRunnable接口
（4）在测试类中创建MyRunnable[]数组，
元素赋值为各种实现类对象，遍历数组，调用元素的run()方法
 */
public class TestExer1 {
	public static void main(String[] args) {
		MyRunnable[] all = new MyRunnable[5];
		all[0] = new Car();
		all[1] = new Car();
		all[2] = new Car();
		all[3] = new Person();
		all[4] = new Dog();
		
		for (int i = 0; i < all.length; i++) {
			all[i].run();
		}
	}
}

 