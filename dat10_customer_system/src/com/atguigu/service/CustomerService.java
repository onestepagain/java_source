package com.atguigu.service;

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
}
