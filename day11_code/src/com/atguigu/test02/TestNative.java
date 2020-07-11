package com.atguigu.test02;

/*
 * native：也是一个修饰符
 * 1、意思：原生的、本地的
 * 2、可以修饰什么？
 * 可以修饰方法
 * 3、它修饰的方法有什么不同？
 * 
 * 语法格式：
 * 【修饰符】 class 类{
 * 	 【其他修饰符】 native 返回值类型  方法名(【形参列表】);
 * }
 * native修饰的方法，看不见方法体。
 * native修饰的方法，不是用Java语言实现的，而是调用了底层C/C++的代码，这些代码
 * 被编译为.dll文件，让Java来执行的。
 * 
 * 4、特殊
 * （1）native方法，对于Java程序员来说，该怎么调用还怎么调用
 * （2）子类还可以选择对它进行重写
 * 
 */
public class TestNative {
	public static void main(String[] args) {
		Object obj = new Object();
		System.out.println(obj.hashCode());
	}
}
class MyClass extends Object{

	//重写父类的native方法
	@Override
	public int hashCode() {
		return 1;
	}
	
}