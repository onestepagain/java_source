package com.atguigu.test02.exer;

//（2）声明它的实现类Car，实现MyRunnable接口，自己随便打印点什么
public class Car implements MyRunnable {

	@Override
	public void run() {
		System.out.println("小汽车滴滴滴");
	}

}
