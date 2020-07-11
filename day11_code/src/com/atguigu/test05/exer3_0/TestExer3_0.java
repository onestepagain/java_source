package com.atguigu.test05.exer3_0;

/*
 * （1）以下代码是否可以编译通过
 * 		不能
 * （2）如果能，运行结果是什么
 * （3）如果不能怎么改
 * 第一种修改方法：把声明挪到前面；
 * 第二种修改方法：看TestExer3
 */
/*public class TestExer3_0 {
	public static void main(String[] args) {
		MyClass obj = new MyClass();
	}
}
class MyClass{
	static{
		i++;//声明i在后面
		System.out.println("（1）静态代码块 i=" + i);
	}
	{
		j = 100;
		j++;
		System.out.println("（2）构造代码块j=" + j);
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
*/