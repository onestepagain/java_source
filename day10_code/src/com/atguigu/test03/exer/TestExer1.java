package com.atguigu.test03.exer;

/*
1、练习题
（1）声明Traffic，
public void drive()方法
（2）声明子类Car,Bicycle，甚至可以声明Car的各种子类，例如BMW,Benz类等
（3）在测试类的main中创建一个数组，有各种交通工具，遍历调用drive()方法
 */
public class TestExer1 {
	public static void main(String[] args) {
		Traffic[] all = new Traffic[5];
		all[0] = new Car();
		all[1] = new Bicycle();
		all[2] = new Car();
		all[3] = new Bicycle();
		all[4] = new Car();
		
		for (int i = 0; i < all.length; i++) {
			all[i].drive();
		}
	}
}
class Traffic{
	public void drive(){
		System.out.println("前进前进前进进...");
	}
}
class Car extends Traffic{
	public void drive(){
		System.out.println("嗖的一下就走了");
	}
}
class Bicycle extends Traffic{
	public void drive(){
		System.out.println("蹬啊蹬啊蹬不动啊");
	}
}