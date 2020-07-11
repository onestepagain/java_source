package com.atguigu.test01;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

/*
 * 示例2：
 * 	 有一个数组，存储了5个学生对象，这个学生类的自然排序是按照编号排序。但是我希望这个数组是按照姓名排序
 * 
 * Comparator符合SAM接口的特征： public abstract int compare(T t1, T t2)
 */
public class Test02 {
	@Test
	public void test04(){
		Student[] arr = new Student[5];
		arr[0] = new Student(1,"zhangsan");
		arr[1] = new Student(2,"lisi");
		arr[2] = new Student(3,"wangwu");
		arr[3] = new Student(4,"zhaoliu");
		arr[4] = new Student(5,"qianqi");
		
		Arrays.sort(arr, (o1, o2)-> o1.getName().compareTo(o2.getName()));//按照元素的姓名定制排序
		for (Student student : arr) {
			System.out.println(student);
		}
	}
	
	@Test
	public void test03(){
		Student[] arr = new Student[5];
		arr[0] = new Student(1,"zhangsan");
		arr[1] = new Student(2,"lisi");
		arr[2] = new Student(3,"wangwu");
		arr[3] = new Student(4,"zhaoliu");
		arr[4] = new Student(5,"qianqi");
		
		Arrays.sort(arr, new Comparator<Student>(){
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});//按照元素的姓名定制排序
		for (Student student : arr) {
			System.out.println(student);
		}
	}
	
	@Test
	public void test02(){
		Student[] arr = new Student[5];
		arr[0] = new Student(1,"zhangsan");
		arr[1] = new Student(2,"lisi");
		arr[2] = new Student(3,"wangwu");
		arr[3] = new Student(4,"zhaoliu");
		arr[4] = new Student(5,"qianqi");
		
		Arrays.sort(arr, new NameComparator());//按照元素的姓名定制排序
		for (Student student : arr) {
			System.out.println(student);
		}
	}
	
	@Test
	public void test01(){
		Student[] arr = new Student[5];
		arr[0] = new Student(1,"zhangsan");
		arr[1] = new Student(2,"lisi");
		arr[2] = new Student(3,"wangwu");
		arr[3] = new Student(4,"zhaoliu");
		arr[4] = new Student(5,"qianqi");
		
		Arrays.sort(arr);//按照元素的自然顺序排列
		for (Student student : arr) {
			System.out.println(student);
		}
	}
}
class NameComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
}


class Student implements Comparable<Student>{
	private int id;
	private String name;
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Student() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Student o) {
		return this.id - o.id;
	}
}