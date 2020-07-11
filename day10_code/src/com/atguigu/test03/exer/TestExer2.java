package com.atguigu.test03.exer;

/*
 * 2、练习题2
（1）声明一个Person类，有一个方法
public void toilet(){
}
（2）声明一个子类Woman类，重写方法
（3）声明一个子类Man类，重写方法
（4）在测试类中声明一个方法，
public static void goToToilet(Person p){
	//调用toilet()
}

 */
public class TestExer2 {
	public static void main(String[] args) {
		Woman m = new Woman();
		goToToilet(m);//形参是Person类型，实参是Woman类型
		
		goToToilet(new Man());//形参是Person类型，实参是Man类型
	}
	public static void goToToilet(Person p){
		p.toilet();
	}
	
}
class Person{
	public void toilet(){
		System.out.println("上厕所");
	}
}
class Woman extends Person{
	public void toilet(){
		System.out.println("蹲着上厕所");
	}
}
class Man extends Person{
	public void toilet(){
		System.out.println("站着上厕所");
	}
}