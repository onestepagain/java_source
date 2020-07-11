package com.atguigu.homewok.test08;

/*
 * 1、Base b1 = new Base();
 * 父类的实例初始化，和子类无关
 * 
 * <init>(){
 * 		method(100);
 * 			System.out.println("base : " + i);  base:100
 * }
 * 
 * 2、Base b2 = new Sub();
 * （1） 父类的实例初始化
 * 
 * <init>(){
 * 		method(100);//执行了子类重写的method()
 * 			System.out.println("sub : " + j);  sub:100
 * }
 * 
 * （2）子类的实例初始化
 * <init>(){
 * 		super.method(70);
 * 			System.out.println("base : " + i);	base:70
 * }
 */
public class Test08 {
	public static void main(String[] args) {
		Base b1 = new Base();
		Base b2 = new Sub();
	}
}

class Base {
	Base() {
		method(100);
	}

	public void method(int i) {
		System.out.println("base : " + i);
	}
}

class Sub extends Base {
	Sub() {
		super.method(70);
	}

	public void method(int j) {
		System.out.println("sub : " + j);
	}
}