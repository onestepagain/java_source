package com.atguigu.homework.test07;


public class Test07 {
	public static void main(String[] args) {
		Worker w = new Worker();
		
		Apple a1 = new Apple(5.0, "青色");
		Apple a2 = new Apple(3.0, "红色");
		
		w.pickApple(new CompareAble(){}, a1, a2);
		
		
		w.pickApple(new CompareAble() {
			public void compare(Apple a1, Apple a2){
				if("红色".equals(a1.getColor())){
					System.out.println(a1);
				}
				if("红色".equals(a2.getColor())){
					System.out.println(a2);
				}
			}
		}, a1, a2);
	}
}
