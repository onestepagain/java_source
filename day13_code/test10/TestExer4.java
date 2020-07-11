package com.atguigu.test10;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 2、匿名内部类练习2
（1）声明一个员工类Employee，有属性：编号、姓名、薪资
（2）在测试类中创建Employee数组
（3）分别调用Arrays.sort(数组，Comparator)，用匿名内部类实现按照编号升序排列
（4）分别调用Arrays.sort(数组，Comparator)，用匿名内部类实现按照薪资升序排列
 */
public class TestExer4 {
	@SuppressWarnings("all")
	public static void main(String[] args) {
		//（2）在测试类中创建Employee数组
		Employee[] all = new Employee[3];
		all[0] = new Employee(2, "张三", 10000);
		all[1] = new Employee(1, "李四", 30000);
		all[2] = new Employee(3, "王五", 20000);
		
		//（3）分别调用Arrays.sort(数组，Comparator)，用匿名内部类实现按照编号升序排列
		Arrays.sort(all, new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				Employee e1 = (Employee) o1;
				Employee e2 = (Employee) o2;
				return e1.getId() - e2.getId();
			}
			
		});
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}
		
//		（4）分别调用Arrays.sort(数组，Comparator)，用匿名内部类实现按照薪资升序排列
		Arrays.sort(all , new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				Employee e1 = (Employee) o1;
				Employee e2 = (Employee) o2;
				
				if(e1.getSalary() > e2.getSalary()){
					return 1;
				}else if(e1.getSalary() < e2.getSalary()){
					return -1;
				}
				return 0;
			}
		});
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}
	}
}
//（1）声明一个员工类Employee，有属性：编号、姓名、薪资
class Employee{
	private int id;
	private String name;
	private double salary;
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
}
