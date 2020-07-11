package com.atguigu.test02.exer.copy;

public class CheckAccount extends Account {
	private double overdraft;

	public CheckAccount() {
	}

	public CheckAccount(String id, double balance, double annualInterestRate,double overdraft) {
		super(id, balance, annualInterestRate);
		this.overdraft = overdraft;
	}

	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}

	@Override
	public void withdraw(double amount) {
		if(amount < 0){
			System.out.println("非法参数");
			return ;//结束当前方法
		}
		//if(amount > 余额 + 可透支额度)
		//balance是父类protected，可以直接使用
		if(amount > balance +overdraft){
			System.out.println("超过可透支的额度");
		}else if(amount > balance){
			//需要透支
			//(1)计算需要透支多少
			double d = amount - balance;
			//(2)修改可透支的额度
			overdraft -= d;
			//(3)把余额修改为0
			balance = 0;
			
		}else if(amount <= balance){
			//不需要透支
			//balance是父类protected，可以直接使用
			balance -= amount;
		}
	}
	
}
