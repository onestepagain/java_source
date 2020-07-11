package com.atguigu.homewok.test08.day10;

/*
 * （1）父类的实例初始化
 * <init>(){
 * 		System.out.println("base");
 * 		method(100);  //子类重写了，执行子类的method
 * 				System.out.println("sub : " + j);  sub:100
 * }
 * （2）子类实例初始化
 * <init>(){
 * 		System.out.println("sub");   sub
 * 		super.method(70);  //父类的method
 * 				System.out.println("base : " + i);  base 70
 * }
 */
public class Test08 {
	public static void main(String[] args) {
		Sub s = new Sub();
	}
}
class Base{
	Base(){
		method(100);
	}
	{
		System.out.println("base");
	}
	public void method(int i){
		System.out.println("base : " + i);
	}
}
class Sub extends Base{
	Sub(){
		//隐含了：super()
		super.method(70);
	}
	{
		System.out.println("sub");
	}
	public void method(int j){
		System.out.println("sub : " + j);
	}
}