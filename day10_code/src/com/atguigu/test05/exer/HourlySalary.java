package com.atguigu.test05.exer;

/*
 * 3、声明一个子类HourEmployee小时工，
有属性，工作小时数，每小时多少钱
重写方法，public double earning()返回实发工资， 
实发工资 = 每小时多少钱 * 小时数
 */
public class HourlySalary extends Employee {
	private int hours;
	private double money;
	public HourlySalary() {
		super();
	}
	public HourlySalary(String name, MyDate birthday, double salary, int hours, double money) {
		super(name, birthday, salary);
		this.hours = hours;
		this.money = money;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	/*
	 * 重写方法，public double earning()返回实发工资， 
		实发工资 = 每小时多少钱 * 小时数
	 */
	@Override
	public double earning() {
		return hours * money;
	}
	
}
