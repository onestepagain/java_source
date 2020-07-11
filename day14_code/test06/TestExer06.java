package com.atguigu.test06;

public class TestExer06 {
	public static void main(String[] args) {
		Body b1 = new Body("张三", 50000, true);
		Body b2 = new Body("李四",100000,false);
		
		System.out.println(b1);
		b1.getHeart().doWork();
		System.out.println(b2);
		b2.getHeart().doWork();
		
		System.out.println("============================");
		
		Doctor d = new Doctor();
		d.swapHeart(b1, b2);
		
		System.out.println(b1);
		b1.getHeart().doWork();
		System.out.println(b2);
		b2.getHeart().doWork();
	}
}
