package com.atguigu.test03.exer;

/*
 * （4）参照SalariedEmployee类定义HourlyEmployee类，实现按小时计算工资的员工处理。该类包括：
	private成员变量wage和hour；
	实现父类的抽象方法earnings(),该方法返回wage*hour值；toString()方法输出员工类型信息及员工的name，birthday。
 */
public class HourlyEmployee extends Employee{
	private int wage;
	private int hour;
	public HourlyEmployee() {
		super();
	}
	public HourlyEmployee(String name, MyDate birthday, int wage, int hour) {
		super(name, birthday);
		this.wage = wage;
		this.hour = hour;
	}
	public HourlyEmployee(String name, int year, int month, int day, int wage, int hour) {
		super(name, year, month, day);
		this.wage = wage;
		this.hour = hour;
	}
	public int getWage() {
		return wage;
	}
	public void setWage(int wage) {
		this.wage = wage;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	//实现父类的抽象方法earnings(),该方法返回wage*hour值；
	@Override
	public double earnings() {
		return wage * hour;
	}
	
	//toString()方法输出员工类型信息及员工的name，birthday。
	public String toString(){
		return "小时工： " + super.toString();
	}
}
