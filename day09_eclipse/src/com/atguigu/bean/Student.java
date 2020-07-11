package com.atguigu.bean;

/*
 * 自动生成代码：
 * 1、构造器
 * 2、get/set
 * 
 * Alt + Shift  + S：或者选Source菜单：
 * 	（1）构造器
 * Generate Constructor using Fields...
 * （2）get/set
 * Generate Getters And Setters...
 */
public class Student {
	private String name;
	private int age;
	private char gender;
	private double score;
	
	public Student() {
		
	}

	public Student(String name, int age, char gender, double score) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.score = score;
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	
}
