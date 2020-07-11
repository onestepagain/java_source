package com.atguigu.homework.test09;

/*
 * 知识点：Object类的方法

案例：

​	1、声明三角形类，包含a,b,c三边

​	（1）属性私有化，提供无参，有参构造，提供get/set

​	（2）重写：toString()

​	（3）重写：hashCode和equals方法

​	（4）编写  public double getArea()：求面积方法

​	（5）编写 public double getPiremeter()：求周长方法

​	2、声明测试类Test09，在测试类中创建两个三角形对象，调用以上方法进行测试
 */
public class Test09 {
	public static void main(String[] args) {
	/*	Triangle t1 = new Triangle(3, 3, 3);
		Triangle t2 = new Triangle(3, 3, 3);*/
		
		Triangle t1 = new Triangle();
		Triangle t2 = new Triangle();
		
		System.out.println("t1和t2是否相同：");
		System.out.println(t1==t2);
		System.out.println(t1.equals(t2));
		
		System.out.println("t1和t2的面积：");
		System.out.println(t1.getArea());
		System.out.println(t2.getArea());
		
		System.out.println("t1和t2的周长：");
		System.out.println(t1.getPiremeter());
		System.out.println(t2.getPiremeter());
		
		System.out.println("t1和t2");
		System.out.println(t1);
		System.out.println(t2);
	}
}
class Triangle{
	private double a;
	private double b;
	private double c;
	public Triangle(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public Triangle() {
		super();
	}
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getC() {
		return c;
	}
	public void setC(double c) {
		this.c = c;
	}
	@Override
	public String toString() {
		return "Triangle [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(a);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(b);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(c);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		//比较当前对象this和指定对象obj的地址值，如果地址值相同，就直接返回true，后面就不看了
		if (this == obj)
			return true;
		
		//如果obj是null，说明是空对象
		//因为当前对象this一定是非空，因为如果为空的话，早就报空指针异常了
		//非空对象与空对象equals，一定是false
		if (obj == null)
			return false;
		
		//获取当前对象的运行时类型，和obj对象的运行时类型，看是否一致，如果不一致，就直接返回
		if (getClass() != obj.getClass())
			return false;
		
		//把obj对象向下转型
		//这里没有对obj进行instanceof判断是因为上面确定了this和obj都是三角形类型的对象
		//为什么要强制？因为obj编译时类型是Object类型，是无法调用obj.a、obj.b、obj.c等
		Triangle other = (Triangle) obj;
		//if(a == other.a)，为什么不这么写，因为double类型是不精确的
		//Double.doubleToLongBits(a)把double类型的值转为二进制形式进行比较，相对更精确
		if (Double.doubleToLongBits(a) != Double.doubleToLongBits(other.a))
			return false;
		if (Double.doubleToLongBits(b) != Double.doubleToLongBits(other.b))
			return false;
		if (Double.doubleToLongBits(c) != Double.doubleToLongBits(other.c))
			return false;
		
		
		return true;
	}
	public double getArea(){
		double p = (a + b + c)/2;
		return Math.sqrt(p *(p-a) * (p-b) * (p-c));
	}
	public double getPiremeter(){
		return a + b + c;
	}
}