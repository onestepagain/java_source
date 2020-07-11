package com.atguigu.test09;

public class CheckAccount extends Account{
	private double overdraft;

	public CheckAccount(String id, double balance, double annualInterestRate, double overdraft) {
		super(id, balance, annualInterestRate);
		this.overdraft = overdraft;
	}

	public CheckAccount() {
		super();
	}

	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}

	@Override
	public void withdraw(double money) throws AccountException {
		if(money <= balance){
			balance -= money;
		}else if(money > balance + overdraft){
			throw new OutOfOverdraftException("超过可透支额度");
		}else{
			overdraft -= money - balance;//超过余额部分
			balance = 0;
		}
	}
	
}
