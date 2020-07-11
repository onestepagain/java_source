package com.atguigu.test02.exer;

//（3）声明它的实现类Dog，实现MyRunnable接口
public class Dog implements MyRunnable {

	@Override
	public void run() {
		System.out.println("小狗汪汪汪");
	}

}
