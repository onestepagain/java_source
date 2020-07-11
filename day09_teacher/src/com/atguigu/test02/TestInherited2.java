package com.atguigu.test02;

/*
 * 3、继承的特点：
 * （1）子类继承了父类，
 * 从事物的特征来说，子类会继承父类所有的特征（属性和方法）。
 * 但是从代码操作角度来说，父类中私有的属性、方法在子类中是不能直接使用的
 * （2）子类继承父类时，构造器是不能被继承的
 * （3）子类继承父类时，在子类的构造器中一定要去调用父类的构造器
 * 默认情况下，调用的是父类的无参构造；
 * 如果父类没有无参构造，那么在子类的构造器的首行，必须手动调用父类的有参构造；
 * （4）Java只支持单继承，即一个Java类只能有一个直接父类
 * 		只能有一个亲生父亲
 * （5）Java支持多层继承，即父类还可以有父类
 * 		代代相传
 * （6）一个Java类可以同时有很多个子类，而且子类还可以有子类
 * 		一个父亲可以有多个孩子，子孙满堂
 * （7）子类可以扩展父类没有的属性、方法
 */
public class TestInherited2 {

}
class Things{
	
}
class Graphic extends Things{
	
}

class Circle extends Graphic{
	
}
class Rectangle extends Graphic{
	
}