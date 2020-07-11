package com.atguigu.homewok.test09;

/*
 * final
 * 方法的参数传递机制
 */
public class Test09 {
	public static void main(String[] args) {
		Other o = new Other();
		new Test09().addOne(o);
		System.out.println(o.i);
	}
	
	//o是引用数据类型，实参给形参的是地址值，那么形参修改了属性，实参也会修改
	//o变量的值不能修改，不是说i的值不能修改
	public void addOne(final Other o){
		o.i++;
	}
}
class Other{
	public int i;//默认值0
}