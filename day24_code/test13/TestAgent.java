package com.atguigu.test13;

import org.junit.Test;

/*
 * 二、代理模式
 * 
 * 生活中：
 * 	  （1）自己不方便做一些事情，例如：去国外   找代购
 * 	  （2）自己没资源，例如：找女朋友    找红娘
 * 
 * Java中：
 * 	 （1）当前这个类做一些事情，不太方便，因为这个事情是多变，重复的，我可以交给代理
 * 例如：项目经理说，在测试环境，即开发阶段（不是生产环境，上线就是生产环境），测试一下每一个方法的运行时间，并且记录方法运行的日志
 *    开发完了，项目经理说，把那些代码都去掉。
 *    
 * 1、代理模式
 * （1）主题接口：要求代理类与被代理类实现同一个接口，例如：DAO接口    
 * (2)被代理者
 * （3）代理者
 * 	 必须持有被代理者的引用
 * 
 * 2、静态代理模式
 * 缺点：一个代理类只能替一个代理主题（接口）代理工作
 * 
 * 3、动态代理模式
 * 优点：一个代理工作处理器，可以替多个代理主题代理工作，只有代理工作内容一样就可以。
 * 需要：
 * （1）编写一个代理工作处理器的类，这个类必须实现一个接口InvocationHandler
 * （2）用JDK中提供了一个Proxy类，来创建代理类的对象
 * （3）调用方法
 * 
 */
public class TestAgent {
	public static void main(String[] args) {
		GoodsDAOImpl dao = new GoodsDAOImpl();
		dao.add();
	}
	
	@Test
	public void test02(){
		//new GoodsDAOImpl()被代理者对象
		//new DAOProxy(x)代理者对象
		DAO d = new DAOProxy(new GoodsDAOImpl());
		d.add();
	}
	
	@Test
	public void test01(){
		//new UserDAOImpl()被代理者对象
		//new DAOProxy(x)代理者对象
		DAO d = new DAOProxy(new UserDAOImpl());
		d.add();
	}
}
interface DAO{
	void add();
/*	void update();
	void delete();
	void select();*/
}
class UserDAOImpl implements DAO{

	@Override
	public void add() {
//		System.out.println("add方法开始执行");
//		long start = System.currentTimeMillis();
		System.out.println("添加用户");
//		long end = System.currentTimeMillis();
//		System.out.println("运行时间：" + (end-start));
//		System.out.println("add方法执行结束");
	}
	
}
class GoodsDAOImpl implements DAO{

	@Override
	public void add() {
//		System.out.println("add方法开始执行");
//		long start = System.currentTimeMillis();
		System.out.println("添加商品");
//		long end = System.currentTimeMillis();
//		System.out.println("运行时间：" + (end-start));
//		System.out.println("add方法执行结束");
	}
	
}

class DAOProxy implements DAO{
	private DAO dao;//持有被代理者的引用，因为核心业务逻辑仍然交给被代理者自己完成
	
	public DAOProxy(DAO dao) {
		super();
		this.dao = dao;
	}

	public void add(){
		System.out.println("add方法开始执行");
		long start = System.currentTimeMillis();
		
//		System.out.println("添加商品");//核心业务逻辑交给被代理者自己玩
		dao.add();
		
		long end = System.currentTimeMillis();
		System.out.println("运行时间：" + (end-start));
		System.out.println("add方法执行结束");
	}
}
interface MyInter{
	void test();
}
class Impl implements MyInter{

	@Override
	public void test() {
	}
	
}