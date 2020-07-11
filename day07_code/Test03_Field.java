/*
属性的特点：
1、属性有默认值
	原则和数组的元素的默认值一样。
	（1）基本数据类型
	byte,short,int,long：0
	float,double：0.0
	boolean:false
	char:\u0000
	（2）引用数据类型：null
	例如：String是引用数据类型

2、每一个对象的属性值是独立的
*/
class Test03_Field{
	public static void main(String[] args){
		//1、创建一个动物的对象
		Animal a1 = new Animal();
		
		//2、直接访问a1对象的属性值
		System.out.println("a1的name属性值：" + a1.name);
		System.out.println("a1的legs属性值：" + a1.legs);
		
		//String str;//错误: 可能尚未初始化变量str
		//System.out.println("str = " +str);
		
		//2、创建第二个动物的对象
		Animal a2 = new Animal();
		a2.name = "大象";
		a2.legs = 4;
		
		//访问a1对象的属性值
		System.out.println("a1的name属性值：" + a1.name);
		System.out.println("a1的legs属性值：" + a1.legs);
		//访问a2对象的属性值
		System.out.println("a2的name属性值：" + a2.name);
		System.out.println("a2的legs属性值：" + a2.legs);
	}
}
//Animal：动物
class Animal{
	//属性
	String name;//动物的名称
	int legs;//腿的数量
}