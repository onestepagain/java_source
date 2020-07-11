package com.atguigu.test03;

import java.util.HashMap;

import org.junit.Test;

/*
 * JDK1.8时Map接口增加了一个方法：
 * 	  default void replaceAll(BiFunction<? super K,? super V,? extends V> function)
 */
public class Test05Lambda3 {
	@Test
	public void test01(){
		HashMap<String,Employee> map = new HashMap<>();
		map.put("张三", new Employee("张三", 8000));
		map.put("李四", new Employee("李四", 9000));
		map.put("王五", new Employee("王五", 12000));
		map.put("赵六", new Employee("赵六", 11000));
		
		//把原来薪资低于10000元的，修改为薪资为10000元，其他的不变
		/*
		 * replaceAll(BiFunction<? super K,? super V,? extends V> function)
		 * 
		 * replaceAll的形参是BiFunction<T,U,R>接口类型，SAM接口，可以使用Lambda表达式赋值
		 * 
		 * BiFunction<T,U,R>接口：
		 * （1）抽象方法
		 * 		R apply(T t, U u) 
		 * （2）如何实现抽象方法
		 * 		例如：把原来value对象的薪资<10000元的替换（覆盖）为薪资是10000元
		 * 
		 * 如果抽象方法有返回值，那么实现抽象方法时，需要return语句。
		 * 这里看返回值类型是V类型，是value的类型
		 */
		map.replaceAll((String key,Employee emp) -> {
			if(emp.getSalary()<10000){
				emp.setSalary(10000);
			}
			return emp;
		});
		
		//优化
		map.replaceAll((key,emp) -> {
			if(emp.getSalary()<10000){
				emp.setSalary(10000);
			}
			return emp;
		});
	}
}
class Employee {
	private String name;
	private double salary;
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public Employee() {
		super();
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
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
}