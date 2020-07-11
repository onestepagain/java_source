package com.atguigu.test04.cast;

/*
 * 向下转型时有风险的，可能会发生ClassCastException。
 * 因为这是一个运行时异常，不能提前发现。
 * 我们想通过代码去避免ClassCastException，我们可以使用instanceof来进行判断。
 * 
 * 语法格式：
 * 	  变量/对象   instanceof 类型
 * 结果要么是true，要么是false
 * 
 * 什么情况下用instanceof判断，返回true?
 * if(p instanceof Woman)   当p中存储的就是Woman的对象
 * if(p instanceof Woman)   当p中存储的是Woman的子类的对象
 */
public class TestInstanceof {
	public static void main(String[] args) {
		Man m = new Man();
		test(m);
		
		Woman w = new Woman();
		test(w);
		
		Woman w2 = new ChineseWoman();
		test(w2);
		
	}
	
	public static void test(Person p){
		//如果这个p是个女人，就调用它的shop方法
		//如果这个p是个男人，就调用它的smoke方法
		/*如果这个写在最前面，后面的else if就进不去了
		if(p instanceof Person){
			p.eat();
			p.walk();
		}else */if(p instanceof Woman){
			Woman m = (Woman) p;
			m.shop();
		}else if(p instanceof Man){
			Man m = (Man) p;
			m.smoke();
		}
	}
}
