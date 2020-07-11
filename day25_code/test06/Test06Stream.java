package com.atguigu.test06;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.Test;

/*
 * StreamAPI：
 * 	 StreamAPI是用来处理数据，处理集合等容器中的数据，处理操作有：查询、筛选、删除、过滤、统计、映射等。
 * 	 希望能够用类似于SQL语法的形式对Java内存中的数据进行处理。
 * 	
 *   SQL是对数据库中的数据进行处理。
 * 
 * 
 * Stream本身不负责存储数据，存储数据是用集合，数组等数据结构。
 * Stream只负责对数据进行处理、加工。
 * 
 * Stream的操作分为三步：
 * 1、创建Stream：告知Stream数据的来源是哪里？
 * 2、加工处理：这个过程可以很多步  0~n
 * 3、终结操作：收集结果
 *  一旦终结就不能再加工了，如果要加工需要重新创建Stream。
 *  
 *  Stream的特点：
 *  （1）Stream本身不负责存储数据，存储数据是用集合，数组等数据结构。
 *  （2）Stream是不可变，一旦修改，就会产生新的Stream对象。Stream不会修改数据源的数据。
 *  （3）Stream的操作是一个延迟操作。所有的操作都必须延迟到终结操作时，一起处理。
 *  
 */
public class Test06Stream {
	@Test
	public void test01(){
		ArrayList<Employee> list= new ArrayList<>();
		list.add(new Employee(1,"张三"));
		list.add(new Employee(1,"张三"));
		
		Stream<Employee> stream = list.stream();
		stream = stream.distinct();//处理，中间操作  
		long count = stream.count();//统计个数   终结操作
		System.out.println(count);
		System.out.println("over");
		System.out.println("--------------------");
		//重新遍历list
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
	}
}
class Employee{
	private int id;
	private String name;
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		System.out.println("比较....");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
