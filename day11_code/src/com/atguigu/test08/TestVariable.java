package com.atguigu.test08;

/*
 * 变量的分类：
 * 1、成员变量
 * （1）类变量：静态的成员变量
 * （2）实例变量：非静态的成员变量
 * 2、局部变量
 * 
 * 区别：
 * 1、声明的位置
 * （1）成员变量：类中方法外
 * （2）局部变量：
 * 		方法()中形参列表
 * 		方法体{}中局部变量
 * 		代码块中局部变量
 * 2、在内存中存储的位置
 * （1）成员变量：
 * 	 类变量：方法区
 *  实例变量：堆
 *  （2）局部变量：
 *   栈
 *   	虚拟机栈：非native方法的局部变量
 *  	本地方法栈：native方法的局部变量
 * 
 * 3、修饰符
 * （1）成员变量：
 * 		4种权限修饰符
 * 		static,final
 * （2）局部变量：final
 * 
 * 
 * 4、生命周期
 * （1）成员变量：
 * 类变量：
 * 	  随着类的加载而分配空间，随着类的卸载而消亡
 * 	 每一个对象是共享
 * 实例变量：
 * 	每一个对象是独立
 * 	随着对象的创建而分配空间，随着对象被垃圾回收而回收
 * 
 * （2）局部变量
 *   方法调用时，在栈中分配空间，方法调用结束就消亡
 * 
 * 5、作用域
 * （1） 成员变量：
 * 类变量：
 * 	 在本类中随便用
 * 	在其他类中，用"类名."或"对象."
 * 实例变量：	 
 * 	在本类中除了静态成员中不能用，其他随便用
 * 	在其他类中，用"对象."
 * 
 * （2）局部变量
 * 	有作用域，超过作用域就不能使用了
 */
public class TestVariable {
	static int num;//成员变量，类变量
	int a;//成员变量，实例变量
	{
		int a;//局部变量
	}
	public static void main(String[] args) {
		
	}
}
