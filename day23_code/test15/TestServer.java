package com.atguigu.test15;

import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 从客户端发送文件到服务器端
 * (1)接收客户端的连接
 * (2)接收文件名.后缀名
 * 思考：
 * 	 存哪里   ①在当前项目中找一个位置存储，例如：upload文件夹
 *  如何解决文件名重名的问题         文件名需要处理，加入时间戳或其他的唯一编码的UUID等值
 *  .后缀名需要保留，因为它代表文件的类型
 * (3)接收文件内容
 * (4)反馈结果
 * 
 * 思考：
 * 		这里既要接收文件名.后缀名，又要接收文件内容。
 * 		这里既有  文本信息“文件名.后缀名”，又有其他类型的数据“文件内容”，只能选择字节流。
 * 
 * 		如何区别，文件名.后缀名   与  文件内容呢
 * 		想哪种字节输入流，可以处理字符串，和字节类型的数据。
 * 
 * 		FileInputStream
 * 		BufferedInputStream
 * 		DataInputStream
 * 		ObjectInputStream
 * 
 * 		这些里面：DataInputStream：readUTF() 和  read(byte[])
 * 				ObjectInputStream也可以，但是麻烦，我这里选择DataInputStream
 * 
 *  加一个条件：同时多个客户端给服务器发送文件，客户端不用修改，服务器端加入多线程
 */
public class TestServer {
	public static void main(String[] args) throws IOException {
		//1、开启服务器
		ServerSocket server = new ServerSocket(9999);
		
		while(true){
			//2、接收客户端的连接
			Socket socket = server.accept();
			
			FileUploadThread ft = new FileUploadThread(socket);
			ft.start();
		
		}
//		server.close();//不关闭服务器
	}
}
class FileUploadThread extends Thread{
	private Socket socket;
	
	public FileUploadThread(Socket socket) {
		super();
		this.socket = socket;
	}

	public void run(){
		try {
			//3、获取输入流
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			//接收文件名.后缀名
			String fileName = dis.readUTF();
			
			//处理文件名
			/*
			 * 希望我要在服务器存储的文件名：   原来的文件名 + 时间戳
			 */
			long timestamp = System.currentTimeMillis();
			//.的下标
			int index = fileName.lastIndexOf(".");
			//后缀名
			String ext = fileName.substring(index);
			// 原来的文件名
			String name = fileName.substring(0, index);
			//新文件名
			String newFileName = "upload/" + name + timestamp + ext;
			
			//创建文件输出流，把接收到的文件内容，写入新文件
			FileOutputStream fos = new FileOutputStream(newFileName);
			
			//接收文件内容
			byte[] data = new byte[1024];
			int len;
			while((len = dis.read(data))!=-1){
				fos.write(data, 0, len);
			}
			
			//还可以给客户端反馈：文件接收完毕
			OutputStream out = socket.getOutputStream();
			PrintStream ps = new PrintStream(out);
			ps.println("文件接收完毕!");
			
			//断开
			fos.close();
			socket.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}