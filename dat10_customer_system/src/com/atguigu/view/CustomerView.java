package com.atguigu.view;

import com.atguigu.bean.Customer;
import com.atguigu.service.CustomerService;
import com.atguigu.utils.CMUtility;

public class CustomerView {
	private CustomerService cs = new CustomerService();
	
	public void menu(){
		while(true){
			System.out.println("-----------------客户信息管理软件-----------------");
	
			System.out.println("\t\t1 添 加 客 户");
			System.out.println("\t\t2 修 改 客 户");
			System.out.println("\t\t3 删 除 客 户");
			System.out.println("\t\t4 客 户 列 表");
			System.out.println("\t\t5 退           出");
	
			System.out.print("请选择(1-5)：");
			char select = CMUtility.readMenuSelection();
			switch(select){
			case '1':
				add();
				break;
			case '2':
				update();
				break;	
			case '3':
				delete();
				break;
			case '4':
				list();
				break;
			case '5':
				System.out.println("确定退出吗？Y/N");
				char confirm = CMUtility.readConfirmSelection();
				if(confirm == 'Y'){
					return;
				}
			}
		}
	}

	private void list() {
	}

	private void delete() {
	}

	private void update() {
	}

	private void add() {
		System.out.println("---------------------添加客户---------------------");
		//（1）键盘输入客户信息
		System.out.print("姓名：");
		String name = CMUtility.readString(20);
		
		System.out.print("性别：");
		char gender = CMUtility.readChar();
//		char gender  = CMUtility.readChar('男');//如果用户不输入，用'男'代替
		
		System.out.print("年龄：");
		int age = CMUtility.readInt();
		
		System.out.print("电话：");
		String phone = CMUtility.readString(11);
		
		System.out.print("邮箱：");
		String email = CMUtility.readString(32);
		
		//（2）创建Customer对象
		Customer c = new Customer(name, gender, age, phone, email);
		
		//（3）调用CustomerService的
		//addCustomer(Customer c)
//		CustomerService cs = new CustomerService();//不应该是局部变量
		cs.addCustomer(c);
		
		System.out.println("---------------------添加完成---------------------");
	}
}
