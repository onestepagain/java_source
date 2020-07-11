package com.atguigu.test16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 * 群聊
 */
public class TestClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1、连接服务器
		Socket socket = new Socket("192.168.30.142",9999);
		
		//2、开启两个线程，一个收消息，一个发消息
		SendThread st = new SendThread(socket);
		ReceiveThread rt = new ReceiveThread(socket);
		
		st.start();
		rt.start();
		
		//等发送线程停下来再往下走
		try {
			st.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//让接收数据的线程停下
		rt.setFlag(false);
		
		//等接收线程停下来，再往下走，断开连接
		try {
			rt.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		socket.close();
	}
}
class SendThread extends Thread{
	private Socket socket;
	
	public SendThread(Socket socket) {
		super();
		this.socket = socket;
	}

	public void run(){
		try {
			//键盘输入
			Scanner input = new Scanner(System.in);
			OutputStream out = socket.getOutputStream();
			PrintStream ps = new PrintStream(out);
			while(true){
				//从键盘输入
				System.out.print("请输入要发送的消息：");
				String content = input.nextLine();
				System.out.println("content:" + content);
				
				//给服务器发送
				ps.println(content);
				
				//如果bye，就结束发送
				if("bye".equals(content)){
					break;
				}
			}
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
class ReceiveThread extends Thread{
	private Socket socket;
	private boolean flag = true;
	
	public ReceiveThread(Socket socket) {
		super();
		this.socket = socket;
	}
	
	public void run(){
		try {
			InputStream in = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			
			while(flag){
				String line = br.readLine();
				System.out.println(line);
				if("bye".equals(line)){
					break;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}