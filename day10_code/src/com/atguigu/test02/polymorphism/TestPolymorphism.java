package com.atguigu.test02.polymorphism;

/*
 * 一、面向对象的基本特征：
 * 1、封装
 * 	和权限修饰符有关	
 * 2、继承
 * 	extends
 * 3、多态
 * 	
 * 二、多态
 * 多态：多种形态
 * 
 * 变量的引用形式：
 * （1）本态引用：左边的变量与右边的对象是同一种类型
 * （2）多态引用：左边的变量是父类类型，右边的对象是子类的对象
 * 
 * 多态的表现出来的特征：编译类型与运行时类型不一致
 * 	编译的时候，按照父类的类型进行编译的
 * 	执行的方法，按照子类进行运行，是“执行子类重写的方法”
 * 	
 * 	编译看左边，运行看右边
 * 
 * 前提：（1）继承（2）重写（3）多态引用
 * 用途：方法的动态绑定
 * 强调：多态和属性无关，只说方法
 * 
 * 网上也有人这么说，把重载也归为多态，我们不这么认为
 * 
 */
public class TestPolymorphism {
	public static void main(String[] args) {
		//1、本态引用
//		Person p = new Person();
//		Woman w = new Woman();
//		Man m = new Man();
		
		//2、多态引用
		Person p2 = new Woman();
		Person p3 = new Man();
		
		p2.eat();
		p2.walk();
//		p2.shop();
		
		System.out.println(p2.info);//属性没有多态，只看编译时类型
	}
}
class Person{
	String info = "atguigu";
	public void eat(){
		System.out.println("吃饭");
	}
	public void walk(){
		System.out.println("走路");
	}
}
class Woman extends Person{
	String info = "尚硅谷";
	public void eat(){
		System.out.println("细嚼慢咽的吃饭");
	}
	public void walk(){
		System.out.println("婀娜多姿走路");
	}
	public void shop(){
		System.out.println("买买买...");
	}
}
class Man extends Person{
	public void eat(){
		System.out.println("狼吞虎咽的吃饭");
	}
	public void walk(){
		System.out.println("大摇大摆的走路");
	}
	public void smoke(){
		System.out.println("吞云吐雾");
	}
}
