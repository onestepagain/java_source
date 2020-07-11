package com.atguigu.test06;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/*
 * 创建：一步
 * 中间：0~n步
 * 终结：一步
 * 
 * 三、终结操作
 * 1、void forEach(Consumer )：遍历流中的数据
 * 2、long count()：统计个数
 * 3、boolean allMatch(Predicate p)：是否全部满足xx条件
 *   boolean anyMatch(Predicate p)：是否有一个满足xx条件
 *   boolean noneMatch(Predicate  p)：是否全部都不满足xx条件
 * 4、  Optional<T> findFirst()：返回第一个
 *    Optional<T> findAny()：返回任意一个
 * 5、Optional<T> max(Comparator c)：找出最大的
 *   Optional<T> min(Comparator c)  ：找出最小的
 * 6、T reduce(T iden, BinaryOperator b) 通过反复的运算，留下最后一个结果
 *  Optional<U>  reduce(BinaryOperator b)
 * 7、R collect(Collector c)：把流中的数据最后都收集到一起
 *   Collector接口
 *   
 *   BiConsumer  抽象方法   void accept(R r,T t)
 */
public class Test09StreamEnding {
	
	@Test
	public void test14(){
		List<Integer> list = Stream.of(1,2,4,5,7,8)
				.filter(t -> t%2==0)
				.collect(Collectors.toList());
		
		System.out.println(list);
	}
	
	
	@Test
	public void test13(){
		Optional<Integer> reduce = Stream.of(1,2,4,5,7,8)
			 .reduce((t1,t2) -> t1>t2?t1:t2);//BinaryOperator接口   T apply(T t1, T t2)
		System.out.println(reduce);
	}
	
	@Test
	public void test12(){
		Integer reduce = Stream.of(1,2,4,5,7,8)
			 .reduce(0, (t1,t2) -> t1+t2);//BinaryOperator接口   T apply(T t1, T t2)
		System.out.println(reduce);
	}
	
	@Test
	public void test11(){
		Optional<Integer> max = Stream.of(1,2,4,5,7,8)
				.max((t1,t2) -> Integer.compare(t1, t2));
		System.out.println(max);
	}
	
	@Test
	public void test10(){
		Optional<Integer> opt = Stream.of(1,2,4,5,7,8)
				.filter(t -> t%3==0)
				.findFirst();
		System.out.println(opt);
	}
	
	@Test
	public void test09(){
		Optional<Integer> opt = Stream.of(1,2,3,4,5,7,9)
				.filter(t -> t%3==0)
				.findFirst();
		System.out.println(opt);
	}
	
	@Test
	public void test08(){
		Optional<Integer> opt = Stream.of(1,3,5,7,9).findFirst();
		System.out.println(opt);
	}
	
	@Test
	public void test04(){
		boolean result = Stream.of(1,3,5,7,9)
			.anyMatch(t -> t%2==0);
		System.out.println(result);
	}
	
	
	@Test
	public void test03(){
		boolean result = Stream.of(1,3,5,7,9)
			.allMatch(t -> t%2!=0);
		System.out.println(result);
	}
	
	@Test
	public void test02(){
		long count = Stream.of(1,2,3,4,5)
				.count();
		System.out.println("count = " + count);
	}
	
	
	@Test
	public void test01(){
		Stream.of(1,2,3,4,5)
				.forEach(System.out::println);
	}
}
