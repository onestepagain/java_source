package com.atguigu.test09;

public class Account {
	private String id;
	protected double balance;
	private double annualInterestRate;
	public Account(String id, double balance, double annualInterestRate) {
		super();
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}
	public Account() {
		super();
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
	
	public double getMonthlyInterestRate(){
		return annualInterestRate / 12;
	}
	public double getMonthlyInterest(){
		return balance * getMonthlyInterestRate();
	}
	public void withdraw(double money) throws AccountException{
		if(money < 0){
			throw new AccountException("取款金额有误，不能小于0");
		}
		if(money > balance){
			throw new AccountException("余额不足");
		}
		balance -= money;
	}
	public void deposit(double money) throws AccountException{
		if(money < 0){
			throw new AccountException("存款金额有误，不能小于0");
		}
		balance += money;
	}
}
