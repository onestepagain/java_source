package com.atguigu.test01;

/*
 * 成员内部类分为两种：
 * 1、静态成员内部类，简称静态内部类
 * 【修饰符】 class 外部类{
 * 		【其他修饰符】 static class 内部类{
 * 		}
 * }
 * 【修饰符】 class 外部类  【 extends 父类】 【implements 父接口们】{
 * 		【其他修饰符】 static class 内部类  【 extends 父类】 【implements 父接口们】{
 * 		}
 * }
 * 注意：只有成员内部类才能用static修饰，其他的外部类，局部内部类等都不可以用static修饰
 * 
 * 2、非静态成员内部类
 * 【修饰符】 class 外部类{
 * 		【其他修饰符】  class 内部类  {
 * 		}
 * }
 * 【修饰符】 class 外部类 【 extends 父类】 【implements 父接口们】{
 * 		【其他修饰符】  class 内部类  【 extends 父类】 【implements 父接口们】{
 * 		}
 * }
 */
public class TestMemberInner {

}
class Outer{
	//静态内部类
	static class Inner{
		
	}
	
	//非静态内部类
	class Nei{
		
	}
}