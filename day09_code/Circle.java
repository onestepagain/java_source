package com.atguigu.bean;

public class Circle{
	private double radius;
	
	public Circle(){
	}
	public Circle(double r){
		radius = r;
	}
	public void printInfo(){
		System.out.println("°ë¾¶£º" + radius);
	}
}