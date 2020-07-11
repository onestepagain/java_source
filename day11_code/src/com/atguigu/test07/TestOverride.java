package com.atguigu.test07;

import com.atguigu.test07.other.Father;

/*
 * 哪些方法不能被重写？
 * （1）final修饰的
 * （2）static修饰的
 * （3）private修饰的
 * 		因为私有的在子类中不可见
 * （4）如果跨包的话，修饰符缺省的也不能被重写，因为缺省的跨包不可见
 */
public class TestOverride {
	
}
class A{
	private void method(){
		
	}
}
class B extends A{
	
}
class Sub extends Father{
	
}