package com.atguigu.test01.review;

/*
 * 请编写代码，演示栈内存溢出 StackOverflowError
 */
public class TestError1 {
	public static void main(String[] args) {
		Son s = new Son();
		s.test();
	}
}
class Father{
	public void test(){
		System.out.println("父类的");
	}
}
class Son extends Father{
	public void test(){
		//本来调用父类的test();要用super.test()
		test();
		System.out.println("子类的");
	}
}