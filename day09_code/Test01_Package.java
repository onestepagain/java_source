/*
包：

1、包的作用
（1）避免类的重名问题
有了包后，类的名称就比较长了，类的全名称就变为了：包.类名
回忆:
	java.util.Scanner ：Scanner类的全名称
	java.lang.String：String类的全名称
	java.lang.System：System类的全名称
	java.lang.Math：Math类的全名称
（2）分类组织管理众多的类
java.io：和IO(输入输出)有关
java.util：和各种常用工具类有关
java.lang：核心系统类
java.net：和网络编程有关
java.sql：和数据库编程有关
（3）用于访问权限控制
如果某个类或某个方法的权限修饰符省略，那么就仅限于本包使用

2、如何声明包？
语法格式：
package 包名;

这句话有要求：
（1）一个.java源文件只能有一句
（2）必须在源文件的代码首行

包名的命名规范：
（1）所有单词都小写，每个单词之间用.分割
（2）习惯上用公司的域名倒置 + 模块名
例如：com.atguigu.xx;
      com.mysql.xxx
	  com.alibaba.xxx
	  org.aphache.xxx
	  
一级域名：
		com：商业
		org：非营利性组织
		gov：政府
		edu：教育
		....

3、如何编译带包的类
了解：
	javac -d . 源文件名.java		
4、如何运行带包的类
了解：
	java 包.类名
5、如何使用其他包的类
前提：被使用的类或成员的权限修饰符得允许跨包使用
方式：
（1）使用全名称：包.类名
（2）使用import语句 + 简名称	

说明：
①import 语句是写在  package语句与class声明之间的
②导包语句可以很多句，导不同包的类
③java.lang包中类可以不使用import语句，就直接使用简名称
例如：System，String，Math....
④可以同时导入同一个包中的很多类
import 包.*;
⑤如果出现了不同包，但是类名相同
例如：
	java.util.Date
	java.sql.Date
只能一个选择使用全名称，一个使用简名称，不能同时使用简名称
*/
package com.atguigu.pkg;

import com.atguigu.bean.*;
import java.util.Date;
//import java.sql.Date;

class Test01_Package{
	public static void main(String[] args){
		System.out.println("hello pkg");
		
		//用另外一个包的类
		Circle c1 = new Circle(1.2);
		//com.atguigu.bean.Circle c1 = new com.atguigu.bean.Circle(1.2);
		c1.printInfo();
		
		Rectangle r1 = new Rectangle();
		
		
		
	}
}
