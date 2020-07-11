package com.atguigu.test02.exer;

/*
 * 写一个测试类TestAccount：
 * 在用户程序中，创建一个账号为11223344、余额为20000、年利率4.5%的Account对象。
 * 使用withdraw方法提款30000元，并打印余额。
再使用withdraw方法提款2500元，使用deposit方法存款3000元，然后打印余额和月利率。*/

public class TestAccount {
	public static void main(String[] args) {
		//创建一个账号为11223344、余额为20000、年利率4.5%的Account对象。
		Account account = new Account("11223344", 20000, 4.5/100);
		
		//使用withdraw方法提款30000元，并打印余额。
		account.withdraw(30000);
		System.out.println("余额：" + account.getBalance());
		
		//再使用withdraw方法提款2500元
		account.withdraw(2500);
		System.out.println("余额：" + account.getBalance());
		
		//deposit方法存款3000元
		account.deposit(3000);
		System.out.println("余额：" + account.getBalance());
		System.out.println("月利率：" + account.getMonthlyInterest()*100+"%");
	}
}
