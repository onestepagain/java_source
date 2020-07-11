package com.atguigu.test02;

//import com.atguigu.test02.Outer.Inner;

/*
 * 二、静态内部类
 * 
 * 1、特点
 * （1）静态内部类中，可以出现原本类中能够定义的所有的成员
 * 属性：可以有静态属性和非静态属性
 * 方法：可以有静态方法和非静态方法
 * 		如果静态内部类是抽象类的话，还可以定义抽象方法
 * 构造器：有参、无参
 * 代码块：可以有静态代码块和非静态代码块
 * 内部类：允许，很少再写内部类（不讨论内部类的内部类）
 * 
 * （2）静态内部类中不能使用外部类的非静态的成员
 * （3）在外部类中，使用静态内部类，和使用其他的类一样的原则
 * 如果使用静态内部类的静态成员，直接“静态内部类名.”
 * 如果使用静态内部类的非静态成员，直接“静态内部类对象名.”
 * （4）在外部类的外面，使用静态内部类
 * 如果使用静态内部类的静态成员，直接“类名.”
 * 		使用外部类名.静态内部类名.静态方法
 * 		使用import 包.外部类名.静态内部类名;  在代码中使用   “静态内部类名.”
 * 如果使用静态内部类的非静态成员，“静态内部类对象名.”
 * 
 * （5）静态内部类不会随着外部类的初始化一起初始化，而是要在使用到这个静态内部类是才会初始化
 * 
 * 
 * 2、结论
 * （1）同级的来说静态的不能直接使用非静态的
 * （2）访问一个类的静态成员，用“类名.”即可，
 * 	   访问一个类的非静态成员，用“对象名.”即可，
 * （3）一个类需要初始化，得用到这个类
 */
public class TestStaticInner {
	public static void main(String[] args) {
/*//		Inner.test();//上面有导包语句，import 包.外部类名.静态内部类名;
		
		Outer.Inner.test();//外部类名.静态内部类名.静态方法
		
//		Inner in = new Inner();//上面有导包语句，import 包.外部类名.静态内部类名;
		Outer.Inner in = new Outer.Inner();
		in.method();*/
		
		Outer out = new Outer();
		out.outMethod();
	}
}
class Outer{
	private int i = 1;
	private static int j = 2;
	
	static{
		System.out.println("外部类的静态代码块");
	}
	
	static class Inner{
		static{
			System.out.println("静态内部类的代码块");
		}
		
		public void method(){
			System.out.println("静态内部类的非静态方法");
//			System.out.println(i);//错误
			System.out.println(j);
		}
		
		public static void test(){
			System.out.println("静态内部类的静态方法");
		}
	}
	
	public void outMethod(){
		Inner in = new Inner();
		in.method();//非静态方法，用对象名.访问
		
		Inner.test();//静态方法，用类名.访问
	}
}
