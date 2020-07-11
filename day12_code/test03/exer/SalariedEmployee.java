package com.atguigu.test03.exer;

/*
 * （3）定义SalariedEmployee类继承Employee类，实现按月计算工资的员工处理。该类包括：
	private成员变量monthlySalary；//月薪
private 成员变量 workingDay;//本月出勤天数
private 成员变量 totalDays;//本月总工作日天数，除了周末和假期
实现父类的抽象方法earnings(),该方法返回月薪*出勤天数/本月总工作日；
toString()方法输出员工类型信息及员工的name，birthday。
 */
public class SalariedEmployee extends Employee{
	private double monthlySalary;
	private int workingDay;
	private int totalDays;
	public SalariedEmployee(String name, MyDate birthday, double monthlySalary, int workingDay, int totalDays) {
		super(name, birthday);
		this.monthlySalary = monthlySalary;
		this.workingDay = workingDay;
		this.totalDays = totalDays;
	}
	public SalariedEmployee(String name, int year, int month, int day, double monthlySalary, int workingDay,
			int totalDays) {
		super(name, year, month, day);
		this.monthlySalary = monthlySalary;
		this.workingDay = workingDay;
		this.totalDays = totalDays;
	}
	public SalariedEmployee() {
		super();
	}
	public double getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	public int getWorkingDay() {
		return workingDay;
	}
	public void setWorkingDay(int workingDay) {
		this.workingDay = workingDay;
	}
	public int getTotalDays() {
		return totalDays;
	}
	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}
	
	//实现父类的抽象方法earnings(),该方法返回月薪*出勤天数/本月总工作日；
	@Override
	public double earnings() {
		return monthlySalary * workingDay / totalDays;
	}
	
	//toString()方法输出员工类型信息及员工的name，birthday。
	public String toString(){
		return "正式工:" + super.toString();
	}
}
