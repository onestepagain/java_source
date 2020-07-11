package com.atguigu.test06;

import java.util.Arrays;

/*
 * Object：是所有引用数据类型的根父类
 * 
 * 那么根据多态，Object类型的变量，形参，就可以接收任意的引用数据类型的对象，包括数组
 * 
 * 和数组有关的常用的方法：java.lang.System类
 *  public static native void arraycopy(Object src,  int  srcPos,Object dest, int destPos,int length);
 *  第一个参数：src  原数组对象
 *  第二个参数：srcPos  从原数组的[srcPos]下标开始复制
 *  第三个参数：dest  目标数组对象
 *  第四个参数：destPos  目标数组从[destPos]开始存储
 *  第五个参数：length  表示从原数组复制几个元素
 *  说明：如果src和dest是同一个数组的话，那么就会实现数组的元素的移动效果
 *  
 *  srcPos > destPos ：往左移动      一般用于删除
 *  srcPos < destPos ：往右移动      一般用于插入
 */
public class TestSystemArrayCopy {
	public static void main(String[] args) {
		String[] arr = {"hello","world","java",null,null};
		int total = 3;//实际的总元素
		
/*		//实现删除arr[0]元素
		System.arraycopy(arr, 1, arr, 0, 2);
		arr[2] = null;*/
		
		//实现在“hello"和"world"中间插入"atguigu"
		System.arraycopy(arr, 1, arr, 2, 2);
		arr[1] = "atguigu";
		
		System.out.println(Arrays.toString(arr));
	}
}
