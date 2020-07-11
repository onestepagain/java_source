package com.atguigu.test06;

public class Doctor {
	public void swapHeart(Body b1, Body b2){
		Organ temp = b1.getHeart();
		b1.setHeart(b2.getHeart());
		b2.setHeart(temp);
		
		boolean hTemp = b1.isHealth();
		b1.setHealth(b2.isHealth());
		b2.setHealth(hTemp);
	}
}
