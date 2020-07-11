package com.atguigu.bean;

public class Rectangle{
	private double length;
	private double width;
	
	public Rectangle(){
	}
	public Rectangle(double chang,double kuan){
		length = chang;
		width = kuan;
	}
	public void printInfo(){
		System.out.println("³¤£º" + length+ "£¬¿í£º" + width);
	}
}