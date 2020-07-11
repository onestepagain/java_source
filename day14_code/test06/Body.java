package com.atguigu.test06;

import java.util.Random;

public class Body {
	private String owner;
	private double weight;//克
	private boolean health;
	private Organ heart;
	
	public Body(String owner, double weight, boolean health) {
		super();
		this.owner = owner;
		this.weight = weight;
		this.health = health;
		
		Heart heart =  new Heart();
		heart.size = weight * 0.005;
		Random rand = new Random();
		if(health){
			heart.color = "鲜红色";
			//rand.nextInt(41)==>[0,41),[0,40]
			//60-100
			heart.beatPerMinute = rand.nextInt(41) + 60;
		}else{
			heart.color = "暗红色";
			//[0,60) 或 [101,~)
			heart.beatPerMinute  = rand.nextInt(60);
		}
		
		this.heart = heart;
	}
	
	private class Heart extends Organ{
		int beatPerMinute;//每分钟跳动次数
		String color;
		double size;
		
		@Override
		public void doWork() {
			System.out.println("心率：" + beatPerMinute + ",大小：" + size + "，颜色：" + color);
			//这里的owner属性是创建Heart对象的那个Body对象
			//即非静态内部类的对象，一直记录着是哪个外部对象创建的它  Body.this
//			System.out.println("为血液流动提供动力，把血液运行至" + owner + "身体各个部分");
			System.out.println("为血液流动提供动力，把血液运行至" + Body.this.owner + "身体各个部分");
		}
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public boolean isHealth() {
		return health;
	}

	public void setHealth(boolean health) {
		this.health = health;
	}

	public Organ getHeart() {
		return heart;
	}

	public void setHeart(Organ heart) {
		this.heart = heart;
	}

	@Override
	public String toString() {
		return "姓名：" + owner + ", 体重：" + weight + "，健康与否：" + health;
	}
	
}
