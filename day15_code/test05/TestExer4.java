package com.atguigu.test05;

/*
 * (1)finally里面有return，就从finally的return回去了
 * (2)类初始化：main所在的类要先初始化，才能执行main方法
 * 由①静态变量的显示赋值（这里没有）②静态代码块
 * （3）实例初始化：必须要new对象才会有，这里没有创建TestExer4的对象，所以不走
 *    
 *    
 *    结果：a
 *        3
 */
public class TestExer4 {
	{
		System.out.println("b");
	}
	static{
		System.out.println("a");
	}
	TestExer4(){
		System.out.println("c");
	}
	public static String getOut(){
		try{
			return "1";
		}catch(Exception e){
			return "2";
		}finally{
			return "3";
		}
	}
	public static void main(String[] args) {
		System.out.println(getOut());//3
	}
}
