package com.atguigu.test05;

/*
 * (1)try..finally，可以没有catch
 * (2)无论try是否有异常，是否catch可以捕获异常，也无论try和catch有没有return，finally一定走
 */
public class TestExer3 {
	public static void main(String[] args) {
		try{
			return;
		}finally{
			System.out.println("finally");
		}
	}
}
