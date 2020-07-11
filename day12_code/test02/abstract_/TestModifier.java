package com.atguigu.test02.abstract_;

/*
 * 1、abstract：抽象的
 * 2、可以修饰什么？
 * （1）类
 * （2）方法
 * 
 * 3、修饰类的话，和那些修饰符不能一起使用
 * 类：public和缺省
 * 	 final
 * 
 * abstract和final不能一起修饰类。
 * 
 * 4、修饰方法，和那些修饰符不能一起使用
 * 方法：4种权限修饰符
 * 	   static,final,abstract,native
 * 
 * (1)final,abstract不行      因为final不能被重写
 * (2)static,abstract不行    因为static不能被重写
 * (3)native,abstract不行    因为都没有方法体，不知道是什么情况，会有歧义
 * (4)private,abstract不行    因为private不能被重写
 */
public class TestModifier {
//	public native abstract void test();
}
