package com.atguigu.test01;

/*
 * 学习修饰符时，希望大家问自己问题？
 * （1）修饰符本身的意思
 * （2）它可以修饰什么？
 * （3）它修饰后有什么不同？
 * 
 * 
 * final：修饰符的一种
 * 1、意思：最终的
 * 2、final可以修饰：类（外部类、内部类）、变量（成员变量（类变量、实例变量）、局部变量）、方法（静态方法、非静态方法）
 * 3、修饰后有什么不同？
 * （1）修饰类：表示这个类不能被继承了，我们可以称它为“太监类”
 * 例如：String、System、Math
 * 
 * （2）修饰方法：表示这个方法不能被重写
 * 
 * （3）修饰变量：表示这个变量的值不能被修改，即我们称为的“常量”
 * 常量有两种：
 * 	一种是字面常量：例如："hello",12,'a'
 *  一种是final声明的变量：final int A = 10;
 *  
 *  这里要说明一下，常量的命名应该是所有单词都大写，每个单词之间使用_
 *  
 *  回忆：权限修饰符
 *  private、缺省、protected、public
 */
public class TestFinal {
	final int NUM = 10;
	
	public int getNUM() {
		return NUM;
	}
/*	public void setNUM(int num){
		this.NUM = NUM;
	}*/

	public static void main(String[] args) {
		Son s = new Son();
		s.method();
		
		final int A = 10;
		//A = 20;//不能修改a的值
	}
	
	public static void change(final Circle c){
//		c = new Circle();//错误的，因为c是常量
		c.radius *= 2; //因为radius的前面没有final，可以修改
	}
}
class Circle{
	double radius;
}
final class TaiJian{
	
}
/*class Sub extends TaiJian{
	
}*/

class Father{
	public void test(){
		//...
	}
	public final void method(){
		//..
	}
}
class Son extends Father{

	@Override
	public void test() {
		super.test();
	}
	
	/*public final void method(){
		//..
	}*/
}
