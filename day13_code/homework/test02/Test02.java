package com.atguigu.homework.test02;

/*
 * 考核点：多态，重载，重写
 * 1、分析每个类都有什么方法
 * A类：
 *   public String show(C obj)
 *   public String show(A obj)
 * B类：
 * 	 public String show(C obj)
 *   public String show(A obj)重写
 *   public String show(B obj)
 * C类和D类，因为这里没有用它们的对象去调用方法，暂时不分析。
 * 
 * 2、继承关系
 * C-->B-->A
 * D-->B-->A
 * 
 * 3、如果出现重载的多个方法，会找其中类型最合适的
 * 
 * 4、分析代码
 * （1）a1.show(b)，a1没有多态，从A类找，public String show(A obj)
 * （2）a2.show(d)，a2有多态，编译时看A类，在A类中找最合适public String show(A obj)
 * 		执行时，看运行时类型，看B类，B类中有重写的方法  
 * （3）b.show(c)，b没有多态，从B类中找public String show(C obj) 
 * （4）b.show(d)，b没有多态，从B类中找public String show(B obj)
 */
public class Test02 {
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new B();
		B b = new B();
		C c = new C();
		D d = new D();
		System.out.println("(1)" + a1.show(b));//A and A
		System.out.println("(2)" + a2.show(d));//B and A
		System.out.println("(3)" + b.show(c));//A and C
		System.out.println("(4)" + b.show(d));//B and B
	}
}

class A {
	public String show(C obj) {
		return ("A and C");
	}

	public String show(A obj) {
		return "A and A";
	}
}

class B extends A {
	public String show(B obj) {
		return "B and B";
	}

	public String show(A obj) {
		return "B and A";
	}
}

class C extends B {

}

class D extends B {

}
