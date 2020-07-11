package com.atguigu.test02.abstract_;

/*
 * 设计模式？
 *   解决问题的套路，代码结构。
 * Java中常用的设计模式有23种。
 * JavaSE阶段给大家普及几个：
 * （1）模板设计模式
 * （2）单例设计模式：（*****）脱稿
 * （3）工厂设计模式：（**）会调用工厂类的方法
 * （4）代理设计模式：（***）模仿
 * （5）迭代器设计模式
 * （6）装饰者设计模式
 * 能看懂代码，能认识
 * 
 * （1）模板设计模式
 * ppt模板，论文模板，简历模板，请假条模板
 * 
 * 当你解决一下问题时，总体的算法的结构/步骤是确定的，但是其中的一步或几步的代码的具体实现是不确定的，
 * 得使用者自己来确定。
 * 
 * 举例：
 * 	 编写一个类，包含一个方法，可以统计  你执行任意代码的运行时间
 * 步骤：
 * （1）获取开始时系统时间
 * （2）执行xxxx
 * （3）获取结束时系统时间
 * （4）计算时间差
 * 
 * 时间的单位：毫秒
 * 提示：System.currentTimeMillis()
 */
public class TestTemplate {
	public static void main(String[] args) {
		MyCalTime my = new MyCalTime();
		long time = my.getTime();
		System.out.println("耗时：" + time + "毫秒");
	}
}
//模板类
abstract class CalTime{
	//可以计算任意一段代码的运行时间
	//这里加final的目的是不希望子类重写，改写我的算法的结构
	public final long getTime(){
		//（1）获取开始时系统时间
		long start = System.currentTimeMillis();
		
		//（2）执行xxxx
		doWork();
		
		//（3）获取结束时系统时间
		long end = System.currentTimeMillis();
		
		//（4）计算时间差
		return end - start;
	}
	//protected的目的，希望只是子类中进行访问和重写
	protected abstract void doWork();
}

class MyCalTime extends CalTime{

	@Override
	protected void doWork() {
		long sum = 0;
		for(int i=1; i<=100000; i++){
			sum += i;
		}
		System.out.println("sum = " + sum);
	}
	
}