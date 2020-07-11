package com.atguigu.test01;

/*
 * this：
 * 1、意思：当前对象
 * （1）构造器
 * 	正在被创建的对象
 * （2）方法
 *  正在调用该方法的对象
 *  
 * 2、 用法
 * （1）this.属性
 * 当局部变量与成员变量同名时，可以在成员变量的前面加this.
 * （2）this.方法
 * 没有非用不可的时候
 * （3）this()或this(实参列表)
 * this()表示调用本类的无参构造
 * this(实参列表)表示调用本类的有参构造
 * 
 * this()或this(实参列表)必须在构造器的首行
 */
public class TestThis {
	public static void main(String[] args) {
		Circle c1 = new Circle(1.2);//1.2代表半径
		c1.setRadius(2.5);
	}
}
class Circle{
	private double radius;
	
	public Circle(){
		System.out.println("一个圆对象被创建");
	}
	//(double radius)局部变量
	//给成员变量private double radius;赋值
	public Circle(double radius){
		this();
		this.radius = radius;
	}
	
	public void setRadius(double radius){
		this.radius = radius;
	}
	public double getRadius(){
		//return radius;//没有同名的问题，可以不加this.
		return this.radius;//也可以加this.
	}
	
	public double getArea(){
		return 3.14 * radius * radius;
	}
	
	public void printInfo(){
//		System.out.println("半径：" + radius + "，面积：" + getArea());
		System.out.println("半径：" + this.radius + "，面积：" + this.getArea());
	}
}

class Student{
	private String name;
	private int age;
	private char gender;
	private int score;
	
	public Student(){
		
	}
	public Student(String name, int age){
		this.name = name;
		this.age = age;
	}
	public Student(String name, int age, char gender, int score){
		/*this.name = name;
		this.age = age;*/
		this(name,age);//调用上面的有参构造
		this.gender = gender;
		this.score = score;
	}
}