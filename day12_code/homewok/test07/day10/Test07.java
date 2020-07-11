package com.atguigu.homewok.test07.day10;

/*
 * new A(new B());
 * （1）new B()
 * <init>(){
 * 		System.out.println("B");
 * }
 * （2）new A(B的对象)
 * <init>(B b){
 * 		this();
 * 				System.out.println("A");
 * 		System.out.println("AB");
 * }
 */
public class Test07 {

	public static void main(String[] args) {
		new A(new B());
	}
}

class A {
	public A() {
		System.out.println("A");
	}

	public A(B b) {
		this();
		System.out.println("AB");
	}
}

class B {
	public B() {
		System.out.println("B");
	}
}