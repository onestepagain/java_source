package com.atguigu.test07;

/*
 * 异常的对象的创建和抛出有两种方式：
 * （1）JVM创建并抛出
 * （2）程序员new出来，然后由throw抛出。
 * 
 * Throwable：
 * 		只有当对象是此类（或其子类之一）的实例时，才能通过 Java 虚拟机或者 Java throw 语句抛出。
 * 		类似地，只有此类或其子类之一才可以是 catch 子句中的参数类型。 
 * 
 * throw：
 * 	用于手动抛出异常对象。
 * 语法格式：
 * 	throw 程序员new的异常对象;
 * 
 * 可以代替return语句，结束当前的方法
 * 
 * 面试题：throw和throws什么区别？
 * （1）throw用于手动抛出异常对象，是个可执行的语句
 * （2）throws，在方法签名中，声明方法可能抛出什么异常，让调用者来处理这些异常。
 */
public class TestThrow {
	public static void main(String[] args) {
		Account a = new Account(100);
		try {
			boolean flag = a.withdraw(500);
			//如果没有异常，取款成功
			System.out.println("取款成功" + flag);
		} catch (IllegalArgumentException e) {
//			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (RuntimeException e) {
//			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
class Account{
	private double balance;
	
	public Account(double balance) {
		super();
		this.balance = balance;
	}

	public boolean withdraw(double money)throws IllegalArgumentException,RuntimeException{
		if(money < 0){
			//System.out.println("取款金额不能小于0");
			throw new IllegalArgumentException("取款金额" +money + "有问题，取款金额不能小于0");
		}
		if(money > balance){
			throw new RuntimeException("余额不足");
		}
		
		balance -= money;
		return true;
	}
}