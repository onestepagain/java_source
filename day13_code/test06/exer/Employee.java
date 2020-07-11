package com.atguigu.test06.exer;

/*
 * 接口的练习2：
（1）声明一个员工类Employee，有属性：编号、姓名、年龄、薪资
（2）让Employee员工类实现java.lang.Comparable接口，
		重写抽象方法，按照编号从小到大排序
 */
public class Employee implements Comparable{
	
	private int id;
	private String name;
	private int age;
	private double salary;
	public Employee(int id, String name, int age, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public Employee() {
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
	//重写抽象方法，按照编号从小到大排序
	@Override
	public int compareTo(Object o) {
		return this.id - ((Employee)o).id;
	}
	
}
