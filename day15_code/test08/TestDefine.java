package com.atguigu.test08;

/*
 * 自定义异常：
 * 	 如果系统预定义的异常类型，
 * 		例如：ArrayIndexOutOfBoundsException
 * 			ClassCastException
 * 			NullPointerException
 * 			ArithmeticException
 * 			InputMisMatchException
 * 			IllegalAugumentException
 * 			....
 *  发现不能准确的表达你当前的异常类型的意思时，你可以选择自定义。
 * 
 * 面试题：列出常见的异常类型，已经什么情况下会发生这个异常，你如何处理？
 * 至少5个
 * 
 * 
 * 1、自定义的要求：
 * （1）必须继承Throwable或它的子类
 * 但是实际开发中，一般继承RuntimeException和Exception
 * （2）建议大家保留两种构造器的形式
 * ①无参构造
 * ②带给父类的message属性赋值的构造器
 * 
 * 2、如何使用自定义异常
 * 只能使用throw语句进行手动抛出。它不能由JVM自动抛出。
 * 
 * 3、建议
 * 大家在自定义异常时，异常的类型名非常重要，见名知意。
 */
public class TestDefine {
	public static void main(String[] args) {
		Account a = new Account(100);
		
		try {
			a.withdraw(-100);
		} catch (MoneyCannotNegativeException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}

//例如：想要声明一个异常类型，表示金额不能为负数
class MoneyCannotNegativeException extends Exception{

	public MoneyCannotNegativeException() {
		super();
	}

	public MoneyCannotNegativeException(String message) {
		super(message);
	}
	
}

class Account{
	private double balance;
	
	public Account(double balance) {
		super();
		this.balance = balance;
	}

	public boolean withdraw(double money) throws MoneyCannotNegativeException{
		if(money < 0){
			throw new MoneyCannotNegativeException("取款金额" +money + "有问题，取款金额不能小于0");
		}
		if(money > balance){
			throw new RuntimeException("余额不足");
		}
		
		balance -= money;
		return true;
	}
}