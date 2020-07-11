/*
方法的参数传递机制：
	实参-->形参

（1）形参是基本数据类型
	实参赋值给形参的是数据值，形参值的修改不影响实参，因为实参是“copy，复制”了一份数据值给形参
（2）形参是引用数据类型	
*/
class Test02_PassParamValue{
	public static void main(String[] args){
		int x = 1;
		int y = 2;
		//本类同级别的方法调用
		swap(x,y);
		
		System.out.println("x = " + x + "，y = " + y);
	}
	//public static修饰符
	public static void swap(int a,int b){
		System.out.println("a = " + a + "，b = " + b);
		int temp = a;
		a = b;
		b = temp;
		System.out.println("a = " + a + "，b = " + b);
	}
}