package com.atguigu.test07;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Test;

/*
 * Optional实际上是个容器，它是一个装一个对象的容器。这个对象可能是个空，可能是非空。
 * 数组和集合是装多个对象的容器。
 * 
 * 1、创建Optional对象的方法：
 * （1）Optional.of(xx);  			只能装非空对象
 * （2）Optional.ofNullable(x);		装可以是null的对象
 * （3）Optional<T> empty()          直接返回一个空箱子对象
 * 
 * 2、如何取出Optional容器中的对象
 * （1）get()  必须配合of(xx)使用，因为这里面的对象不能是null
 * （2）orElse(T other)   如果Optional容器中的对象是空的，用other代替
 * （3）orElseGet(Supplier<? extends T> other) 如果Optional容器中的对象是空的，用other这个供给型接口提供的对象代替
 * （4）orElseThrow(Supplier<? extends X> exceptionSupplier) 
 * 
 * 3、其他操作
 * Optional<T> filter(Predicate<? super T> predicate)  
 */
public class TestOptional {
	@Test
	public void test9(){
		String str = "hello";
		Optional<String> opt = Optional.ofNullable(str);
		Optional<String> opt2 = opt.filter(s->s.length()>5);
		System.out.println(opt2);
	}
	
	
	@Test
	public void test8(){
		String str = null;
		Optional<String> opt = Optional.ofNullable(str);
		String string = opt.orElseThrow(()->new RuntimeException("值不存在"));
		System.out.println(string);
	}
	
	
	@Test
	public void test7(){
		String str = null;
		Optional<String> opt = Optional.ofNullable(str);
		String string = opt.orElseGet(String::new);
		System.out.println(string);
	}
	
	@Test
	public void test6(){
		String str = "hello";
		Optional<String> opt = Optional.ofNullable(str);
		String string = opt.orElse("atguigu");
		System.out.println(string);
	}
	
	@Test
	public void test5(){
		String str = null;
		Optional<String> opt = Optional.ofNullable(str);
//		System.out.println(opt.get());//java.util.NoSuchElementException: No value present
	}
	
	@Test
	public void test4(){
		String str = "hello";
		Optional<String> opt = Optional.of(str);

		String string = opt.get();
		System.out.println(string);
	}
	
	
	@Test
	public void test3(){
		String str = null;
		Optional<String> opt = Optional.ofNullable(str);
		System.out.println(opt);
	}
	
	@Test
	public void test2(){
		String str = "hello";
		Optional<String> opt = Optional.of(str);
		System.out.println(opt);
	}
	
	
	@Test
	public void test1(){
		ArrayList<Student> list = new ArrayList<>();
		list.add(new Student("张三", 23));
		//...
		
		//取出流中第一个年龄大于30岁的学生
		Optional<Student> opt = list.stream()
			.filter(s -> s.getAge()>30)
			.findFirst();
	
		
		//打印该学生的年龄
		Student stu = opt.orElse(new Student());
		System.out.println("学生的年龄：" + stu.getAge());
	}
}
class Student{
	private String name;
	private int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Student() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
}