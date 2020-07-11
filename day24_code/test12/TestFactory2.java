package com.atguigu.test12;

/*
 * 2、工厂方法模式
 * 出发点：
 * 	（1）为了生产对象与使用对象分开   
 * 	（2）如果增加新产品，就不需要修改原来的工厂类
 * 
 * 优点：遵循了增加新产品，不修改原来的类的原则，
 * 缺点：类太多了
 */
public class TestFactory2 {
	public static void main(String[] args) {
		BaoMaFactory bf = new BaoMaFactory();
		Che c = bf.getChe();
		c.run();
	}
}
interface Che{
	void run();
}
class BaoMa implements Che{

	@Override
	public void run() {
		System.out.println("宝马");
	}
	
}

class BenChi implements Che{

	@Override
	public void run() {
		System.out.println("奔驰");
	}
}
class AoDi implements Che{
	@Override
	public void run() {
		System.out.println("奥迪");
	}
}

interface GongChang{
	Che getChe();
}
class BaoMaFactory implements GongChang{

	@Override
	public Che getChe() {
		return new BaoMa();
	}
	
}
class BenChiFactory implements  GongChang{

	@Override
	public Che getChe() {
		return new BenChi();
	}
	
}
//只需要增加一个工厂类，专门生产奥迪车