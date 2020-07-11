package com.atguigu.test03.exer;

/*
 * （1）定义一个Employee类，该类包含：
	private成员变量姓名name,生日birthday，其中birthday 为MyDate类的对象；
	abstract方法double earnings()；toString()方法输出对象的name,birthday。	
 */
public abstract class Employee {
	private String name;
	private MyDate birthday;
	public Employee(String name, MyDate birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}
	public Employee() {
		super();
	}
	public Employee(String name,int year, int month, int day){
		super();
		this.name = name;
		this.birthday = new MyDate(year, month ,day);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MyDate getBirthday() {
		return birthday;
	}
	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}
	
	//double earnings()
	public abstract double earnings();
	
	//toString()方法输出对象的name,birthday。	
	public String toString(){
		return "姓名：" + name + "，生日：" + birthday.toDateString();
	}
}
