package com.atguigu.test03;

import java.util.stream.Stream;

import org.junit.Test;

/*
 * Supplier和Consumer
 */
public class Test04Lambda2 {
	@Test
	public void test01(){
		/*
		 * Java8中，有一个新的类：Stream类型，它代表一个数据加工流
		 * java.util.stream.Stream<T>接口
		 * 		static <T> Stream<T> generate(Supplier<T> s) 
		 * 
		 *  这个静态方法的形参：Supplier<T>供给型接口的类型，SAM接口，可以使用Lambda表达式赋值
		 *  接口的静态方法通过“接口名.静态方法”调用
		 *  
		 *  Supplier<T>接口
		 *  （1）抽象方法		T get()
		 *  （2）抽象方法如何实现
		 *  		例如：在抽象方法中实现，随机产生一个小数[0,1)，返回值类型double
		 */
//		Stream<Double> stream = Stream.generate(() -> {return Math.random();});
		
		//优化
		Stream<Double> stream = Stream.generate(() -> Math.random());
		
		/*
		 * 为了看效果，我再调用Stream<T>接口的void forEach(Consumer<? super T> action) 
		 * 这个方法形参是Consumer<T>消费型接口类型，SAM接口，也可以使用Lambda表达式赋值
		 * 
		 * Consumer<T>消费型接口：
		 * （1）抽象方法
		 * 		void accept(T t)
		 * （2）如何实现抽象方法
		 * 		例如：打印流中的元素
		 * 
		 */
//		stream.forEach((Double num) -> {System.out.println(num);});
		//优化
		stream.forEach(num -> System.out.println(num));
	}
}
