package com.atguigu.test15;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 * 从客户端发送文件到服务器端
 * 
 * 
 * 客户端：
 * （1）从键盘输入文件的路径名，即选择要发送的文件
 * （2）给服务器先把“文件名.后缀名"
 * （3）发送文件内容
 * （4）接收服务器的反馈结果
 * 
 * 这里同样因为既要发送“文件名.后缀名"，又要发送“文件内容”，选择字节流，选择DataOutputStream
 * 
 * 加一个条件：同时多个客户端给服务器发送文件，客户端不用修改
 */
public class TestClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1、连接服务器
		Socket socket = new Socket("192.168.30.142",9999);
		
		//2、从键盘输入文件的路径名，即选择要发送的文件
		Scanner input = new Scanner(System.in);
		System.out.print("请选择你要发送的文件（例如：D:/尚硅谷_190513班_柴林燕_JavaSE/开学典礼所发资料.rar）：");
		String fileName = input.nextLine();
		File file = new File(fileName);
		
		//3、给服务器发送“文件名.后缀名"
		OutputStream out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		
		//发送“文件名.后缀名"
		dos.writeUTF(file.getName());
		
		//4、发送文件内容
		//先从file文件读取内容
		FileInputStream fis = new FileInputStream(file);
		byte[] data = new byte[1024];
		int len;
		while((len = fis.read(data)) != -1){
			//一边读，一边给服务器发送
			dos.write(data,0,len);
		}
		socket.shutdownOutput();//表示发送完毕了
		
		//5、接收反馈
		InputStream in = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		String result = br.readLine();
		System.out.println("结果：" + result);
		
		//6、关闭
		socket.close();
		fis.close();
		input.close();
	}
}
