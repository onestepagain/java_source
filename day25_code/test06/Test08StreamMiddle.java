package com.atguigu.test06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

import org.junit.Test;

/*
 * 二、中间的加工操作
 * （1）filter(Predicate p)：过滤
 * （2）distinct()：去重
 * （3）limit(long maxSize)：取有限的几个
 * （4）skip(long n)：跳过n个
 * （5）peek(Consumer action)  接收Lambda表达式，对流中的每个数据执行Lambda体操作
 * （6）sorted()：排序，按照自然排序
 *    sorted(Comparator com)：排序，按照定制排序
 *  （7）map(Function f)：接收Lambda表达式，对流中的每个数据，执行Lambda体操作，返回新的数据构成新的流
 *  （8）flatMap(Function f)
 *  
 *    map(Function<? super T,? extends R> mapper)   map操作流中的把T对象变成R对象，由R对象构成新的流
 *    flatMap(Function<? super T,? extends Stream<? extends R>> mapper) 
 *    				 flatMap把流中的数据T对象压扁变成一个Stream，然后把一个个的Stream最后再合成一个大的Stream
 */
public class Test08StreamMiddle {
	
	@Test
	public void test12(){
		String[] arr = {"hello","world","java"};
		Stream<String> flatMap = Arrays.stream(arr)
			.flatMap(t -> Stream.of(t.split("|")));//Function<T,R>接口抽象方法 R apply(T t)  现在的R是一个Stream
		flatMap.forEach(System.out::println);
	}
	
	
	@Test
	public void test11(){
		String[] arr = {"hello","world","java"};
		
		Arrays.stream(arr)
		
			.map(t->t.toUpperCase())
			.forEach(System.out::println);
	}
	
	@Test
	public void test10(){
		Stream.of(1,2,3,4,5)
			.map(t -> t+=1)//Function<T,R>接口抽象方法 R apply(T t)
			.forEach(System.out::println);
	}
	
	@Test
	public void test09(){
		//希望能够找出前三个最大值，前三名最大的，不重复
		Stream.of(11,2,39,4,54,6,2,22,3,3,4,54,54)
			.distinct()
			.sorted((t1,t2) -> -Integer.compare(t1, t2))//Comparator接口  int compare(T t1, T t2)
			.limit(3)
			.forEach(System.out::println);
	}
	
	@Test
	public void test08(){
		long count = Stream.of(1,2,3,4,5,6,2,2,3,3,4,4,5)
			.distinct()
			.peek(System.out::println)  //Consumer接口的抽象方法  void accept(T t)
			.count();
		System.out.println("count="+count);
	}
	
	
	@Test
	public void test07(){
		Stream.of(1,2,3,4,5,6,2,2,3,3,4,4,5)
			.skip(5)
			.distinct()
			.filter(t -> t%3==0)
			.forEach(System.out::println);
	}

	@Test
	public void test06(){
		Stream.of(1,2,3,4,5,6,2,2,3,3,4,4,5)
			.skip(5)
			.forEach(System.out::println);
	}
	
	@Test
	public void test05(){
		Stream.of(1,2,2,3,3,4,4,5,2,3,4,5,6,7)
			.distinct()  //(1,2,3,4,5,6,7)
			.filter(t -> t%2!=0) //(1,3,5,7)
			.limit(3)
			.forEach(System.out::println);
	}
	
	
	@Test
	public void test04(){
		Stream.of(1,2,3,4,5,6,2,2,3,3,4,4,5)
			.limit(3)
			.forEach(System.out::println);
	}
	
	
	@Test
	public void test03(){
		Stream.of(1,2,3,4,5,6,2,2,3,3,4,4,5)
			.distinct()
			.forEach(System.out::println);
	}
	
	
	@Test
	public void test02(){
		Stream.of(1,2,3,4,5,6)
			.filter(t -> t%2==0)
			.forEach(System.out::println);
	}
	
	@Test
	public void test01(){
		//1、创建Stream
		Stream<Integer> stream = Stream.of(1,2,3,4,5,6);
		
		//2、加工处理
		//过滤：filter(Predicate p)
		//把里面的偶数拿出来
		/*
		 * filter(Predicate p)
		 * Predicate是函数式接口，抽象方法：boolean test(T t)
		 */
		stream = stream.filter(t -> t%2==0);
		
		//3、终结操作：例如：遍历
		stream.forEach(System.out::println);
	}
}
