package com.atguigu.test02.exer.copy;

/*
 * 1、写一个名为Account的类模拟账户。该类的属性和方法如下图所示。
 * 该类包括的属性：账号id，余额balance，年利率annualInterestRate；
 * 包含的方法：访问器方法（getter和setter方法），
 * 返回月利率的方法getMonthlyInterest()，
 * 取款方法withdraw()，
 * 存款方法deposit()。
 * 
 * 属性私有化，无参有参构造器，get/set，toString()一套套餐
 * */
public class Account {
	 private String id;//银行账号，身份证号，邮编，手机号，这种数字比较长的，又不进行数学运算，一般字符串存储
	
//	 protected：在本类、本包（包含子类和非子类）、其他包的子类
	 protected double balance;
	 private double annualInterestRate;
	public Account() {
		super();
	}
	public Account(String id, double balance, double annualInterestRate) {
		super();
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	 
	 /*
	  *  * 返回月利率的方法getMonthlyInterest()，
 * 取款方法withdraw()，
 * 存款方法deposit()。
	  */
	public double getMonthlyInterest(){
		//月利率 = 年利率 / 12;
		return annualInterestRate / 12;
	}
	
	public void withdraw(double amount){
		if(amount < 0){
			System.out.println("非法参数");
			return ;//结束当前方法
		}
		
		if(amount > balance){
			System.out.println("余额不足");
		}else{
			balance -= amount;
		}
	}
	
	public void deposit(double amount){
		if(amount < 0){
			System.out.println("非法参数");
			return ;//结束当前方法
		}
		balance += amount;
	}
	 
}
