package com.atguigu.test02;

import org.junit.Test;

public class TestDigui2 {
	/*
	 * 求阶乘
	 * 例如：5! = 5 * 4 * 3* 2 *1
	 * 求n！
	 */
	public long jieCheng(int n){
		/*
		 * 如果n=0 或 1，结果就是1
		 * 如果n = 2 ,  2 * 1  = 2 * jieCheng(1)
		 * 如果n = 3 ,  3 * 2 * 1  = 3 * jieCheng(2)
		 * ...
		 */
		if(n==0 || n==1){
			return 1;
		}else{
			return n * jieCheng(n-1);
		}
	}
	@Test
	public void test02(){
		System.out.println(jieCheng(20));
	}
}
