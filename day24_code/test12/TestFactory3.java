package com.atguigu.test12;

public class TestFactory3 {
	public static void main(String[] args)throws Exception {
		Vehicle c = SimpleFactory3.getVehicle("com.atguigu.test12.QQ");
		c.run();
		
		Vehicle c2 = SimpleFactory3.getVehicle("com.atguigu.test12.Aoto");
		c2.run();
		
		Vehicle c3 = SimpleFactory3.getVehicle("com.atguigu.test12.Atguigu");
		c3.run();
		
		
	}
}
interface Vehicle{
	void run();
}
class QQ implements Vehicle{

	@Override
	public void run() {
		System.out.println("qq车");
	}
	
}
class Aoto implements  Vehicle{

	@Override
	public void run() {
		System.out.println("奥拓");
	}
	
}
class Atguigu implements Vehicle{

	@Override
	public void run() {
		System.out.println("尚硅谷");
	}
	
}
class SimpleFactory3{
	public static Vehicle getVehicle(String className)throws Exception{
		Class clazz = Class.forName(className);
		return (Vehicle) clazz.newInstance();
	}
}