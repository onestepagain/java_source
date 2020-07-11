package com.atguigu.test09;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 一、匿名内部类
 * 语法格式：
 * 	new 父类名（【实参列表】）{
 * 		类的成员列表
 * 	}
 * 说明：如果你子类调用的是父类的无参构造，那么()中实参列表不用写，如果子类调用的是父类的有参构造，那么就在()中传入实参列表
 * 或
 * new 父接口名(){
 *    类的成员列表
 * }
 * 
 * 特殊：声明匿名内部类与创建它的对象是一起完成的。即匿名内部类只有唯一的对象。
 * 
 */
public class TestAnonymousInner {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//1、需求1：要声明一个Object的子类，匿名子类，
		//并在子类中声明一个方法public void test(){}打印“hello匿名内部类"
		
		//下面这段代码，声明了匿名内部类，也创建了它的对象
		//但是没有说这个对象干什么，编译不通过的。
/*		new Object(){
			public void test(){
				System.out.println("hello匿名内部类");
			}
		}*/
		
		//（1）我们可以把这个对象，赋值给一个变量
		//多态引用
		Object obj1 = new Object(){
			public void test(){
				System.out.println("hello匿名内部类");
			}
		};
		System.out.println(obj1.getClass());//获取对象的运行时类型
		System.out.println(obj1);//打印对象时，自动对象的toString()
		
		//这是另一个Object的匿名子类的对象
/*		Object obj2 = new Object(){
			public void test(){
				System.out.println("hello匿名内部类");
			}
		};*/
		
//		（2）我们可以用这个对象，直接调用方法
		//匿名内部类的匿名对象.方法()
		new Object(){
			public void test(){
				System.out.println("hello匿名内部类");
			}
		}.test();
		
		//java.util.Comparator接口
		//我要在这里声明一个比较器类型，用于比较两个圆的半径大小
		//把一个Comparator接口的匿名实现类对象，赋值给Comparator的变量
		//多态引用
/*		Comparator c = new Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
				Circle c1 = (Circle) o1;
				Circle c2 = (Circle) o2;
				if(c1.getRadius() > c2.getRadius()){
					return 1;
				}else if(c1.getRadius() < c2.getRadius()){
					return -1;
				}
				return 0;
			}
		};
		
		System.out.println(c.compare(new Circle(1), new Circle(2)));*/
		
		Circle[] all = new Circle[3];
		all[0] = new Circle(3);
		all[1] = new Circle(2);
		all[2] = new Circle(1);
		
		//匿名内部类的匿名对象作为实参使用
		Arrays.sort(all, new Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
				Circle c1 = (Circle) o1;
				Circle c2 = (Circle) o2;
				if(c1.getRadius() > c2.getRadius()){
					return 1;
				}else if(c1.getRadius() < c2.getRadius()){
					return -1;
				}
				return 0;
			}
		});
		
		
	}
}
/*class RadiusComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Circle c1 = (Circle) o1;
		Circle c2 = (Circle) o2;
		if(c1.getRadius() > c2.getRadius()){
			return 1;
		}else if(c1.getRadius() < c2.getRadius()){
			return -1;
		}
		return 0;
	}
	
}*/

class Circle{
	private double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
	
}
