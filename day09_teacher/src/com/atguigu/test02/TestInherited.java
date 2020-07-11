package com.atguigu.test02;

/*
 * 继承：
 * （1）延续	
 * （2）扩展
 * 
 * 1、为什么要有继承？
 * （1）当某个类，需要派生出很多子类别
 * Person：
 * 	  需要派生出Teacher，Student等等子类别
 * 	 那么此时Person中的共有的部分，就不需要在子类别中再次去声明
 * （2）当多个类，出现了共同的特征时，可以把共同的部分抽取到父类中
 * 
 * 目的：
 * 	代码的复用和扩展
 * 
 * 2、如何实现继承？
 * 【修饰符】 class 子类   extends 父类{
 * }
 * 
 * 子类：subclass，也称为派生类
 * 父类：superclass，也称为超类，基类
 * 
 * 3、继承的特点：
 * （1）子类继承了父类，
 * 从事物的特征来说，子类会继承父类所有的特征（属性和方法）。
 * 但是从代码操作角度来说，父类中私有的属性、方法在子类中是不能直接使用的
 * （2）子类继承父类时，构造器是不能被继承的
 * （3）子类继承父类时，在子类的构造器中一定要去调用父类的构造器
 * 默认情况下，调用的是父类的无参构造；
 * 如果父类没有无参构造，那么在子类的构造器的首行，必须手动调用父类的有参构造；
 * 
 * 未完待续。。。
 */
public class TestInherited {
	public static void main(String[] args) {
		Teacher t = new Teacher();
		t.setName("柴老师");
		t.setAge(18);
		
		System.out.println("姓名：" + t.getName());
		System.out.println("年龄：" + t.getAge());
		
//		Teacher t2 = new Teacher("宋老师",28);
	}
}
class Person{
	private String name;
	private int age;
	//构造器
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	//get/set
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
class Teacher extends Person{
	private double salary;
	
	public Teacher() {
		super(null, 0);
	}

	public Teacher(String name, int age, double salary) {
		super(name, age);//调用父类的有参构造，必须在子类构造器的首行
		this.salary = salary;
	}

	public void test(){
		//System.out.println("name = " + name);//父类私有的属性在子类中不能直接使用
	}
}
class Student extends Person{
	private int score;

	public Student(String name, int age, int score) {
		super(name, age);//调用父类的有参构造，必须在子类构造器的首行
		this.score = score;
	}
	
}