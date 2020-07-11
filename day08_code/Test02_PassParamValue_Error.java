/*
陷阱：
	当形参是引用数据类型，实参给形参地址值之后，
	形参修改了地址值，那么和实参就无关了
*/
class Test02_PassParamValue_Error{
	public static void main(String[] args){
		Circle yuan = new Circle();
		yuan.radius = 1.0;
		
		doubleRadius(yuan);
		
		System.out.println("半径：" + yuan.radius);
	}
	//方法的功能：可以把c这个圆对象的半径，变为原来的2倍
	public static void doubleRadius(Circle c){
		c = new Circle();//加了一句代码  修改了形参c中存储的地址值，即c指向新对象了
		c.radius *= 2;
	}
	
}
class Circle{
	double radius;
}