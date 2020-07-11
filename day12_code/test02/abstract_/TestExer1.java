package com.atguigu.test02.abstract_;
/*
1、父类：动物，Animal，包含属性：name（动物名称）
抽象方法，生育：public abstract void giveBirthTo();
2、子类：卵生动物，Oviparity
3、子类：胎生动物，Viviparity
4、在测试类中，创建Animal数组，并保存多个子类对象，
并调用getName()和giveBirthTo()方法，打印：例如：狗是胎生动物
 */
public class TestExer1 {
	public static void main(String[] args) {
		//创建Animal数组
		//此时不是创建Animal的对象，而是创建数组对象
		Animal[] arr = new Animal[2];
		arr[0] = new Oviparity("翠鸟");
		arr[1] = new Viviparity("京巴狗");
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i].getName() );
			arr[i].giveBirthTo();
		}
	}
}
//如果类中有抽象方法，类必须是抽象类
abstract class Animal{
	private String name;

	public Animal(String name) {
		super();
		this.name = name;
	}

	public Animal() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//抽象方法
	public abstract void giveBirthTo();
}
//子类继承抽象类，子类如果不是抽象类的话，就要重写父类所有的抽象方法
class Oviparity extends Animal{

	public Oviparity() {
		super();
	}

	public Oviparity(String name) {
		super(name);
	}

	@Override
	public void giveBirthTo() {
		System.out.println("卵生动物");
	}
	
}
class Viviparity extends Animal{

	public Viviparity() {
		super();
	}

	public Viviparity(String name) {
		super(name);
	}

	@Override
	public void giveBirthTo() {
		System.out.println("胎生动物");
	}
	
}