package com.atguigu.test12;

import org.junit.Test;

/*
 * 设计模式：
 * 1、模板设计模式（了解）：抽象类
 * 2、单例设计模式（重点）：多线程时
 * 3、装饰者设计模式（IO流体系结构就体现了）
 * 4、迭代器设计模式（集合，在集合的内部设计迭代器类型）
 * 5、工厂设计模式（了解）
 * 6、代理设计模式（了解）
 * 
 * 一、工厂设计模式：为了解耦合，把对象的创建者与对象的使用者分开。
 * 生活中：批量生产产品
 * Java中：批量生产对象
 * 
 * 生活中：
 * 	   最早没有工厂，自给自足，男耕女织
 * 	  作坊
 * 	 大工厂
 * Java：
 * 	 没有工厂，需要对象，自己new
 * 
 * 分工：
 * 	  把生产（创建）对象与使用对象分开了，解耦合
 * 
 * 1、简单工厂模式
 * class SimpleFactory2{
	public static Car getCar(String type){
		if("宝马".equals(type)){
			return new BMW();
		}else if("奔驰".equals(type)){
			return new Benz();
		}
		return null;
	}
 }
 *
 *	优点：代码比较简洁
 *  缺点：如果增加新的产品类型，需要修改工厂类
 *     违反了面向对象的一个开发原则：对扩展开放，对修改关闭
 *
 * 2、工厂方法模式
 * 特点：一个产品就对应一个工厂类
 * 
 * interface Che{
	void run();
}
class BaoMa implements Che{

	@Override
	public void run() {
		System.out.println("宝马");
	}
	
}

 * interface GongChang{
	Che getChe();
}
class BaoMaFactory implements GongChang{

	@Override
	public Che getChe() {
		return new BaoMa();
	}
	
}
 */
public class TestFactory {
	@Test
	public void test03(){
		Car c = SimpleFactory2.getCar("奔驰");
		c.run();
	}
	
	@Test
	public void test02(){
		Car c = SimpleFactory.getCar();
		c.run();//这里也是运行宝马的run()，但是从头至尾没有出现BMW类型
	}
	
	@Test
	public void test01(){
		//没有工厂
		BMW b = new BMW();
		
		//使用对象，调用方法
		b.run();
	}
}
interface Car{
	void run();
}
class BMW implements Car{

	@Override
	public void run() {
		System.out.println("宝马让你在车里面哭");
	}
	
}
class Benz implements Car{
	@Override
	public void run() {
		System.out.println("奔驰让你在车盖上哭");
	}
}
class Audi implements Car{
	@Override
	public void run() {
		System.out.println("奥迪让你在...");
	}
}

//工厂类
class SimpleFactory{
	public static Car getCar(){
		return new BMW();
	}
}

class SimpleFactory2{
	public static Car getCar(String type){
		if("宝马".equals(type)){
			return new BMW();
		}else if("奔驰".equals(type)){
			return new Benz();
		}
		return null;
	}
}