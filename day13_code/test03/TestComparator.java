package com.atguigu.test03;

import java.util.Arrays;
import java.util.Comparator;

/*
 * java.util.Comparator<T>接口：
 *   抽象方法：int compare(T o1, T o2)
 *   
 * 因为<T>是泛型，我们还没讲。现在就把T擦除，换成Object
 * 
 * java.util.Comparator接口：
 * 		抽象方法：int compare(Object o1, Object o2)
 * 这个接口是代表Java中比较两个对象的大小标准。而且是一种“定制”比较的标准。
 * 这个接口中没有规定如何比较两个对象的大小，
 * 但是规定了，如果你认为o1 大于  o2，就返回正整数表示
 * 		        如果你认为o1 小于  o2，就返回负整数表示
 * 		       如果你认为o1 等于  o2，就返回0表示
 *
 */
public class TestComparator {
	public static void main(String[] args) {
		Student s1 = new Student("杨洪强", 24, 89);
		Student s2 = new Student("苏海波", 23, 100);
		
		//比较s1和s2的大小
		/*if(s1 > s2){//错误的
			System.out.println("s1 > s2");
		}*/
		AgeComparator c = new AgeComparator();
		if(c.compare(s1, s2) > 0){//如果比较s1，s2的结果是正整数，说明s1>s2
			System.out.println("s1 > s2的年龄");
		}else if(c.compare(s1, s2) <0){
			System.out.println("s1 < s2的年龄");
		}else{
			System.out.println("s1 = s2的年龄");
		}
		
		ScoreComparator s = new ScoreComparator();
		if(s.compare(s1, s2) > 0){//如果比较s1，s2的结果是正整数，说明s1>s2
			System.out.println("s1 > s2的成绩");
		}else if(s.compare(s1, s2) <0){
			System.out.println("s1 < s2的成绩");
		}else{
			System.out.println("s1 = s2的成绩");
		}
		System.out.println("-------------------------------------");
		
		Student[] all = new Student[5];
		all[0] = s1;
		all[1] = s2;
		all[2] = new Student("张三",23,88);
		all[3] = new Student("李四",24,44);
		all[4] = new Student("王五",25,45);
		
		//Arrays工具类
//		Arrays.sort(all);
		/*
		 * public static void sort(Object[] a, Comparator c)
		 * 第一个形参：需要排序的数组，Object[]说明可以是任意类型的对象数组
		 * 第二个形参：比较器对象     Comparator接口不能创建对象，只能传入实现类对象
		 */
//		Arrays.sort(all, new AgeComparator());
		//按照成绩必须交
		Arrays.sort(all, new ScoreComparator());
		
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}
	}
}
//实现Comparator接口，来定制两个学生比较的具体实现方式
//例如：按照年龄比较
class AgeComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		//（1）向下转型
		Student s1 = (Student) o1;
		Student s2 = (Student) o2;
		
		//（2）开始比较
		if(s1.getAge() > s2.getAge()){
			return 1;
		}else if(s1.getAge() < s2.getAge()){
			return -1;
		}
		return 0;
	}
	
}

//实现Comparator接口，来定制两个学生比较的具体实现方式
//例如：按照成绩比较
class ScoreComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		//（1）向下转型
		Student s1 = (Student) o1;
		Student s2 = (Student) o2;
		
		//（2）开始比较
		if(s1.getScore() > s2.getScore()){
			return 1;
		}else if(s1.getScore() < s2.getScore()){
			return -1;
		}
		return 0;
	}
	
}

class Student{
	private String name;
	private int age;
	private int score;
	public Student(String name, int age, int score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
	}
	
}