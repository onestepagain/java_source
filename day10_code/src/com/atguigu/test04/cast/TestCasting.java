package com.atguigu.test04.cast;

/*
 * 数据类型的转换：
 * 	1、基本数据类型的转换
 * （1）自动类型转换
 * byte->short->int->long->float->double
 * 		  char->
 * boolean不参与
 * （2）强制类型转换
 * double->float->long->int->short->byte
 * 						   ->char
 * 
 * 2、引用数据类型数据
 * 父子类之间的转换：编译期间
 * （1）向上转型（UpCasting）：从子类-》父类
 * 		把子类的对象赋值给父类的变量时
 * （2）向下转型（DownCasting）：从父类-》子类
 * 		把父类的变量赋值给子类的变量时
 * 
 * 	  为什么要向上转型？
 * 		因为多态数组、多态参数的应用场景，使得有的时候，不得不向上转型，这是为了方便统一管理各种子类的对象。
 *   为什么又需要向下转型呢？
 *   	向下转型的目的是为了调用子类特有的方法等
 *   
 *  是不是随意的父类的变量，向下转型都会成功呢？ 
 *  	不是
 *  要想转型成功，必须之前是向上转型的，才能向下转型成功。
 *  或者说，要想转型成功，必须保证该变量中保存的对象的运行时类型是<=强转的类型
 *  例如：
 *  	Person p = new Woman();//向上转型
 *  	//向下转型
 *  	Woman m = (Woman)p; p变量中实际存储的对象就是Woman类型，和强转的Woman类型一样
 *
 *		Person p4 = new ChineseWoman();//向上转型
 *		//向下转型
		Woman w4 = (Woman) p4; p4变量中实际存储的对象是ChineseWoman类型，强制的类型是Woman，ChineseWoman<Woman类型
 *
 *
 *	回忆：
 *	（1）ArrayIndexOutOfBoundsException：数组下标越界异常
 *		下标超过了[0,长度-1]
 *	（2）NullPointerException：空指针异常
 *		对象.属性
 *		对象.方法
 *		如果对象是null，就会发生空指针异常
 *  （3）ClassCastException：类型转换异常
 *  	在向下转型时，可能会发生
 *
 * 请列出至少5个常见异常类型？
 */
public class TestCasting {
	public static void main(String[] args) {
		//(1)向上转型
		Person p = new Woman();//多态引用
		//一旦把Woman对象向上转型为Person类型后，就只能调用父类有的方法
		p.eat();
		p.walk();
		
		//(2)向下转型
		//想要在这里调用Woman特有的方法时
		//编译时，p是Person类型，那么编译不通过
		//因为在Java中，认为父类的概念范围>子类的概念范围
//		long num = 1L;
//		int i = (int)num;
//		Woman m = p;//编译报错
		Woman m = (Woman)p;
		m.shop();
		
		//Person p2 = new Person();
		//Woman w2 = (Woman) p2;//ClassCastException:类型转换异常
		//w2.shop();
		
//		Person p3 = new Man();
//		Woman w3 = (Woman) p3;//ClassCastException:类型转换异常
//		w3.shop();
		
		Person p4 = new ChineseWoman();
		Woman w4 = (Woman) p4;
		w4.shop();
		
		//不是父子类之间是不能进行向上与向下转型的
//		Person p5 = "hello";
//		Person p6 = (Person)"hello";
	}
}
class Person{
	public void eat(){
		System.out.println("吃饭");
	}
	public void walk(){
		System.out.println("走路");
	}
}
class Woman extends Person{
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
class ChineseWoman extends Woman{
	
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
