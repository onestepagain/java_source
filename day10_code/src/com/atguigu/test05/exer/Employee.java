package com.atguigu.test05.exer;

/*
 * 有属性，姓名（String），出生日期（MyDate类型），薪资
有方法，public double earning()返回实发工资，返回薪资
 */
public class Employee {
	private String name;
	private MyDate birthday;
	private double salary;
	public Employee() {
		super();
	}
	public Employee(String name, MyDate birthday, double salary) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.salary = salary;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	//public double earning()返回实发工资，返回薪资
	public double earning(){
		return salary;
	}
}
