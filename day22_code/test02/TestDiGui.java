package com.atguigu.test02;

import org.junit.Test;

public class TestDiGui {
	/*
	 * 4.通项公式如下：f(n)=n + (n-1) + (n-2) + .... + 1，
	 * 其中n是大于等于5并且小于10000的整数，例如：f(5) = 5 + 4 + 3 + 2 + 1，
	 * f(10) = 10 + 9 + 8 + 7+ 6 + 5 + 4 + 3 + 2 + 1，
	 * 请用递归的方式完成方法long f( int n)的方法体。
	 */
	public long f(int n){
		/*
		 * 如果n=1  f(1) = 1;
		 * f(2) = 2 + 1 = 2 + f(1)
		 * f(3) = 3 + 2 + 1 = 3 + f(2)
		 * f(4) = 4 + 3 + 2 + 1 = 4 + f(3)
		 * ....
		 * 如果n>1  f(n) = n + f(n-1)
		 */
		if(n == 1){
			return 1;
		}else{
			return n + f(n-1);
		}
	}
	@Test
	public void test01(){
		System.out.println(f(5));
		System.out.println(f(10));
	}
}
