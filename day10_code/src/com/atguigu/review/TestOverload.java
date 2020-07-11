package com.atguigu.review;

public class TestOverload {
	public static void main(String[] args) {
		B b = new B();
		//b对象可以调用几个a方法
		b.a();
		b.a("");//从b对象同时拥有两个方法名相同，形参不同的角度来说，算是重载
	}
}
class A{
	public void a(){
		//...
	}
}
class B extends A{
	public void a(String str){
		
	}
}
