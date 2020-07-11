package com.atguigu.test05;

/*
 * java.util.Comparator：定制比较，定制顺序
 * 		int compare(Object o1, Object o2)：
 * 				o1与o2比较，o1>o2，返回正整数
 * 				o1与o2比较，o1<o2，返回负整数
 * 				o1与o2比较，o1=o2，返回0
 * java.lang.Comparable：自然比较，自然顺序
 * 		int compareTo(Object obj)
 * 				this与obj对象比较，this > obj，返回正整数
 * 				this与obj对象比较，this < obj，返回负整数
 * 				this与obj对象比较，this = obj，返回0
 * 
 * 上午讲的定制比较器，用定制比较器的对象，比较两个学生对象：
 * 		AgeComparator c = new AgeComparator();
 * 		if(c.compare(s1, s2) > 0){...}
 * 
 * 希望学生对象本身就具备比较大小的能力。
 */
public class TestComparable {
	public static void main(String[] args) {
		Student s1 = new Student("杨洪强", 24, 89);
		Student s2 = new Student("苏海波", 23, 100);
		
		//按成绩比较
		if(s1.compareTo(s2)>0){
			System.out.println("s1 > s2成绩");
		}else if(s1.compareTo(s2)<0){
			System.out.println("s1 < s2成绩");
		}else{
			System.out.println("s1 = s2成绩");
		}
		
		//按年龄比较，只能再用定制比较，补充完成这个功能
	}
}
class Student implements Comparable{
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
	@Override
	public int compareTo(Object obj) {
		//this与obj比较，this和obj都是学生对象
		Student other = (Student) obj;
		//例如：对于学生对象来说，最常用的是按成绩排名，那么我就可以把自然顺序定位成绩升序
/*		if(this.score > other.score){
			return 1;
		}else if(this.score < other.score){
			return -1;
		}
		return 0;*/
		
		return this.score - other.score;
	}
}