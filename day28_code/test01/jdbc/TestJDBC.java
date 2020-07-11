package com.atguigu.test01.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * java.sql包和javax.sql包
 * JDBC是代表一组公共的接口。
 * JDBC中的这些公共接口和DBMS数据库厂商提供的实现类（驱动jar），是为了实现Java代码可以连接DBMS，并且操作它里面的数据而声明的。
 * 
 * 常用的接口：
 * Connection：连接
 * Statement和PreparedStatement：增删改查
 * ResultSet：接收和处理查询结果
 * 
 * 辅助的类：
 * DriverManager：驱动管理类。
 * 
 * JDBC程序的编写步骤：
 * 1、注册驱动（如果这步不做，编译不会报错，运行会报找不到驱动类等异常）
 *     java.sql.SQLException: No suitable driver found for jdbc:mysql://localhost:3306/test
 * 2、连接数据库：
 * 		DriverManager和Connection
 * 3、操作数据库
 * （1）增、删、改：Statement或PreparedStatement
 * （2）查询：Statement或PreparedStatement
 * 			ResultSet
 * 4、断开连接，关闭对应各种资源
 * 
 * url：统一资源定位符，通俗的讲就是网址
 *     url是用来定位到①哪台电脑上的②哪种DBMS数据库软件，③访问哪个数据库，这个DBMS软件目前运行在④哪个断开号⑤连接这个DBMS软件是否还需要其他的参数。
 *     url的标准格式：
 *     		协议://主机名:端口号/资源路径
 *  mysql：
 *  	jdbc:mysql://主机名:端口号/数据库名?其他的参数
 *     例如：
 *     	jdbc:mysql://localhost:3306/test
 *     
 *     
 *  注册驱动三部曲：
 *  （1）把jar放到项目的libs中
 *  （2）把jar添加到build path中   
 *    在jar包上选择右键，Build Path-->Add to Build Path
 *  （3）在代码中注册驱动   
 */
public class TestJDBC {
	public static void main(String[] args) throws Exception {
		//1、注册驱动：把驱动类加载到内存，并且初始化这个类
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、连接数据库
		String url = "jdbc:mysql://localhost:3306/test";
		Connection conn = DriverManager.getConnection(url, "root", "1234");
		//java.sql.SQLException: Access denied for user 'root'@'localhost' (using password: YES)  
		//解决这个问题的思路：查看主机名，用户名，密码
		System.out.println(conn.getClass());//获取运行时类型   class com.mysql.jdbc.Connection
		
		//3、操作数据库
		//这里我要添加一条记录到t_stu
		//(1)编写sql
		String sql = "INSERT INTO t_stu VALUES(3,'yan')";
		
		/*
		 * Connection好比网络编程中的Socket
		 * Statement好比和服务器进行数据读写的InputStream和OutputStream
		 */
		//(2)准备一个Statement   
		Statement st = conn.createStatement();
		
		//(3)执行sql，通过Statement对象把Sql发给服务器，服务器执行Sql后，把结果返回
		//insert ,update,delete语句都是通过这个方法执行
		int len = st.executeUpdate(sql);
		System.out.println(len>0?"添加成功":"添加失败");
		
		//4、释放资源
		st.close();
		conn.close();
	}
}
