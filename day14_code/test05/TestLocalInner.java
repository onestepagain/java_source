package com.atguigu.test05;

/*
 * 四、局部内部类（最少使用的一种，几乎见不着）
 * 1、声明的位置很特殊：在方法体内
 * 
 * 2、特点
 * （1）局部内部类的修饰符，只能有abstract或final
 * （2）有作用域
 * （3）如果局部内部类在静态方法中，不能使用外部类的非静态成员
 * （4）在局部内部中，可以使用当前局部内部类所在方法的局部变量，
 * 但是要求，这个局部变量必须是final的常量。
 * 
 * 在Java8时，如果某个局部变量被局部内部类使用了，会自动添加final变为常量，一旦变为常量，它的值就不能修改了。
 * 
 * 为什么它要这么要求？加final
 * 避免局部内部类对象被返回到外部类的外面使用时，访问不到这个局部变量，所以要把这个局部变量变为final的常量。
 * 
 */
public class TestLocalInner {
	public static void main(String[] args) {
		Outer out = new Outer();
		Father in = out.test();//在外部类的外面虽然不能使用局部内部类，但是可以得到它的对象
		System.out.println(in.getClass());
		in.method();//在这里仍然可以访问到这个a，那么这个a就不能存在栈中，得挪到方法区，变为常量
	}
}
abstract class Father{
	public abstract void method();
}
class Outer{
	private int i = 1;//成员变量，实例变量，非静态成员变量
	private static int j = 2;//成员变量，类变量，静态变量
	
	public Father test(){
//		Inner in = new Inner();
		
		final int a = 10;//局部变量==>局部的常量
		
		//局部内部类
		class Inner extends Father{
			public void method(){
				System.out.println(i);
				System.out.println(j);
				System.out.println(a);
			}
		}
		
		Inner in = new Inner();
		in.method();
		
		return in;
	}
	
	public void method(){
//		Inner in = new Inner();
	}
	
	public static void fun(){
		//局部内部类
		class Inner{
			public void method(){
//				System.out.println(i);//是因为fun方法是静态的
				System.out.println(j);
			}
		}
	}
}