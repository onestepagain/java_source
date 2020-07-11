package com.atguigu.test05;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

/*
 * Writer:
 * (1)void write(int c)  ：写单个字符
 * (2)void write(char[] cbuf)  ：把整个字符数组的内容都写出去
 * (3)void write(char[] cbuf, int off, int len) ：把cbuf[off]开始，len个字符写出去
 * (4)void write(String str) ：把str的内容都写出去
 * (5)void write(String str, int off, int len) ：把str从[off]开始len个字符写出去
 * (6)void close() 关闭
 * (7)void flush() 刷新
 * 
 * 二、写一些数据到纯文本文件中
 * 步骤：
 * （1）选择IO流，并创建对象
 * （2）读/写
 * （3）关闭
 */
public class TestFileWriter {
	@Test
	public void test02() throws IOException{
		Scanner input = new Scanner(System.in);
		System.out.print("请输入一句话：");
		String str = input.nextLine();
		
		//1、选择IO流，并创建对象
		FileWriter fw = new FileWriter("1.txt",true);
		
		//2、写数据
		fw.write("\n");
		fw.write(str);
		
		//3、关闭
		fw.close();
		input.close();
	}
	
	@Test
	public void test01() throws IOException{
		Scanner input = new Scanner(System.in);
		System.out.print("请输入一句话：");
		String str = input.nextLine();
		
		//1、选择IO流，并创建对象
		FileWriter fw = new FileWriter("1.txt");
		
		//2、写数据
		fw.write(str);
		
		//3、关闭
		fw.close();
		input.close();
	}
}
