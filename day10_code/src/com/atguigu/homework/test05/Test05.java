package com.atguigu.homework.test05;

public class Test05 {
	public static void main(String[] args) {
		Book[] all = new Book[4];
		
		all[0] = new Book(1, "《西游记》", "吴承恩", 88, 100, 200);
		all[1] = new Book(2, "《红楼梦》", "曹雪芹", 56, 800, 100);
		all[2] = new Book(3, "《三国演义》", "罗贯中", 77, 500, 800);
		all[3] = new Book(4, "《水浒传》", "施耐庵", 66, 54, 600,"static/img/shui.jpg");
		
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i].getInfo());
		}
		
		for (int i = 1; i < all.length; i++) {
			for (int j = 0; j < all.length-i; j++) {
				if(all[j].getSales() < all[j+1].getSales()){
					Book temp = all[j];
					all[j] = all[j+1];
					all[j+1] = temp;
				}
			}
		}
		
		System.out.println("----------------------------------");
		System.out.println("编号\t书名\t\t作者\t价格\t销量\t库存量\t图片");
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i].getInfo());
		}
	}
}
