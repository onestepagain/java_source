package com.atguigu.test02.exer.copy;

/*
 * 要求：写一个用户程序测试CheckAccount类。
 * 在用户程序中，创建一个账号为11223344、余额为20000、年利率4.5%，可透支限额为5000元的CheckAccount对象。
使用withdraw方法提款5000元，并打印账户余额和可透支额。
再使用withdraw方法提款18000元，并打印账户余额和可透支额。
再使用withdraw方法提款3000元，并打印账户余额和可透支额。
再使用deposit方法存款1000元，并打印账户余额和可透支额。
再使用withdraw方法提款3000元，并打印账户余额和可透支额
 */
public class TestCheckAccount {

	public static void main(String[] args) {
		//创建一个账号为11223344、余额为20000、年利率4.5%，可透支限额为5000元的CheckAccount对象
		CheckAccount c = new CheckAccount("11223344", 20000, 4.5/100, 5000);
		
		//使用withdraw方法提款5000元，并打印账户余额和可透支额。
		c.withdraw(5000);
		System.out.println("余额：" + c.getBalance());//这个方法是从父类继承的
		System.out.println("可透支额度：" + c.getOverdraft());
		System.out.println();
		
		//再使用withdraw方法提款18000元，并打印账户余额和可透支额。
		c.withdraw(18000);
		System.out.println("余额：" + c.getBalance());//这个方法是从父类继承的
		System.out.println("可透支额度：" + c.getOverdraft());
		System.out.println();
		
		//再使用withdraw方法提款3000元，并打印账户余额和可透支额。
		c.withdraw(3000);
		System.out.println("余额：" + c.getBalance());//这个方法是从父类继承的
		System.out.println("可透支额度：" + c.getOverdraft());
		System.out.println();
		
		//再使用deposit方法存款1000元，并打印账户余额和可透支额
		c.deposit(1000);
		System.out.println("余额：" + c.getBalance());//这个方法是从父类继承的
		System.out.println("可透支额度：" + c.getOverdraft());
		System.out.println();
		
		//再使用withdraw方法提款3000元，并打印账户余额和可透支额
		c.withdraw(3000);
		System.out.println("余额：" + c.getBalance());//这个方法是从父类继承的
		System.out.println("可透支额度：" + c.getOverdraft());
		System.out.println();
	}

}
