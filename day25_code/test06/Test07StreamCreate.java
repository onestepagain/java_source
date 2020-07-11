package com.atguigu.test06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

/*
 * Stream接口：
 * 实现类
 * IntStream
 * DoubleStream
 * LongStream
 * 
 * 一、创建Stream
 * 1、方式一：通过集合创建
 * 		集合对象.stream()
 * 2、方式二：通过数组工具类Arrays
 * 	   Arrays.stream(数组对象)
 * 3、方式三：Stream接口的静态方法of方法，产生一个有限流
 * 		Stream.of(...)
 * 4、方式四：Stream接口的静态方法
 * （1）generate方法，产生无限流
 * （2）Stream<T> iterate(T seed, UnaryOperator<T> f)  
 */
public class Test07StreamCreate {
	@Test
	public void test06(){
		/*
		 * Stream<T> iterate(T seed, UnaryOperator<T> f)  
		 * UnaryOperator接口，SAM接口，抽象方法：
		 * 
		 * UnaryOperator<T> extends Function<T,T>
		 * 		T apply(T t)
		 */
		Stream<Integer> stream = Stream.iterate(1, num -> num+=2);
//		stream = stream.limit(10);
		stream.forEach(System.out::println);
	}
	
	@Test
	public void test05(){
		Stream<Double> stream = Stream.generate(Math::random);
		stream.forEach(System.out::println);
	}
	
	@Test
	public void test04(){
		Stream<Integer> stream = Stream.of(1,2,3,4,5);
		stream.forEach(System.out::println);
	}
	
	@Test
	public void test03(){
		String[] arr = {"hello","world"};
		Stream<String> stream = Arrays.stream(arr);
	}
	
	@Test
	public void test02(){
		int[] arr = {1,2,3,4,5};
		IntStream stream = Arrays.stream(arr);
	}
	
	@Test
	public void test01(){
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
		//JDK1.8中，Collection系列集合增加了方法
		Stream<Integer> stream = list.stream();
	}
}
