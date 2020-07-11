package com.atguigu.test10;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.junit.Test;

public class TestObject2 {
	@Test
	public void test02()throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("obj.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		/*
		 * 当对象已经输出到文件中后，修改了类，再次读取这个文件时，报InvalidClassException。
		 * 报这个错的原因是：流中关于类的serialVersionUID与本地类的serialVersionUID对不上，就会报InvalidClassException错误，
		 * 如何解决？
		 * （1）修改本地的serialVersionUID为流中的serialVersionUID
		 * （2）或者，在当初实现Serializable接口时，就固定一个serialVersionUID，这样每次编译就不会自动生成一个新的serialVersionUID
		 */
		Object obj = ois.readObject();
		//把字节流中的数据，转为一个对象，读取过程中会创建对象，new对象时需要找对象的类型
		System.out.println(obj);
		
		ois.close();
		fis.close();
	}
}
