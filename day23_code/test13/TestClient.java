package com.atguigu.test13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 * 客户端：
 * （1）从键盘输入词语
 * （2）发送给服务器
 * （3）接收服务器返回的结果
 * （1）（2）（3）多次进行，直到键盘输入bye并发送给发服务器之后就结束
 * 
 * 加一个条件，服务器端可以同时接收n个客户端连接
 * 客户端代码不用修改
 */
public class TestClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1、连接服务器
		Socket socket = new Socket("192.168.30.142",8989);
		
		/*
		 *  * （1）从键盘输入词语
		 * （2）发送给服务器
		 * （3）接收服务器返回的结果
		 * （1）（2）（3）多次进行，直到键盘输入bye并发送给发服务器之后就结束
		 */
		Scanner input = new Scanner(System.in);
		/*
		 * 同样考虑到发送词语，以及词语之间分割问题，那我们选择PrintStream和BufferedReader
		 */
		PrintStream ps = new PrintStream(socket.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		while(true){
			//从键盘输入词语
			System.out.print("请输入词语：");
			String word = input.next();
			
			//发送给服务器端
			ps.println(word);
			
			if("bye".equals(word)){
				break;
			}
			
			//接收服务器返回的结果
			String result = br.readLine();
			System.out.println("服务器返回的反转后的结果：" + result);
		}
		
		input.close();
		socket.close();
	}
}
