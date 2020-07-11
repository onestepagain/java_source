package com.atguigu.test02;

/*
 * super：
 * 	  从父类中取查找，引用父类的xx
 * 要求：super只能方法在子类中可见的属性、方法、构造器
 * 
 * 用法：
 * 1、super.属性
 * 当子类声明了和父类同名的属性时，可以使用super.属性来访问父类的属性
 * 
 * 2、super.方法
 * 当在子类中需要调用父类被重写的方法时，可以使用super.方法
 * 
 * 3、super()或super(实参列表）
 * super()；调用父类的无参构造
 * super(实参列表)：调用父类的有参构造
 * 
 * 注意：
 * （1）super()或super(实参列表）必须在子类构造器的首行
 * （2）如果子类的构造器中，没有写super()，它也存在
 *    但是如果子类构造器中写super(实参列表)，那么super()就不会存在的
 */
public class TestSuper {
	public static void main(String[] args) {
//		B b = new B();
//		b.printNum(3);
		
//		XueSheng x = new XueSheng("张三", 23, 89);
//		System.out.println(x.getInfo());
		
		XueSheng x = new XueSheng();
	}
}
class A{
	int num = 1;
}
class B extends A{
	int num = 2;
	public void printNum(int num){
		System.out.println(num);//局部变量  (int num)
		System.out.println(this.num);//成员变量，子类自己的int num
		System.out.println(super.num);
	}
}
class Human{
	private String name;
	private int age;
	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Human() {
		super();//调用的是公共父类java.lang.Object类的无参构造
		System.out.println("父类的无参构造");
	}
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
	public String getInfo(){
		return "姓名：" + name + "，年龄：" + age;
	}
}
class XueSheng extends Human{
	private int score;

	public XueSheng(String name, int age, int score) {
		super(name, age);//调用父类Human的有参构造
		this.score = score;
	}

	public XueSheng() {
//		super();//调用父类Human的无参构造
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	public String getInfo(){
	//	return "姓名：" + getName() + "，年龄：" + getAge() + "，成绩：" + score;
		return super.getInfo() + "，成绩：" + score;
	}
}
