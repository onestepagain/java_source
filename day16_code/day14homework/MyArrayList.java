package com.atguigu.day14homework;

import java.util.Arrays;

public class MyArrayList implements Touchable{
	private Object[] all = new Object[2];//用来存对象
	private int total;//记录实际存储的对象的个数
	
	public void add(Object element){
		if(total >= all.length){
			all = Arrays.copyOf(all, all.length*2);
		}
		
		all[total++] = element;
	}
	public void remove(int index){
		if(index<0 || index>=total){
			System.out.println("没有这个元素");
			return;
		}
		
		System.arraycopy(all, index+1, all, index, total-index-1);
		all[total-1] = null;
		total--;
	}
	
	public void set(int index ,Object value){
		if(index<0 || index>=total){
			System.out.println("没有这个元素");
			return;
		}
		
		all[index] = value;//替换
	}
	public Object get(int index){
		if(index<0 || index>=total){
			System.out.println("没有这个元素");
			return null;
		}
		
		return all[index];
	}
	@Override
	public Selector select() {
		return new MySelector();
	}
	
	/*
	 * MySelector对象，是用来遍历，访问MyArrayList容器中的元素用的。
	 * MySelector对象好比车上的乘务员对象。
	 * MyArrayList对象好比是车。
	 * all[]数组中装的是乘客。
	 */
	private class MySelector implements Selector{
		int cursor;

		@Override
		public boolean hasNext() {
			return cursor != total;
		}

		@Override
		public Object next() {
			
			return all[cursor++];
		}
		
	}

	public Object[] getAll() {
		return all;
	}
	public int getTotal() {
		return total;
	}
	
	
}
