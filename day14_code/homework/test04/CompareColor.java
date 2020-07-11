package com.atguigu.homework.test04;

public class CompareColor implements CompareAble{
	public void compare(Apple a1, Apple a2){
		if("红色".equals(a1.getColor())){
			System.out.println(a1);
		}
		if("红色".equals(a2.getColor())){
			System.out.println(a2);
		}
	}
}
