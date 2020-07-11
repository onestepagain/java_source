package com.atguigu.test02.abstract_;

/*
 * 面试题：
 * 	1、面向对象的基本特征：封装、继承、多态
 *  2、面向对象的特征：封装、继承、多态、抽象
 * 
 * 抽象：abstract
 *  是具体的反义词
 *  和模糊，不确定，不清晰有的类似
 *  
 * 1、什么情况下会用到抽象？
 *  当我们在声明一个父类时，某个/些方法的实现不清楚，或者说无法给出具体的实现，
 *  要等到具体的子类中才能给出具体的实现，那么这样的方法，就可以声明为抽象方法。
 *  
 *  抽象方法没有方法体
 *  
 * 2、抽象方法
 * 语法格式：
 * 	【其他修饰符】 abstract 返回值类型   方法名(【形参列表】); 
 * 
 * 3、抽象类
 * 	如果一个类中包含了抽象方法，那么这个类必须是一个抽象类。
 * 语法格式：
 * 【其他修饰符】 abstract class 抽象类名{
 * 		【其他修饰符】 abstract 返回值类型   方法名(【形参列表】); 
 * }
 *  
 *  
 *  例如：我们声明一个图形类：Graphic
 *  	我们知道在图形这个事物中，不管是什么图形，都有两个特征：（1）求面积（2）求周长
 *  
 * 4、抽象类的特点
 * （1）抽象类不能实例化，不能直接创建对象或者说，不能创建抽象类的对象
 * （2） 如果子类继承了抽象类，必须重写父类的所有的抽象方法，否则子类也得是一个抽象类
 * （3）抽象类也有构造器，这个构造器不是为了创建抽象类自己的对象用的，而是为子类创建对象服务的
 * （4）抽象父类与子类的对象之间可以构成多态引用
 * （5）抽象类中也可能没有抽象方法，目的就是不能你创建它的对象
 * 	如果一个类中包含了抽象方法，那么这个类必须是一个抽象类。
 */
public class TestAbstract {
	public static void main(String[] args) {
//		Graphic g1 = new Graphic();//不能创建抽象类的对象
		
		Graphic g1 = new Circle(1.2);//多态引用
		System.out.println("面积：" + g1.getArea());
	}
}
abstract class Graphic{
	private String name;
	public Graphic(String name) {
		super();
		this.name = name;
	}
	public Graphic() {
		super();
	}
	/*public double getArea(){
		return 0.0;
	}*/

	public abstract double getArea();
	
}
class Circle extends Graphic{
	private double radius;

	public Circle() {
		super();
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	public Circle(String name, double radius) {
		super(name);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		//return 3.14 * radius * radius;
		return Math.PI * radius * radius;
	}
	
}

//像这种没有抽象方法的抽象类，存在的意义
//(1)为了多态的应用，因为父类可以管理各种子类对象
//(2)不希望你创建这个父类的对象，而是创建子类的对象
abstract class Person{
	
}
class Woman extends Person{
	
}
class Man extends Person{
	
}



