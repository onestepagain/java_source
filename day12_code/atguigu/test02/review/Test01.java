package com.atguigu.test02.review;

/*
 * （1）因为finally中没有return，最后结束是从try或catch中回去
 * （2）我们try或catch中的return 返回值;语句拆开来执行
 * ①先把返回值放到“操作数栈”，8的值放到操作数栈中
 * ②再去走finally
 * 此时虽然finally对result做了修改，但是没有影响操作数栈中值
 * ③回去执行return后半个动作，结束当前方法
 */
public class Test01 {
	public static void main(String[] args) {
		int test = test(3,5);
		System.out.println(test);
	}

	public static int test(int x, int y){
		int result = x;
		try{
			if(x<0 || y<0){
				return 0;
			}
			result = x + y;
			return result;
		}finally{
			result = x - y;
		}
	}
}
