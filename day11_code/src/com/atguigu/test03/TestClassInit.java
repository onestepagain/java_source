package com.atguigu.test03;

/*
 * 一个类初始化时会先检查它的父类是否初始化，如果父类没有初始化，那么会先初始化父类。因为一个类只要初始化一次。
 * 
 * （1）父类的初始化<clinit>()
 * ①父类的静态变量的显式赋值
 * ②父类的静态代码块
 * （2）子类的初始化<clinit>()
 * ①父类的静态变量的显式赋值
 * ②父类的静态代码块
 * 
 * 特殊：
 * 	 静态方法是不能被重写的
 */
public class TestClassInit {
	public static void main(String[] args) {
		/*Father f = new Father();
		System.out.println("-------------------");
		Son s = new Son();*/
		
		Son s = new Son();
		
		/*Father f = new Son();//多态引用
		System.out.println("----------------");
		f.assign();//静态方法在编译期间就确定了，不需要在运行时动态绑定
*/	}
}
class Father{
	private static String info = assign();
	static{
		System.out.println("(1)父类的静态代码块");
	}
	public static String assign(){
		System.out.println("（3）assign()方法");
		return "Father";
	}
}
class Son extends Father{
	private static String info = assign();
	static{
		System.out.println("(2)子类的静态代码块");
	}
	public static String assign(){
		System.out.println("（4）assign()方法");
		return "Son";
	}
}