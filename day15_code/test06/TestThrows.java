package com.atguigu.test06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
 * 异常处理的方式之一：
 * 		在当前方法中直接用try...catch处理
 * 异常处理的方式之二：
 * 		在当前方法中不处理，扔/抛给调用者处理
 * 
 * throws的好处：
 * （1）throws：告知被调用者，我这个方法可能会抛出哪些异常，使得调用者可以明确的知道应该catch什么异常
 * 如果没有throws，那么调用者就不清楚，只能按照Exception处理，或者根据错误经验来处理。
 * （2）编译时异常，如果在当前方法中不用try..catch处理，编译不通过，那么可以通过throws明确的说明，抛给调用者处理
 * 
 * throws的语法格式：
 * 	【修饰符】 返回值类型  方法名(【形参列表】)throws 异常列表们{
 * }
 * 说明：throws后面可以跟好几个异常，顺序无所谓，每一个异常之间使用,分割
 * 
 * 关于方法重写时，对throws抛出的异常的要求：
 * 	子类重写的方法抛出的异常类型必须<=父类被重写的方法抛出的异常类型。
 * 
 * 例如：Exception > RuntimeException > ArrayIndexOutOfBoundsException
 * 	
 * 整理重写的要求：
 * （1）方法名：相同
 * （2）形参列表：相同
 * （3）返回值类型：
 * 		基本数据类型与void：相同
 * 		引用数据类型：<=
 * （4）修饰符
 * 	  权限修饰符：>=
 * 	其他修饰符：不能是final,private,static
 * （5）抛出的异常类型：<=
 * 
 */
public class TestThrows {
	public static void main(String[] args) {
			try {
				divide(1,1);
			} catch (ArithmeticException e) {
				e.printStackTrace();
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
			
			try {
				copy("1.txt","2.txt");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			Father f = new Son();//多态引用
			try {
				f.method();
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
			
			Father f2 = new Son();
			Object str = f2.test();
	}
	
	public static void divide(int a, int b)throws ArithmeticException,RuntimeException{
		System.out.println(a/b);
	}
	
	public static void copy(String srcFile, String destFile) throws FileNotFoundException{
		FileInputStream fis = new FileInputStream(srcFile);//用来读取srcFile文件的内容
	}
}
class Father{
	public void method()throws RuntimeException{
		//....
	}
	
	public Object test(){
		return null;
	}
}
class Son extends Father{
	@Override
	public void method()throws ArrayIndexOutOfBoundsException{
		//....
	}
	
	@Override
	public String test(){
		return "";
	}
}