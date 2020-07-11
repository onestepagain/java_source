package com.atguigu.test06;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test07FileInputStream {
	public static void main(String[] args) throws IOException {
		//（1）选择IO流
		//这里故意选取字节流，因为字节流可以用于处理所有类型的问题
		FileInputStream fis = new FileInputStream("单身狗.jpg");
		
		//（2）读
		byte[] arr = new byte[10];
		int len;
		while((len = fis.read(arr)) != -1){
//			System.out.println(Arrays.toString(arr));
			
			//字节数组-->字符串  new String(byte[],off,len)
			System.out.println(new String(arr,0,len));//乱码，因为图片无法在控制台显示
		}
		
//		（3）关闭
		fis.close();
	}
}
