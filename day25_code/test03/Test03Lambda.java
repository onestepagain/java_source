package com.atguigu.test03;

import java.util.ArrayList;

import org.junit.Test;

/*
 * Lambda表达式是给函数式接口（SAM接口）的变量或形参赋值的表达式。
 * Lambda表达式替代了原来使用匿名内部类的对象给函数式接口（SAM接口）的变量或形参赋值的形式。
 * 
 * 匿名内部类：实现了这个接口，重写了接口的抽象方法，同时创建了对象。
 * Lambda表达式也要实现这个接口，重写接口的抽象方法，隐含的创建了对象。
 * 	既然Lambda表达式是SAM接口的变量或形参赋值的，那么实现接口这部分语法可以省略，SAM接口的抽象方法只有一个，因此方法签名可以省略一部分。
 * 例如：修饰符，返回值类型、方法名可以省略，但是其中的形参列表不能省略，因此这里表表现形参类型和形参名，这个在方法体的实现中要使用。
 * 
 * 
 * Lambda表达式语法格式：
 * 	(形参列表) -> {Lambda体}
 * 
 * 说明：（1）(形参列表)就是SAM接口的抽象方法的形参列表
 * 	        （2）{Lambda体}就是实现SAM接口的抽象方法的方法体
 * 	       （3）->称为Lambda操作符，由“减号”和“大于号”构成，中间不能有空格
 * 
 * 优化：
 * 	（1）如果{Lambda体}只有一句语句，可以省略{}以及{}中的语句的结束;，如果{}没有省略的话，;就不能省略
 *  （2）如果(形参列表)中形参的类型是已知的，获取可以推断，那么数据类型可以省略
 *  （3）如果(形参列表)只有一个形参，并且数据类型也已经省略了，那么这个()可以省略了，如果数据类型没有省略，()不能省略
 *  （4）如果{Lambda体}只有一句语句，并且是一个return语句，那么可以省略{}以及{}中的语句的结束;还有return。
 *  （5）如果没有形参，()不能省略
 */
public class Test03Lambda {
	@Test
	public void test01(){
		//使用Lambda表达式给Runnable接口的形参赋值，这个线程要打印“尚硅谷"
		//构造器：new Thread(Runnable target)
		//现在要用Lambda表达式给Runnable类型的target形参赋值
		
		/*
		 * 写好一个Lambda表达式关注两个事情：
		 * （1）抽象方法长什么样		-->形参列表怎么写
		 * 	  public void run()
		 * （2）抽象方法怎么实现，即这个抽象方法要做什么事情 -->Lambda体
		 */
		//new Thread(() -> {System.out.println("尚硅谷");}).start();
		
		//优化
		new Thread(() -> System.out.println("尚硅谷")).start();
	}
	
	@Test
	public void test02(){
		/*
		 * 在Java8版本，给Iterable<T>这个接口增加一个默认方法
		 *   default void forEach(Consumer<? super T> action)  这个方法可以遍历容器中的元素，做xx事情
		 * 
		 * Collection<E>接口继承了Iterable<T>接口，说明Collection系列的集合都有这个方法，例如：ArrayList
		 *
		 */
		ArrayList<String> list = new ArrayList<>();
		list.add("hello");
		list.add("world");
		list.add("java");
		list.add("atguigu");
		
		/*
		 * forEach方法的形参是Consumer类型，它是消费型接口的类型，是SAM接口，就可以使用Lambda表达式赋值
		 * （1）接口的抽象方法
		 * 		void  accept(T t)  这里方法名不重要，只看返回值类型和形参列表
		 * （2）要如何实现这个抽象方法，例如：我这里要打印元素
		 */
//		list.forEach((String str) -> {System.out.println(str);});
		
//		优化
//		list.forEach((String str) -> System.out.println(str));
		
		//再优化
		list.forEach((str) -> System.out.println(str));
		
		//再优化
		list.forEach(str -> System.out.println(str));
	}
	
	@Test
	public void test03(){
		//从集合中删除字符个数超过6个的
		ArrayList<String> list = new ArrayList<>();
		list.add("hello");
		list.add("world");
		list.add("java");
		list.add("atguigu");
		
		/*
		 * Java8中Collection接口增加了一个方法
		 * 		default boolean removeIf(Predicate<? super E> filter)
		 * 这个方法的形参是Predicate判断型接口，是SAM接口，可以使用Lambda表达式赋值
		 * 
		 * Predicate<T>判断型接口
		 * （1）抽象方法
		 * 		boolean test(T t)
		 * （2）如何实现抽象方法
		 * 		这里判断条件是  字符个数>6
		 */
/*		list.removeIf((String str) -> {
				if(str.length()>6){
					return true;
				}else{
					return false;
				}
			});*/
		
		//代码优化
		list.removeIf((String str) -> {return str.length()>6;});
		
		//再优化
		list.removeIf(str -> str.length()>6);
	}
	
}
