package com.atguigu.test01.block;

/*
 * （1）先执行父类的实例初始化方法
 * 它由三部分：
 * ①成员变量的显式赋值
 * ②非静态代码块
 * ③构造器
 * （2）再执行子类的实例初始化方法
 * 它由三部分：
 * ①成员变量的显式赋值
 * ②非静态代码块
 * ③构造器
 * 
 * super()或super(实参列表)之前说的是调用父类的构造器，其实是调用父类对应的实例初始化方法
 * super()或super(实例列表）之前说的是在子类构造器的首行，其实是在子类实例初始化方法的首行
 */
public class TestInit2 {
	public static void main(String[] args) {
		Zi z = new Zi();//312645
	}
}
class Fu{
	private String strFu = assignFu();
	{
		System.out.println("(1)父类的非静态代码块");
	}
	public Fu(){
		System.out.println("(2)父类的无参构造");
	}
	public String assignFu(){
		System.out.println("(3)父类的assignFu()");
		return "fu";
	}
}
class Zi extends Fu{
	private String strZi = assignZi();
	{
		System.out.println("(4)子类的非静态代码块");
	}
	public Zi(){
		//super()  ==>调用父类的实例初始化方法，而且它在子类实例初始化方法的首行
		System.out.println("(5)子类的无参构造");
	}
	
	public  String assignZi(){
		System.out.println("(6)子类的assignZi()");
		return "zi";
	}
}