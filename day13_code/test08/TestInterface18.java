package com.atguigu.test08;

/*
 * 1、Java8对接口进行了修改：
 * Java8之前，接口中的成员只有两种：
 * （1）全局的静态的常量：public static final，可以省略
 * （2）公共的抽象的方法：public abstract，可以省略
 * 
 * Java8之后，接口又增加了两种新成员：
 * （3）静态方法：public static，不可以省略
 * 		调用方式：接口名.静态方法(实参列表)
 * （4）默认方法：public default，不可以省略
 * 
 * 2、为什么Java8要允许接口中定义静态方法？
 * 是因为JDK发展了一段时间后，发现类库中，多了很多这样的成组的API：
 * （1）Path接口和Paths工具类
 * （2）Collection接口和Collections工具类
 * .....
 * 一般工具类中都是静态方法，这些静态方法，基本上都是为前面这个对应接口服务的。
 * 这样的话，就会出现很多API，使得程序员的学习成本增加了，使用成本也增加了。
 * 
 * 开始把这样的静态方法，直接挪到接口中定义就好了。减少了这样的工具类的出现。
 * 
 * 3、为什么么Java8要允许接口中定义默认方法？
 * 是因为有的时候，一个接口它的大多数实现类对接口的抽象方法的实现代码是一样，那么我们写好几次就太麻烦了。
 * 即相当于，默认方法是原来的抽象方法有了一个默认实现。如果实现类的实现和接口一样，就不需要重写，如果不一样就重写即可。
 * 
 * 4、冲突问题
 * （1）当一个类同时实现了两个甚至更多个接口时，这些个接口中出现了方法签名相同的默认方法时，
 * 那么我们必须在这个实现类中，做出选择。
 * 选择一：保留其中一个，放弃另一个
 * 选择二：两者都不用，完全重写一个
 * 
 * （2）当一个类同时继承了父类，又实现了接口，那么当父类中出现了和接口中方法签名一样的方法时，怎么办？
 * 那么我们怎么选择？
 * 选择一：默认选择，编译器默认选择父类
 * 选择二：改选保留接口的
 * 选择三：完全自己重写
 *  */
public class TestInterface18 {
	public static void main(String[] args) {
		MyInter.test();
		
//		MyInter my = new MyInter();//接口不能创建对象
		
//		MyInter my = new InterImpl1();
//		my.method();
		
		Son s = new Son();
		s.test();
	}
}
interface MyInter{
	public static void test(){
		System.out.println("接口中的静态方法");
	}
	
	void fun();
	
	public default void method(){
		System.out.println("接口中的默认方法");
	}
}
class InterImpl1 implements MyInter{

	@Override
	public void fun() {
		System.out.println("aaaa");
	}
	
}
class InterImpl2 implements MyInter{

	@Override
	public void fun() {
		System.out.println("aaaa");
	}
	
}
class InterImpl3 implements MyInter{

	@Override
	public void fun() {
		System.out.println("bbbb");
	}

	//在类中，重写接口的默认方法是，default要去掉
	@Override
	public void method() {
		System.out.println("重写接口的默认方法");
	}
	
}
interface A{
	public default  void test(){
		System.out.println("aaa");
	}
}
interface B{
	public default  void test(){
		System.out.println("bbb");
	}
}
class C implements A,B{
	//选择一：保留其中一个，放弃另一个
	//在类中，重写接口的默认方法是，default要去掉
/*	public void test(){
//		A.super.test();//保留A接口的实现
		B.super.test();//保留B接口的实现
	}*/
	
	public void test(){
		System.out.println("ccc");
	}
}

class Father{
	public void test(){
		System.out.println("ffff");
	}
}
interface D{
	public default void test(){
		System.out.println("dddd");
	}
}
class Son extends Father implements D{
	//选择一：默认选择，保留父类的
	//选择二：该选，保留干爹的
//	public void test(){
//		D.super.test();
//	}
	
	//选择三：完全自己重写
	public void test(){
		System.out.println("ssss");
	}
}
