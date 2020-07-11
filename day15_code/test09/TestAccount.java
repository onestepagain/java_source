package com.atguigu.test09;

public class TestAccount {
	public static void main(String[] args) {
		Account a = new Account("1122", 20000, 4.5/100);
		
		try {
			a.withdraw(30000);
			System.out.println("取款成功：余额，" + a.getBalance());
		} catch (AccountException e) {
			System.out.println("取款失败，原因：" + e.getMessage());
		}
		
		try {
			a.withdraw(2500);
			System.out.println("取款成功：余额，" + a.getBalance());
		} catch (AccountException e) {
			System.out.println("取款失败，原因：" + e.getMessage());
		}
		
		try {
			a.deposit(3000);
			System.out.println("存款成功，余额：" + a.getBalance());
			System.out.println("月利率：" + a.getMonthlyInterestRate() * 100 + "%");
			System.out.println("年利息：" + a.getBalance() * a.getAnnualInterestRate());
		} catch (AccountException e) {
			System.out.println("存款失败，原因：" + e.getMessage());
		}
	}
}
