package com.atguigu.test01.block;

public class TestInit {
	public static void main(String[] args) {
		/*
		Father f = new Father();
		//父类的无参构造
		*/
		
		/*
		 * Son s = new Son();
		 * 父类的无参构造
			子类的无参构造
		 */
		
		//Son s2 = new Son("atguigu");
		/*
		 * 父类的无参构造
		子类的有参构造
		 */
		
		Son s3 = new Son("atguigu", 10);
		/*
		 * 父类的无参构造
			子类的有参构造1
			子类的有参构造2
		 */
	}
}
class Father{
	public Father(){
		System.out.println("父类的无参构造");
	}
}
class Son extends Father{
	private String str;
	private int num;
	
	public Son(){
		//隐含了super();  子类的构造器中一定会调用父类的构造器，默认调用父类的无参构造
		System.out.println("子类的无参构造");
	}
	
	public Son(String str){
		//隐含了super()
		this.str = str;
		System.out.println("子类的有参构造1");
	}
	
	public Son(String str,int num){
		this(str);
		this.num = num;
		System.out.println("子类的有参构造2");
	}
}