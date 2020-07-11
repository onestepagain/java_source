package com.atguigu.day14homework;

/*
 * 
 */
public class Test06 {
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();//好比创建了火车
		
		//上车
		list.add("杨洪强");
		list.add("崔志恒");
		list.add("杜冠军");
		
		//想一想：MyArrayList的list对象，all.length=4，total=3
		//MyArrayList的list的list对象中all的length，添加杜冠军时，发现不够了，扩容为4个
		
		list.remove(1);//崔志恒被删除，杜冠军成为[1]的元素
		
		list.set(1, "李四");//杜冠军被替换为“李四”
		
		Object object = list.get(1);
		System.out.println(object);
		
		//验证
		//方法一（1）直接获取all
	/*	Object[] all = list.getAll();
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}
		System.out.println("total：" + list.getTotal());*/
		//方法二：（2）通过list的选择器，迭代器遍历
		Selector select = list.select();//得到车上的乘务员对象
		while(select.hasNext()){
			Object next = select.next();
			System.out.println(next);
		}
		
	}
}
