package com.atguigu.test04;

/*
 * 二、try..catch的形式二
 * try{
 * 		可能发生异常的代码
 * }catch(异常类型1  异常对象名){//异常对象名绝大多数都是写e
 * 		处理这个异常的代码
 * }catch(异常类型2  异常对象名){//异常对象名绝大多数都是写e
 * 		处理这个异常的代码
 * }catch(异常类型3  异常对象名){//异常对象名绝大多数都是写e
 * 		处理这个异常的代码
 * }
 * 。。。。
 * finally{
 * 		不管try中是否发生异常，也不管catch是否可以捕获异常，这里代码都必须执行
 * }
 * 
 * 一般用于编写释放资源，断开连接等代码
 * 
 * 特殊情况：可以没有catch部分
 * try{
 * 		
 * }finally{
 * 		
 * }
 */
public class TestTryCatchFinally {
	public static void main(String[] args) {
		try {
			int a = 1;
			int b = 0;
			System.out.println(a/b);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} finally{
			System.out.println("最终块");
		}
	}
}
