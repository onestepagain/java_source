package com.atguigu.test02.polymorphism;

/*
 * 多态的好处：
 * 	 使得程序员编写代码更灵活
 * 
 * 
 * 多态的应用：
 * （1）多态数组：
 * 	 数组的元素是父类的类型，实际存储的是子类的对象
 *  用这样的数组，就可以统一管理，所有子类的对象
 */
public class TestUse1 {
	public static void main(String[] args) {
		/*
		 * 创建一个数组，可以存储各种图形的对象，包括圆对象，矩形对象，三角形对象...
		 */
		//本态数组
		//Circle[] yuans = new Circle[3];//这个数组存圆
		//Rectangle[] jus = new Rectangle[3];//这个数组存矩形
		
		Graphic[] all = new Graphic[3];//这个数组就可以存储各种图形的对象
		//左边的元素arr[0]是Graphic类型，右边是子类圆对象
		all[0] = new Circle(1.2);
		
		//左边的g2是Graphic，右边的是矩形对象
		Graphic g2 = new Rectangle(2, 4);
		all[1] = g2;
		
		all[2] = new Circle(4.2);
		
		//遍历所有图形的面积
		for (int i = 0; i < all.length; i++) {
			//执行哪个getArea()方法，要看all[i]中存储的是哪个子类的对象
			System.out.println("面积：" + all[i].getArea());
		}
	}
}
//Graphic图形
class Graphic{
	public double getArea(){
		return 0.0;//这句话没有什么意义，只是为了保证语法
	}
}
class Circle extends Graphic{
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}
	//重写
	public double getArea(){
		return 3.14 * radius * radius;
	}
}
class Rectangle extends Graphic{
	private double length;
	private double width;
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	//重写
	public double getArea(){
		return length * width;
	}
}