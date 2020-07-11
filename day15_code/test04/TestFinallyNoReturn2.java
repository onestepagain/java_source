package com.atguigu.test04;
/*
 * finally与return混用：
 * 
 * （1）不管try中是否发生异常，也不管catch是否可以捕获异常，也无论try或catch中是否有return。
 * 	finally中的代码都必须执行
 * （2）如果finally中有return，就从finally块的的return回去。
 * （3）如果finally中没有return，那么先把try或catch中该执行的执行完（包括把返回值的结果放到要带回调用处的操作数栈的位置）
 * 在return结束当前方法之前，先走一下finally，然后回去结束当前方法.
 * 结论，如果finally中没有return，finally中的代码不影响返回值。
 */
public class TestFinallyNoReturn2 {
	public static void main(String[] args) {
		int num = getNum(4);
		System.out.println(num);//0
	}
	
	public static int getNum(int a){
		int result = 10;
		try{
			System.out.println(a/0);
			if(a > 0){
				result = 20;
				return result;
			}else if(a < 0){
				result = -20;
				return result;
			}else{
				return result;
			}
		}catch(Exception e){
			System.out.println("exception");
			result = 0;
			return result;
		}finally{
			result = 30;
			System.out.println("finally");
//			return result;//如果有这句，结果就变成30
		}
	}
}
