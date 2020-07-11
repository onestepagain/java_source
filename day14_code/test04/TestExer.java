package com.atguigu.test04;

import com.atguigu.test04.Outer.Inner;

public class TestExer {
	public static void main(String[] args) {
		MySub my = new MySub(new Outer());
		my.test();
	}
}
class Outer{
	abstract class Inner{
		public abstract void test();
	}
}

//class MySub 去继承Inner，重写test()打印"hello"，并在测试中调用

/*
 * (1)使用非静态内部类名时，可以使用
 * import 包.外部类名.内部类名;
 * (2)要调用非静态内部类的构造器，需要用到外部类的对象
 * (3)因为子类的构造器的首行一定要调用父类的构造器，默认调用父类的无参构造
 * (4)继承抽象类，要重写抽象的抽象方法
 */
class MySub extends Inner{
	MySub(Outer out){
		out.super();//需要外部类的对象，才能调用非静态内部类的构造器
	}

	@Override
	public void test() {
		System.out.println("hello");
	}
}