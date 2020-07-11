package com.atguigu.homework.test05;

public class Test05 {
	public static void main(String[] args) {
		User[] all = new User[15];
		for (int i = 0; i < all.length; i++) {
			all[i] = new User(null, i+1);
		}
		
		Receptionist r1 = new Receptionist();
		r1.setFilter(new V1Filter());
		
		Receptionist r2 = new Receptionist();
		r2.setFilter(new V2Filter());
		
		Receptionist r3 = new Receptionist();
		r3.setFilter(new AFilter());
		
		for (int i = 0; i < all.length; i++) {
			if(all[i].getId() >=1 && all[i].getId()<=5){
				r1.recept(all[i]);
			}else if(all[i].getId() >=6 && all[i].getId()<=10){
				r2.recept(all[i]);
			}else{
				r3.recept(all[i]);
			}
		}
		
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}
	}
}
