package com.atguigu.test02.review;

public class Test06 {
	public static int fun(){
		int result = 5;
		try{
			result = result / 0;//会发生异常，发生算术异常ArithmeticException
			return result;
		}catch(Exception e){
			System.out.println("Exception");
			result = -1;
			return result;//（1）先把-1放到操作数栈（2）跳到finally中执行（3）回来结束当前方法
		}finally{
			result = 10;
			System.out.println("I am in finally.");
		}
	}
	public static void main(String[] args) {
		int x = fun();
		System.out.println(x);
	}
}