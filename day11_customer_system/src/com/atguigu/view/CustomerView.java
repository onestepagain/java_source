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
		//（1）调用CustomerService类的getAll方法获取已经存储的所有客户对象
		Customer[] all = cs.getAll();
		
		//（2）遍历显示
		System.out.println("---------------------------客户列表---------------------------");
		System.out.println("编号\t姓名\t性别\t年龄\t电话\t邮箱");
		for (int i = 0; i < all.length; i++) {
			//打印客户对象的信息
			System.out.println( (i+1) + "\t" +all[i].getInfo());
		}
		System.out.println("-------------------------客户列表完成-------------------------");
	}

	private void delete() {
		System.out.println("---------------------删除客户---------------------");
		System.out.print("请选择待删除客户编号(-1退出)：");
		int id = CMUtility.readInt();
		
		if(id == -1){//如果是-1就结束
			return;
		}
		
		System.out.print("确认是否删除(Y/N)：");
		char confirm = CMUtility.readConfirmSelection();
		if(confirm == 'N'){//如果不删除，就结束
			return;
		}
		
		//调用CustomerService类的removeById(int id)删除
		cs.removeById(id);
		System.out.println("---------------------删除完成---------------------");
	}

	private void update() {
		System.out.println("---------------------修改客户---------------------");
		System.out.print("请选择待修改客户编号(-1退出)：");
		int id = CMUtility.readInt();
		
		if(id == -1){//-1退出
			return;
		}
		
		//调用CustomerSerivce的getById(id)获取该客户对象的原来的信息
		Customer old = cs.getById(id);
		
		//输入新的数据
		System.out.print("姓名(" + old.getName() + ")：");
		//如果用户直接输入回车，没有输入新的姓名，那么就用old.getName()代替，即保持不变
		String name = CMUtility.readString(20, old.getName());
		
		System.out.print("性别(" + old.getGender() +")：");
		char gender = CMUtility.readChar(old.getGender());
		
		System.out.print("年龄(" + old.getAge() +")：");
		int age = CMUtility.readInt(old.getAge());
		
		System.out.print("电话(" + old.getPhone() +")：");
		String phone = CMUtility.readString(11, old.getPhone());
		
		System.out.print("邮箱(" + old.getEmail() +")：");
		String email = CMUtility.readString(32, old.getEmail());
		
		//创建一个新的客户对象
		Customer newCustomer = new Customer(name, gender, age, phone, email);
	
		//替换数组中原来的客户对象
		//调用CustomerService的replace(id,newCustomer)
		cs.replace(id, newCustomer);
		
		System.out.println("---------------------修改完成---------------------");
		
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
