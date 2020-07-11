package com.atguigu.test05.exer;

/*
 * 2、声明一个子类SalaryEmployee正式工，
有属性，工作日天数，请假天数
重写方法，public double earning()返回实发工资， 
实发工资 = 薪资 - 薪资/工作日天数 * 请假天数
 */
public class SalaryEmployee extends Employee {
	private int workingDays;//工作日天数
	private int offDays;//请假天数

	public SalaryEmployee() {
	}

	public SalaryEmployee(String name, MyDate birthday, double salary, int workingDays, int offDays) {
		super(name, birthday, salary);
		this.workingDays = workingDays;
		this.offDays = offDays;
	}

	public int getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(int workingDays) {
		this.workingDays = workingDays;
	}

	public int getOffDays() {
		return offDays;
	}

	public void setOffDays(int offDays) {
		this.offDays = offDays;
	}

	/*
	 * 重写方法，public double earning()返回实发工资， 
		实发工资 = 薪资 - 薪资/工作日天数 * 请假天数
	 */
	@Override
	public double earning() {
		return getSalary() - getSalary()/workingDays*offDays;
	}

}
