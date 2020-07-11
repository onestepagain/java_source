package com.atguigu.homewok.test04.day10;

public class Test04 extends Father{
	private String name = "test";
	
	public static void main(String[] args) {
		Test04 test = new Test04();
		System.out.println(test.getName());//父类getName()，就近原则，找父类的name
	}
}
class Father {
	private String name = "father";

	public String getName() {
		return name;
	}
}