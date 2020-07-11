package com.atguigu.test04;

/*
 * 自定义函数式接口：
 * 1、声明一个接口，只能包含一个抽象方法
 * 2、给这个接口加@FunctionalInterface
 */
public class TestDefineFunctionalInterface {
	public static void main(String[] args) {
		//IntCalc tools形参，函数式接口，可以Lambda表达式赋值
		/*
		 * (1)抽象方法：int cal(int a , int b);
		 * (2)如何实现抽象方法
		 * 		例如：求a+b的和
		 */
		getProduct(1,2, (int a , int b) -> {return a+b;});//new了一个IntCalc的实现类的对象，而且实现了IntCalc抽象方法
		
		getProduct(1,2, (a ,b) ->a*b);
	}

	//2、在测试类中定义public static void getProduct(int a , int b ,IntCalc tools), 
	//该方法的预期行为打印使用tools的cal(a,b)的计算结果
	public static void getProduct(int a , int b ,IntCalc tools){
		int result = tools.cal(a, b);
		System.out.println("结果：" + result);
	}
}
//1、定义一个函数式接口IntCalc,其中抽象方法int cal(int a , int b)，使用注解@FunctionalInterface
@FunctionalInterface
interface IntCalc{
	int cal(int a , int b);
}