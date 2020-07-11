package com.atguigu.test02.review;

/*
 * (1)因为finally有return，最终一定从finally的语句 回去
 * (2)但是try中的return也会走，只是执行它的第一个动作，把返回值放到“操作数栈”
 * 例如：把i=1先放到操作数栈中
 * (3)因为finally有return，这个时候，我们这里的return也有两个动作
 * ①再把它的返回值也放到操作数栈中，i=2，②结束当前方法
 */
public class Test04 {
	static int i = 0;
	public static void main(String[] args) {
		System.out.println(test());
	}

	public static int test(){
		try{
			return ++i;
		}finally{
			return ++i;
		}
	}
}
