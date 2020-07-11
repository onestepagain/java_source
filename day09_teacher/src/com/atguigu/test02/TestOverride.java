package com.atguigu.test02;

/*
 * 方法的重写：Override
 * 当子类继承了父类的方法时，但是父类的方法体不适用于子类了，那么子类可以选择进行“重写overwrite”。
 * 
 * 方法 = 方法签名/方法头 + 方法体
 * 
 * 重写有要求：
 * （1）方法名：必须和父类被重写的方法名“相同”
 * （2）形参列表：必须和父类被重写的形参列表“相同”
 * （3）返回值类型：
 * 	   基本数据类型和void：要求与父类被重写的方法的返回值类型“相同”
 *   引用数据类型：要求子类重写的方法的返回值类型 <= 父类被重写的方法的返回值类型
 *   		例如：
 *   			子类方法的返回值类型是Student，父类被重写方法的返回值类型是Student
 *   			子类方法的返回值类型是Student，父类被重写方法的返回值类型是Person
 *   			子类方法的返回值类型是Person，父类被重写方法的返回值类型是Student（错误的）
 * （4）修饰符
 * ①权限修饰符：子类重写的方法的权限修饰符的可见性范围 >= 父类被重写方法的权限修饰符的可见性范围
 * 			例如：
 * 				子类方法的权限修饰符是public，父类被重写方法的权限修饰符public
 * 				子类方法的权限修饰符是public，父类被重写方法的权限修饰符protected
 * ②其他修饰符（后面讲）
 */
public class TestOverride {
	public static void main(String[] args) {
		Manager m = new Manager("崔志恒", 20000,1000);
		System.out.println(m.getInfo());
	}
}
//员工
class Employee{
	//属性列表
	private String name;
	private double salary;
	//构造器列表
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	public Employee() {
	}
	//get/set
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
	public String getInfo(){
		return "姓名：" + name + "，薪资：" + salary;
	}
}
//经理
class Manager extends Employee{
	//子类的属性列表
	private double bonus;//奖金

	//子类的构造器列表
	public Manager(String name, double salary, double bonus) {
		super(name, salary);
		this.bonus = bonus;
	}

	public Manager() {
	}

	//子类的get/set
	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	//重写父类的getInfo()
	public String getInfo(){
		//父类的name和salary的属性是私有的，不能在子类中直接使用
		//return "姓名：" + name + "，薪资："+salary + "，奖金" + bonus;
		return "姓名：" + getName() + "，薪资："+ getSalary() + "，奖金" + bonus;
	}
}