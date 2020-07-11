package com.atguigu.test03;

import java.io.File;
import java.io.FileFilter;

import org.junit.Test;

/*
 * 文件或目录过滤器
 * File类中
 * File[]  listFiles(FileFilter f)
 */
public class Test03 {
	@Test
	public void test01(){
		//列出D:\atguigu\javaee\JavaSE20190513\code\day01_code目录下的所有的.java文件
		File dir = new File("D:/atguigu/javaee/JavaSE20190513/code/day01_code");
		File[] listFiles = dir.listFiles(new FileFilter() {
			
			//File pathname表示dir这个目录的下一级的每一个文件或目录
			//这个方法返回true，说明要保留的
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".java");
			}
		});
		
		for (File file : listFiles) {
			System.out.println(file);
		}
	}
	
	@Test
	public void test02(){
		//列出D:\atguigu\javaee\JavaSE20190513\code\day01_code目录下的所有的.java文件
		//并源文件名中包含Test这个单词
		File dir = new File("D:/atguigu/javaee/JavaSE20190513/code/day01_code");
		File[] listFiles = dir.listFiles(new FileFilter() {
			
			//File pathname表示dir这个目录的下一级的每一个文件或目录
			//这个方法返回true，说明要保留的
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".java") && pathname.getName().contains("Test");
			}
		});
		
		for (File file : listFiles) {
			System.out.println(file);
		}
	}
	
	@Test
	public void test03(){
		//列出D:\atguigu\javaee\JavaSE20190513\code\day01_code目录下的所有的文件名的长度超过10个字符的
		File dir = new File("D:/atguigu/javaee/JavaSE20190513/code/day01_code");
		File[] listFiles = dir.listFiles(new FileFilter() {
			
			//File pathname表示dir这个目录的下一级的每一个文件或目录
			//这个方法返回true，说明要保留的
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().length()>10;
			}
		});
		
		for (File file : listFiles) {
			System.out.println(file);
		}
	}
}
