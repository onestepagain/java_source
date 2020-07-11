package com.atguigu.service;

import java.util.Arrays;

import com.atguigu.bean.Customer;

public class CustomerService {
	private Customer[] all ;//用来存储客户对象
	private int total;//记录实际存储的客户的数量
	
	public CustomerService(){
		all = new Customer[2];
	}
	public CustomerService(int initSize){
		all = new Customer[initSize];
	}
	
	//添加一个客户对象到当前的数组中
	public void addCustomer(Customer c){
		//(1)数组是否已满
		if(total >= all.length){
			System.out.println("数组已满");
			return;
		}
		
		//(2)把c存储all数组中
		//all[total] = c;
		//total++;
		all[total++] = c;
	}
	
	//返回所有已经存储的客户对象
	public Customer[] getAll(){
//		return all;//如果返回all，里面可能有空null
		
/*		Customer[] result = new Customer[total];
		for (int i = 0; i < total; i++) {
			result[i] = all[i];
		}
		return result;*/
		
		return Arrays.copyOf(all, total);//复制一个新数组，长度为total
	}

	//根据客户的编号进行删除客户对象的操作
	public void removeById(int id){
		//（1）确定下标
		int index = id-1;
		
		//（2）检查下标的合理性
		if(index<0 || index>=total){
			System.out.println(id + "对应的客户不存在");//以后这个可以抛异常解决
			return;
		}
		
		//（3）把[index]后面的元素往前移动
		/*
		 * 假设：total = 5
		 * index = 1  移动all[2]->all[1], all[3]-->all[2],all[4]-->all[3]
		 * 移动3个    length = total - index - 1;
		 */
		System.arraycopy(all, index+1, all, index, total-index-1);
		
//		//（4）把最后一个置为null
//		all[total-1] = null;
//		
//		//（5）人数减少
//		total--;
		
		all[--total] = null;
	}

	//根据客户编号查询一个客户对象的方法
	public Customer getById(int id){
		//(1)确定下标
		int index = id -1;
		
		//(2)考虑下标的合理性
		if(index<0 || index>=total){
			System.out.println(id+"客户不存在");
			return null;
		}
		
		//（3）返回[index]位置的客户对象
		return all[index];
	}

	//根据客户编号，替换原来的客户对象
	public void replace(int id, Customer newCustomer){
		//(1)先确定index下标
		int index = id -1;
		
		//(2)检查下标
		if(index<0 || index>=total){
			System.out.println(id + "客户不存在");
			return;
		}
		
		//(3)替换
		all[index] = newCustomer;
	}
}








