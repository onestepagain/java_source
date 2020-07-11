package com.atguigu.test03;

/*
 * static：也是一种修饰符
 * 1、意思：静态的
 * 2、可以修饰什么？
 * （1）方法
 * （2）成员变量
 * （3）内部类：后面讲
 * （4）代码块
 * 3、修饰后有什么不同？
 * （1）方法：我们称为“静态方法”或“类方法”
 * ①这个方法，对于其他类来说可以用"类名.方法"进行调用，当然也可以使用"对象名.方法"进行调用，我们推荐用"类名.方法"
 * ②静态方法中，是不允许出现：this,super,对本类的非静态属性、非静态的方法的直接使用代码的
 * 
 * （2）成员变量：称为“类变量、静态变量”
 * ①用static修饰的成员变量的值，表示是这个类型的所有对象“共享的”
 * ②static修饰的成员变量的值，存储在方法区
 * ③static修饰的成员变量的get/set也是静态的，
 * ④如果在方法中有局部变量与static修饰的成员变量同名时，在静态变量前面加"类名."进行区别
 * 
 * 结论：非静态的"对象名."，静态的用"类名."
 * 
 * 问？黄色的脸，黑色的眼，中国人
 * class Chinese{
 * 		private static String face = "黄色";
 * 		private static String eyes = "黑色";
 * 		private String name;
 * }
 */
public class TestStatic {
	private static int a ;//可以修饰成员变量
	private int num = 10;//非静态的
	
	public int getNum(){
		return num;
	}
	
	public static void main(String[] args) {
		GraphicTools tools = new GraphicTools();
		tools.printRectangle(5, 10, "#");//不推荐使用"对象名."调用，因为会让人误会不同的对象，调用的结果不同
		
		GraphicTools.printRectangle(3, 5, "&");
		
//		System.out.println(num);
//		System.out.println(getNum());
//		System.out.println(this.num);
//		System.out.println(super.hashCode());
		
//		static int a = 10;//不能修饰局部变量
		
		Account a1 = new Account();
		Account a2 = new Account();
		System.out.println("a1.rate = " +  a1.rate + "，a1.balance = " + a1.balance);
		System.out.println("a2.rate = " +  a2.rate + "，a2.balance = " + a2.balance);
		
		a1.rate = 0.045;
		a1.balance = 2000;
		System.out.println("a1.rate = " +  a1.rate + "，a1.balance = " + a1.balance);
		System.out.println("a2.rate = " +  a2.rate + "，a2.balance = " + a2.balance);
		
		System.out.println(Account.rate);//建议访问静态方法，用"类名."进行访问
	}
	
	
	/*static class Inner{
		
	}*/
}
class GraphicTools{
	public static void printRectangle(int line,int column, String sign){
		for (int i = 0; i < line; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(sign);
			}
			System.out.println();
		}
	}
}
class Account{
	static double rate = 0.035;//是Account的所有对象共享的
	double balance = 1000;//是Account的每一个对象独立的
	
	public static double getRate() {
		return rate;
	}
	public static void setRate(double rate) {
		Account.rate = rate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
