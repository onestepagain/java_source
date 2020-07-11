package com.atguigu.test16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * 
 */
public class TestServer {
	private static ArrayList<Socket> online = new ArrayList<Socket>();
	
	public static void main(String[] args) throws IOException {
		//1、开启服务器
		ServerSocket server = new ServerSocket(9999);
		
		while(true){
			//2、接收客户端的连接
			Socket socket = server.accept();
			
			//把这个客户端加入到online中
			online.add(socket);
			
			//每一个客户端独立的线程
			MessageHandler mh = new MessageHandler(socket);
			mh.start();
		}
	}

	//私有的静态的内部类
	//这里用内部类的原因，是为了用上面的online集合
	private static class MessageHandler extends Thread{
		private Socket socket;
		private String ip;
		
		public MessageHandler(Socket socket) {
			super();
			this.socket = socket;
			this.ip = socket.getInetAddress().getHostAddress();
		}

		public void run(){
			//这个客户端的一连接成功，线程一启动，就可以告诉其他人我上线了
			sendToOthers(ip+"上线了");
			
			/*
			 * （1）接收当前的客户端发送的消息
			 * （2）给其他在线的客户端转发
			 */
			//（1）接收当前的客户端发送的消息
			try {
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader br = new BufferedReader(isr);
				
				String content;
				while((content = br.readLine()) !=null){
					if("bye".equals(content)){
						//给自己发一句bye
						OutputStream out = socket.getOutputStream();
						PrintStream ps = new PrintStream(out);
						ps.println("bye");
						
						break;
					}
					
					//收到一句，转发一句
					sendToOthers(ip+"说:" + content);
				}
				
				sendToOthers(ip+"下线了");
			} catch (IOException e) {
				sendToOthers(ip+"掉线了");
			}
		}
		
		//因为转发的代码也很长，独立为一个方法
		public void sendToOthers(String str){
			//遍历所有online的客户端
			Iterator<Socket> iterator = online.iterator();
			while(iterator.hasNext()){
				Socket on = iterator.next();
				if(!on.equals(socket)){//只给其他客户端转发
					try {
						OutputStream out = on.getOutputStream();
						PrintStream ps = new PrintStream(out);
						
						ps.println(str);
					} catch (IOException e) {
						//说明on这个客户端要么下线了，要么掉线了
						iterator.remove();
					}
				}
			}
		}
	}
	
	
}
