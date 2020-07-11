package com.atguigu.test03;

/*
 * 三、非静态的成员内部类
 * 
 * 1、特点：
 * （1）在非静态内部类中，不能出现任何和static有关的声明
 * （2）在非静态内部类中，可以随意访问外部类的所有的成员，包括静态的和非静态的
 * （3）在外部类的静态成员中，不能使用非静态的成员内部类
 * （4）在外部类的外面使用
 * 第一步：先创建外部类的对象
 * 第二步：要么通过外部类的对象，去创建内部类的对象
 * 				Outer out = new Outer();
				Outer.Inner in = out.new Inner();
 * 		要么通过外部类的对象，去获取内内部类的对象
 * 				Outer out = new Outer();
 * 				Outer.Inner in  = out.getInner();
 * 
 * 
 */
public class TestNonStaticInner {
	public static void main(String[] args) {
//		Outer.Inner in = new Outer.Inner();//错误的
		
		//我们要在这里使用Inner,因为此时的Inner是Outer的非静态成员，所以需要用到Outer的对象
		Outer out = new Outer();
//		Outer.Inner in = out.new Inner();
		Outer.Inner in  = out.getInner();
		in.method();
	}
}
class Outer{
	private int i = 1;
	private static int j = 2;
	
	class Inner{
		public void method(){
			System.out.println("非静态内部类的非静态方法");
			System.out.println(i);
			System.out.println(j);
		}
	}
	
	public static void outTest(){
//		Inner in = new Inner();//静态的方法不能访问非静态的成员
	}
	public void outMethod(){
		Inner in = new Inner();
		in.method();
	}
	
	public Inner getInner(){
		return new Inner();
	}
}