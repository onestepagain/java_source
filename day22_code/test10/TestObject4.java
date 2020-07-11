package com.atguigu.test10;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class TestObject4 {
	@Test
	public void test02(){
		Husband h = new Husband();
		Wife wife = new Wife();
		
		h.setName("崔志恒");
		wife.setName("石榴");
		
		h.setWife(wife);
		wife.setHusband(h);
		
		System.out.println(h);
	}
	
	@Test
	public void test01()throws Exception {
		Husband h = new Husband();
		Wife wife = new Wife();
		
		h.setName("崔志恒");
		wife.setName("石榴");
		
		h.setWife(wife);
		wife.setHusband(h);
		
		FileOutputStream fos = new FileOutputStream("marry.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(h);
		/*
		 * java.io.NotSerializableException: com.atguigu.test10.Wife
		 * 虽然Husband实现了Serializable，但是因为在序列化Husband过程中，包含wife对象，所以要求Wife类也要实现Serializable接口
		 */
		
		oos.close();
		fos.close();
	}
}
