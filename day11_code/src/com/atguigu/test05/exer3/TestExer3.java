package com.atguigu.test05.exer3;

/*
 * （1）类初始化
 * ①静态代码块
 * static{
		i = 100;//可以
		MyClass.i++;//		i=101
		System.out.println("（1）静态代码块 i=" + MyClass.i);  //（1）静态代码块 i=101
	}
	②静态变量的显示赋值
	i = getNum("（4）i");

	public static int getNum(String str){
		print(str);
		
			public static void print(String str){
				System.out.println(str + "->" + i);  //（4）i-》101
			}
		return ++i;								i=102
	}
 * （2）实例初始化
 * ①非静态代码块
 * {
		j = 100;
		this.j++;			j=101
		System.out.println("（2）构造代码块j=" + this.j);   //（2）构造代码块j=101
		//构造代码块：就是非静态代码块，因为它总是和构造器一起执行，所以就把它叫做构造代码块
	}
 ②非静态变量的显式赋值
 	j = getNum("（5）j");

	public static int getNum(String str){
		print(str);
			 public static void print(String str){
				System.out.println(str + "->" + i);		//（5）j->102
			}
		return ++i;									i=103
	}
	
 ③构造器
 	MyClass(){
		j = 200;
		j++;				j=201
		System.out.println("（3）构造器j=" + j);			//（3）构造器j=201
	}
 */
public class TestExer3 {
	public static void main(String[] args) {
		MyClass obj = new MyClass();
	}
}
class MyClass{
	static{
		i = 100;//可以
		MyClass.i++;//stackoverflow
		System.out.println("（1）静态代码块 i=" + MyClass.i);
	}
	{
		j = 100;
		this.j++;
		System.out.println("（2）构造代码块j=" + this.j);
	}
	MyClass(){
		j = 200;
		j++;
		System.out.println("（3）构造器j=" + j);
	}
	private static int i = getNum("（4）i");
	private int j = getNum("（5）j");
	
	public static void print(String str){
		System.out.println(str + "->" + i);
	}
	public static int getNum(String str){
		print(str);
		return ++i;
	}
}
