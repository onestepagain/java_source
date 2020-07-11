package com.atguigu.test02.polymorphism;

/*
 * 多态的应用：
 * （1）多态数组：
 * 		 数组的元素是父类的类型，实际存储的是子类的对象
 * （2）多态参数：
 * 		形参是父类的类型，实参是子类的对象
 */
public class TestUse2 {
	//这个方法，能够检查所有的动物吃东西是否正常
	//没有多态的话，需要重载很多个
	/*public static void check(Dog dog ){
		dog.eat();
	}
	public static void check(Cat cat ){
		cat.eat();
	}*/
	
	public static void check(Animal a){
		a.eat();
	}
	
	public static void main(String[] args) {
		//匿名对象
		check(new Dog());//隐含了，形参Animal a = 实参  new Dog()
		check(new Cat());//隐含了，形参Animal a = 实参  new Cat()
		
		Dog d = new Dog();
		check(d);//有名对象
	}
}
class Animal{
	public void eat(){
		System.out.println("吃东西");
	}
}
class Dog extends Animal{
	public void eat(){
		System.out.println("啃骨头");
	}
}
class Cat extends Animal{
	public void eat(){
		System.out.println("吃鱼");
	}
}