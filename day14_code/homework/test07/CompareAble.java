package com.atguigu.homework.test07;

public interface CompareAble {
	//定义默认方法compare，挑选较大苹果。
	public default void compare(Apple a1, Apple a2){
		if(a1.getSize() > a2.getSize()){
			System.out.println(a1);
		}else{
			System.out.println(a2);
		}
	}
}
