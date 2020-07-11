package com.atguigu.test13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 服务器端：
 * 	(1)接收客户端的连接
 *  (2)接收客户端的词语
 *  (3)把词语“反转”返回给客户端
 *  (2)(3)多次，直到客户端发送"bye"为止
 *  
 *  加一个条件，服务器端可以同时接收n个客户端连接
 *  服务器端得加多线程
 */
public class TestServer {
	public static void main(String[] args) throws IOException {
		//1、开启服务器
		ServerSocket server = new ServerSocket(8989);
		
		boolean flag = true;
		while(flag){
			//2、接收一个客户端的连接
			Socket socket = server.accept();//每个客户端的socket是独立的
			
			//为没一个客户端开启一个独立的线程维护它的通信
			MessageHandler mh = new MessageHandler(socket);
			mh.start();
		}
			
		//5、关闭服务器
		server.close();
	}
}
class MessageHandler extends Thread{
	private Socket socket;
	
	public MessageHandler(Socket socket) {
		super();
		this.socket = socket;
	}

	public void run(){
		try {
			//3、先获取输入流和输出流
			InputStream in = socket.getInputStream();
			/*
			 * 因为是接收一个词语，反转一个，返回一个
			 * 那么如果仅仅使用字节流，不好区分词语
			 * 需要用到字符流
			 * 那么就意味着需要把字节流转为字符流
			 */
			InputStreamReader isr = new InputStreamReader(in);//这里不涉及编码问题，仅仅为了转换流的类型
			/*
			 * 字符流中几个字符是一个词语
			 * 那么我们这里选择“换行符”来作为词语的分割
			 * 意味着我们可以按行读取Scanner或BufferedReader
			 */
			BufferedReader br = new BufferedReader(isr);
			
			OutputStream out = socket.getOutputStream();
			/*
			 * 客户端收到字节，同样不方便处理几个字节是一个词语，仍然要把字节输出流转为字符流
			 * 而且字符之间也不好区分，那么也选择“换行符”进行区别词语
			 * 我们现在需要把OutputStream转为一个可以按行写的字符流或其他的处理流
			 * 
			 * 可以按行写的：BufferedWriter(newLine())
			 * 		   PrintStream(println())
			 */
			PrintStream ps = new PrintStream(out);
			
			//从客户端接收词语
			String word;
			while((word = br.readLine()) != null){
				if("bye".equals(word)){
					break;
				}
				
				//如果不是bye，要反转，并且返回
				StringBuilder sb = new StringBuilder(word);
				sb.reverse();
				
				//返回给客户端
				ps.println(sb.toString());
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				//4、断开
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}