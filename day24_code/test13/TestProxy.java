package com.atguigu.test13;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

/*
 * 3、动态代理模式：Spring框架中
 * 优点：一个代理工作处理器，可以替多个代理主题（接口）代理工作，只有代理工作内容一样就可以。
 * 需要：
 * （1）编写一个代理工作处理器的类，这个类必须实现一个接口InvocationHandler
 * （2）用JDK中提供了一个Proxy类，来创建代理类的对象
 * new ProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
 * 参数一：被代理者的类加载器对象
 * 参数二：被代理者实现的接口们
 * 参数三：代理者替被代理者要完成的工作的处理器对象
 * 
 * （3）调用方法
 */
public class TestProxy {
	@Test
	public void test01() {
		AImpl a = new AImpl();//被代理者
		
		ClassLoader loader = a.getClass().getClassLoader();
		Class<?>[] interfaces = a.getClass().getInterfaces();
		Handler h = new Handler(a);
		
		A proxy = (A) Proxy.newProxyInstance(loader, interfaces, h);
		proxy.a();
	}
	
	@Test
	public void test02() {
		BImpl b = new BImpl();//被代理者
		
		ClassLoader loader = b.getClass().getClassLoader();
		Class<?>[] interfaces = b.getClass().getInterfaces();
		Handler h = new Handler(b);
		
		B proxy = (B) Proxy.newProxyInstance(loader, interfaces, h);
		proxy.b();
	}
}
class Handler implements InvocationHandler{
	private Object target;//被代理者对象
	
	public Handler(Object target) {
		super();
		this.target = target;
	}

	/*
	 * 参数一：代理类的对象
	 * 参数二：被代理者要执行的方法
	 * 参数三：被代理者要执行的方法需要的实参列表
	 * 这个方法不是程序调用的，是一会执行代理类对象的方法时自动调用
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(method.getName() + "方法开始执行");
		long start = System.currentTimeMillis();
		
//		method.invoke(obj, args);//obj是要求写被代理者对象
		Object value = method.invoke(target, args);
		
		long end = System.currentTimeMillis();
		System.out.println("运行时间：" + (end-start));
		System.out.println(method.getName() + "方法执行结束");
		
		
		return value;
	}
	
}

//主题1
interface A{
	void a();
}
//被代理者1
class AImpl implements A{

	@Override
	public void a() {
		System.out.println("a方法被执行");
	}
	
}
//主题2
interface B{
	void b();
}
//被代理者2
class BImpl implements B{

	@Override
	public void b() {
		System.out.println("b方法被执行");
	}
	
}