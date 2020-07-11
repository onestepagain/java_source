package com.atguigu.homework.test04;

public class Test04 {
	public static void main(String[] args) {
		Worker w = new Worker();
		
		Apple a1 = new Apple(5.0, "青色");
		Apple a2 = new Apple(3.0, "红色");
		CompareBig cb = new CompareBig();
		w.pickApple(cb, a1, a2);
		
		CompareColor cc = new CompareColor();
		w.pickApple(cc, a1, a2);
	}
}
