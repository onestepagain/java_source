package com.atguigu.test05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.Test;

/*
 * lambda表达式是用来简化匿名内部类的一种函数式编程的语法。
 * 		只有SAM接口才能使用lambda表达式
 * 方法引用和构造器引用是用来简化lambda表达式。
 * 		只有当lambda表达式满足一些特殊情况时，才能使用方法引用和构造器引用。
 * 
 * 条件：
 * （1）当Lambda体的实现是通过调用一个现有的方法来完成功能时
 * （2）要求函数式接口的抽象方法返回值类型与该方法的返回值类型要对应。
 * （3）要求函数式接口的抽象方法的形参列表与该方法的形参列表对应
 *    或者
 *    要求函数式接口的抽象方法的形参列表的第一个形参是作为调用方法的对象，剩余的形参正好是给这个方法的实参列表
 * 
 * 方法引用的语法格式：
 * 	（1）对象::实例方法名
 *  （2）类名::静态方法名
 *  （3）类名::实例方法名
 *  
 *  条件：
 *  （1）当Lambda体的实现是通过创建一个对象来实现的
 *  （2）要求函数式接口的抽象方法返回值类型与该对象的类型一致
 *  （3）要求函数式接口的抽象方法的形参列表与该对象创建时的构造器的形参列表对应
 *  
 *  构造器引用语法格式：
 *  （1）类名::new
 *  （2）数组类型::new
 */
public class TestFunctionReference {
	@Test
	public void test06(){
		new Thread(() -> System.out.println("hello")).start();//不能使用方法引用来优化
	}
	
	@Test
	public void test05(){
		//调用createArray这个方法，创建一个2的n次方长度的数组
		/*
		 * public <R> R[] createArray(Function<Integer,R[]> fun,int length)
		 * 第一个参数：Function<Integer,R[]>接口  ，是SAM接口，可以赋值为Lambda表达式
		 * Function<T,R>接口的抽象方法：	R apply(T t)
		 * 
		 * 					R[] apply(Integer i)
		 * 如何实现，创建一个长度为i的R类型的数组
		 * 
		 */
//		String[] arr = createArray((Integer i) -> new String[i], 10);
		//优化为
		
		String[] arr = createArray(String[]::new, 10);
		System.out.println(Arrays.toString(arr));
		System.out.println(arr.length);
	}
	
	/*
	 * 模仿HashMap的源码实现的一个方法，功能是，可以创建一个2的n次方长度的数组
	 * 例如：这个length是你希望的数组的长度，但是它可能不是2的n次方，那么我会对length进行处理，纠正为一个2的n次方长度，并且创建这个数组
	 */
	public <R> R[] createArray(Function<Integer,R[]> fun,int length){
		int n = length - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        length = n < 0 ? 1 : n + 1;
		return fun.apply(length);
	}
	
	@Test
	public void test04(){
		//lambda表达式也可以用于给SAM接口的变量赋值
		/*
		 * Supplier<T> 接口的抽象方法   T get()
		 * 如何实现这个抽象方法，例如：这里要new一个String的空对象
		 */
//		Supplier<String> s = () -> new String();
		
		//就可以使用构造器引用，来创建对象
		Supplier<String> s = String::new;
	}
	
	@Test
	public void test03(){
		String[] arr = {"hello","Hi","world","chailinyan","atguigu"};
		
		//不区分大小写的排序
		/*
		 * public static <T> void sort(T[] a, Comparator<? super T> c)
		 * 第二个形参：Comparator接口，SAM接口，赋值为Lambda表达式
		 * 
		 * Comparator<String>接口的抽象方法：
		 * 		int compare(String s1, String s2)
		 * 如何实现？不区分大小写比较字符串
		 */
//		Arrays.sort(arr, (s1,s2) ->  s1.compareToIgnoreCase(s2));
		/*
		 * Comparator<String>接口    int compare(String s1, String s2)
		 * String类的 		     int compareToIgnoreCase(String str)  此处，s1正好是调用compareToIgnoreCase的对象，s2是给它的参数
		 */
		//使用方法引用优化
		Arrays.sort(arr, String::compareToIgnoreCase);
		
		System.out.println(Arrays.toString(arr));
	}
	
	@Test
	public void test02(){
		/* 
		 * Stream的
		 * public static<T> Stream<T> generate(Supplier<T> s)
		 * 形参是Supplier接口类型，赋值为Lambda表达式
		 * 
		 * （1）抽象方法   T get()
		 * （2）如何实现，  用Math.random()随机产生一个[0,1)范围的数
		 */
//		Stream<Double> stream = Stream.generate(() -> Math.random());
		
		/*
		 * Supplier接口的抽象方法   T get()   Double get()
		 * 调用的是						double Math.random()  
		 */
		//使用方法引用
		Stream<Double> stream = Stream.generate(Math::random);
		stream.forEach(System.out::println);
	}
	
	
	@Test
	public void test01(){
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
		/*
		 * default void forEach(Consumer<? super T> action)
		 * 形参的类型是Consumer接口，可以使用Lambda表达式赋值
		 * Consumer<T>  void accept(T t)
		 * 
		 */
		//list.forEach(num -> System.out.println(num));
		
		/*
		 * （1）这里的lambda表达式是通过调用一个现有的方法来完成的，是out对象的println()方法来完成
		 * （2）Consumer<T>  			public void accept(T t)
		 * 	  PrintStream类的out对象	public void println(Object x)
		 */
		list.forEach(System.out::println);
	}
	
	
}
