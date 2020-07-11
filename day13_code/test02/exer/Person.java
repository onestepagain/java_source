package com.atguigu.test02.exer;

//（3）声明它的实现类Person，实现MyRunnable接口
public class Person implements MyRunnable {

	@Override
	public void run() {
		System.out.println("人嘿哟嘿哟");
	}

}
