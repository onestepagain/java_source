package com.atguigu.test09;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Target;

import static java.lang.Math.*;

/*
 * JDK1.5：
 * （1）枚举
 * （2）注解
 * （3）静态导入
 * ...
 * 
 * 静态导入：JDK1.5
 * 语法格式：
 * 	 import static 包.类名.静态成员;
 * 	 import static 包.类名.*;
 */
public class TestStaticImport {
	public static void main(String[] args) {
/*		System.out.println(Math.PI);
		System.out.println(Math.sqrt(4));*/
		
		System.out.println(PI);
		System.out.println(sqrt(4));
	}
}

@Target({TYPE,METHOD,FIELD})
@interface MyAnnotation{
	
}