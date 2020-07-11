package com.atguigu.test09;

public class TestCheckAccount {

	public static void main(String[] args) {
		CheckAccount c = new CheckAccount("1122", 20000, 4.5/100, 5000);
		
		try {
			c.withdraw(5000);
			System.out.println("取款成功，余额：" + c.getBalance() + "，可透支额度：" + c.getOverdraft());
		} catch (AccountException e) {
			System.out.println("取款失败，原因：" + e.getMessage());
		}
		
		try {
			c.withdraw(18000);
			System.out.println("取款成功，余额：" + c.getBalance() + "，可透支额度：" + c.getOverdraft());
		} catch (AccountException e) {
			System.out.println("取款失败，原因：" + e.getMessage());
		}
		
		try {
			c.withdraw(3000);
			System.out.println("取款成功，余额：" + c.getBalance() + "，可透支额度：" + c.getOverdraft());
		} catch (AccountException e) {
			System.out.println("取款失败，原因：" + e.getMessage());
		}
	}

}
