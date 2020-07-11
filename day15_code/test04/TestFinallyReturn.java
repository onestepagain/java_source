package com.atguigu.test04;

/*
 * finally与return混用：
 * 
 * （1）不管try中是否发生异常，也不管catch是否可以捕获异常，也无论try或catch中是否有return。
 * 	finally中的代码都必须执行
 * （2）如果finally中有return，就从finally块的的return回去。
 */
public class TestFinallyReturn {
	public static void main(String[] args) {
		String str = getNum(1);
		System.out.println(str);
	}
	
	public static String getNum(int a){
		try{
			System.out.println(a/0);
			if(a > 0){
				return "正数";
			}else if(a < 0){
				return "负数";
			}else{
				return "零";
			}
		}catch(Exception e){
			return "异常";
		}finally{
			return "最终";
		}
	}
}
